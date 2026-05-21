package ordenamientoPokedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JTextArea;

public class AnimadorQuicksort implements Animador {
    private List<Pokemon> lista;
    private Stack<int[]> pila;
    private int[] rango;
    private int low, high, i, j;
    private int pivoteId;
    private Pokemon pivotePokemon;
    private int subFase; // 0 = inicio, 1 = particion, 2 = colocar
    private JTextArea log;

    public AnimadorQuicksort(List<Pokemon> original, JTextArea log) {
        this.lista = new ArrayList<>(original);
        this.pila = new Stack<>();
        pila.push(new int[]{0, lista.size() - 1});
        this.log = log;
        avanzarSiguienteRango();
    }

    private void avanzarSiguienteRango() {
        while (!pila.isEmpty()) {
            rango = pila.pop();
            low = rango[0];
            high = rango[1];
            if (low < high) {
                i = low - 1;
                j = low;
                pivotePokemon = lista.get(high);
                pivoteId = pivotePokemon.getId();
                subFase = 0;
                log.append("\nQuickSort: particionar [" + low + "-" + high + "] con pivote " + pivotePokemon.getNombre() + " (#" + pivoteId + ")\n");
                return;
            }
        }
        rango = null;
    }

    @Override
    public boolean avanzar() {
        if (rango == null) return false;

        if (subFase == 0) {
            subFase = 1;
            return true;
        } else if (subFase == 1) {
            if (j < high) {
                Pokemon actual = lista.get(j);
                log.append("  Comparar " + actual.getNombre() + " (#" + actual.getId() + ") con pivote → ");
                if (actual.getId() <= pivoteId) {
                    i++;
                    log.append("menor/igual → intercambiar posiciones " + i + " y " + j + "\n");
                    Pokemon temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                } else {
                    log.append("mayor → no intercambiar\n");
                }
                j++;
                return true;
            } else {
                subFase = 2;
                return true;
            }
        } else {
            log.append("  Colocar pivote en posición " + (i + 1) + "\n");
            Pokemon temp = lista.get(i + 1);
            lista.set(i + 1, lista.get(high));
            lista.set(high, temp);
            int pivotePos = i + 1;
            if (pivotePos + 1 < high) pila.push(new int[]{pivotePos + 1, high});
            if (low < pivotePos - 1) pila.push(new int[]{low, pivotePos - 1});
            avanzarSiguienteRango();
            return true;
        }
    }

    @Override
    public List<Pokemon> getListaActual() { return lista; }

    @Override
    public String getNombre() { return "Quicksort"; }
}