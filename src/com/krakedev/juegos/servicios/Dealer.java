package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.Carta;

public class Dealer {

    private ArrayList<Carta> naipe;

    public Dealer() {
        naipe = new ArrayList<>();
        generarNaipe();
    }

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    private void generarNaipe() {
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] palos = {"T","CN","CR","D"};

        for (String palo : palos) {
            for (String v : valores) {
                Carta c = new Carta();
                c.setValor(v);
                c.setPalo(palo);
                naipe.add(c);
            }
        }
    }

    public void imprimirNaipe() {
        for (Carta c : naipe) {
            c.imprimir();
        }
    }

    public int generarAleatorio(int maximo) {
        return (int) (Math.random() * (maximo + 1));
    }

    public Carta entregarCarta() {
        int pos = generarAleatorio(naipe.size() - 1);
        Carta seleccionada = naipe.get(pos);
        naipe.remove(pos);
        return seleccionada;
    }
}