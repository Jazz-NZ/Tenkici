package main;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ToServer {

	Socket socketForServerCommunication;
	PrintStream outputToServer;
	
	
	public ToServer(Socket socket) {
		
		socketForServerCommunication = socket;
		 try {
			outputToServer = new PrintStream(
					socketForServerCommunication.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void send(String playerXY) {
		
		//slanje podataka ka serveru
		outputToServer.println(playerXY);
		
	}
	
	
	
}
