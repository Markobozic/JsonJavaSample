import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrettyPrinter {

    public static void formatJson(ObjectMapper mapper, Object obj) {
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            System.out.println(String.format("Error trying to format json: %s", e.getMessage()));
            System.exit(1);
        }
    }
}
