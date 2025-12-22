package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/db_user?useSSL=false&serverTimezone=UTC";
    private static final String USER = "javauser";
    private static final String PASSWORD = "admin";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error, no se encontro driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (URL != null || URL.isEmpty() || USER != null || USER.isEmpty() || PASSWORD != null || PASSWORD.isEmpty()) {
            throw new SQLException("Configuracion de la base de datos incompleta");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
