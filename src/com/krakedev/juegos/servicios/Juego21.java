package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Dealer dealer;

    public void cargarValores() {
        for (Carta c : dealer.getNaipe()) {
            switch (c.getValor()) {
                case "A":
                    c.setValorJuego(11);
                    break;
                case "J":
                case "Q":
                case "K":
                    c.setValorJuego(10);
                    break;
                default:
                    c.setValorJuego(Integer.parseInt(c.getValor()));
            }
        }
    }

    public void inicializar() {
        dealer = new Dealer();
        cargarValores();

        // reinicia a los jugadores
        for (Jugador j : jugadores) {
            j.limpiarCartas();
        }
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void repartirCarta(Jugador jugador) {
        Carta carta = dealer.entregarCarta();
        jugador.recibirCarta(carta);
    }

    public void repartirRonda() {
        for (Jugador j : jugadores) {
            repartirCarta(j);
        }
        calcularTotal();
    }

    public void calcularTotal() {
        for (Jugador j : jugadores) {
            int suma = 0;
            for (Carta c : j.getCartas()) {
                suma += c.getValorJuego();
            }
            j.setPuntajeCartas(suma);
        }
    }

    public ArrayList<Jugador> validarGanador() {
        ArrayList<Jugador> ganadores = new ArrayList<>();

        for (Jugador j : jugadores) {
            if (j.getPuntajeCartas() == 21) {
                ganadores.add(j);
            }
        }

        return ganadores;
    }

    public ArrayList<Jugador> jugar() {
        ArrayList<Jugador> ganadores = null;

        for (int i = 0; i < 3; i++) {
            repartirRonda();
            ganadores = validarGanador();

            if (!ganadores.isEmpty()) {
                break;
            }
        }

        return ganadores;
    }
}