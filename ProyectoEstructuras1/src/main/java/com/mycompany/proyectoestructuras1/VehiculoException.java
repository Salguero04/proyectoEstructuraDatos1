package com.mycompany.proyectoestructuras1;

/**
 * Excepción personalizada para errores relacionados con operaciones de vehículos.
 */
public class VehiculoException extends Exception {

    public VehiculoException(String message) {
        super(message);
    }

    public VehiculoException(String message, Throwable cause) {
        super(message, cause);
    }
}
