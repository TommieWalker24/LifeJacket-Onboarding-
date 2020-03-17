using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class Assets
    {
        public long AssetId { get; set; }
        public int? Equipment { get; set; }
        public string Email { get; set; }

        public virtual User EmailNavigation { get; set; }
        public virtual UserAssignedEquipment UserAssignedEquipment { get; set; }
    }
}
