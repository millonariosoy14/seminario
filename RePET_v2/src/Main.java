import javax.swing.*; // Importa la biblioteca Swing para la interfaz gráfica

public class Main {
    // Metodo principal que inicia la aplicación
    public static void main(String[] args) {
        // Ejecuta la creación del marco en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            DatabaseManager dbManager = new DatabaseManager(); // Crea una instancia de DatabaseManager
            MainFrame frame = new MainFrame(dbManager); // Pasa dbManager a MainFrame
            frame.setVisible(true); // Hace visible el marco
        });
    }

       }
