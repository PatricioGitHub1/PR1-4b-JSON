package cat.iesesteveterradas.mp06.uf1.exemples;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EscripturaJSONJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        map.put("nom", "Joan");
        map.put("edat", 30);

        objectMapper.writeValue(new File("data/json_file_sortida.json"), map);
        System.out.println("Dades guardades amb èxit!");
    }
}