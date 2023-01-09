package org.example.entities;

public class Modulo {
    private int id;
    private String nombre;
    private int curso;
    private int horasSemanales;

    public Modulo() {
    }

    public Modulo(String nombre, int curso, int horasSemanales) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasSemanales = horasSemanales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", horasSemanales=" + horasSemanales +
                '}';
    }
}
