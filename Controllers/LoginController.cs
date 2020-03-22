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

namespace LoginApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly DBConnect myDbc = new Data.DBConnect();

        // GET: api/Login
        [HttpGet]
        public IEnumerable<Userdata>[] Get()
        {
            //return all logged in users that are in the userdata column 


            IEnumerable<Userdata>[] columnData = myDbc.Select();
            // select * from userdata table which is a list of valid logged in users with {first}.{last}@ruralsourcing.com email
            //if empty?    // return status?
            //still needs error handling i.e. try/catch blocks
            return columnData;
            
        }

        

        // GET: api/Logins/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            //get a user with a specific id
            //SelectEmail(string userEmail)//need to change this to an ID or change the method to a string param?

            string columndata = myDbc.SelectEmailByID(id);

            //return 
            return columndata;
        }

        // POST: api/Logins
        [HttpPost]
        public string Post([FromBody] User value)
        {
            User user = new User();
            {
                user.Email = value.Email;
                
            }
            //string jsonTest = "{\"name\":\"Brandon Roberts\",\"email\":\"brandon.roberts@ruralsourcing.com\",\"photoUrl\":\"https://lh3.googleusercontent.com/a-/AAuE7mBr5bTYig1ynTCsuoVl_DIQg9i3JuNRsXk1_l4_=s96-c\",\"firstName\":\"Brandon\",\"lastName\":\"Roberts\",\"authToken\": \"ya29.ImC9B74V1kF_wL6VvsEG5q2Bcp7zHI49hEOAUBAkcn2JzQoNbivwejO-KUN5iNDEuJMdl3-bdPX-dGswM0x_jr1uL1YumayNB-MXqMReilk7OC9iK2mbpOoqXf936RxCBbI\",\"idToken\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc2MmZhNjM3YWY5NTM1OTBkYjhiYjhhNjM2YmYxMWQ0MzYwYWJjOTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDA3MDk4MTkzMTY3LTJlcWRrajRmZWFkY2tzcmE3ZDJibWZzaGZhNjExNTZvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3OTgyNTQ4MzE2ODMxNzk0OTA0IiwiaGQiOiJydXJhbHNvdXJjaW5nLmNvbSIsImVtYWlsIjoiYnJheWRlbi5yb2JiaW5zQHJ1cmFsc291cmNpbmcuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI3SWMyT1ZseGFaSjNXRHg3LTZsT2lBIiwibmFtZSI6IkJyYXlkZW4gUm9iYmlucyIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUF1RTdtQnI1YlRZaWcxeW5UQ3N1b1ZsX0RJUWc5aTNKdU5Sc1hrMV9sNF89czk2LWMiLCJnaXZlbl9uYW1lIjoiQnJheWRlbiIsImZhbWlseV9uYW1lIjoiUm9iYmlucyIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNTgyMDU3MzY3LCJleHAiOjE1ODIwNjA5NjcsImp0aSI6IjNkNWVhOWVhMzM4NzkxYTFhNjM4ZTVlZTZlMTgxYzkwNDljY2JiZjIifQ.UN_7sA3WfL6qMDfogd7cgcGkDpC3ZnxR5bChsldTz2WDxmgM-jyUr4X3cntwx81G3f7hmb9VVFb-GdO_lA4UHqjJz9DzhNyGgsTa3ffLlDy_xL3_Z5tpqfc_1OIj_oF90pJiBiurp-BKDJ175Rm7_pvnnP9M8YHp4F0P24mlUCpoJrasn8WCTTE2UC9nDmnqwmri4SR61qtheIrtveIrJK7AcwChJFjGObMHDDVVtEe23aD1dIynNKSBbKvxvW7D5ZwlVRggdBqDBFuYIhoY2w_SiR9F_MjdQDtxFpG3icf3kwENVbABzLG6rX3I8BSadsSO64yEUsAWjnIqq3M2Iw\",\"provider\":\"GOOGLE\"}";
         //string json1 =   JsonConvert.SerializeObject(jsonTest);
        //string json2 = value;
         //LoginModel logIn2 = JsonConvert.DeserializeObject<LoginModel>(jsonTest);

            //return logIn2.EmailAddress;
            //return /*json1.ToString();*/
            //return jsonTest;

            // need to create user in userdata table;
            
            return user.Email.ToString();
    }

    // PUT: api/Logins/5
    [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
