package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            // Start listening on the specified port
            ServerSocket sock = new ServerSocket(portNumber);


            // Run forever, which is common for server style services
            while (true) {
                // Wait until someone connects, thereby requesting a date
                Socket client = sock.accept();
                System.out.println("Got a request!");

                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                // Construct a writer so we can write to the socket, thereby
                // sending something back to the client.


                // Send the current date back to the client.
                byte[] bytes = new byte[16*1024];

                int line;
                while ((line = input.read(bytes)) > 0) {
                    output.write(bytes, 0, line);
                }
                // Close the client socket since we're done.
                client.close();
            }
            // *Very* minimal error handling.
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}