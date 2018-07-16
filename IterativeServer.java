import java.io.*;
import java.net.ServerSocket;

// IterativeServer class
public class IterativeServer {
    public static void main(String[] args) {
        // Instantiate and run IterativeServer
        System.out.println("Welcome to Triangle Iterative Server!");
        new IterativeServer().run();
    } // End main

    private void run() {
        // Create Socket for client attachment point
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                // Instantiate socket wrapper
                System.out.println("Waiting for a connection...");
                SocketWrapper clientSocket = new SocketWrapper(serverSocket.accept());
                // Instantiate message handler
                MessageHandler handler = new MessageHandler(clientSocket.receiveMessage());
                // Send response as message to client
                clientSocket.sendMessage(handler.genResponse());
                // Close connection
                clientSocket.close();
            } // End while
        } catch (IOException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run
} // End IterativeServer
