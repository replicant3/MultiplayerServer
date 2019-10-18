import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 8876;
    // champion object creation
    private Champion player;
    
    public Server() throws IOException, ClassNotFoundException{
    	long cdt[] = new long[4];
    	cdt[0] = 500;
    	cdt[1] = 1000;
    	cdt[2] = 2000;
    	cdt[3] = 3000;
    	player = new Champion(cdt);
    	
    }
    
    public void PortListener() throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){            
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
            //convert ObjectInputStream object to String
            String recieved = (String) ois.readObject();
            //System.out.println("Received: " + recieved);
            ProcessInput(recieved);
            
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            //write object to Socket
            oos.writeObject("Server Confirmation");
            
            //close resources
            ois.close();
            oos.close();
            socket.close();

            //terminate the server if client sends exit request
            if(recieved.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down server...");
        //close the ServerSocket object
        server.close();
    }
    
    public void ProcessInput(String input) {
		switch (input.toUpperCase()) {
		case "LEFT":
			System.out.println("Left");
			break;

		case "RIGHT":
			System.out.println("Right");
			break;

		case "UP":
			System.out.println("Up");
			break;
			
		case "DOWN":
			System.out.println("Down");
			break;
		
		case "QABILITY":
			System.out.println("Q");
			player.abilityQ();
			break;
		
		case "WABILITY":
			System.out.println("W");
			player.abilityW();
			break;
		
		case "EABILITY":
			System.out.println("E");
			player.abilityE();
			break;
		
		case "RABILITY":
			System.out.println("R");
			player.abilityR();
			break;
		}
    }
}
