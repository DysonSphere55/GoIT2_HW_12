package goit.planet;

import goit.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class PlanetCrudService {

    public String create(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
        return planet.getId();
    }

    public Planet getById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            NativeQuery<Planet> query = session.createNativeQuery(
                    "SELECT * FROM planet WHERE id = :id",
                    Planet.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    public void delete(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }

    public List<Planet> getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createNativeQuery(
                    "SELECT * FROM planet",
                    Planet.class).list();
        }
    }
}
