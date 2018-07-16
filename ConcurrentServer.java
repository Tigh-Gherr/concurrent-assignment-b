import java.io.IOException;
import java.net.ServerSocket;

// Concurrent Server class
public class ConcurrentServer {

    public static void main(String[] args) {
        // Instantiate and run ConcurrentServer
        System.out.println("Welcome to Triangle Concurrent Server!");
        new ConcurrentServer().run();
    } // End main

    private void run() {
        // Create Socket for client attachment point
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                // Instantiate socket wrapper
                System.out.println("Waiting for a connection...");
                SocketWrapper clientSocket = new SocketWrapper(serverSocket.accept());
                // Start new thread for handling message
                new ConcurrentServerThread(clientSocket).start();
            } // End while
        } catch (IOException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run

    // Concurrent Server's thread
    private static class ConcurrentServerThread extends Thread {
        private SocketWrapper socket;

        public ConcurrentServerThread(SocketWrapper socket) {
            this.socket = socket;
        } // End constructor

        @Override
        public void run() {
            try {
                // Instantiate message handler
                MessageHandler handler = new MessageHandler(socket.receiveMessage());
                // Send response as message to client
                socket.sendMessage(handler.genResponse());
                // Close connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } // End try/catch
        } // End run
    } // End ConcurrentServerThread
} // End ConcurrentServer
