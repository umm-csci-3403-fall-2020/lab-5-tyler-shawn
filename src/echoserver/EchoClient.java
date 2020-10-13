package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient { 
  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;
    // If no server is specified use "127.0.0.1" ,localhost.
    if (args.length == 0) {
      server = "127.0.0.1";
    }
    else {
      server = args[0];
    }

  
  
    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);
    
      // Get the input stream so we can read from the socket
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      
      // Print all the input we receive from the server
      byte line;
      while (( line = reader.readLine()) != null) {
	int num  = read(line);
        char charactor = (char)num;
	// write();
	// flush();
	System.out.println(num);
	System.out.println(charactor);
	System.out.println(line);
      } 
      
      //Close the socket when we are done reading from it
      socket.close();


    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.out.println(ioe);
    }  
  
  }  

}

