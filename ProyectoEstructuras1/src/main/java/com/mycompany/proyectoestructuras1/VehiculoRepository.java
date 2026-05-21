package com.mycompany.proyectoestructuras1;

/**
 * Implementación del repositorio de vehículos usando arreglos primitivos.
 * Redimensionamiento manual y desplazamiento de elementos.
 * Patrón Singleton para compartir datos entre formularios.
 */
public class VehiculoRepository implements IVehiculoRepository {

    private static VehiculoRepository instancia;

    private Vehiculo[] vehiculos;
    private int cantidad;

    private VehiculoRepository() {
        vehiculos = new Vehiculo[10]; // Tamaño inicial
        cantidad = 0;
    }

    public static VehiculoRepository getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoRepository();
        }
        return instancia;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void insertar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }

        // Redimensionar si el arreglo está lleno
        if (cantidad == vehiculos.length) {
            Vehiculo[] nuevoArreglo = new Vehiculo[vehiculos.length * 2];
            for (int i = 0; i < cantidad; i++) {
                nuevoArreglo[i] = vehiculos[i];
            }
            vehiculos = nuevoArreglo;
        }

        vehiculos[cantidad] = vehiculo;
        cantidad++;
    }

    @Override
    public void eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException(
                    "Índice " + indice + " fuera de rango. Rango válido: 0 a " + (cantidad - 1) + ".");
        }

        // Desplazar elementos a la izquierda para cubrir el hueco
        for (int i = indice; i < cantidad - 1; i++) {
            vehiculos[i] = vehiculos[i + 1];
        }

        vehiculos[cantidad - 1] = null; // Limpiar última referencia
        cantidad--;
    }

    @Override
    public void eliminarPorPlaca(String placa) {
        int indiceEncontrado = -1;
        for (int i = 0; i < cantidad; i++) {
            if (vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            throw new IllegalArgumentException("No se encontró un vehículo con la placa '" + placa + "'.");
        }

        eliminarPorIndice(indiceEncontrado);
    }

    @Override
    public void modificar(int indice, Vehiculo vehiculoActualizado) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException(
                    "Índice " + indice + " fuera de rango. Rango válido: 0 a " + (cantidad - 1) + ".");
        }

        if (vehiculoActualizado == null) {
            throw new IllegalArgumentException("El vehículo actualizado no puede ser nulo.");
        }

        vehiculos[indice] = vehiculoActualizado;
    }

    @Override
    public Vehiculo[] obtenerTodos() {
        Vehiculo[] resultado = new Vehiculo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = vehiculos[i];
        }
        return resultado;
    }

    @Override
    public Vehiculo buscarPorPlaca(String placa) {
        for (int i = 0; i < cantidad; i++) {
            if (vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                return vehiculos[i];
            }
        }
        return null;
    }

    @Override
    public Vehiculo buscarPorIndice(int indice) {
        if (indice < 0 || indice >= cantidad) {
            return null;
        }
        return vehiculos[indice];
    }

    @Override
    public void limpiarTodo() {
        vehiculos = new Vehiculo[10];
        cantidad = 0;
    }
}
