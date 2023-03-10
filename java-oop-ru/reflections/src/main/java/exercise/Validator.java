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

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        final Map<String, List<String>> fieldListMap = new HashMap<>();
        String fieldName = null;

        final List<String> availableMethods = new ArrayList<>();
        final List<String> errorMessages = List.of("length less than 4", "can not be null");
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                fieldName = (String) field.get(address);
                System.out.println("Fields: " + field);
                System.out.println("Value: " + fieldName);

                if (fieldName == null) {
                    String result = String.valueOf(field);
                    availableMethods.add(result.substring(result.lastIndexOf(".") + 1));
                }
            }
        }
        for (Field field : fields) {
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                MinLength minLength = field.getAnnotation(MinLength.class);
                fieldName = (String) field.get(address);
                String fieldToString = String.valueOf(field);
                fieldListMap.put(fieldToString.substring(fieldToString.lastIndexOf(".") + 1), errorMessages);
            }
        }
        System.out.println(availableMethods);
//        fieldListMap.put(, errorMessages);
        return fieldListMap;
    }
}
// END
