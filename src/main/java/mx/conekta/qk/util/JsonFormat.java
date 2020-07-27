package mx.conekta.qk.util;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonFormat {

    private static final Logger log = LoggerFactory.getLogger(JsonFormat.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonFormat() {
    }

    // {"property":"value"} ---> Object
    public static <T> Object toObject(String json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    // C:\\directory\\filename.json ---> Object
    public static <T> Object toObjectFromFile(String jsonFile, Class<T> c) {
        try {
            return mapper.readValue(new File(jsonFile), c);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /*
     * {"key":"value"} ---> {
     * 
     * "key" : "value"
     * 
     * }
     * 
     */
    public static String toPrettyJson(String inlinedJson, boolean logged) {
        String prettyJson = null;
        try {
            prettyJson = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(toObject(inlinedJson, Object.class));
            if (logged) {
                log.info(prettyJson);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return prettyJson;
    }

    /*
     * Object ---> {
     * 
     * "property" : "value"
     * 
     * }
     * 
     */
    public static String toPrettyJson(Object o, boolean logged) {
        String prettyJson = null;
        try {
            prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            if (logged) {
                log.info(prettyJson);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return prettyJson;

    }

    // Object ---> {"property":"value"}
    public static String toInlinedJson(Object o, boolean logged) {
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
            if (logged) {
                log.info(json);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return json;
    }

    // Object ---> C:\\directory\\filename.json
    public static void toJsonFile(String jsonFile, Object o, boolean logged) {
        try {
            mapper.writeValue(new File(jsonFile), o);
            if (logged) {
                log.info(mapper.writeValueAsString(o));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}