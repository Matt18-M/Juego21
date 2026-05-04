package com.krakedev.juegos.entidades;

import java.util.ArrayList;

public class Jugador {

    private String nickname;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int puntajeCartas;

    public Jugador(String nickname) {
        this.nickname = nickname;
    }

    public void recibirCarta(Carta c) {
        cartas.add(c);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int getPuntajeCartas() {
        return puntajeCartas;
    }

    public void setPuntajeCartas(int puntajeCartas) {
        this.puntajeCartas = puntajeCartas;
    }

    public void limpiarCartas() {
        cartas.clear();
        puntajeCartas = 0;
    }

    public void imprimir() {
        System.out.println("Jugador: " + nickname);
        for (Carta c : cartas) {
            c.imprimir();
        }
        System.out.println("Puntaje total: " + puntajeCartas);
        System.out.println("---------------------------");
    }
}