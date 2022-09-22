package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    Connection c = null;

    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/conway");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;

}


}
