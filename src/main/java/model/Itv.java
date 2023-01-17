package model;

import java.util.ArrayList;
import java.util.List;

public class Itv implements Runnable {
    private Coche coche;
    private static Integer numeroCoches=10;


    public Itv() {
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
            Coche aux = new Coche();
            aux.setMatricula((int) (Math.random() * 10000));
            aux.setTiempoInspeccion(String.valueOf((int) (Math.random() * 10000)));
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
        if (numeroCoches > 0) {
            numeroCoches--;
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
