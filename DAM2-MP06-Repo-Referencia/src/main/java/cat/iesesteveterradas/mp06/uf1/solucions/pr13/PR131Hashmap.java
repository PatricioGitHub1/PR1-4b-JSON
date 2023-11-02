package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.Serializable;
import java.util.HashMap;

public class PR131Hashmap implements Serializable {
    // El serialVersionUID és un identificador únic per a la serialització de classes Serializable.
    // Aquest UID s'utilitza per a verificar que el remitent i el receptor d'un objecte serialitzat
    // tinguin classes carregades que siguin compatibles respecte a la serialització.
    // Si l'objecte té un UID diferent que el de la classe corresponent del receptor,
    // llavors es llançarà una InvalidClassException.
    // Un valor típic que es pot assignar és 1L, com en aquest cas, però pot ser qualsevol nombre llarg que escullis.
    // És recomanable definir un valor explícitament, ja que si no es fa, la JVM assignarà un de forma implícita
    // basat en detalls de la classe que poden variar amb canvis de la classe com ara l'ordre dels camps o mètodes.
    private static final long serialVersionUID = 1L;

    public HashMap<String, Integer> hashMap;

    public PR131Hashmap() {
        hashMap = new HashMap<>();
    }
}

