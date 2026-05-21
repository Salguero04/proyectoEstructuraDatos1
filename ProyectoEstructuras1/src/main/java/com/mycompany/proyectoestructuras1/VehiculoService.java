package com.mycompany.proyectoestructuras1;

/**
 * Servicio de lógica de negocio para vehículos.
 * Envuelve las llamadas al repositorio con manejo de excepciones.
 * Patrón Singleton para compartir instancia entre formularios.
 */
public class VehiculoService {

    private static VehiculoService instancia;

    private final IVehiculoRepository repository;

    private VehiculoService(IVehiculoRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("El repositorio no puede ser nulo.");
        }
        this.repository = repository;
    }

    public static VehiculoService getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoService(VehiculoRepository.getInstancia());
        }
        return instancia;
    }

    /** Inserta un nuevo vehículo validando los datos. */
    public void insertar(String placa, String propietario, String modelo, String tipoMotor) throws VehiculoException {
        try {
            Vehiculo vehiculo = new Vehiculo(placa, propietario, modelo, tipoMotor);
            repository.insertar(vehiculo);
        } catch (IllegalArgumentException ex) {
            throw new VehiculoException("Error de validación al insertar: " + ex.getMessage(), ex);
        }
    }

    /** Elimina un vehículo por su índice. */
    public void eliminarPorIndice(int indice) throws VehiculoException {
        try {
            repository.eliminarPorIndice(indice);
        } catch (IndexOutOfBoundsException ex) {
            throw new VehiculoException("Error al eliminar: " + ex.getMessage(), ex);
        }
    }

    /** Elimina un vehículo por su placa. */
    public void eliminarPorPlaca(String placa) throws VehiculoException {
        try {
            repository.eliminarPorPlaca(placa);
        } catch (IllegalArgumentException ex) {
            throw new VehiculoException("Error al eliminar: " + ex.getMessage(), ex);
        }
    }

    /** Modifica un vehículo existente por índice. */
    public void modificar(int indice, String nuevaPlaca, String nuevoPropietario, String nuevoModelo, String nuevoTipoMotor) throws VehiculoException {
        try {
            Vehiculo vehiculoActualizado = new Vehiculo(nuevaPlaca, nuevoPropietario, nuevoModelo, nuevoTipoMotor);
            repository.modificar(indice, vehiculoActualizado);
        } catch (IllegalArgumentException ex) {
            throw new VehiculoException("Error de validación al modificar: " + ex.getMessage(), ex);
        } catch (IndexOutOfBoundsException ex) {
            throw new VehiculoException("Error al modificar: " + ex.getMessage(), ex);
        }
    }

    /** Obtiene todos los vehículos. */
    public Vehiculo[] obtenerTodos() {
        return repository.obtenerTodos();
    }

    /** Busca un vehículo por placa. */
    public Vehiculo buscarPorPlaca(String placa) throws VehiculoException {
        if (placa == null || placa.trim().isEmpty()) {
            throw new VehiculoException("La placa de búsqueda no puede estar vacía.");
        }
        return repository.buscarPorPlaca(placa);
    }

    /** Busca un vehículo por índice. */
    public Vehiculo buscarPorIndice(int indice) {
        return repository.buscarPorIndice(indice);
    }

    /** Obtiene la cantidad de vehículos. */
    public int getCantidad() {
        return repository.getCantidad();
    }

    /** Limpia todos los datos (para cierre de sesión). */
    public void limpiarTodo() {
        repository.limpiarTodo();
    }
}
