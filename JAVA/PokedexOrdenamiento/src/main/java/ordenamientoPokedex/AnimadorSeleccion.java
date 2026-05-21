package ordenamientoPokedex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class AnimadorSeleccion implements Animador {
    private List<Pokemon> lista;
    private int i, j, minIdx;
    private int estado; // 0 = buscar mínimo, 1 = intercambiar
    private JTextArea log;

    public AnimadorSeleccion(List<Pokemon> original, JTextArea log) {
        this.lista = new ArrayList<>(original);
        this.i = 0;
        this.j = 1;
        this.minIdx = 0;
        this.estado = 0;
        this.log = log;
    }

    @Override
    public boolean avanzar() {
        int n = lista.size();
        if (i < n - 1) {
            if (estado == 0) {
                if (j < n) {
                    Pokemon actualMin = lista.get(minIdx);
                    Pokemon actual = lista.get(j);
                    log.append("Buscar mínimo: " + actualMin.getNombre() + " (#" + actualMin.getId() + ") vs " + actual.getNombre() + " (#" + actual.getId() + ") → ");
                    if (actual.getId() < actualMin.getId()) {
                        minIdx = j;
                        log.append("nuevo mínimo\n");
                    } else {
                        log.append("no cambia\n");
                    }
                    j++;
                    return true;
                } else {
                    estado = 1;
                    return true;
                }
            } else {
                if (minIdx != i) {
                    log.append("Intercambiar posición " + i + " (" + lista.get(i).getNombre() + ") con mínimo " + lista.get(minIdx).getNombre() + "\n");
                    Pokemon temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                } else {
                    log.append("El mínimo ya está en su lugar\n");
                }
                i++;
                if (i < n - 1) {
                    minIdx = i;
                    j = i + 1;
                    estado = 0;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Pokemon> getListaActual() { return lista; }

    @Override
    public String getNombre() { return "Selección"; }
}