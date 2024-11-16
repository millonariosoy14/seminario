import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonLoader {
    private List<Terrorista> terroristas; // Lista de terroristas cargados desde el JSON

    public JsonLoader() {
        terroristas = new ArrayList<>();
    }

    // Metodo para cargar datos desde un archivo JSON
    public void cargarDesdeJson(String filePath) throws IOException {
        // Leemos el archivo JSON
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

        // Usamos Gson para convertir el JSON en una lista de terroristas
        Gson gson = new Gson();
        JsonArray jsonArray = JsonParser.parseString(jsonContent).getAsJsonArray();

        // Iteramos sobre el array de terroristas y construimos la lista
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Extraemos los nombres
            String firstName = jsonObject.has("FIRST_NAME") ? jsonObject.get("FIRST_NAME").getAsString() : null;
            String secondName = jsonObject.has("SECOND_NAME") ? jsonObject.get("SECOND_NAME").getAsString() : null;
            String thirdName = jsonObject.has("THIRD_NAME") ? jsonObject.get("THIRD_NAME").getAsString() : null;
            String fourthName = jsonObject.has("FOURTH_NAME") ? jsonObject.get("FOURTH_NAME").getAsString() : null;

            // Extraemos el número de documento
            String numeroDocumento = "";
            if (jsonObject.has("INDIVIDUAL_DOCUMENT")) {
                JsonArray documentos = jsonObject.getAsJsonArray("INDIVIDUAL_DOCUMENT");
                if (documentos.size() > 0) {
                    JsonObject doc = documentos.get(0).getAsJsonObject();
                    if (doc.has("NUMBER")) {
                        numeroDocumento = doc.get("NUMBER").getAsString();
                    }
                }
            }

            // Creamos el objeto Terrorista y lo añadimos a la lista
            Terrorista terrorista = new Terrorista(firstName, secondName, thirdName, fourthName, numeroDocumento);
            terroristas.add(terrorista);
        }

        // Verifica si la lista de terroristas tiene datos
        if (terroristas.isEmpty()) {
            System.out.println("No se encontraron terroristas en el JSON.");
        } else {
            System.out.println("Terroristas cargados desde JSON: " + terroristas.size());
        }
    }

    // Metodo para obtener la lista de terroristas
    public List<Terrorista> getTerroristas() {
        return terroristas;
    }
}
