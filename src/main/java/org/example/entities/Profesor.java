package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, unique = true)
    private String nombre;
    @Column(length = 50, unique = true)
    private String primerApellido;
    @Column(length = 50, unique = true)
    private String segundoApellido;
    @Column(length = 20, unique = true)
    private int numeroTelefono;
    @Column(length = 50, unique = true)
    private String direccion;
    @OneToMany(mappedBy = "equipo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Modulo> modulo;

    public Profesor() {
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, int numeroTelefono, String direccion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, int numeroTelefono, String direccion, Set<Modulo> modulo) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
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
                ", modulo=" + modulo +
                '}';
    }
}
