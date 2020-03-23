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

            //services.AddAuthentication(options =>
            //    {
            //        options.DefaultScheme = CookieAuthenticationDefaults.AuthenticationScheme;
            //        options.DefaultChallengeScheme = GoogleDefaults.AuthenticationScheme;
            //    })
            //    .AddCookie()
            //    .AddGoogle(options =>
            //    {
            //        options.ClientId = Configuration["Authentication:Google:CliendID"];
            //        options.ClientSecret = Configuration["Authentication:Google:ClientSecret"];
            //    });
            //services.Configure<CookiePolicyOptions>(options =>
            //{
            //    // This lambda determines whether user consent for non-essential cookies is needed for a given request.
            //    options.CheckConsentNeeded = context => true;
            //    options.MinimumSameSitePolicy = Microsoft.AspNetCore.Http.SameSiteMode.None;
            //});
            //services.AddSingleton<IHttpContextAccessor, HttpContextAccessor>();

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
