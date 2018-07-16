import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Client class
public class Client {
    private Scanner sc;

    private Client() {
        // Instantiate scanner
        sc = new Scanner(System.in);
    } // End Client

    public static void main(String[] args) {
        // Instantiate and run Client
        System.out.println("Welcome to the Triangle Client!");
        new Client().run();
    } // End main

    private void run() {
        try {
            // Connect to server on port 5000
            SocketWrapper serverSocket = new SocketWrapper("localhost", 5000);

            // Receive input for side a
            double a = getSide('a');

            // Receive input for side b
            double b = getSide('b');

            // Receive input for side c
            double c = getSide('c');

            // Build and send method
            String message = a + " " + b + " " + c;
            serverSocket.sendMessage(message);

            // Print received message and close connection
            System.out.println("From server: " + serverSocket.receiveMessage());
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run

    private double getSide(char side) {
        double input = -1;
        // Until a valid input is entered
        while (input <= 0) {
            try {
                System.out.print("Enter side " + side + ": ");
                input = sc.nextDouble();
            } catch (InputMismatchException ignored) {
            } finally {
                sc.nextLine();
            } // End try/catch/finally
        } // End while
        return input;
    } // End getSide
} // End Client
