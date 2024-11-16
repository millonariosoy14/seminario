import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    // Metodo para conectar a la base de datos
    public static Connection ConectarBD(String bd) {
        Connection conexion;
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "Psql10.-?";

        System.out.println("Conectando a la base de datos...");
        try {
            conexion = DriverManager.getConnection(host + bd, user, pass);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }

    // Metodo principal que inicia la aplicación
    public static void main(String[] args) {
        Connection db = ConectarBD("seminario");

        // Ejecuta la creación del marco en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            DatabaseManager dbManager = new DatabaseManager(db); // Se pasa la conexión a la base de datos
            MainFrame frame = new MainFrame(dbManager); // Pasa dbManager a MainFrame
            frame.setVisible(true); // Hace visible el marco
        });
    }
}
