using Proyecto_P1.Lib.Models;
using System;
using System.Collections.Generic;

namespace Proyecto_P1.Lib.Repositories
{
    /// <summary>
    /// Implementación del repositorio de vehículos usando arreglos primitivos.
    /// Redimensionamiento manual y desplazamiento de elementos.
    /// </summary>
    public class VehiculoRepository : IVehiculoRepository
    {
        private Vehiculo[] _vehiculos;
        private int _cantidad;

        public VehiculoRepository()
        {
            _vehiculos = new Vehiculo[10]; // Tamaño inicial
            _cantidad = 0;
        }

        public int Cantidad => _cantidad;

        public void Insertar(Vehiculo vehiculo)
        {
            if (vehiculo == null)
                throw new ArgumentNullException(nameof(vehiculo), "El vehículo no puede ser nulo.");

            // Redimensionar si el arreglo está lleno
            if (_cantidad == _vehiculos.Length)
            {
                Vehiculo[] nuevoArreglo = new Vehiculo[_vehiculos.Length * 2];
                for (int i = 0; i < _cantidad; i++)
                {
                    nuevoArreglo[i] = _vehiculos[i];
                }
                _vehiculos = nuevoArreglo;
            }

            _vehiculos[_cantidad] = vehiculo;
            _cantidad++;
        }

        public void EliminarPorIndice(int indice)
        {
            if (indice < 0 || indice >= _cantidad)
                throw new IndexOutOfRangeException($"Índice {indice} fuera de rango. Rango válido: 0 a {_cantidad - 1}.");

            // Desplazar elementos a la izquierda para cubrir el hueco
            for (int i = indice; i < _cantidad - 1; i++)
            {
                _vehiculos[i] = _vehiculos[i + 1];
            }
            
            _vehiculos[_cantidad - 1] = null!; // Limpiar última referencia
            _cantidad--;
        }

        public void EliminarPorPlaca(string placa)
        {
            int indiceEncontrado = -1;
            for (int i = 0; i < _cantidad; i++)
            {
                if (_vehiculos[i].Placa.Equals(placa, StringComparison.OrdinalIgnoreCase))
                {
                    indiceEncontrado = i;
                    break;
                }
            }

            if (indiceEncontrado == -1)
                throw new KeyNotFoundException($"No se encontró un vehículo con la placa '{placa}'.");

            EliminarPorIndice(indiceEncontrado);
        }

        public void Modificar(int indice, Vehiculo vehiculoActualizado)
        {
            if (indice < 0 || indice >= _cantidad)
                throw new IndexOutOfRangeException($"Índice {indice} fuera de rango. Rango válido: 0 a {_cantidad - 1}.");

            if (vehiculoActualizado == null)
                throw new ArgumentNullException(nameof(vehiculoActualizado), "El vehículo actualizado no puede ser nulo.");

            _vehiculos[indice] = vehiculoActualizado;
        }

        public Vehiculo[] ObtenerTodos()
        {
            Vehiculo[] resultado = new Vehiculo[_cantidad];
            for (int i = 0; i < _cantidad; i++)
            {
                resultado[i] = _vehiculos[i];
            }
            return resultado;
        }

        public Vehiculo? BuscarPorPlaca(string placa)
        {
            for (int i = 0; i < _cantidad; i++)
            {
                if (_vehiculos[i].Placa.Equals(placa, StringComparison.OrdinalIgnoreCase))
                {
                    return _vehiculos[i];
                }
            }
            return null;
        }

        public Vehiculo? BuscarPorIndice(int indice)
        {
            if (indice < 0 || indice >= _cantidad)
                return null;

            return _vehiculos[indice];
        }

        public void LimpiarTodo()
        {
            _vehiculos = new Vehiculo[10];
            _cantidad = 0;
        }
    }
}
