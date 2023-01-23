package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 50)
    private String primerApellido;
    @Column(length = 50)
    private String segundoApellido;
    @Column(length = 20, unique = true)
    private int nia;
    @Column(length = 20, unique = true)
    private int numeroTelefono;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "alumnos")
    private Set<Modulo> modulos;

    public Alumno() {
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, int nia, int numeroTelefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nia = nia;
        this.numeroTelefono = numeroTelefono;
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, int nia, int numeroTelefono, Set<Modulo> modulos) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nia = nia;
        this.numeroTelefono = numeroTelefono;
        this.modulos = modulos;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Set<Modulo> getModulos() {
        return this.modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", nia=" + nia +
                ", numeroTelefono=" + numeroTelefono +
                ", modulos=" + modulos +
                '}';
    }
}
