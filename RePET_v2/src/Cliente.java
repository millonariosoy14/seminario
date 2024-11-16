public class Cliente {
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String mail;

    public Cliente(String nombre, String apellido, String numeroDocumento, String fechaNacimiento, String direccion, String telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
