import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Serializer {

    public static void writeJsonToFile(ObjectMapper mapper, Object obj, String filePath) {
        try {
            mapper.writeValue(new File(filePath), obj);
        } catch (IOException err) {
            System.out.println(String.format("error trying to write out json file: %s", err));
            System.exit(1);
        }
    }
}
