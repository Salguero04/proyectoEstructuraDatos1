package ordenamientoPokedex;

import java.util.List;

public interface Animador {
    /** Ejecuta un paso del algoritmo. Devuelve true si hay más pasos, false si terminó. */
    boolean avanzar();
    /** Devuelve la lista actual después del último paso. */
    List<Pokemon> getListaActual();
    /** Nombre del algoritmo para mostrar. */
    String getNombre();
}