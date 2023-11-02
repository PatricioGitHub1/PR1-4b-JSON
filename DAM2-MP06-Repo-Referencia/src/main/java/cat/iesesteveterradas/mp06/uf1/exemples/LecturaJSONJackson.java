package cat.iesesteveterradas.mp06.uf1.exemples;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LecturaJSONJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(new File("data/json_file_exemple1.json"), Map.class);
        System.out.println(map);
    }
}
