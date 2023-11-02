package cat.iesesteveterradas.mp06.uf1.exemples;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscripturaJSON {
    public static void main(String[] args) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("nom", "Joan")
                .add("edat", 30)
                .build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileWriter("data/json_file_sortida.json"))) {
            jsonWriter.writeObject(jsonObject);
            System.out.println("Dades guardades amb èxit!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
