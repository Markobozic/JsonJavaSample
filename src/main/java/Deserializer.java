import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Deserializer {

    public static void readJsonFileToObject(ObjectMapper mapper, Object obj, String filePath) {
        try {
            obj = mapper.readValue(new File(filePath), Object.class);
            PrettyPrinter.formatJson(mapper, obj);
        } catch (IOException err) {
            System.out.println(String.format("error trying to deserialize json: %s", err));
            System.exit(1);
        }
    }
}
