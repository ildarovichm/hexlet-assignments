package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String message = "Не удалось посчитать площадь";

    public NegativeRadiusException (String message) {
        super(message);
        this.message = message;
    }

    public String getErrorDescription() {
        return message;
    }
}
// END
