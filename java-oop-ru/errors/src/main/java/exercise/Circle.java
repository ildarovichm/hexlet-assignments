package exercise;

import java.util.regex.Matcher;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle (Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (this.radius >= 0) {
            double result = Math.PI * this.radius * this.radius;
            return result;
        } else {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
    }
}
// END
