package goit.ticket;

import goit.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class TicketCrudService {

    public long create(Ticket ticket) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
        return ticket.getId();
    }

    public Ticket getById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            NativeQuery<Ticket> query = session.createNativeQuery(
                    "SELECT * FROM ticket WHERE id = :id",
                    Ticket.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    public void delete(Ticket ticket) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }

    public List<Ticket> getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createNativeQuery(
                    "SELECT * FROM ticket",
                    Ticket.class).list();
        }
    }

    public Ticket getByIdWithField(long id, TicketInitField ... fields) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        for (TicketInitField field : fields) {
            switch (field) {
                case client:
                    ticket.getClient();
                    break;
                case planetFrom:
                    ticket.getPlanetFrom();
                    break;
                case planetTo:
                    ticket.getPlanetTo();
                    break;
            }
        }
        session.close();
        return ticket;
    }

    public List<Ticket> getAllWithField(TicketInitField ... fields) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> tickets = session.createNativeQuery(
                "SELECT * FROM ticket",
                Ticket.class).list();
        for (Ticket ticket : tickets) {
            for (TicketInitField field : fields) {
                switch (field) {
                    case client:
                        ticket.getClient();
                        break;
                    case planetFrom:
                        ticket.getPlanetFrom();
                        break;
                    case planetTo:
                        ticket.getPlanetTo();
                        break;
                }
            }
        }
        session.close();
        return tickets;
    }


    public enum TicketInitField {
        client,
        planetFrom,
        planetTo
    }


}

