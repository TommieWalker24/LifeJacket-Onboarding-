using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class RoleSteps
    {
        public string RoleRole { get; set; }
        public long StepsStep { get; set; }

        public virtual Role RoleRoleNavigation { get; set; }
        public virtual Steps StepsStepNavigation { get; set; }
    }
}
