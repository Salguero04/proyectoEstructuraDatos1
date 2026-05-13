namespace Proyecto_P1.Lib.Exceptions
{
    /// <summary>
    /// Excepción personalizada para errores relacionados con operaciones de vehículos.
    /// </summary>
    public class VehiculoException : Exception
    {
        public VehiculoException(string message) : base(message) { }
        public VehiculoException(string message, Exception innerException) : base(message, innerException) { }
    }
}
