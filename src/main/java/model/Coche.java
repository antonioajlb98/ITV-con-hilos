package model;

public class Coche {

    private String marca;
    private String modelo;
    private String tiempoInspeccion;

    public Coche(String marca, String modelo, String tiempoInspeccion) {
        this.marca = marca;
        this.modelo = modelo;
        this.tiempoInspeccion = tiempoInspeccion;
    }
    public Coche() {
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getTiempoInspeccion() {
        return tiempoInspeccion;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setTiempoInspeccion(String tiempoInspeccion) {
        this.tiempoInspeccion = tiempoInspeccion;
    }





}
