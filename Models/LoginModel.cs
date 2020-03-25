using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LoginApi.Models
{
    //IEnumerable interface contains the System.Collections.Generic namespace.
    //Returns an enumerator that iterates through the collection
    //added to allow looping over generic or non-generic lists
    public class LoginModel : IEnumerable  
    {

        public string UserId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string EmailAddress { get; set; }
        public string PictureUrl { get; set; }
        public string Provider { get; set; }
        public string authToken { get; set; }
        public string idToken { get; set; }
        public bool IsAuthenticated { get; set; }
        public IEnumerator GetEnumerator()
        {
            throw new NotImplementedException();
        }
    }


}
