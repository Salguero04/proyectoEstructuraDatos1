package ordenamientoPokedex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class AnimadorBurbuja implements Animador {
    private List<Pokemon> lista;
    private int i, j;
    private boolean intercambiado;
    private int n;
    private JTextArea log;

    public AnimadorBurbuja(List<Pokemon> original, JTextArea log) {
        this.lista = new ArrayList<>(original);
        this.n = lista.size();
        this.i = 0;
        this.j = 0;
        this.intercambiado = false;
        this.log = log;
    }

    @Override
    public boolean avanzar() {
        if (i < n - 1) {
            if (j < n - i - 1) {
                Pokemon a = lista.get(j);
                Pokemon b = lista.get(j + 1);
                log.append("Comparar " + a.getNombre() + " (#" + a.getId() + ") con " + b.getNombre() + " (#" + b.getId() + ") → ");
                if (a.getId() > b.getId()) {
                    // Intercambio
                    lista.set(j, b);
                    lista.set(j + 1, a);
                    log.append("INTERCAMBIAR\n");
                    intercambiado = true;
                } else {
                    log.append("no cambiar\n");
                }
                j++;
                return true;
            } else {
                log.append("Fin pasada " + (i + 1) + "\n");
                if (!intercambiado) return false; // ordenado
                i++;
                j = 0;
                intercambiado = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Pokemon> getListaActual() { return lista; }

    @Override
    public String getNombre() { return "Burbuja"; }
}