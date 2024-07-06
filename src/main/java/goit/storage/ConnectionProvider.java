package goit.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionProvider {

    public static final String DB_URL = "jdbc:h2:./SpaceTravelDB";
    private List<Connection> connectionList;

    public ConnectionProvider() {
        this.connectionList = new ArrayList<>();
    }

    public Connection create() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionList.add(connection);
        return connection;
    }

    public void close() {
        for (Connection connection : connectionList) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
