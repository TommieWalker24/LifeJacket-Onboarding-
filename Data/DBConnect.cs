using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using LoginApi.Controllers;
using static LoginApi.Controllers.LoginController;

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
                        Console.WriteLine("Cannot connect to server.  Contact administrator");
                        //Console.ReadLine();
                        break;

                    case 1045:
                        Console.WriteLine("Invalid username/password, please try again");
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
                Console.WriteLine(ex.Message);
                //Console.ReadLine();
                return false;
            }
        }


        //Insert statement
        //public void Insert(string firstName, string lastName, string emailAddress, string pictureURL, string IFormatProvider, string authtoken, string idtoken)
        public void Insert(Credentials cred)
        {
            string query = "INSERT INTO Userdata (FirstName, LastName, EmailAddress, PictureURL, Provider, authToken, idToken) VALUES(" +
                "\"" + cred.FirstName  + "\"" + "," +
                "\"" + cred.LastName + "\"" + "," +
                "\"" + cred.Email + "\"" + "," +
                "\"" + cred.PictureUrl + "\"" + "," +
                "\"" + cred.Provider + "\"" + "," +
                "\"" + cred.AuthToken + "\"" + "," +
                "\"" + cred.IdToken + "\"" + ")";

            Console.WriteLine( query);

            //removed , authToken, idToken
            //    "," +
            //      cred.authToken + "," +
            //      cred.idToken +                 
            //cred.PictureUrl + "," +
            //      cred.Provider + 


            ////open connection
            if (this.OpenConnection() == true)
            {
                //create command and assign the query and connection from the constructor
                MySqlCommand cmd = new MySqlCommand(query, connection);

                //Execute command
                cmd.ExecuteNonQuery();

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
        public void Delete()
        {
            string query = "DELETE FROM tableinfo WHERE name='John Smith'";

            if (this.OpenConnection() == true)
            {
                MySqlCommand cmd = new MySqlCommand(query, connection);
                cmd.ExecuteNonQuery();
                this.CloseConnection();
            }
        }

        //alternate select statement to check for just email in field
        public string SelectEmailByID(int userId)
        {
            //return the email of the user with the given UserId
            string query = "SELECT EmailAddress FROM userdata WHERE UserID= " + userId.ToString();

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
                Console.WriteLine(list);
                return rsiEmail;
            }
            else
            {
                return null; //not found rsiEmail;

            }
        }

        public string SelectAll()
        {
            //return the email of the user with the given UserId
            string query = "SELECT * userdat";

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
                Console.WriteLine(list);
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
            string query = "SELECT EmailAddress FROM userdata WHERE UserID= " + email.ToString();

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
                Console.WriteLine(list);
                return rsiEmail;
            }
            else
            {
                return null; //not found rsiEmail;

            }
        }
        //Select statement to check for user in user table
        public List<string>[] Select()
        {
            string query = "SELECT * FROM userdata";  //user or userdata?



            //Create a list to store the result
            List<string>[] list = new List<string>[8];

            list[0] = new List<string>();
            list[1] = new List<string>();
            list[2] = new List<string>();
            list[3] = new List<string>();
            list[4] = new List<string>();
            list[5] = new List<string>();
            list[6] = new List<string>();
            list[7] = new List<string>();

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
                    //var rowNum = 0;
                    list[0].Add(dataReader["UserId"] + "");
                    list[1].Add(dataReader["FirstName"] + "");
                    list[2].Add(dataReader["LastName"] + "");
                    list[3].Add(dataReader["EmailAddress"] + "");
                    list[4].Add(dataReader["PictureURL"] + "");
                    list[5].Add(dataReader["Provider"] + "");
                    list[6].Add(dataReader["authToken"] + "");
                    list[7].Add(dataReader["idToken"] + "");


                    //Console.WriteLine(list.ToString());
                }

                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                Console.WriteLine(list);
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

        //Backup
        public void Backup()
        {
        }

        //Restore
        public void Restore()
        {
        }
    }
}