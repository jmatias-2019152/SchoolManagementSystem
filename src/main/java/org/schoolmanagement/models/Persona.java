package org.schoolmanagement.models;

public class Persona {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String fechaDeNacimiento;

    public Persona(int id, String nombre, String apellido, String fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
