package LibraryManagementSystem.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class LibraryDAO {

    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load db.properties", e);
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
