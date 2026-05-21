package com.mycompany.proyectoestructuras1.ordenamientoPokedex;

import java.util.List;

public interface Animador {
    /** Ejecuta un paso del algoritmo. Devuelve true si hay mÃ¡s pasos, false si terminÃ³. */
    boolean avanzar();
    /** Devuelve la lista actual despuÃ©s del Ãºltimo paso. */
    List<Pokemon> getListaActual();
    /** Nombre del algoritmo para mostrar. */
    String getNombre();
}
