using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using LoginApi.Data;
using LoginApi.Models;
using System.Dynamic;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using SWH = System.Web.Http;
using MySql.Data.MySqlClient;
//using System.Web.Mvc;
using System.Data;

namespace LoginApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly DBConnect myDbc = new Data.DBConnect();
        private readonly object _httpContextAccessor;


      





        //references the json object data passed in from client
        public class Credentials  //references json object from client
        {
            public string Id { get; set; }

            [JsonProperty("name")]
            public string Username { get; set; }

            [JsonProperty("password")]
            public string Password { get; set; }

            [JsonProperty("email")]
            public string Email { get; set; }

            [JsonProperty("firstName")]
            public string FirstName { get; set; }

            [JsonProperty("lastName")]
            public string LastName { get; set; }

            [JsonProperty("photoUrl")]
            public string PictureUrl { get; set; }

            [JsonProperty("authToken")]
            public string AuthToken { get; set; }

            [JsonProperty("idToken")]
            public string IdToken { get; set; }

            [JsonProperty("provider")]
            public string Provider { get; set; }

            public string Role = "user";

            public string dev_center = "None";

        }

        //////////// GET: api/Logins/{id}   ex: {localhost:port/api/login/1
        //////////[HttpGet("{id}", Name = "Get")]
        //////////public string GetLogins(int id) //IEnumerable<dynamic> GetLogins()
        //////////{
        //////////    string connStr = "server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp";
        //////////    MySqlConnection myConnection = new MySqlConnection(connStr);
        //////////    myConnection.Open();

        //////////    string myQuery = "SELECT * FROM orientationapp.user WHERE UserID = " + id;  //from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME =
            
        //////////    MySqlCommand command = new MySqlCommand(myQuery, myConnection);
        //////////    MySqlDataReader reader = command.ExecuteReader();

        //////////    var r = Serialize(reader);
        //////////    string json = JsonConvert.SerializeObject(r, Formatting.Indented);
        //////////    return json;
        //////////}

        [HttpGet]
        public string GetLogins() //IEnumerable<dynamic> GetLogins()
        {
            //string connStr;
            string connStr = "server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp";
            MySqlConnection myConnection = new MySqlConnection(connStr);
            myConnection.Open();

            string myQuery = "SELECT * FROM orientationapp.user";  //from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME =
            MySqlCommand command = new MySqlCommand(myQuery, myConnection);
            MySqlDataReader reader = command.ExecuteReader();

            var r = Serialize(reader);
            string json = JsonConvert.SerializeObject(r, Formatting.Indented);
            return json;

            //var data = new ExpandoObject() as IDictionary<string, Object>;
            //string connStr;
            //connStr = "server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp";
            //MySqlConnection myConnection = new MySqlConnection(connStr);
            //myConnection.Open();
               
            //string myQuery = "SELECT * FROM orientationapp.user";  //from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME =
            //using ( myConnection ) 
            //{

            //    using (MySqlCommand command = new MySqlCommand(myQuery,myConnection))
            //    {
            //        MySqlDataReader reader = command.ExecuteReader();

            //        var schemaTable = reader.GetSchemaTable();

            //        List<string> colnames = new List<string>();
            //        foreach (DataRow row in schemaTable.Rows)
            //        {
            //            colnames.Add(row["ColumnName"].ToString());
            //        }

            //        while (reader.Read())
            //        {

            //            foreach (string colname in colnames)
            //            {
            //                var val = reader[colname];
            //                if (!data.ContainsKey(colname))
            //                {
            //                    data.Add(colname, Convert.IsDBNull(val) ? null : val);
            //                }

            //            }


            //        }
            //        yield return (ExpandoObject)data;
            //    }
            //}


        }
        
        //serialize into a dictionary then convert to json
        public IEnumerable<Dictionary<string, object>> Serialize(MySqlDataReader reader)
        {
            var results = new List<Dictionary<string, object>>();
            var cols = new List<string>();
            for (var i = 0; i < reader.FieldCount; i++)
                cols.Add(reader.GetName(i));

            while (reader.Read())
                results.Add(SerializeRow(cols, reader));

            return results;
        }
        private Dictionary<string, object> SerializeRow(IEnumerable<string> cols, MySqlDataReader reader)
        {
            var result = new Dictionary<string, object>();
            foreach (var col in cols)
                result.Add(col, reader[col]);
            return result;
        }


        // POST: api/Logins
        [HttpPost]
        public string Post([FromBody] Credentials credentials)
        {
            //ok for this API to raise errors? - performance concern for larger app
            try
            {
                myDbc.Insert(credentials);
                return credentials.Email;
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine( ex.ToString() + ex.InnerException.ToString());
                return ex.ToString();
                //can customize to match expected return here
            }
        }


         // PUT: api/Logins/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public string Delete(int id)
        {
            //Response.Cookies.Delete(somekey);

                string connStr = "server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp";
                MySqlConnection myConnection = new MySqlConnection(connStr);
                myConnection.Open();

                string myQuery = "Delete FROM orientationapp.user WHERE UserID = " + id;  //from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME =

                MySqlCommand command = new MySqlCommand(myQuery, myConnection);
                MySqlDataReader reader = command.ExecuteReader();

                var r = Serialize(reader);
            // string response = JsonConvert.SerializeObject(r, Formatting.Indented);
            string response = "";
            //return response;  
            if (reader.RecordsAffected == 1)
            //if (response == "")
            { 
                return "Successfully deleted user ID: " + id;
            }
            
            else
            {
                return "Error occurred";
            }
        }
    }
}
