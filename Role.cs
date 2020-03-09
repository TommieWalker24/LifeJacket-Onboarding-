using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class Role
    {
        public Role()
        {
            RoleSteps = new HashSet<RoleSteps>();
            Steps = new HashSet<Steps>();
            User = new HashSet<User>();
        }

        public string Role1 { get; set; }

        public virtual ICollection<RoleSteps> RoleSteps { get; set; }
        public virtual ICollection<Steps> Steps { get; set; }
        public virtual ICollection<User> User { get; set; }
    }
}
