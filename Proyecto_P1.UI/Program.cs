using MudBlazor.Services;
using Proyecto_P1.Lib.Repositories;
using Proyecto_P1.Lib.Services;
using Proyecto_P1.UI.Components;

namespace Proyecto_P1.UI
{
    public class Program
    {
        /// <summary>
        /// Punto de entrada principal de la aplicación.
        /// </summary>
        public static async Task Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddRazorComponents()
                .AddInteractiveServerComponents();

            // MudBlazor
            builder.Services.AddMudServices();

            // Registro de servicios - Scoped para base de datos temporal por sesión
            builder.Services.AddScoped<IVehiculoRepository, VehiculoRepository>();
            builder.Services.AddScoped<VehiculoService>();

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Error", createScopeForErrors: true);
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseAntiforgery();

            app.MapStaticAssets();
            app.MapRazorComponents<App>()
                .AddInteractiveServerRenderMode();

            await app.RunAsync();
        }
    }
}
