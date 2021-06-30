package com.example.app01sqlite.tablas;

public class Persona {

    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer edades;
    private String correos;
    private String direcciones;

    public  Persona(){

    }

    public Persona(Integer id, String nombres, String apellidos, Integer edades, String correos, String direcciones){
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edades = edades;
        this.correos = correos;
        this.direcciones = direcciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdades() {
        return edades;
    }

    public void setEdades(Integer edades) {
        this.edades = edades;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }
}
