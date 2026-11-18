package org.example.ejercicio3;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean activo;

    public Cliente(int id, String nombre, String apellido, String correo, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isActivo() {
        return activo;
    }
}