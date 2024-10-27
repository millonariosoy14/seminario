import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private List<Cliente> listaClientes; // Lista de clientes
    private List<Terrorista> listaTerroristas; // Lista de terroristas

    public DatabaseManager() {
        listaClientes = new ArrayList<>(); // Inicializa la lista de clientes
        listaTerroristas = new ArrayList<>(); // Inicializa la lista de terroristas
        cargarClientes(this); // Cargar los clientes al inicializar
    }

    private static void cargarClientes(DatabaseManager dbManager) {
        // Ejemplo de carga de 20 clientes
        dbManager.agregarCliente(new Cliente("Juan", "Pérez", "12345678", "", "1980-01-01", "Calle Falsa 123", "01123456789", "juan.perez@gmail.com"));
        dbManager.agregarCliente(new Cliente("Ana", "Gómez", "87654321", "", "1992-02-02", "Av. Siempre Viva 456", "01198765432", "ana.gomez@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Carlos", "Martínez", "34567890", "", "1985-03-03", "Ruta 8 Km 10", "01134567890", "carlos.martinez@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Lucía", "Rodríguez", "45678901", "", "1990-04-04", "Calle 9 de Julio 789", "01187654321", "lucia.rodriguez@gmail.com"));
        dbManager.agregarCliente(new Cliente("MUHAMMAD IBRAHIM", "SHOLEH", "6908545", "", "1980-05-05", "Calle del Terrorista 101", "01101234567", "muhammad.sholeh@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Martín", "Fernández", "56789012", "", "1982-06-06", "Calle Libertador 202", "01165432109", "martin.fernandez@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Sofía", "López", "67890123", "", "1995-07-07", "Calle San Martín 303", "01132109876", "sofia.lopez@gmail.com"));
        dbManager.agregarCliente(new Cliente("Pablo", "García", "78901234", "", "1978-08-08", "Calle Sarmiento 404", "01121098765", "pablo.garcia@hotmail.com"));
        dbManager.agregarCliente(new Cliente("María", "Hernández", "89012345", "", "1993-09-09", "Calle Belgrano 505", "01154321012", "maria.hernandez@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Andrés", "Martínez", "90123456", "", "1988-10-10", "Calle 25 de Mayo 606", "01165478901", "andres.martinez@gmail.com"));
        dbManager.agregarCliente(new Cliente("Elena", "Cruz", "01234567", "", "1984-11-11", "Calle Rivadavia 707", "01145612378", "elena.cruz@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Javier", "Vázquez", "12345679", "", "1991-12-12", "Calle Moreno 808", "01178901234", "javier.vazquez@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Gabriela", "Alvarez", "23456780", "", "1989-01-13", "Calle Alsina 909", "01121034567", "gabriela.alvarez@gmail.com"));
        dbManager.agregarCliente(new Cliente("Facundo", "Díaz", "34567890", "", "1987-02-14", "Calle Salta 101", "01109876543", "facundo.diaz@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Carla", "Ponce", "45678901", "", "1990-03-15", "Calle Córdoba 202", "01134567890", "carla.ponce@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Nicolás", "González", "56789012", "", "1983-04-16", "Calle Mendoza 303", "01154321098", "nicolas.gonzalez@gmail.com"));
        dbManager.agregarCliente(new Cliente("Paola", "Ramírez", "67890123", "", "1994-05-17", "Calle Tucumán 404", "01176543210", "paola.ramirez@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Leonardo", "Soto", "78901234", "", "1986-06-18", "Calle La Rioja 505", "01145678901", "leonardo.soto@yahoo.com"));
        dbManager.agregarCliente(new Cliente("Verónica", "Castro", "89012345", "", "1991-07-19", "Calle Santa Fe 606", "01132165498", "veronica.castro@gmail.com"));
        dbManager.agregarCliente(new Cliente("Ignacio", "Maldonado", "90123456", "", "1980-08-20", "Calle Chaco 707", "01178965432", "ignacio.maldonado@hotmail.com"));
        dbManager.agregarCliente(new Cliente("Victoria", "Ibarra", "01234567", "", "1985-09-21", "Calle Catamarca 808", "01112345678", "victoria.ibarra@yahoo.com"));
    }

    // Método para obtener la lista de clientes
    public List<Cliente> getListaClientes() {
        return listaClientes; // Retorna la lista de clientes
    }

    // Método para agregar un cliente
    public boolean agregarCliente(Cliente nuevoCliente) {
        // Verifica si ya existe un cliente con el mismo DNI o Pasaporte
        for (Cliente cliente : listaClientes) {
            boolean dniIgual = cliente.getDni().equals(nuevoCliente.getDni()); // Verifica si el DNI es igual
            boolean pasaporteIgual = !nuevoCliente.getPasaporte().isEmpty() &&
                    cliente.getPasaporte().equals(nuevoCliente.getPasaporte()); // Verifica si el Pasaporte es igual

            if (dniIgual || pasaporteIgual) {
                return false; // Ya existe un cliente con el mismo DNI o Pasaporte
            }
        }
        listaClientes.add(nuevoCliente); // Agrega el nuevo cliente a la lista
        return true; // Cliente agregado exitosamente
    }

    // Método para obtener la lista de terroristas
    public List<Terrorista> getListaTerroristas() {
        return listaTerroristas; // Retorna la lista de terroristas
    }

    // Método para establecer la lista de terroristas
    public void setListaTerroristas(List<Terrorista> terroristas) {
        this.listaTerroristas = terroristas; // Establece la lista de terroristas
    }

    // Método para cruzar clientes con la lista de terroristas
    public List<Cliente> cruzarClientes() {
        List<Cliente> coincidencias = new ArrayList<>(); // Lista para almacenar coincidencias

        for (Cliente cliente : listaClientes) {
            String nombreCompletoCliente = cliente.getNombreCompleto().toLowerCase(); // Convertir a minúsculas
            String[] partesCliente = nombreCompletoCliente.split(" "); // Dividir el nombre completo en partes

            // Recorremos la lista de terroristas
            for (Terrorista terrorista : listaTerroristas) {
                String nombreCompletoTerrorista = terrorista.getNombreCompleto().toLowerCase(); // Convertir a minúsculas
                String[] partesTerrorista = nombreCompletoTerrorista.split(" "); // Dividir el nombre completo en partes

                boolean coincidencia = true; // Variable para verificar coincidencias

                // Comparamos cada parte del nombre del terrorista con el nombre completo del cliente
                for (String parteTerrorista : partesTerrorista) {
                    boolean encontrado = false; // Variable para indicar si se encontró coincidencia
                    for (String parteCliente : partesCliente) {
                        if (parteCliente.equals(parteTerrorista)) {
                            encontrado = true; // Se encontró una coincidencia
                            break; // Salimos del loop de partes del cliente
                        }
                    }
                    if (!encontrado) {
                        coincidencia = false; // No hay coincidencia
                        break; // Si alguna parte no coincide, salimos
                    }
                }

                // Si hay coincidencia, agregamos el cliente
                if (coincidencia) {
                    coincidencias.add(cliente); // Agrega el cliente a las coincidencias
                    break; // Salimos del loop de terroristas si encontramos una coincidencia
                }
            }
        }
        return coincidencias; // Retorna la lista de coincidencias
    }
}
