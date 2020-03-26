package quarkus.extension.dynamic.config;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class JsonFileProvider implements ConfigProvider {
    private Map<String, String> cache;
    private String fileLocation = System.getProperty("user.dir").split("target")[0]
            + "/example.json";

    public JsonFileProvider() {
        cache = getProperties();
    }

    @Override
    public Map<String, String> get() {
        return cache;
    }

    private Map<String, String> getProperties() {
        Map<String, String> m = new HashMap<>();
        String jsonData = this.readFile(this.fileLocation);
        JsonParser parser = Json.createParser(new StringReader(jsonData));
        String key = null;
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    key = parser.getString();
                    break;
                case VALUE_STRING:
                    String string = parser.getString();
                    m.put(key, string);
                    break;
                case VALUE_NUMBER:
                    BigDecimal number = parser.getBigDecimal();
                    m.put(key, number.toString());
                    break;
                case VALUE_TRUE:
                    m.put(key, "true");
                    break;
                case VALUE_FALSE:
                    m.put(key, "false");
                    break;
                default:
                    break;
            }
        }
        parser.close();
        cache = m;
        return m;
    }

    public String readFile(String fileName) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
