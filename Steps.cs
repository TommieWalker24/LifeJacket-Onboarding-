using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class Steps
    {
        public Steps()
        {
            StepsUser = new HashSet<StepsUser>();
            UserStep = new HashSet<UserStep>();
        }

        public long Step { get; set; }
        public string Description { get; set; }
        public string Title { get; set; }
        public string Category { get; set; }
        public string StepNum { get; set; }

        public virtual Categories CategoryNavigation { get; set; }
        public virtual Role StepNumNavigation { get; set; }
        public virtual RoleSteps RoleSteps { get; set; }
        public virtual ICollection<StepsUser> StepsUser { get; set; }
        public virtual ICollection<UserStep> UserStep { get; set; }
    }
}
