package org.example.repositories;

import org.example.entities.Profesor;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ProfesorRepository implements Repository<Profesor>{
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public List<Profesor> findAll() {
        s.getTransaction().begin();
        List<Profesor> profesor = s.createSelectionQuery("from Profesor ", Profesor.class).list();
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public Optional<Profesor> findOneById(int id) {
        s.getTransaction().begin();
        Profesor profesor = s.get(Profesor.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(profesor);
    }

    @Override
    public Profesor save(Profesor profesor) {
        s.getTransaction().begin();
        s.persist(profesor);
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public Optional<Profesor> updateById(int id) {
        s.getTransaction().begin();
        Profesor profesor = s.get(Profesor.class, id);
        s.merge(profesor);
        s.getTransaction().commit();
        return Optional.ofNullable(profesor);
    }

    @Override
    public Optional<Profesor> deleteById(int id) {
        s.getTransaction().begin();
        Profesor profesor = s.get(Profesor.class, id);
        s.remove(profesor);
        s.getTransaction().commit();
        return Optional.ofNullable(profesor);
    }
    public void close() {
        s.close();
        sf.close();
    }
}
