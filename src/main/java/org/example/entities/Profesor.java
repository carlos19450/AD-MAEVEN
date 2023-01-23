package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
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
    private int numeroTelefono;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Direccion direccion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Modulo> modulo;

    public Profesor() {
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, int numeroTelefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, int numeroTelefono, Direccion direccion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.modulo = modulo;
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, int numeroTelefono, Direccion direccion, Set<Modulo> modulo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.modulo = modulo;
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

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Modulo> getModulo() {
        return modulo;
    }

    public void setModulo(Set<Modulo> modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
