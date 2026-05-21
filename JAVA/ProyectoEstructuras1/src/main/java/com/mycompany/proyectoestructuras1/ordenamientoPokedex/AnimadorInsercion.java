package com.mycompany.proyectoestructuras1.ordenamientoPokedex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class AnimadorInsercion implements Animador {
    private List<Pokemon> lista;
    private int i, j;
    private Pokemon clave;
    private int fase; // 0 = tomar, 1 = desplazar, 2 = insertar
    private JTextArea log;

    public AnimadorInsercion(List<Pokemon> original, JTextArea log) {
        this.lista = new ArrayList<>(original);
        this.i = 1;
        this.fase = 0;
        this.log = log;
    }

    @Override
    public boolean avanzar() {
        int n = lista.size();
        if (i < n) {
            if (fase == 0) {
                clave = lista.get(i);
                j = i - 1;
                log.append("Insertar " + clave.getNombre() + " (#" + clave.getId() + ") desde posicion " + i + "\n");
                fase = 1;
                return true;
            } else if (fase == 1) {
                if (j >= 0 && lista.get(j).getId() > clave.getId()) {
                    log.append("  Desplazar a la derecha: " + lista.get(j).getNombre() + "\n");
                    lista.set(j + 1, lista.get(j));
                    j--;
                    return true;
                } else {
                    fase = 2;
                    return true;
                }
            } else {
                lista.set(j + 1, clave);
                log.append("  Colocar " + clave.getNombre() + " en posicion " + (j + 1) + "\n");
                i++;
                fase = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Pokemon> getListaActual() { return lista; }

    @Override
    public String getNombre() { return "Insercion"; }
}