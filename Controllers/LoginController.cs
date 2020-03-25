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

        //some sample data to work with 
        UserData[] seedData = new UserData[] {

            //new UserData 
            //{ UserId = "99", EmailAddress = "brandon.roberts@ruralsourcing.com", FirstName="Brandon", LastName = "Roberts",
            //authToken = "ya29.ImC9B74V1kF_wL6VvsEG5q2Bcp7zHI49hEOAUBAkcn2JzQoNbivwejO-KUN5iNDEuJMdl3-bdPX-dGswM0x_jr1uL1YumayNB-MXqMReilk7OC9iK2mbpOoqXf936RxCBbI",
            //idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc2MmZhNjM3YWY5NTM1OTBkYjhiYjhhNjM2YmYxMWQ0MzYwYWJjOTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3OTgyNTQ4MzE2ODMxNzk0OTA0IiwiaGQiOiJydXJhbHNvdXJjaW5nLmNvbSIsImVtYWlsIjoiYnJheWRlbi5yb2JiaW5zQHJ1cmFsc291cmNpbmcuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI3SWMyT1ZseGFaSjNXRHg3LTZsT2lBIiwibmFtZSI6IkJyYXlkZW4gUm9iYmlucyIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUF1RTdtQnI1YlRZaWcxeW5UQ3N1b1ZsX0RJUWc5aTNKdU5Sc1hrMV9sNF89czk2LWMiLCJnaXZlbl9uYW1lIjoiQnJheWRlbiIsImZhbWlseV9uYW1lIjoiUm9iYmlucyIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNTgyMDU3MzY3LCJleHAiOjE1ODIwNjA5NjcsImp0aSI6IjNkNWVhOWVhMzM4NzkxYTFhNjM4ZTVlZTZlMTgxYzkwNDljY2JiZjIifQ.UN_7sA3WfL6qMDfogd7cgcGkDpC3ZnxR5bChsldTz2WDxmgM-jyUr4X3cntwx81G3f7hmb9VVFb-GdO_lA4UHqjJz9DzhNyGgsTa3ffLlDy_xL3_Z5tpqfc_1OIj_oF90pJiBiurp-BKDJ175Rm7_pvnnP9M8YHp4F0P24mlUCpoJrasn8WCTTE2UC9nDmnqwmri4SR61qtheIrtveIrJK7AcwChJFjGObMHDDVVtEe23aD1dIynNKSBbKvxvW7D5ZwlVRggdBqDBFuYIhoY2w_SiR9F_MjdQDtxFpG3icf3kwENVbABzLG6rX3I8BSadsSO64yEUsAWjnIqq3M2Iw",
            //PictureUrl="https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c",
            //Provider = "GOOGLE"
            //} ,
            //new UserData
            //{
            //    UserId = "89", EmailAddress = "brian.roberts@ruralsourcing.com", FirstName="Brian", LastName = "Roberts",
            //authToken = "ya29.ImC9B74V1kF_wL6VvsEG5q2Bcp7zHI49hEOAUBAkcn2JzQoNbivwejO-KUN5iNDEuJMdl3-bdPX-dGswM0x_jr1uL1YumayNB-MXqMReilk7OC9iK2mbpOoqXf936RxCBbI",
            //idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc2MmZhNjM3YWY5NTM1OTBkYjhiYjhhNjM2YmYxMWQ0MzYwYWJjOTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3OTgyNTQ4MzE2ODMxNzk0OTA0IiwiaGQiOiJydXJhbHNvdXJjaW5nLmNvbSIsImVtYWlsIjoiYnJheWRlbi5yb2JiaW5zQHJ1cmFsc291cmNpbmcuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI3SWMyT1ZseGFaSjNXRHg3LTZsT2lBIiwibmFtZSI6IkJyYXlkZW4gUm9iYmlucyIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUF1RTdtQnI1YlRZaWcxeW5UQ3N1b1ZsX0RJUWc5aTNKdU5Sc1hrMV9sNF89czk2LWMiLCJnaXZlbl9uYW1lIjoiQnJheWRlbiIsImZhbWlseV9uYW1lIjoiUm9iYmlucyIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNTgyMDU3MzY3LCJleHAiOjE1ODIwNjA5NjcsImp0aSI6IjNkNWVhOWVhMzM4NzkxYTFhNjM4ZTVlZTZlMTgxYzkwNDljY2JiZjIifQ.UN_7sA3WfL6qMDfogd7cgcGkDpC3ZnxR5bChsldTz2WDxmgM-jyUr4X3cntwx81G3f7hmb9VVFb-GdO_lA4UHqjJz9DzhNyGgsTa3ffLlDy_xL3_Z5tpqfc_1OIj_oF90pJiBiurp-BKDJ175Rm7_pvnnP9M8YHp4F0P24mlUCpoJrasn8WCTTE2UC9nDmnqwmri4SR61qtheIrtveIrJK7AcwChJFjGObMHDDVVtEe23aD1dIynNKSBbKvxvW7D5ZwlVRggdBqDBFuYIhoY2w_SiR9F_MjdQDtxFpG3icf3kwENVbABzLG6rX3I8BSadsSO64yEUsAWjnIqq3M2Iw",
            //PictureUrl="https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c",
            //Provider = "GOOGLE"
            //}
        };



        // GET: api/Login
        //[HttpGet]
        //public List<UserData> Get()
        //{
        //    //return all logged in users that are in the userdata column 

        //    var users = myDbc.Select();
        //    //IEnumerable<Userdata>[] columnData = myDbc.Select();


        //    // select * from userdata table which is a list of valid logged in users with {first}.{last}@ruralsourcing.com email
        //    users = myDbc.Select();
        //    return users;

        //}


        public class Credentials
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

        }

        // GET: api/Logins/
        [HttpGet("{id}", Name = "Get")]


        [HttpGet]
        public IEnumerable<dynamic> GetLogins()
        {
            var data = new ExpandoObject() as IDictionary<string, Object>;
            string connStr;
            connStr = "server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp";
            MySqlConnection myConnection = new MySqlConnection(connStr);
            myConnection.Open();
               
            string myQuery = "SELECT * FROM orientationapp.userdata";  //from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME =
            using ( myConnection ) 
            {

                using (MySqlCommand command = new MySqlCommand(myQuery,myConnection))
                {
                    MySqlDataReader reader = command.ExecuteReader();

                    var schemaTable = reader.GetSchemaTable();

                    List<string> colnames = new List<string>();
                    foreach (DataRow row in schemaTable.Rows)
                    {
                        colnames.Add(row["ColumnName"].ToString());
                    }

                    while (reader.Read())
                    {

                        foreach (string colname in colnames)
                        {
                            var val = reader[colname];
                            if (!data.ContainsKey(colname))
                            {
                                data.Add(colname, Convert.IsDBNull(val) ? null : val);
                            }
                            
                        }


                    }
                    yield return (ExpandoObject)data;
                }
            }

            //        using (MySqlConnection connection = new DBConnect)
            //        {
            //            connection.Open();
            //            //string commandText = @"SELECT JSON_OBJECT('uid',uid,'username',username) FROM  orientationapp.userdata";
            //             string commandText = @"SELECT * FROM  userdata"; 
            //            using (MySqlCommand command = new MySqlCommand(commandText, connection))
            //            {
            //                MySqlDataReader reader = command.ExecuteReader();

            //                while (reader.Read())
            //                {
            //                    LoginModel login = new LoginModel();
            //l
            //                    yield return reader.GetInt32(0);

            //                }
            //            }
            //        }
        }
        //private IEnumerable<string> GetAll()
        //{
        //    using (MySqlConnection connection = new DBConnect)
        //    {
        //        connection.Open();
        //        string commandText = @"SELECT * FROM userdata"; 

        //        using (MySqlCommand command = new MySqlCommand(commandText, connection))
        //        {
        //            MySqlDataReader reader = command.ExecuteReader();

        //            while (reader.Read())
        //            {
        //                yield return reader.Read();

        //            }

        //        }
        //    }
        //}

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
        private Dictionary<string, object> SerializeRow(IEnumerable<string> cols,
                                                        MySqlDataReader reader)
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
            //are APIs supposed to raise errors?
            try
            {
                myDbc.Insert(credentials);
                return credentials.Email;
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine( ex.ToString() + ex.InnerException.ToString());
                return ex.ToString();
            }
        }

        //public void setCookie() 
        //{
        //    string cookie = Request.Cookies.Append(somekey, somevalue);
        //    CookieOptions option = new CookieOptions();
        //    option.Expires = DateTime.Now.AddHours(12);
        //    Response.Cookies.Append(key, value, option);
        //}
        //public IActionResult Write(string key, string value, bool isPersistent)
        //{
        //    CookieOptions options = new CookieOptions();
        //    if (isPersistent)
        //        options.Expires = DateTime.Now.AddDays(1);
        //    else
        //        options.Expires = DateTime.Now.AddSeconds(10);
        //    //_httpContextAccessor.HttpContext.Response.Cookies.Append
        //    //(key, value, options);
        //    //return View("WriteCookie");
        //    return 0;
        //}
        //public IActionResult Read(string key)
        //{
        //    //ViewBag.Data =
        //    //_httpContextAccessor.HttpContext.Request.Cookies[key];
        //    //return View("ReadCookie");

            //}
            // PUT: api/Logins/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            //Response.Cookies.Delete(somekey);
        }
    }
}
