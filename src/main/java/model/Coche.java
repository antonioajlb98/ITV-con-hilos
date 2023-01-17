package model;

import java.util.Random;

public class Coche {

    private String matricula;
    private String tiempoInspeccion;

    public Coche( String tiempoInspeccion, String matricula) {
        this.tiempoInspeccion = tiempoInspeccion;
        this.matricula = matricula;
    }
    public Coche() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTiempoInspeccion() {
        return tiempoInspeccion;
    }
    public void setTiempoInspeccion(String tiempoInspeccion) {
        this.tiempoInspeccion = tiempoInspeccion;
    }
    public String generarMatricula() {
        Random random = new Random();
        String numeros = "";
        for (int i = 0; i < 4; i++) {
            numeros += random.nextInt(10);
        }
        String letras = "";
        for (int i = 0; i < 3; i++) {
            letras += (char)(random.nextInt(26) + 'A');
        }

        return numeros + "-" + letras;
    }





}
