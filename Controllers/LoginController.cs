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
        [HttpGet]
        //public List<UserData> Get()
        //{
        //    //return all logged in users that are in the userdata column 

        //    var users = myDbc.Select();
        //    //IEnumerable<Userdata>[] columnData = myDbc.Select();


        //    // select * from userdata table which is a list of valid logged in users with {first}.{last}@ruralsourcing.com email
        //    users = myDbc.Select();
        //    return users;

        //}




        // GET: api/Logins/
        [HttpGet("{id}", Name = "Get")]
        public List<string>[] Get() //int id
        {
               List<string>[] columndata = myDbc.Select();

            //return 
            return columndata;
        }
        public class Credentials
        {
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


        // POST: api/Logins
        [HttpPost]
        public string Post([FromBody] Credentials credentials)
        {
            //string jsonTest = "{\"name\":\"Brandon Roberts\",\"email\":\"brandon.roberts@ruralsourcing.com\",\"photoUrl\":\"https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c\",\"firstName\":\"Brandon\",\"lastName\":\"Roberts\",\"authToken\": \"ya29.ImC9B74V1kF_wL6VvsEG5q2Bcp7zHI49hEOAUBAkcn2JzQoNbivwejO-KUN5iNDEuJMdl3-bdPX-dGswM0x_jr1uL1YumayNB-MXqMReilk7OC9iK2mbpOoqXf936RxCBbI\",\"idToken\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc2MmZhNjM3YWY5NTM1OTBkYjhiYjhhNjM2YmYxMWQ0MzYwYWJjOTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3OTgyNTQ4MzE2ODMxNzk0OTA0IiwiaGQiOiJydXJhbHNvdXJjaW5nLmNvbSIsImVtYWlsIjoiYnJheWRlbi5yb2JiaW5zQHJ1cmFsc291cmNpbmcuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI3SWMyT1ZseGFaSjNXRHg3LTZsT2lBIiwibmFtZSI6IkJyYXlkZW4gUm9iYmlucyIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUF1RTdtQnI1YlRZaWcxeW5UQ3N1b1ZsX0RJUWc5aTNKdU5Sc1hrMV9sNF89czk2LWMiLCJnaXZlbl9uYW1lIjoiQnJheWRlbiIsImZhbWlseV9uYW1lIjoiUm9iYmlucyIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNTgyMDU3MzY3LCJleHAiOjE1ODIwNjA5NjcsImp0aSI6IjNkNWVhOWVhMzM4NzkxYTFhNjM4ZTVlZTZlMTgxYzkwNDljY2JiZjIifQ.UN_7sA3WfL6qMDfogd7cgcGkDpC3ZnxR5bChsldTz2WDxmgM-jyUr4X3cntwx81G3f7hmb9VVFb-GdO_lA4UHqjJz9DzhNyGgsTa3ffLlDy_xL3_Z5tpqfc_1OIj_oF90pJiBiurp-BKDJ175Rm7_pvnnP9M8YHp4F0P24mlUCpoJrasn8WCTTE2UC9nDmnqwmri4SR61qtheIrtveIrJK7AcwChJFjGObMHDDVVtEe23aD1dIynNKSBbKvxvW7D5ZwlVRggdBqDBFuYIhoY2w_SiR9F_MjdQDtxFpG3icf3kwENVbABzLG6rX3I8BSadsSO64yEUsAWjnIqq3M2Iw\",\"provider\":\"GOOGLE\"}";
            //string json1 = JsonConvert.SerializeObject(FromB);
            //LoginModel user2 = JsonConvert.DeserializeObject<LoginModel>(jsonTest);
            //UserData user = new UserData();
            //{
                //string name = credentials.Username;
                //string email = credentials.Email;
                //string photoURl = credentials.PictureUrl;
                //string firstName = credentials.FirstName;
                //string lastName = credentials.LastName;
                //string authToken = credentials.AuthToken;
                //string idToken = credentials.IdToken;
                //string provider = credentials.Provider;
                
                //user.FirstName = value.FirstName;
                //user.LastName = value.LastName;
                //user.EmailAddress = value.EmailAddress;
                //user.PictureUrl = value.PictureUrl;
                //user.Provider = value.Provider;
                //user.authToken = value.authToken;
                //user.idToken = value.idToken;

            //}


            //return logIn2.EmailAddress;
            //return /*json1.ToString();*/
            //return jsonTest;

            


            //are APIs supposed to raise errors?
            
            try
            {
                myDbc.Insert(credentials);
                return credentials.Email;
            }
            catch (Exception ex)
            {
                Console.WriteLine( ex.ToString() + ex.InnerException.ToString());
                return ex.ToString();

            }




            ///need to return something else?
            //return credentials.Email;
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
