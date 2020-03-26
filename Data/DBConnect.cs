using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using MySql.Data.MySqlClient;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using LoginApi.Controllers;
using static LoginApi.Controllers.LoginController;
using static LoginApi.Models.LoginModel;
using Newtonsoft.Json;


namespace LoginApi.Data
{
    public class DBConnect
    {
        private MySqlConnection connection;
        private string server;
        private string database;
        private string uid;
        private string password;

        //Constructor
        public DBConnect()
        {
            Initialize();
        }

        //Initialize values
        private void Initialize()
        {
            server = "agssqlw02";
            database = "orientationapp";
            uid = "orientationapp";
            password = "9MHCnt76dy3RmNmp";
            string connectionString;
            connectionString = "SERVER=" + server + ";" + "DATABASE=" +
            database + ";" + "UID=" + uid + ";" + "PASSWORD=" + password + ";";

            connection = new MySql.Data.MySqlClient.MySqlConnection(connectionString);
        }

        //open connection to database
        private bool OpenConnection()
        {
            try
            {
                connection.Open();
                return true;
            }
            catch (MySqlException ex)
            {
                //When handling errors, you can your application's response based 
                //on the error number.
                //The two most common error numbers when connecting are as follows:
                //0: Cannot connect to server.
                //1045: Invalid user name and/ or password.
                switch (ex.Number)
                {
                    case 0:
                        System.Diagnostics.Debug.WriteLine("Cannot connect to server.  Contact administrator");
                        //Console.ReadLine();
                        break;

                    case 1045:
                        System.Diagnostics.Debug.WriteLine("Invalid username/password, please try again");
                        //Console.ReadLine();
                        break;
                }
                return false;
            }
        }

        //Close connection
        private bool CloseConnection()
        {
            try
            {
                connection.Close();
                return true;
            }
            catch (MySqlException ex)
            {
                //MessageBox.Show(ex.Message);
                System.Diagnostics.Debug.WriteLine(ex.Message);
                //Console.ReadLine();
                return false;
            }
        }


        //Insert statement
        public void Insert(Credentials cred)
        {
            int mySqlReturnCode;
            //using @ is maybe a better way to concat his with using @ ?(time permitting). 
            //also needs to be parameterized in mysql for sql injection prevention
            string query = "INSERT INTO User (first_name, last_name, email, photo_url, provider, auth_Token, id_Token) VALUES(" +
                '"' + cred.FirstName + '"' + "," +
                '"' + cred.LastName + '"' + "," +
                '"' + cred.Email + '"' + "," +
                '"' + cred.PictureUrl + '"' + "," +
                '"' + cred.Provider + '"' + "," +
                '"' + cred.AuthToken + '"' + "," +
                '"' + cred.IdToken + '"' + ")";

            System.Diagnostics.Debug.WriteLine(query);

            if (this.OpenConnection() == true)
            {
                //create command and assign the query and connection from the constructor
                MySqlCommand cmd = new MySqlCommand(query, connection);

                //Execute command
                mySqlReturnCode = cmd.ExecuteNonQuery();
                System.Diagnostics.Debug.WriteLine(mySqlReturnCode);

                //close connection
                this.CloseConnection();
            }

        }
        //Update statement
        public void Update()
        {
            string query = "UPDATE tableinfo SET name='Joe', age='22' WHERE name='John Smith'";

            //Open connection
            if (this.OpenConnection() == true)
            {
                //create mysql command
                MySqlCommand cmd = new MySqlCommand
                {
                    //Assign the query using CommandText
                    CommandText = query,
                    //Assign the connection using Connection
                    Connection = connection
                };

                //Execute query
                cmd.ExecuteNonQuery();

                //close connection
                this.CloseConnection();
            }
        }

        //Delete statement
        public void Delete(Credentials cred)
        {
            string queryParam = cred.Email;
            string query = "DELETE FROM user WHERE email= " + '"' + queryParam + '"';

            if (this.OpenConnection() == true)
            {
                MySqlCommand cmd = new MySqlCommand(query, connection);
                cmd.ExecuteNonQuery();
                this.CloseConnection();
            }
        }

