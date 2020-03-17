using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class DevCenterUsers
    {
        public string DevCenterLocation { get; set; }
        public string UsersEmail { get; set; }

        public virtual DevCenter DevCenterLocationNavigation { get; set; }
        public virtual User UsersEmailNavigation { get; set; }
    }
}
