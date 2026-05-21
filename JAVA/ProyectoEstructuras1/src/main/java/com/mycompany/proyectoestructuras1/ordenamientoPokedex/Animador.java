package com.mycompany.proyectoestructuras1.ordenamientoPokedex;

import java.util.List;

public interface Animador {
    /** Ejecuta un paso del algoritmo. Devuelve true si hay mas pasos, false si termino. */
    boolean avanzar();
    /** Devuelve la lista actual despues del ultimo paso. */
    List<Pokemon> getListaActual();
    /** Nombre del algoritmo para mostrar. */
    String getNombre();
}