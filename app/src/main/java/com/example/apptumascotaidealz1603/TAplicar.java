package com.example.apptumascotaidealz1603;

public class TAplicar {
    private int idAplicar;
    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private String telefono;
    private String correo;
    private String contraseña;

    public TAplicar(){
    }

    public int getIdAplicar() { return idAplicar; }

    public void setIdAplicar(int idAplicar) {
        this.idAplicar = idAplicar;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNumeroDocumento(String numeroDocumento) {this.numeroDocumento = numeroDocumento; }

    public String getNumeroDocumento() {return numeroDocumento;}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

}
