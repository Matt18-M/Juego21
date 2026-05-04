package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

    public static void main(String[] args) {

        Juego21 juego = new Juego21();

        juego.agregarJugador(new Jugador("Mateo"));
        juego.agregarJugador(new Jugador("Luis"));
        juego.agregarJugador(new Jugador("Ana"));

        juego.inicializar();

        System.out.println("---- PRIMERA PARTIDA ----");

        ArrayList<Jugador> ganadores = juego.jugar();

        if (ganadores.isEmpty()) {
            System.out.println("No hubo ganadores.");
        } else {
            System.out.println("Ganadores:");
            for (Jugador j : ganadores) {
                j.imprimir();
            }
        }

        System.out.println("---- PRUEBA 10 PARTIDAS ----");

        for (int i = 0; i < 10; i++) {

            Juego21 nuevo = new Juego21();
            nuevo.agregarJugador(new Jugador("A"));
            nuevo.agregarJugador(new Jugador("B"));
            nuevo.agregarJugador(new Jugador("C"));
            nuevo.inicializar();

            ArrayList<Jugador> gw = nuevo.jugar();

            if (!gw.isEmpty()) {
                System.out.println("Ganadores en iteración " + i);
                for (Jugador g : gw) {
                    g.imprimir();
                }
                break;
            }
        }
    }
}