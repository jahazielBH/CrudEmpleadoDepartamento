package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielhs
 */
public class ConexionDB {

    private static ConexionDB instance;
    private static Connection conn;

    private ConexionDB() {
        String urlDatabase = "jdbc:postgresql://localhost:5432/Crud2";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlDatabase, "postgres", "password");
        } catch (Exception e) {
            System.out.println("Ocurrio un error:" + e.getMessage());
        }
        System.out.println("La conexion se realizo sin problemas");
    }

    public Connection getConnection() {
        return conn;
    }

    public static ConexionDB getInstance() {
        if (conn == null) {
            instance = new ConexionDB();
        }
        return instance;
    }

    public boolean execute(String sql) {
        boolean res = false;
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return res;
    }

}
