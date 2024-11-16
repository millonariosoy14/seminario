import com.google.gson.annotations.SerializedName;

public class Terrorista {

    @SerializedName("FIRST_NAME")
    private String firstName;

    @SerializedName("SECOND_NAME")
    private String secondName;

    @SerializedName("THIRD_NAME")
    private String thirdName;

    @SerializedName("FOURTH_NAME")
    private String fourthName;

    @SerializedName("INDIVIDUAL_DOCUMENT")
    private String numeroDocumento; // Variable para almacenar el número de documento

    // Constructor de la clase Terrorista
    public Terrorista(String firstName, String secondName, String thirdName, String fourthName, String numeroDocumento) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.fourthName = fourthName;
        this.numeroDocumento = numeroDocumento;
    }

    // Métodos Getter para obtener los valores de los nombres y documento
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getFourthName() {
        return fourthName;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    // Metodo que concatena los nombres
    public String getNombreCompleto() {
        StringBuilder nombreCompleto = new StringBuilder();
        if (firstName != null) nombreCompleto.append(firstName).append(" ");
        if (secondName != null) nombreCompleto.append(secondName).append(" ");
        if (thirdName != null) nombreCompleto.append(thirdName).append(" ");
        if (fourthName != null) nombreCompleto.append(fourthName);

        return nombreCompleto.toString().trim();
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombreCompleto() + " - Documento: " + numeroDocumento;
    }
}
