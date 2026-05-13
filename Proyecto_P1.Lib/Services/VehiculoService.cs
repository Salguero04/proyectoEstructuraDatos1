using Proyecto_P1.Lib.Exceptions;
using Proyecto_P1.Lib.Models;
using Proyecto_P1.Lib.Repositories;
using System;
using System.Collections.Generic;

namespace Proyecto_P1.Lib.Services
{
    /// <summary>
    /// Servicio de lógica de negocio para vehículos.
    /// Envuelve las llamadas al repositorio con manejo de excepciones.
    /// </summary>
    public class VehiculoService
    {
        private readonly IVehiculoRepository _repository;

        public VehiculoService(IVehiculoRepository repository)
        {
            _repository = repository ?? throw new ArgumentNullException(nameof(repository));
        }

        /// <summary>Inserta un nuevo vehículo validando los datos.</summary>
        public void Insertar(string placa, string propietario)
        {
            try
            {
                var vehiculo = new Vehiculo(placa, propietario);
                _repository.Insertar(vehiculo);
            }
            catch (ArgumentException ex)
            {
                throw new VehiculoException($"Error de validación al insertar: {ex.Message}", ex);
            }
            catch (FormatException ex)
            {
                throw new VehiculoException($"Error de formato al insertar: {ex.Message}", ex);
            }
        }

        /// <summary>Elimina un vehículo por su índice.</summary>
        public void EliminarPorIndice(int indice)
        {
            try
            {
                _repository.EliminarPorIndice(indice);
            }
            catch (IndexOutOfRangeException ex)
            {
                throw new VehiculoException($"Error al eliminar: {ex.Message}", ex);
            }
        }

        /// <summary>Elimina un vehículo por su placa.</summary>
        public void EliminarPorPlaca(string placa)
        {
            try
            {
                _repository.EliminarPorPlaca(placa);
            }
            catch (KeyNotFoundException ex)
            {
                throw new VehiculoException($"Error al eliminar: {ex.Message}", ex);
            }
        }

        /// <summary>Modifica un vehículo existente por índice.</summary>
        public void Modificar(int indice, string nuevaPlaca, string nuevoPropietario)
        {
            try
            {
                var vehiculoActualizado = new Vehiculo(nuevaPlaca, nuevoPropietario);
                _repository.Modificar(indice, vehiculoActualizado);
            }
            catch (ArgumentException ex)
            {
                throw new VehiculoException($"Error de validación al modificar: {ex.Message}", ex);
            }
            catch (FormatException ex)
            {
                throw new VehiculoException($"Error de formato al modificar: {ex.Message}", ex);
            }
            catch (IndexOutOfRangeException ex)
            {
                throw new VehiculoException($"Error al modificar: {ex.Message}", ex);
            }
        }

        /// <summary>Obtiene todos los vehículos.</summary>
        public Vehiculo[] ObtenerTodos()
        {
            return _repository.ObtenerTodos();
        }

        /// <summary>Busca un vehículo por placa.</summary>
        public Vehiculo? BuscarPorPlaca(string placa)
        {
            if (string.IsNullOrWhiteSpace(placa))
                throw new VehiculoException("La placa de búsqueda no puede estar vacía.");

            return _repository.BuscarPorPlaca(placa);
        }

        /// <summary>Busca un vehículo por índice.</summary>
        public Vehiculo? BuscarPorIndice(int indice)
        {
            return _repository.BuscarPorIndice(indice);
        }

        /// <summary>Obtiene la cantidad de vehículos.</summary>
        public int Cantidad => _repository.Cantidad;

        /// <summary>Limpia todos los datos (para cierre de sesión).</summary>
        public void LimpiarTodo()
        {
            _repository.LimpiarTodo();
        }
    }
}
