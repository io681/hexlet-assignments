package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) throws IllegalAccessException {
        List<String> result = new ArrayList<>();
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (var field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                String  value = (String) field.get(object);
                if (value == null) {
                    result.add(field.getName());
                }
            }
        }
        return result;
    }
}
// END
