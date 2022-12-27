package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App{
    public static long getCountOfFreeEmails(List<String> emails) {
        System.out.println(emails);
        return emails.stream()
                .filter(s -> s.contains("@gmail.com") || s.contains("@yandex.ru") || s.contains("@hotmail.com"))
                .count();
    }
}
// END
