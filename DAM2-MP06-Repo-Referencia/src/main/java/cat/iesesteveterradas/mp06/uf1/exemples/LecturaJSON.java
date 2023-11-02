package cat.iesesteveterradas.mp06.uf1.exemples;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaJSON {
    public static void main(String[] args) {
        try (JsonReader jsonReader = Json.createReader(new FileReader("data/json_file_exemple1.json"))) {
            JsonObject jsonObject = jsonReader.readObject();
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
