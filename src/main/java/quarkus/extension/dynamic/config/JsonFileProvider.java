package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonFileProvider implements ConfigProvider {
    private Map<String, String> cache;
    private String filePath;
    Map<String, String> data = new HashMap<>();

    public JsonFileProvider(Config config) {
        filePath = config.getValue("filePath", String.class);
        cache = getProperties();
    }

    @Override
    public Map<String, String> get() {
        return cache;
    }

    private Map<String, String> getProperties() {
        String jsonData = this.readFile(filePath);
        cache = parse(jsonData);
        return cache;
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

    public Map<String, String> parse(String grandParentKey, String parentKey, JSONObject json) throws JSONException {
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object val;

            val = json.get(key);

            if (val.getClass().getTypeName().contains("JSONArray")) {
                JSONArray jArr = (JSONArray) val;
                for (int i = 0; i < jArr.length(); i++) {
                    JSONObject childJSONObject = jArr.getJSONObject(i);
                    parse(parentKey, key, childJSONObject);
                }

            } else if (val.getClass().getTypeName().equals("org.json.JSONObject")) {
                parse(parentKey, key, (JSONObject) val);

            } else {
                if (val.getClass().getTypeName().equals("org.json.JSONObject$Null")) {
                    val = "null";
                }
                String s1;
                if (!grandParentKey.isEmpty()) {
                    s1 = grandParentKey + "." + parentKey + "." + key;
                } else if (!parentKey.isEmpty()) {
                    s1 = parentKey + "." + key;

                } else {
                    s1 = key;
                }
                data.put(s1, val.toString());
            }
        }

        return data;
    }

    private Map<String, String> parse(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);

            return parse("", "", jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
