package cat.iesesteveterradas.mp06.uf1.exercicisjson;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PR143GestioLlibreriaMain {
    public static void main(String[] args) throws IOException {
        JsonReader jsonReader;
        ArrayList<Libro> books = new ArrayList<>();

        try {
            // Lectura del array de objectes JSON y carregarles a un array de objectes Libro
            jsonReader = Json.createReader(new FileReader("data/llibres_input.json"));
            JsonArray array = jsonReader.readArray();
            
            for (JsonObject jsonObject : array.getValuesAs(JsonObject.class)) {
                books.add(new Libro(jsonObject.getInt("id"), jsonObject.getString("títol"), jsonObject.getString("autor"), jsonObject.getInt("any")));
            }

            // 1) Lectura del fitxer 
            // Lectura del llibres en memoria
            printHeader("Objectes en memoria");
            for (Libro l : books) {
                System.out.println(l.toString());
            }

            printHeader("Modificar objecte amb id = 1");

            ArrayList<JsonObject> nousJsonObjects = new ArrayList<>();

            // 2) Modificació 
            for (JsonObject jsonObject : array.getValuesAs(JsonObject.class)) {
                
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder
                .add("id", jsonObject.getInt("id"))
                .add("títol", jsonObject.getString("títol"))
                .add("autor", jsonObject.getString("autor"))
                .add("any", jsonObject.getInt("any"));

                if (jsonObject.getInt("id") == 1) {
                    jsonObjectBuilder.add("any", 1995);
                }
                JsonObject newJsonObj = jsonObjectBuilder.build();
                System.out.println(newJsonObj);
                nousJsonObjects.add(newJsonObj);
            }

            // 3) Afegir nou objecte JSON
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder
                .add("id", 4)
                .add("títol", "Històries de la ciutat")
                .add("autor", "Miquel Soler")
                .add("any", 2022);
            JsonObject newJsonLlibre = jsonObjectBuilder.build();
            nousJsonObjects.add(newJsonLlibre);

            printHeader("Afegir nou objecte JSON");

            for (JsonObject jo: nousJsonObjects) {
                System.out.println(jo);
            }

            // 4) Eliminar llibre
            JsonObject objectDelete = null;
            for (JsonObject jo: nousJsonObjects) {
                if (jo.getInt("id") == 2) {
                    objectDelete = jo;
                }
            }
            nousJsonObjects.remove(objectDelete);

            printHeader("Eliminat objecte JSON amb id = 2");

            for (JsonObject jo: nousJsonObjects) {
                System.out.println(jo);
            }

            printHeader("Guardar arxius en llibres_output.java");
            try (JsonWriter jsonWriter = Json.createWriter(new FileWriter("data/llibres_output.json"))) {
                JsonArrayBuilder builder = Json.createArrayBuilder();
                for (JsonObject jo: nousJsonObjects) {
                    builder.add(jo);
                }
                
                JsonArray newJsonArray = builder.build();
                jsonWriter.writeArray(newJsonArray);
                System.out.println("Dades modificades i guardades amb èxit!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
    }

    static void printHeader(String message) {
        String output = "=========================================";
        output += "\n"+message;
        output += "\n=========================================";
        System.out.println(output);
    }
}

class Libro {
    int id;
    String titulo;
    String autor;
    int year;

    public Libro(int id, String titulo, String autor, int year) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", year=" + year + "]";
    }
    
}
