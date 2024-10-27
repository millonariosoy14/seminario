import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame {
    private DatabaseManager databaseManager; // Declaración de DatabaseManager
    private JButton btnAgregarCliente;
    private JButton btnMostrarClientes;
    private JButton btnCargarJson;
    private JButton btnCruzarClientes;

    // Constructor sin parámetros
    public MainFrame(DatabaseManager dbManager) {
        // Inicializar el DatabaseManager
        databaseManager = new DatabaseManager();

        // Configuracion del marco (frame)
        setTitle("Sistema de Registro de Clientes y Cruce contra Bases Terroristas");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inicializacion de los componentes
        btnAgregarCliente = new JButton("Agregar Cliente");
        btnMostrarClientes = new JButton("Mostrar Clientes");
        btnCargarJson = new JButton("Cargar JSON");
        btnCruzarClientes = new JButton("Cruzar con Terroristas");

        // Configuración de los botones
        configurarBoton(btnAgregarCliente);
        configurarBoton(btnMostrarClientes);
        configurarBoton(btnCargarJson);
        configurarBoton(btnCruzarClientes);

        // Agregar Cliente Button
        btnAgregarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        // Mostrar Clientes Button
        btnMostrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarClientes();
            }
        });

        // Cargar JSON Button
        btnCargarJson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    JsonLoader loader = new JsonLoader();
                    try {
                        loader.cargarDesdeJson(file.getAbsolutePath());
                        databaseManager.setListaTerroristas(loader.getTerroristas());
                        mostrarDatosCargados(loader.getTerroristas());
                        JOptionPane.showMessageDialog(null, "JSON cargado exitosamente.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al cargar el JSON: " + ex.getMessage());
                    }
                }
            }
        });

        // Cruzar con Terroristas Button
        btnCruzarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzarClientes();
            }
        });

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas con espacio de 10
        panelBotones.add(btnAgregarCliente);
        panelBotones.add(btnMostrarClientes);
        panelBotones.add(btnCargarJson);
        panelBotones.add(btnCruzarClientes);

        // Agregar el panel de botones y el titulo al marco
        add(panelBotones, BorderLayout.CENTER);

        // Agregar un titulo
        JLabel labelTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelTitulo, BorderLayout.NORTH);

        // Ajustar visibilidad
        setVisible(true);
    }

    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Arial", Font.PLAIN, 14)); // Aumentar tamaño de fuente
        boton.setBackground(new Color(211, 211, 211)); // Color gris claro
    }

    private void agregarCliente() {
        // Ventana para ingresar los datos del cliente
        JTextField nombreField = new JTextField(15);
        JTextField apellidoField = new JTextField(15);
        JTextField dniField = new JTextField(15);
        JTextField pasaporteField = new JTextField(15);
        JTextField fechaNacimientoField = new JTextField(15);
        JTextField direccionField = new JTextField(15);
        JTextField telefonoField = new JTextField(15);
        JTextField mailField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(0, 2)); // Layout vertical
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido:"));
        panel.add(apellidoField);
        panel.add(new JLabel("DNI:"));
        panel.add(dniField);
        panel.add(new JLabel("Pasaporte:"));
        panel.add(pasaporteField);
        panel.add(new JLabel("Fecha Nacimiento:"));
        panel.add(fechaNacimientoField);
        panel.add(new JLabel("Direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("Telefono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("Mail:"));
        panel.add(mailField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Cliente nuevoCliente = new Cliente(
                    nombreField.getText(),
                    apellidoField.getText(),
                    dniField.getText(),
                    pasaporteField.getText(),
                    fechaNacimientoField.getText(),
                    direccionField.getText(),
                    telefonoField.getText(),
                    mailField.getText()
            );

            if (databaseManager.agregarCliente(nuevoCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con el mismo DNI o Pasaporte.");
            }
        }
    }

    private void mostrarClientes() {
        List<Cliente> clientes = databaseManager.getListaClientes();
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        } else {
            String[] columnNames = {"Nombre", "Apellido", "DNI", "Pasaporte", "Fecha Nacimiento", "Direccion", "Telefono", "Mail"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Rellenar el modelo con datos de clientes
            for (Cliente cliente : clientes) {
                Object[] rowData = {
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getDni(),
                        cliente.getPasaporte(),
                        cliente.getFechaNacimiento(),
                        cliente.getDireccion(),
                        cliente.getTelefono(),
                        cliente.getMail()
                };
                model.addRow(rowData);
            }

            // Crear la tabla
            JTable table = new JTable(model);
            table.setFillsViewportHeight(true);

            // Crear un panel con barra de desplazamiento
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(550, 300)); // Ajustar tamaño del scroll

            // Mostrar la ventana con los datos cargados
            JOptionPane.showMessageDialog(null, scrollPane, "Clientes Registrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cruzarClientes() {
        List<Cliente> coincidencias = databaseManager.cruzarClientes();
        if (coincidencias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias entre clientes y terroristas.");
        } else {
            StringBuilder mensaje = new StringBuilder("Coincidencias encontradas:\n");
            for (Cliente cliente : coincidencias) {
                mensaje.append(cliente.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    private void mostrarDatosCargados(List<Terrorista> terroristas) {
        String[] columnNames = {"First Name", "Second Name", "Third Name", "Fourth Name"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Rellenar el modelo con datos de terroristas
        for (Terrorista terrorista : terroristas) {
            Object[] rowData = {
                    terrorista.getFirstName(),
                    terrorista.getSecondName(),
                    terrorista.getThirdName(),
                    terrorista.getFourthName()
            };
            model.addRow(rowData);
        }

        // Crear la tabla
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);

        // Crear un panel con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 300)); // Ajustar tamaño del scroll

        // Mostrar la ventana con los datos cargados
        JOptionPane.showMessageDialog(null, scrollPane, "Terroristas Cargados", JOptionPane.INFORMATION_MESSAGE);
    }
}
