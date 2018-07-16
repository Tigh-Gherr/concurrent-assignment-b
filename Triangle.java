import java.util.Arrays;

// Triangle class
public abstract class Triangle {

    // Build triangle from params
    public static Triangle triangleFactory(double[] sides) {
        // Sort the sides from smallest to largest
        Arrays.sort(sides);
        double a = sides[0], b = sides[1], c = sides[2];

        // Law of inequality
        if (a + b < c) {
            return null;
        } // End if

        // Pythagoras Theorem
        if (a * a + b * b == c * c) { // Test for Right Angle
            return new RightAngle();
        } else if (a == c) { // Test for Equilateral
            return new Equilateral();
        } else if (a == b || b == c) { // Test for Isosceles
            return new Isosceles();
        } else { // Last possibility is Scalene
            return new Scalene();
        } // End if
    } // End triangleFactory

    // Returns a string representation of triangle type
    public abstract String type();

    // Isosceles Triangle implementation
    private static class Isosceles extends Triangle {
        @Override
        public String type() {
            return "Isosceles";
        } // End type
    } // End Isosceles

    // Scalene Triangle implementation
    private static class Scalene extends Triangle {
        @Override
        public String type() {
            return "Scalene";
        } // End type
    } // End Scalene

    // Equilateral Triangle implementation
    private static class Equilateral extends Triangle {
        @Override
        public String type() {
            return "Equilateral";
        } // End type
    } // End Equilateral

    // Right Angle Triangle implementation
    private static class RightAngle extends Triangle {
        @Override
        public String type() {
            return "Right Angle";
        } // End type
    } // End RightAngle
} // End Triangle
