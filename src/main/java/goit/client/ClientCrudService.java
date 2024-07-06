package goit.client;

import goit.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ClientCrudService {

    public long create(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
        return client.getId();
    }

    public Client getById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            NativeQuery<Client> query = session.createNativeQuery(
                    "SELECT * FROM client WHERE id = :id",
                    Client.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    public void delete(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }

    public List<Client> getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createNativeQuery(
                    "SELECT * FROM client",
                    Client.class).list();
        }
    }
}
