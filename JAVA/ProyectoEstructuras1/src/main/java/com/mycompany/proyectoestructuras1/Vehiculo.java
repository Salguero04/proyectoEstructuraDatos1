package com.mycompany.proyectoestructuras1;

import java.util.regex.Pattern;

/**
 * Modelo de Vehículo con encapsulamiento estricto y validaciones.
 */
public class Vehiculo {

    private String placa = "";
    private String propietario = "";

    private static final Pattern PLACA_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern PROPIETARIO_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");

    /**
     * Constructor parametrizado con validaciones.
     */
    public Vehiculo(String placa, String propietario) {
        setPlaca(placa);
        setPropietario(propietario);
    }

    /**
     * Constructor vacío requerido para serialización.
     */
    public Vehiculo() {
    }

    /**
     * Placa del vehículo. Solo acepta entre 7 y 8 caracteres alfanuméricos.
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula ni vacía.");
        }
        if (value.length() < 7 || value.length() > 8) {
            throw new IllegalArgumentException("La placa debe tener entre 7 y 8 caracteres.");
        }
        if (!PLACA_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("La placa solo debe contener caracteres alfanuméricos.");
        }
        this.placa = value.toUpperCase();
    }

    /**
     * Propietario del vehículo. Solo acepta letras y espacios.
     */
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El propietario no puede ser nulo ni vacío.");
        }
        if (!PROPIETARIO_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El propietario solo debe contener letras y espacios.");
        }
        this.propietario = value.trim();
    }

    @Override
    public String toString() {
        return "[" + placa + "] - " + propietario;
    }
}
