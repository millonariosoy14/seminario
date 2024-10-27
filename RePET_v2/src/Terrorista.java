import com.google.gson.annotations.SerializedName;

public class Terrorista {
    @SerializedName("FIRST_NAME")
    private String firstName; // Primer nombre del terrorista

    @SerializedName("SECOND_NAME")
    private String secondName; // Segundo nombre del terrorista

    @SerializedName("THIRD_NAME")
    private String thirdName; // Tercer nombre del terrorista

    @SerializedName("FOURTH_NAME")
    private String fourthName; // Cuarto nombre del terrorista

    // Constructor de la clase Terrorista
    public Terrorista(String firstName, String secondName, String thirdName, String fourthName) {
        this.firstName = firstName; // Inicializa el primer nombre
        this.secondName = secondName; // Inicializa el segundo nombre
        this.thirdName = thirdName; // Inicializa el tercer nombre
        this.fourthName = fourthName; // Inicializa el cuarto nombre
    }

    // Getters para obtener los atributos del terrorista
    public String getFirstName() {
        return firstName; // Retorna el primer nombre
    }

    public String getSecondName() {
        return secondName; // Retorna el segundo nombre
    }

    public String getThirdName() {
        return thirdName; // Retorna el tercer nombre
    }

    public String getFourthName() {
        return fourthName; // Retorna el cuarto nombre
    }

    // Setters (opcional, si no los necesitas, puedes omitirlos)
    public void setFirstName(String firstName) {
        this.firstName = firstName; // Establece el primer nombre
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName; // Establece el segundo nombre
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName; // Establece el tercer nombre
    }

    public void setFourthName(String fourthName) {
        this.fourthName = fourthName; // Establece el cuarto nombre
    }

    // Metodo para obtener el nombre completo del terrorista
    public String getNombreCompleto() {
        StringBuilder nombreCompleto = new StringBuilder(); // Crea un nuevo StringBuilder
        if (firstName != null) nombreCompleto.append(firstName).append(" "); // Agrega el primer nombre
        if (secondName != null) nombreCompleto.append(secondName).append(" "); // Agrega el segundo nombre
        if (thirdName != null) nombreCompleto.append(thirdName).append(" "); // Agrega el tercer nombre
        if (fourthName != null) nombreCompleto.append(fourthName); // Agrega el cuarto nombre
        return nombreCompleto.toString().trim(); // Elimina espacios en blanco al inicio o al final
    }

    // Metodo toString para representar al terrorista en forma de texto
    @Override
    public String toString() {
        return "Terrorista{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", fourthName='" + fourthName + '\'' +
                '}';
    }
}
