using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class StepsUser
    {
        public long StepStep { get; set; }
        public long UserUserStepId { get; set; }

        public virtual Steps StepStepNavigation { get; set; }
        public virtual UserStep UserUserStep { get; set; }
    }
}
