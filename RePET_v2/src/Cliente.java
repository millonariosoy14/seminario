public class Cliente {
    private String nombre; // Nombre del cliente
    private String apellido; // Apellido del cliente
    private String dni; // Documento Nacional de Identidad
    private String pasaporte; // Numero de pasaporte
    private String fechaNacimiento; // Fecha de nacimiento
    private String direccion; // Direccion de residencia
    private String telefono; // Numero de telefono
    private String mail; // Correo electronico

    // Constructor de la clase Cliente
    public Cliente(String nombre, String apellido, String dni, String pasaporte, String fechaNacimiento,
                   String direccion, String telefono, String mail) {
        this.nombre = nombre; // Inicializa el nombre
        this.apellido = apellido; // Inicializa el apellido
        this.dni = dni; // Inicializa el DNI
        this.pasaporte = pasaporte; // Inicializa el pasaporte
        this.fechaNacimiento = fechaNacimiento; // Inicializa la fecha de nacimiento
        this.direccion = direccion; // Inicializa la direccion
        this.telefono = telefono; // Inicializa el telefono
        this.mail = mail; // Inicializa el correo electronico
    }

    // Getters para obtener los atributos del cliente
    public String getNombre() {
        return nombre; // Retorna el nombre
    }

    public String getApellido() {
        return apellido; // Retorna el apellido
    }

    public String getDni() {
        return dni; // Retorna el DNI
    }

    public String getPasaporte() {
        return pasaporte; // Retorna el pasaporte
    }

    public String getFechaNacimiento() {
        return fechaNacimiento; // Retorna la fecha de nacimiento
    }

    public String getDireccion() {
        return direccion; // Retorna la direccion
    }

    public String getTelefono() {
        return telefono; // Retorna el telefono
    }

    public String getMail() {
        return mail; // Retorna el correo electronico
    }

    // Metodo para obtener el nombre completo del cliente
    public String getNombreCompleto() {
        return nombre + " " + apellido; // Retorna el nombre completo
    }

    // Metodo toString para representar al cliente en forma de texto
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
