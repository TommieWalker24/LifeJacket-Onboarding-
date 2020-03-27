using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.EntityFrameworkCore;
using LoginApi.Models;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Options;
using System.Threading.Tasks;

namespace LoginApi
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        #region snippet_ConfigureServices

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {

            //services.AddDbContext<LoginContext>(opt =>
            //   opt.UseInMemoryDatabase("TodoList"));
            //// Add framework services.
            ///
            services.AddRouting();

            services
                .AddDbContext<LoginContext>(opt =>
               opt.UseMySql(Configuration.GetConnectionString("DefaultConnection")));
            // requires using Microsoft.Extensions.Options
            //services.Configure<UserDataDatabaseSettings>(
            //    Configuration.GetSection(nameof(UserDataDatabaseSettings)));

            //services.AddSingleton<IUserDatabaseSettings>(sp =>
            //    sp.GetRequiredService<IOptions<UserDataDatabaseSettings>>().Value);
 

            services
                .AddControllers()
                .AddNewtonsoftJson(options => options.UseMemberCasing());

            services.AddAuthentication(options => {
                options.DefaultScheme = "Cookies";
            }).AddCookie("Cookies", options => {
                options.Cookie.Name = "auth_cookie";
                options.Cookie.SameSite = SameSiteMode.None;
                options.Events = new CookieAuthenticationEvents
                {
                    OnRedirectToLogin = redirectContext =>
                    {
                        redirectContext.HttpContext.Response.StatusCode = 401;
                        return Task.CompletedTask;
                    }
                };
            });

            services.AddCors();

        }
        #endregion
        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            //app.UseDefaultFiles();  //part of enabling "Call an ASP.NET Core web API with JavaScript"
            app.UseStaticFiles();
            
            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseCookiePolicy();
            //app.UseMvc();
            //app.UseAuthentication

            // see https://docs.microsoft.com/en-us/aspnet/core/security/authentication/social/social-without-identity?view=aspnetcore-3.1
            //app.UseAuthentication();

            //app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
