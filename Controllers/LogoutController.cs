using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace LoginApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LogoutController : ControllerBase
    {
        // GET: api/Logout
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        //removed:{ , Name = "Get"} to resolve error "Error 1: Attribute routes with the same name 'Get' must have the same template:"
        //ref https://stackoverflow.com/questions/46553072/asp-net-core-2-multiple-controllers and 
        // GET: api/Logout/5
        [HttpGet("{id}")]  
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Logout
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT: api/Logout/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
