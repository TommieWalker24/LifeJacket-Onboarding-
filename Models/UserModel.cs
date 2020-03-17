using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LoginApi.Models
{
    public class UserModel
    {
        public string email { get; set; }
        public int cube_number { get; set; }
        public string fist_name { get; set; } //should spell "first" but mispelled in the db
        public string password { get; set; }
        public string dev_center { get; set; }
        public string role { get; set; }
        public string picture_url { get; set; }

    }
}
