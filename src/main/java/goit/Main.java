package goit;

import goit.client.Client;
import goit.client.ClientCrudService;
import goit.planet.Planet;
import goit.planet.PlanetCrudService;
import goit.storage.InitDatabaseService;
import goit.storage.hibernate.HibernateUtil;
import goit.ticket.Ticket;
import goit.ticket.TicketCrudService;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitDatabaseService initDatabaseService = new InitDatabaseService();
        initDatabaseService.init();

        // Test client table:
        ClientCrudService clientService = new ClientCrudService();
        Client cl = new Client();
        cl.setName("New_Client");
        long clientId = clientService.create(cl);
        clientService.delete(clientService.getById(clientId));
        clientService.getAll().forEach(System.out::println);
        System.out.println(" ");

        // Test planet table:
        PlanetCrudService planetService = new PlanetCrudService();
        Planet pl = new Planet();
        pl.setId("NEW007");
        pl.setName("New_Planet");
        String planetId = planetService.create(pl);
        planetService.delete(planetService.getById(planetId));
        planetService.getAll().forEach(System.out::println);
        System.out.println(" ");

        // Test ticket table:
        TicketCrudService ticketService = new TicketCrudService();

        Client client = clientService.getById(9L);
        Planet planetFrom = planetService.getById("SCA004");
        Planet planetTo = planetService.getById("TAT005");
        Ticket newTicket = new Ticket();
        newTicket.setCreatedAt(LocalDateTime.now());
        newTicket.setClient(client);
        newTicket.setPlanetFrom(planetFrom);
        newTicket.setPlanetTo(planetTo);

        ticketService.create(newTicket);

        List<Ticket> allTickets = ticketService.getAllWithField(
                TicketCrudService.TicketInitField.client,
                TicketCrudService.TicketInitField.planetFrom,
                TicketCrudService.TicketInitField.planetTo);
        allTickets.forEach(System.out::println);
        System.out.println(" ");



    }
}
