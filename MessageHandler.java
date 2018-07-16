// MessageHandler class
public class MessageHandler {
    private String[] messageParts;

    public MessageHandler(String message) {
        // Split message at delimiter
        System.out.println("Message received: "+ message);
        messageParts = message.split(" ");
    } // End constructor

    public String genResponse() {
        // Create array of doubles of equal length to message parts
        double[] sides = new double[messageParts.length];

        // Iterative over message parts and parse each to a double
        for (int i = 0; i < sides.length; i++) {
            sides[i] = Double.parseDouble(messageParts[i]);
        } // End for

        // Build triangle from parsed values
        Triangle triangle = Triangle.triangleFactory(sides);

        // Return result based on triangle state
        return triangle != null ? triangle.type() + " Triangle" : "Not A Triangle";
    } // End getResponse
} // End MessageHandler