        alternate select statement to check for just email(query by id)
        public List<Credentials> Select()// Select(int id)
        {
            //return the email of the user with the given UserId
            string query = "SELECT * FROM user"; //where UserId = 
            //Create a list to store the result
            var list = new List<Credentials>();


            string rsiEmail = "";

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {
                    list.Add(new Credentials
                    {
                        Id = dataReader["UserId"].ToString(),
                        FirstName = dataReader["FirstName"].ToString(),
                        LastName = dataReader["LastName"].ToString(),
                        Email = dataReader["EmailAddress"].ToString(),
                        PictureUrl = dataReader["PictureUrl"].ToString(),
                        Provider = dataReader["Provider"].ToString(),
                        AuthToken = dataReader["authToken"].ToString(),
                        IdToken = dataReader["idToken"].ToString(),
                    });
                }
                rsiEmail = dataReader["EmailAddress"].ToString();


                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                System.Diagnostics.Debug.WriteLine(list);
                return list;
            }
            else
            {
                return null; //not found rsiEmail;

            }
        }

        public string SelectAll()
        {
            //return the email of the user with the given UserId
            string query = "SELECT * user";

            //Create a list to store the result
            List<string>[] list = new List<string>[1];
            string rsiEmail = "";

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {

                    //list[1].Add(dataReader["EmailAddress"] + "");

                    //probably just need a string not a list  

                    rsiEmail = dataReader["email"].ToString();

                }


                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                System.Diagnostics.Debug.WriteLine(list);
                return rsiEmail;
            }
            else
            {
                return null; //not found rsiEmail;

            }
        }



        public string SelectEmailByString(string email)
        {
            //return the email of the user with the given UserId
            string query = "SELECT email FROM user WHERE email= " + email.ToString();

            //Create a list to store the result
            List<string>[] list = new List<string>[1];
            string rsiEmail = "";

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {

                    //list[1].Add(dataReader["EmailAddress"] + "");

                    //probably just need a string not a list  

                    rsiEmail = dataReader["EmailAddress"].ToString();

                }


                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                System.Diagnostics.Debug.WriteLine(list);
                return rsiEmail;
            }
            else
            {
                return null; //not found rsiEmail;

            }
        }
        Select statement to check for user in user table
        public List<Object> SelectDataSet()
        {
            string query = "SELECT * FROM user";  //user or userdata?
            DataSet dataSet = new DataSet();

            //Create a list to store the result
            List<Object> list = new List<object>();
            //change to userdata object?

            #region newlists
            //list[0] = new List<string>();
            //list[1] = new List<string>();
            //list[2] = new List<string>();
            //list[3] = new List<string>();
            //list[4] = new List<string>();
            //list[5] = new List<string>();
            //list[6] = new List<string>();
            //list[7] = new List<string>();
            #endregion
            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader reader = cmd.ExecuteReader();
                System.Data.DataTable dt = reader.GetSchemaTable();
                //Read the data and store them in the list
                while (reader.Read())
                {
                    list.Add(new object, reader);
                    //list
                    //modify to add key/valud pairs instead
                    //var rowNum = 0;
                    list.Add(reader["UserId"] + reader. "");
                    list.Add(reader);
                    list.Add(reader["FirstName"] + "");
                    list.Add(reader["LastName"] + "");
                    list.Add(reader["EmailAddress"] + ""); dt.
                     list.Add(reader["PictureURL"] + "");
                    list.Add(reader["Provider"] + "");
                    list.Add(reader["authToken"] + "");
                    list.Add(reader["idToken"] + "");


                    //System.Diagnostics.Debug.WriteLine(list.ToString());
                }

                //close Data Reader
                reader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                System.Diagnostics.Debug.WriteLine(list);
                System.Diagnostics.Debug.Write(list + Environment.NewLine);
                return list;
            }
            else
            {
                return list;
            }
        }

        //Count statement
        public int Count()
        {
            string query = "SELECT Count(*) FROM tableinfo";
            int Count = -1;

            //Open Connection
            if (this.OpenConnection() == true)
            {
                //Create Mysql Command
                MySqlCommand cmd = new MySqlCommand(query, connection);

                //ExecuteScalar will return one value
                Count = int.Parse(cmd.ExecuteScalar() + "");

                //close Connection
                this.CloseConnection();

                return Count;
            }
            else
            {
                return Count;
            }
        }


    }
}