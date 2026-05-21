package com.mycompany.proyectoestructuras1;

import java.util.regex.Pattern;

/**
 * Modelo de Vehículo con encapsulamiento estricto y validaciones.
 */
public class Vehiculo {

    private String placa = "";
    private String propietario = "";
    private String modelo = "Genérico";
    private String tipoMotor = "Estándar";

    private static final Pattern PLACA_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern PROPIETARIO_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");

    /**
     * Constructor parametrizado con validaciones.
     */
    public Vehiculo(String placa, String propietario, String modelo, String tipoMotor) {
        setPlaca(placa);
        setPropietario(propietario);
        setModelo(modelo);
        setTipoMotor(tipoMotor);
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

    public void setPropietario(String propietario) {
        if (propietario == null || propietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El propietario no puede estar vacío");
        }
        if (!PROPIETARIO_PATTERN.matcher(propietario).matches()) {
            throw new IllegalArgumentException("El nombre del propietario contiene caracteres inválidos");
        }
        this.propietario = propietario.trim();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        }
        this.modelo = modelo.trim();
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        if (tipoMotor == null || tipoMotor.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de motor no puede estar vacío");
        }
        this.tipoMotor = tipoMotor.trim();
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", propietario='" + propietario + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                '}';
    }
}
