using Proyecto_P1.Lib.Models;

namespace Proyecto_P1.Lib.Repositories
{
    /// <summary>
    /// Interfaz del repositorio de vehículos con operaciones CRUD.
    /// Utiliza arreglos primitivos.
    /// </summary>
    public interface IVehiculoRepository
    {
        /// <summary>Inserta un vehículo en el almacenamiento.</summary>
        void Insertar(Vehiculo vehiculo);

        /// <summary>Elimina un vehículo por su índice.</summary>
        void EliminarPorIndice(int indice);

        /// <summary>Elimina un vehículo por su placa.</summary>
        void EliminarPorPlaca(string placa);

        /// <summary>Modifica un vehículo en el índice dado.</summary>
        void Modificar(int indice, Vehiculo vehiculoActualizado);

        /// <summary>Obtiene todos los vehículos almacenados como un arreglo primitivo.</summary>
        Vehiculo[] ObtenerTodos();

        /// <summary>Busca un vehículo por su placa.</summary>
        Vehiculo? BuscarPorPlaca(string placa);

        /// <summary>Busca un vehículo por índice.</summary>
        Vehiculo? BuscarPorIndice(int indice);

        /// <summary>Obtiene la cantidad de vehículos almacenados.</summary>
        int Cantidad { get; }

        /// <summary>Limpia todos los datos del repositorio (para logout).</summary>
        void LimpiarTodo();
    }
}
