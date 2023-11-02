package cat.iesesteveterradas.mp06.uf1.exemples;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ModificacioJSON {
    public static void main(String[] args) throws IOException {
        // Your initial JsonObject
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        // Modify the JSON: add new data
        jsonObjectBuilder
                .add("nom", "Joan")
                .add("edat", 30)
                .add("clau1", 1);


        // Modify the JSON: add new data, modify existing data, and remove data
        jsonObjectBuilder
                .add("novaClau", "nouValor")  // Adding new key-value pair
                .add("edat", 31)  // Modifying existing key-value pair
                .remove("clau1");  // Removing existing key-value pair

        // Build the modified JsonObject
        JsonObject modifiedJsonObject = jsonObjectBuilder.build();

        // Write the modified JsonObject to a file
        try (JsonWriter jsonWriter = Json.createWriter(new FileWriter("data/json_file_modif_sortida.json"))) {
            jsonWriter.writeObject(modifiedJsonObject);
            System.out.println("Dades modificades i guardades amb èxit!");
        }
    }
}
