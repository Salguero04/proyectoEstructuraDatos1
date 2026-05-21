package com.mycompany.proyectoestructuras1;

/**
 * Interfaz del repositorio de vehículos con operaciones CRUD.
 * Utiliza arreglos primitivos.
 */
public interface IVehiculoRepository {

    /** Inserta un vehículo en el almacenamiento. */
    void insertar(Vehiculo vehiculo);

    /** Elimina un vehículo por su índice. */
    void eliminarPorIndice(int indice);

    /** Elimina un vehículo por su placa. */
    void eliminarPorPlaca(String placa);

    /** Modifica un vehículo en el índice dado. */
    void modificar(int indice, Vehiculo vehiculoActualizado);

    /** Obtiene todos los vehículos almacenados como un arreglo primitivo. */
    Vehiculo[] obtenerTodos();

    /** Busca un vehículo por su placa. */
    Vehiculo buscarPorPlaca(String placa);

    /** Busca un vehículo por índice. */
    Vehiculo buscarPorIndice(int indice);

    /** Obtiene la cantidad de vehículos almacenados. */
    int getCantidad();

    /** Limpia todos los datos del repositorio (para logout). */
    void limpiarTodo();
}
