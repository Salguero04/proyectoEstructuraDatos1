using System.Text.RegularExpressions;

namespace Proyecto_P1.Lib.Models
{
    /// <summary>
    /// Modelo de Vehículo con encapsulamiento estricto y validaciones.
    /// </summary>
    public class Vehiculo
    {
        private string _placa = string.Empty;
        private string _propietario = string.Empty;

        /// <summary>
        /// Placa del vehículo. Solo acepta entre 7 y 8 caracteres alfanuméricos.
        /// </summary>
        public string Placa
        {
            get => _placa;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("La placa no puede ser nula ni vacía.");

                if (value.Length < 7 || value.Length > 8)
                    throw new ArgumentException("La placa debe tener entre 7 y 8 caracteres.");

                if (!Regex.IsMatch(value, @"^[a-zA-Z0-9]+$"))
                    throw new ArgumentException("La placa solo debe contener caracteres alfanuméricos.");

                _placa = value.ToUpper();
            }
        }

        /// <summary>
        /// Propietario del vehículo. Solo acepta letras y espacios.
        /// </summary>
        public string Propietario
        {
            get => _propietario;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new FormatException("El propietario no puede ser nulo ni vacío.");

                if (!Regex.IsMatch(value, @"^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$"))
                    throw new FormatException("El propietario solo debe contener letras y espacios.");

                _propietario = value.Trim();
            }
        }

        /// <summary>
        /// Constructor parametrizado con validaciones.
        /// </summary>
        public Vehiculo(string placa, string propietario)
        {
            Placa = placa;
            Propietario = propietario;
        }

        /// <summary>
        /// Constructor vacío requerido para serialización.
        /// </summary>
        public Vehiculo() { }

        public override string ToString()
        {
            return $"[{Placa}] - {Propietario}";
        }
    }
}
