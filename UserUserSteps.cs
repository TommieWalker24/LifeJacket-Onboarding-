using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class UserUserSteps
    {
        public string UserEmail { get; set; }
        public long UserStepsUserStepId { get; set; }

        public virtual User UserEmailNavigation { get; set; }
        public virtual UserStep UserStepsUserStep { get; set; }
    }
}
