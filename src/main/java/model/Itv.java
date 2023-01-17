package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Itv implements Runnable {
    private Coche coche;
    private static Integer numeroCoches=10;
    private static Integer cochesInspeccionados=0;


    public Itv() {
    }

    public Integer getCochesInspeccionados() {
        return cochesInspeccionados;
    }


    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Integer getNumeroCoches() {
        return numeroCoches;
    }

    public Coche generaCoches() {
        Random random = new Random();
            Coche aux = new Coche();
            aux.setMatricula(aux.generarMatricula());
            aux.setTiempoInspeccion(random.nextInt(7001)+1000+"");
            return aux;
    }
    public synchronized boolean hayCoches(){
        if(numeroCoches>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean sacarCoche() {
        if (hayCoches()) {
            numeroCoches--;
            cochesInspeccionados++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void run() {
        try{
            while(hayCoches()) {
                if(sacarCoche()){
                    synchronized (this) {
                        this.coche = generaCoches();
                        this.notifyAll();
                        this.wait();
                    }
                }
                }
            synchronized (this) {
                this.notifyAll();
            }
            }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
