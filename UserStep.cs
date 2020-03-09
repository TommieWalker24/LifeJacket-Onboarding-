using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class UserStep
    {
        public long UserStepId { get; set; }
        public ulong? Complete { get; set; }
        public ulong? Pending { get; set; }
        public long? StepId { get; set; }
        public string Email { get; set; }

        public virtual User EmailNavigation { get; set; }
        public virtual Steps Step { get; set; }
        public virtual StepsUser StepsUser { get; set; }
        public virtual UserUserSteps UserUserSteps { get; set; }
    }
}
