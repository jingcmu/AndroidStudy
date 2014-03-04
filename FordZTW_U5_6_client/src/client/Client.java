package client;

public class Client extends DefaultSocketClient {
	public Client(String servIp, Integer servPort) {
		super(servIp, servPort);
	}
	
	public void run() {
		super.run();
	}
	
	public static void main(String[] argvs) {
		Client client = new Client(argvs[0], Integer.parseInt(argvs[1]));
		client.start();
		System.out.println("Client is up...");
	}
	
}
