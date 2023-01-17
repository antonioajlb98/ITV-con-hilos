package com.franciscodelosrios.proyctohilos;

import model.Coche;
import model.Itv;
import model.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public static void main(String[] args) {
        Itv itv = new Itv();
        Itv itv2 = new Itv();
        Itv itv3 = new Itv();
        Thread itv2Thread = new Thread(itv2);
        Thread itv3Thread = new Thread(itv3);
        Thread itvThread = new Thread(itv);
        itvThread.start();
        itv2Thread.start();
        itv3Thread.start();

        List<Thread> inspeccionadores = new ArrayList<>();
        Thread inspeccionador1 = new Thread(new Trabajador("Juan", itv));
        Thread inspeccionador2 = new Thread(new Trabajador("Pedro", itv2));
        Thread inspeccionador3 = new Thread(new Trabajador("Luis", itv3));
        inspeccionadores.add(inspeccionador1);
        inspeccionadores.add(inspeccionador2);
        inspeccionadores.add(inspeccionador3);
        inspeccionadores.forEach(Thread::start);

        for (Thread inspeccionador : inspeccionadores) {
            try {
                inspeccionador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La ITV ha terminado de inspeccionar todos los coches");
        System.out.println("La Itv ha inspecionado " + itv.getNumeroCoches() + " coches");
    }
}
