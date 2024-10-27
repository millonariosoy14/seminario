import com.google.gson.Gson; // Importa la biblioteca Gson para manejar JSON
import com.google.gson.reflect.TypeToken; // Importa TypeToken para manejar tipos genéricos

import java.io.BufferedReader; // Importa BufferedReader para leer archivos
import java.io.FileReader; // Importa FileReader para leer archivos
import java.io.IOException; // Importa IOException para manejar excepciones de entrada/salida
import java.lang.reflect.Type; // Importa Type para manejar tipos genéricos
import java.util.List; // Importa List para manejar listas

public class JsonLoader {
    private List<Terrorista> terroristas; // Lista de terroristas

    // Metodo para cargar datos desde un archivo JSON
    public void cargarDesdeJson(String filePath) throws IOException {
        Gson gson = new Gson(); // Crea una instancia de Gson
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Lee el archivo especificado
            Type listType = new TypeToken<List<Terrorista>>() {}.getType(); // Define el tipo de lista de terroristas
            terroristas = gson.fromJson(br, listType); // Carga los datos desde el JSON
        }
    }

    // Metodo para obtener la lista de terroristas
    public List<Terrorista> getTerroristas() {
        return terroristas; // Devuelve la lista de terroristas
    }
}
