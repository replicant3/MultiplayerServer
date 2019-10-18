import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
		
		public void sendPacket(Object input) throws UnknownHostException, 
		IOException, ClassNotFoundException, InterruptedException{
            //establish socket connection to server
            socket = new Socket("192.168.178.26", 8876);
            
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(input);
            
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String recieved = (String) ois.readObject();
            System.out.println("Server: " + recieved);

            //close resources
            ois.close();
            oos.close();
            //Thread.sleep(100);
		}
	}
