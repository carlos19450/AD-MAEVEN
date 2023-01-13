package org.example;

import org.example.entities.Modulo;
import org.example.entities.Profesor;
import org.example.repositories.ModuloRepository;

import java.time.LocalDate;
import java.util.Optional;

public class App
{
    public static void main( String[] args )
    {
        ModuloRepository modulos = new ModuloRepository();

        Profesor p1 = new Profesor("Paco", "Perez", "Cacho", 675648321, "Calle Perico/8");

        Modulo m1 = new Modulo("Matematicas", 4, 16, p1);
        Modulo m2 = new Modulo("Ingles", 2, 8, p1);

        System.out.println("\nAntes de insertar ------ ");
        System.out.println(m1);
        System.out.println(m2);

        //Crear modulos
        modulos.save(m1);
        modulos.save(m2);
        System.out.println("\nCreamos modulos ------");
        modulos.findAll().forEach(System.out::println);

        //Leer por id
        Optional<Modulo> pilotoCopia = modulos.findOneById(m2.getId());
        System.out.println("\nLeer por id ------ ");
        if (pilotoCopia.isPresent())
            System.out.println(pilotoCopia);
        else
            System.out.println("El id del modulo no existe");

        //Leer por id (no existe)
        System.out.println("\nLeer por id que no existe------ ");
        Optional<Modulo> moduloNoExiste = modulos.findOneById(3);
        if (moduloNoExiste.isPresent())
            System.out.println(moduloNoExiste);
        else
            System.out.println("El id del modulo no existe");

        //Actualizar por id
        System.out.println("\nTras actualizar, lectura ------ ");
        pilotoCopia = modulos.findOneById(m2.getId());
        if (pilotoCopia.isPresent()) {
            m2.setNombre("Castellano");
            modulos.updateById(2);
            System.out.println(m2);
        }else
            System.out.println("El id del modulo no existe");


        // Borrado del piloto p3
        modulos.deleteById(2);

        // Ver todos
        System.out.println("\nBorrado y lectura ------ ");
        modulos.findAll().forEach(System.out::println);

        modulos.close();
    }
}
