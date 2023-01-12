package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "modulos")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, unique = true)
    private String nombre;
    @Column(length = 50, unique = true)
    private int curso;
    @Column(length = 30, unique = true)
    private int horasSemanales;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Profesor profesor;
    public Modulo() {
    }

    public Modulo(String nombre, int curso, int horasSemanales) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasSemanales = horasSemanales;
    }

    public Modulo(String nombre, int curso, int horasSemanales, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasSemanales = horasSemanales;
        this.profesor = profesor;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", horasSemanales=" + horasSemanales +
                ", profesor=" + profesor +
                '}';
    }
}
