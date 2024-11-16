import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame {
    private DatabaseManager databaseManager;
    private List<Terrorista> listaTerroristas;
    private JButton btnAgregarCliente;
    private JButton btnMostrarClientes;
    private JButton btnCargarJson;
    private JButton btnCruzarClientes;

    public MainFrame(DatabaseManager dbManager) {
        databaseManager = dbManager;

        setTitle("Sistema de Registro de Clientes y Cruce contra Bases Terroristas");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        btnAgregarCliente = new JButton("Agregar Cliente");
        btnMostrarClientes = new JButton("Mostrar Clientes");
        btnCargarJson = new JButton("Cargar JSON");
        btnCruzarClientes = new JButton("Cruzar con Terroristas");

        configurarBoton(btnAgregarCliente);
        configurarBoton(btnMostrarClientes);
        configurarBoton(btnCargarJson);
        configurarBoton(btnCruzarClientes);

        btnAgregarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        btnMostrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarClientes();
            }
        });

        btnCargarJson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarJson();
            }
        });

        btnCruzarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzarClientes();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 2, 10, 10));
        panelBotones.add(btnAgregarCliente);
        panelBotones.add(btnMostrarClientes);
        panelBotones.add(btnCargarJson);
        panelBotones.add(btnCruzarClientes);

        add(panelBotones, BorderLayout.CENTER);

        JLabel labelTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelTitulo, BorderLayout.NORTH);

        setVisible(true);
    }

    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Arial", Font.PLAIN, 14));
        boton.setBackground(new Color(211, 211, 211));
    }

    private void agregarCliente() {
        JTextField nombreField = new JTextField(15);
        JTextField apellidoField = new JTextField(15);
        JTextField dniField = new JTextField(15);
        JTextField fechaNacimientoField = new JTextField(15);
        JTextField direccionField = new JTextField(15);
        JTextField telefonoField = new JTextField(15);
        JTextField mailField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido:"));
        panel.add(apellidoField);
        panel.add(new JLabel("Número de Documento:"));
        panel.add(dniField);
        panel.add(new JLabel("Fecha Nacimiento(dd/MM/yyyy):"));
        panel.add(fechaNacimientoField);
        panel.add(new JLabel("Dirección:"));
        panel.add(direccionField);
        panel.add(new JLabel("Teléfono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("Correo:"));
        panel.add(mailField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Cliente nuevoCliente = new Cliente(
                    nombreField.getText(),
                    apellidoField.getText(),
                    dniField.getText(),
                    fechaNacimientoField.getText(),
                    direccionField.getText(),
                    telefonoField.getText(),
                    mailField.getText()
            );
            if (databaseManager.agregarCliente(nuevoCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente ya existente.");
            }
        }
    }

    private void mostrarClientes() {
        List<Cliente> clientes = databaseManager.getListaClientes();
        String[] columnNames = {"Nombre", "Apellido", "Número de Documento", "Fecha Nacimiento", "Dirección", "Teléfono", "Correo"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Cliente cliente : clientes) {
            Object[] rowData = {
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getNumeroDocumento(),
                    cliente.getFechaNacimiento(),
                    cliente.getDireccion(),
                    cliente.getTelefono(),
                    cliente.getMail()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cargarJson() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JsonLoader loader = new JsonLoader();
            try {
                loader.cargarDesdeJson(selectedFile.getAbsolutePath());
                listaTerroristas = loader.getTerroristas();
                mostrarTerroristas(listaTerroristas);
                JOptionPane.showMessageDialog(null, "Datos cargados correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo JSON.");
            }
        }
    }

    private void cruzarClientes() {
        if (listaTerroristas != null && !listaTerroristas.isEmpty()) {
            List<Cliente> coincidencias = databaseManager.cruzarClientes(listaTerroristas);
            if (coincidencias.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            } else {
                StringBuilder coincidenciasTexto = new StringBuilder("Clientes coincidentes:\n");
                for (Cliente cliente : coincidencias) {
                    coincidenciasTexto.append(cliente).append("\n");
                }
                JOptionPane.showMessageDialog(null, coincidenciasTexto.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero cargue los datos de terroristas.");
        }
    }

    private void mostrarTerroristas(List<Terrorista> terroristas) {
        String[] columnNames = {"Nombre Completo", "Número de Documento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Terrorista terrorista : terroristas) {
            Object[] rowData = {
                    terrorista.getNombreCompleto(), // Modificado a getNombreCompleto
                    terrorista.getNumeroDocumento()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Terroristas Cargados", JOptionPane.INFORMATION_MESSAGE);
    }
}
