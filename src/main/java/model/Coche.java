package model;

public class Coche {

    private Integer matricula;
    private String tiempoInspeccion;

    public Coche( String tiempoInspeccion, Integer matricula) {
        this.tiempoInspeccion = tiempoInspeccion;
        this.matricula = matricula;
    }
    public Coche() {
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getTiempoInspeccion() {
        return tiempoInspeccion;
    }
    public void setTiempoInspeccion(String tiempoInspeccion) {
        this.tiempoInspeccion = tiempoInspeccion;
    }





}
