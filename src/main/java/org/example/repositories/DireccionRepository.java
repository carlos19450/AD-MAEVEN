package org.example.repositories;

import org.example.entities.Direccion;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class DireccionRepository implements Repository<Direccion>{
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public List<Direccion> findAll() {
        s.getTransaction().begin();
        List<Direccion> direccion = s.createSelectionQuery("from Direccion ", Direccion.class).list();
        s.getTransaction().commit();
        return direccion;
    }

    @Override
    public Optional<Direccion> findOneById(int id) {
        s.getTransaction().begin();
        Direccion direccion = s.get(Direccion.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(direccion);
    }

    @Override
    public Direccion save(Direccion direccion) {
        s.getTransaction().begin();
        s.persist(direccion);
        s.getTransaction().commit();
        return direccion;
    }

    @Override
    public Optional<Direccion> updateById(int id) {
        s.getTransaction().begin();
        Direccion direccion = s.get(Direccion.class, id);
        s.merge(direccion);
        s.getTransaction().commit();
        return Optional.ofNullable(direccion);
    }

    @Override
    public Optional<Direccion> deleteById(int id) {
        s.getTransaction().begin();
        Direccion direccion = s.get(Direccion.class, id);
        s.remove(direccion);
        s.getTransaction().commit();
        return Optional.ofNullable(direccion);
    }
    public void close() {
        s.close();
        sf.close();
    }
}
