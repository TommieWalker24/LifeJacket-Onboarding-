using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class DevCenter
    {
        public DevCenter()
        {
            DevCenterUsers = new HashSet<DevCenterUsers>();
            User = new HashSet<User>();
        }

        public string Location { get; set; }
        public string HrRep { get; set; }

        public virtual ICollection<DevCenterUsers> DevCenterUsers { get; set; }
        public virtual ICollection<User> User { get; set; }
    }
}
