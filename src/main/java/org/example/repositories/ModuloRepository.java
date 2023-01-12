package org.example.repositories;

import org.example.entities.Modulo;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ModuloRepository implements Repository<Modulo>{
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public List<Modulo> findAll() {
        s.getTransaction().begin();
        List<Modulo> modulo = s.createSelectionQuery("from Modulo ", Modulo.class).list();
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public Optional<Modulo> findOneById(int id) {
        s.getTransaction().begin();
        Modulo modulo = s.get(Modulo.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(modulo);
    }

    @Override
    public Modulo save(Modulo modulo) {
        s.getTransaction().begin();
        s.persist(modulo);
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public Optional<Modulo> updateById(int id) {
        s.getTransaction().begin();
        Modulo modulo = s.get(Modulo.class, id);
        s.merge(modulo);
        s.getTransaction().commit();
        return Optional.ofNullable(modulo);
    }

    @Override
    public Optional<Modulo> deleteById(int id) {
        s.getTransaction().begin();
        Modulo modulo = s.get(Modulo.class, id);
        s.remove(modulo);
        s.getTransaction().commit();
        return Optional.ofNullable(modulo);
    }
    public void close() {
        s.close();
        sf.close();
    }
}
