package model;

public class Trabajador implements Runnable {
    private String name;
    private final Itv itv;

    public Trabajador(String name, Itv itv) {
        this.name = name;
        this.itv = itv;
    }


    @Override
    public void run() {
        try {
            while (itv.hayCoches()) {
                synchronized (itv) {
                    if (itv.sacarCoche()) {
                        inspeccionarCoche(itv.getCoche());
                        itv.notifyAll();
                        itv.wait();
                    }
                }
            }
            synchronized (itv) {
                itv.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void inspeccionarCoche(Coche coche) {
        System.out.println("El trabajador " + name + " esta inspeccionando el coche " + coche.getMatricula());
        try {
            Thread.sleep(Integer.parseInt(coche.getTiempoInspeccion()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El trabajador " + name + " ha terminado de inspeccionar el coche " + coche.getMatricula());
    }
}
