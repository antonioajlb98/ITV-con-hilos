package com.franciscodelosrios.proyctohilos;

import model.Itv;
import model.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        //Creamos las Lineas de la itv en la que vamos a dividir el trabajo
        Itv linea1 = new Itv();
        Itv linea2 = new Itv();
        Itv linea3 = new Itv();
        List<Thread> Lineas = new ArrayList<>();
        Lineas.add(new Thread(linea1));
        Lineas.add(new Thread(linea2));
        Lineas.add(new Thread(linea3));
        Lineas.forEach(Thread::start);
        //Creamos los trabajdores y los arrancamos
        List<Thread> Trabajadores = new ArrayList<>();
        Thread trabajador1 = new Thread(new Trabajador("Paco", linea1));
        Thread trabajador2 = new Thread(new Trabajador("Manolo", linea2));
        Thread trabajador3 = new Thread(new Trabajador("Antonio", linea3));
        Trabajadores.add(trabajador1);
        Trabajadores.add(trabajador2);
        Trabajadores.add(trabajador3);
        Trabajadores.forEach(Thread::start);

        for (Thread trabajador : Trabajadores) {
            try {
                trabajador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos los trabajadores han terminado");
        System.out.println("La ITV ha inspeccionado un total de " + linea1.getCochesInspeccionados() + " coches");
    }
