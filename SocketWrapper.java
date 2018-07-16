import java.io.*;
import java.net.Socket;

// SocketWrapper class
public class SocketWrapper {
    private BufferedReader input;
    private PrintWriter output;
    private Socket socket;

    public SocketWrapper(String host, int port) throws IOException {
        // Instantiate socket
        System.out.println("Connection request made to server " + host + " on port " + port);
        socket = new Socket(host, port);
        setStreams();
    } // End constructor

    public SocketWrapper(Socket socket) throws IOException {
        // Set socket
        System.out.println("Connection accepted.");
        this.socket = socket;
        setStreams();
    } // End constructor

    public void sendMessage(String msg) {
        System.out.println("Sending message: " + msg);
        // Send message and flush stream
        output.println(msg);
        output.flush();
    } // End sendMessage

    public String receiveMessage() throws IOException {
        // Read message from stream
        return input.readLine();
    } // End receiveMessage

    public void close() throws IOException {
        // Close socket
        socket.close();
    } // End close

    private void setStreams() throws IOException {
        // Create BufferedReader
        input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        // Create PrintWriter
        output = new PrintWriter(
            new OutputStreamWriter(socket.getOutputStream())
        );
    } // End setStreams
} // End SocketWrapper
