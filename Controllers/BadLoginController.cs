using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using LoginApi.Models;
using LoginApi.Data;

namespace LoginApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BadLoginController : ControllerBase
    {
        private readonly LoginContext _context;


        public BadLoginController(LoginContext context)
        {
            _context = context;
        }

        // GET: api/LoginItems
        [HttpGet]
        public async Task<ActionResult<IEnumerable<LoginItems>>> GetLoginItems()
        {



            return await _context.LoginItems.ToListAsync();

        }

        // GET: api/LoginItems/5
        [HttpGet("{id}")]
        public async Task<ActionResult<LoginItems>> GetLoginItem(long id)
        {
            var loginItem = await _context.LoginItems.FindAsync(id);

            if (loginItem == null)
            {
                return NotFound();
            }

            return loginItem;
        }

        // PUT: api/LoginItems/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutLoginItem(long id, LoginItems loginItem)
        {
            if (id != loginItem.Id)
            {
                return BadRequest();
            }

            _context.Entry(loginItem).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LoginItemExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }


        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        // POST: api/LoginItems
        [HttpPost]
        public async Task<ActionResult<LoginItems>> PostLoginItem(LoginItems loginItem)
        {
            _context.LoginItems.Add(loginItem);
            await _context.SaveChangesAsync();

            //return CreatedAtAction("GetLoginItem", new { id = loginItem.Id }, loginItem);
            return CreatedAtAction(nameof(GetLoginItem), new { id = loginItem.Id }, loginItem);
        }

        // DELETE: api/LoginItems/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<LoginItems>> DeleteLoginItem(long id)
        {
            var loginItem = await _context.LoginItems.FindAsync(id);
            if (loginItem == null)
            {
                return NotFound();
            }

            _context.LoginItems.Remove(loginItem);
            await _context.SaveChangesAsync();

            return loginItem;
        }

        private bool LoginItemExists(long id)
        {
            return _context.LoginItems.Any(e => e.Id == id);
        }

    }
}
