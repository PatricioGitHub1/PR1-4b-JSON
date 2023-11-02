package cat.iesesteveterradas.mp06.uf1.exemples;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LecturaJSONAmbMapeigAObjecte {
    public static void main(String[] args) {
        try (JsonReader jsonReader = Json.createReader(new FileReader("data/json_file_exemple1.json"))) {
            JsonObject jsonObject = jsonReader.readObject();

            Map<String, Object> map = new HashMap<>();
            Set<String> keys = jsonObject.keySet();
            for (String key : keys) {
                map.put(key, jsonObject.get(key));
            }

            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
