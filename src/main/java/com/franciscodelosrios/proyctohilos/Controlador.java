package com.franciscodelosrios.proyctohilos;

import model.Coche;
import model.Itv;
import model.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public static void main(String[] args) {
        Itv itv = new Itv();
        itv.addCoche(new Coche("Seat", "Ibiza", "1000"));
        itv.addCoche(new Coche("Seat", "Leon", "2000"));
        itv.addCoche(new Coche("Seat", "Toledo", "3000"));
        itv.addCoche(new Coche("Seat", "Arona", "4000"));
        itv.addCoche(new Coche("Seat", "Ateca", "7000"));

        List<Thread> inspeccionadores = new ArrayList<>();
        Thread inspeccionador1 = new Thread(new Trabajador("Juan", itv));
        Thread inspeccionador2 = new Thread(new Trabajador("Pedro", itv));
        Thread inspeccionador3 = new Thread(new Trabajador("Luis", itv));
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
