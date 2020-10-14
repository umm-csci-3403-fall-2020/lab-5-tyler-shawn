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

                //Creating input and output streams so we are able to send and recieve stuff in the socket
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();


                //Creating new array of bytes
                byte[] bytes = new byte[16*1024];

                int line;
                //Reading from the input stream
                while ((line = input.read(bytes)) > 0) {
                    //Outputting back to the socket to return to the clien
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