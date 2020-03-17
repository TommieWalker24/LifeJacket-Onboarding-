using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class UserAssignedEquipment
    {
        public string UserEmail { get; set; }
        public long AssignedEquipmentAssetId { get; set; }

        public virtual Assets AssignedEquipmentAsset { get; set; }
        public virtual User UserEmailNavigation { get; set; }
    }
}
