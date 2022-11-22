package com.example.apptumascotaidealz1603;

public class Tabla_mascotas {
    private int idCrearMascota;
    private String tipo;
    private String nombreMascota;
    private String sexoMascota;
    private String raza;
    private String edad;
    private String vacunas;

    public Tabla_mascotas(){}

    public int getIdCrearMascota() {
        return idCrearMascota;
    }

    public void setIdCrearMascota(int idCrearMascota) {
        this.idCrearMascota = idCrearMascota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getSexoMascota() {
        return sexoMascota;
    }

    public void setSexoMascota(String sexoMascota) {
        this.sexoMascota = sexoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }
}
