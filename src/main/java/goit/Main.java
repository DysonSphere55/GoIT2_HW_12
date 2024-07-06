package goit;

import goit.client.Client;
import goit.client.ClientCrudService;
import goit.planet.Planet;
import goit.planet.PlanetCrudService;
import goit.storage.InitDatabaseService;

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

        // Test planet table:
        PlanetCrudService planetService = new PlanetCrudService();
        Planet pl = new Planet();
        pl.setId("NEW007");
        pl.setName("New_Planet");
        String planetId = planetService.create(pl);
        planetService.delete(planetService.getById(planetId));
        planetService.getAll().forEach(System.out::println);
    }
}
