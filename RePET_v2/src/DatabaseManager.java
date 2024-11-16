import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, numeroDocumento, fechaNacimiento, direccion, telefono, mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getNumeroDocumento());
            statement.setString(4, cliente.getFechaNacimiento());
            statement.setString(5, cliente.getDireccion());
            statement.setString(6, cliente.getTelefono());
            statement.setString(7, cliente.getMail());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> getListaClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("numeroDocumento"),
                        resultSet.getString("fechaNacimiento"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("mail")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> cruzarClientes(List<Terrorista> terroristas) {
        List<Cliente> coincidencias = new ArrayList<>();
        List<Cliente> clientes = getListaClientes();

        for (Cliente cliente : clientes) {
            String clienteNombreCompleto = (cliente.getNombre() + " " + cliente.getApellido()).toLowerCase();
            for (Terrorista terrorista : terroristas) {
                String terroristaNombreCompleto = terrorista.getNombreCompleto().toLowerCase();
                if (clienteNombreCompleto.equals(terroristaNombreCompleto)) {
                    coincidencias.add(cliente);
                }
            }
        }
        return coincidencias;
    }
}
