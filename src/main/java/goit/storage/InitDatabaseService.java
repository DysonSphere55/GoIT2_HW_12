package goit.storage;

import org.flywaydb.core.Flyway;

public class InitDatabaseService {
    public static final String DB_URL = "jdbc:h2:./SpaceTravelDB";
    public void init() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(DB_URL, null,  null)
                .load();

        flyway.migrate();
    }
}
