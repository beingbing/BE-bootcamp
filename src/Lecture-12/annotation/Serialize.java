import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Serialize {
    public String convertToJson(Object object) {
        try {
            checkIfSerializable(object);
            runStringMethod(object);
            return getJsonString(object);
        }
        catch(Exception e) {
            throw new JsonSerializableException();
        }
    }

    private void checkIfSerializable(Object object)  {
        if(Objects.isNull(object)) {
            throw new JsonSerializableException();
        }

        Class<?> cls =  object.getClass();
        if (!cls.isAnnotationPresent(JsonSerialized.class)) {
            throw new JsonSerializableException();
        }
    }

    private void runStringMethod(Object object) throws Exception {
        Class<?> cls =  object.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            if(method.isAnnotationPresent(StringAnnotation.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Map<String, String> jsonMap = new HashMap<>(); 
        Class<?> cls =  object.getClass();

        for(Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)) {
                JsonElement jaJsonElement = field.getAnnotation(JsonElement.class);
                jsonMap.put(jaJsonElement.key(), (String) field.get(object));
            }
        }

        StringBuilder convertedJson = new StringBuilder("");
        // { "key" : "value"}
        jsonMap.forEach((key,value) -> {
            convertedJson.append("\"" + key + "\":\"" + value + "\"");
            convertedJson.append(",");
        });

        return "{" +  convertedJson.substring(0, convertedJson.length()-1) + "}";
    }
}
