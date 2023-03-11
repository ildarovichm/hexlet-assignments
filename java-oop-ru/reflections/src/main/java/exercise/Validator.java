package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) throws IllegalAccessException {
        final List<String> availableMethods = new ArrayList<>();
        String name;
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                name = (String) field.get(address);
                if (name == null) {
                    String result = String.valueOf(field);
                    availableMethods.add(result.substring(result.lastIndexOf(".") + 1));
                }
            }
        }
        System.out.println();
        return availableMethods;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        final List<String> availableMethods = new ArrayList<>();
        final Map<String, List<String>> fieldListMap = new HashMap<>();
        String fieldName;
        final List<String> errorLength = List.of("length less than 4");
        final List<String> errorNull = List.of("can not be null");
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                fieldName = (String) field.get(address);
                String fieldToString = String.valueOf(field);
                if (fieldName == null) {
                    String result = String.valueOf(field);
                    availableMethods.add(result.substring(result.lastIndexOf(".") + 1));
                    fieldListMap.put(fieldToString
                            .substring(fieldToString.lastIndexOf(".") + 1), errorNull);
                }

            }
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                fieldName = (String) field.get(address);
                String fieldToString = String.valueOf(field);
                if (fieldName != null && fieldName.length() < 4) {
                    fieldListMap.put(fieldToString
                            .substring(fieldToString.lastIndexOf(".") + 1), errorLength);
                }
            }
        }
        return fieldListMap;
    }
}
// END
