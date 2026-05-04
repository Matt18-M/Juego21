package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

    public static void main(String[] args) {
        Dealer d = new Dealer();

        for (int i = 0; i < 100; i++) {
            int num = d.generarAleatorio(51);
            System.out.println(num);
        }
    }
}