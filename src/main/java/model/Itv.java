package model;

import java.util.ArrayList;
import java.util.List;

public class Itv {

    private List<Coche> coches;
    private Integer numeroCoches;

    public Itv() {
        coches = new ArrayList<>();
        numeroCoches = 0;
    }

    public Integer getNumeroCoches() {
        return numeroCoches;
    }

    public synchronized void addCoche(Coche coche) {
        coches.add(coche);
    }
    public synchronized Coche nextCoche() {
        if(numeroCoches >= coches.size()) {
            return null;
        }
        return coches.get(numeroCoches++);
    }


}
