package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        String name = null;
        final List<String> availableMethods = new ArrayList<>();
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                name = (String) field.get(address);
                System.out.println("Fields: " + field);
                System.out.println("Value: " + name);

                if (name == null) {
                    String result = String.valueOf(field);
                    availableMethods.add(result.substring(result.lastIndexOf(".") + 1));
                }
            }
        }
        System.out.println(availableMethods);
        return availableMethods;
    }
}
// END
