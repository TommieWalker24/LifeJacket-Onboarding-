using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class User
    {
        public User()
        {
            Assets = new HashSet<Assets>();
            UserAssignedEquipment = new HashSet<UserAssignedEquipment>();
            UserStep = new HashSet<UserStep>();
            UserUserSteps = new HashSet<UserUserSteps>();
        }

        public string Email { get; set; }
        public int CubeNumber { get; set; }
        public string FistName { get; set; }
        public string LastName { get; set; }
        public string Password { get; set; }
        public string DevCenter { get; set; }
        public string Role { get; set; }

        public virtual DevCenter DevCenterNavigation { get; set; }
        public virtual Role RoleNavigation { get; set; }
        public virtual DevCenterUsers DevCenterUsers { get; set; }
        public virtual ICollection<Assets> Assets { get; set; }
        public virtual ICollection<UserAssignedEquipment> UserAssignedEquipment { get; set; }
        public virtual ICollection<UserStep> UserStep { get; set; }
        public virtual ICollection<UserUserSteps> UserUserSteps { get; set; }
    }
}
