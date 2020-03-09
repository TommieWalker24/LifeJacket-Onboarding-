using System;
using System.Collections.Generic;

namespace LoginApi
{
    public partial class Categories
    {
        public Categories()
        {
            Steps = new HashSet<Steps>();
        }

        public long CategoryId { get; set; }
        public string Category { get; set; }

        public virtual ICollection<Steps> Steps { get; set; }
    }
}
