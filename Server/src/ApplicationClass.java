import java.io.IOException;

public class ApplicationClass {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Server server = new Server();
		server.PortListener();
	}
}
