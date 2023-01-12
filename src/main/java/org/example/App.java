package org.example;

import org.example.entities.Modulo;
import org.example.entities.Profesor;
import org.example.repositories.ModuloRepository;

public class App
{
    public static void main( String[] args )
    {
        ModuloRepository modulos = new ModuloRepository();

        Profesor p1 = new Profesor();

        Modulo m1 = new Modulo("Matematicas", 4, 16, p1);
        Modulo m2 = new Modulo("Ingles", 2, 8, p1);
        modulos.close();
    }
}
