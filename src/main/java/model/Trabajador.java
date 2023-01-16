package model;

public class Trabajador implements Runnable {
    private String name;
    private Itv itv;

    public Trabajador(String name, Itv itv) {
        this.name = name;
        this.itv = itv;
    }

    @Override
    public void run() {
        while (true) {
            Coche coche = itv.nextCoche();
            if (coche == null) {
                break;
            }
            inspeccionarCoche(coche);

        }
    }
    private void inspeccionarCoche(Coche coche) {
        System.out.println("El trabajador " + name + " esta inspeccionando el coche " + coche.getMarca() + " " + coche.getModelo());
        try {
            Thread.sleep(Integer.parseInt(coche.getTiempoInspeccion()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El trabajador " + name + " ha terminado de inspeccionar el coche " + coche.getMarca() + " " + coche.getModelo());
    }
}
