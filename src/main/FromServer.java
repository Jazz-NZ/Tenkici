package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FromServer extends Thread {
	
	Socket socketForServerCommunication;
	
	public FromServer(Socket socket) {
		
		socketForServerCommunication = socket;
	}
	
	public void run() {
		
		int portNumber = 8090;
		
		System.out.println("FromServer zapocet");
		
		try {
			
			BufferedReader inputFromServer = new BufferedReader(
					new InputStreamReader(
							socketForServerCommunication.getInputStream()));//init inputstream
			
			PrintStream outputToServer = new PrintStream(
					socketForServerCommunication.getOutputStream());//init ouputstream
			
			String data;
			
			/*
			 * int counter = 0; int x = 550;
			 * 
			 * while(counter<30) { Thread.sleep(1000); x-=5; Gameplay.moveP2(x); counter++;
			 * 
			 * }
			 */
			// citanje podataka sa servera
			while ((data = inputFromServer.readLine()) != null) {
			
				//inicijalni string je duzine 1 i u njemu se namesta status
				
				System.out.println(data); 
				
				if(data.length() == 1) {
//					System.out.println(data);
					
					if(data.contains("1")) {
						Gameplay.setStatusP1(true);
					
					}else {
						Gameplay.setStatusP2(true);	
					
					}
					
				}
				
				else {
					
					String dataArr[] = data.split(","); // splituju se player,x,y,_,_,_,_ (smer)
				
				 //podesavanje statusa 1 ili 2
					if(dataArr[0].contains("1")) { //provera da li je u pitanju igrac 1
						System.out.println("Pomeranje igraca 1");
					
					
					int x = Integer.parseInt(dataArr[1]);
					Gameplay.setP1X(x); //podesavanje x kordinate igraca 1
					int y = Integer.parseInt(dataArr[2]);
					Gameplay.setP1Y(y); //podesavanje y kordinate
					if(dataArr[3].contains("1")) {
						Gameplay.setDirectionP1(true, false, false, false);
					}
					if(dataArr[4].contains("1")) {
						Gameplay.setDirectionP1(false, true, false, false);
					}
					if(dataArr[5].contains("1")) {
						Gameplay.setDirectionP1(false, false, true, false);
					}
					if(dataArr[6].contains("1")) {
						Gameplay.setDirectionP1(false, false, false, true);
					}
				}else {
					
					
					int x = Integer.parseInt(dataArr[1]);
					Gameplay.setP2X(x); //podesavanje x kordinate igraca 2
					int y = Integer.parseInt(dataArr[2]);
					Gameplay.setP2Y(y); //podesavanje y kordinate
					if(dataArr[3].contains("1")) {
						Gameplay.setDirectionP2(true, false, false, false);
					}
					if(dataArr[4].contains("1")) {
						Gameplay.setDirectionP2(false, true, false, false);
					}
					if(dataArr[5].contains("1")) {
						Gameplay.setDirectionP2(false, false, true, false);
					}
					if(dataArr[6].contains("1")) {
						Gameplay.setDirectionP2(false, false, false, true);
					}
					
				}
				}
				//int x = Integer.parseInt(newX);
				//Gameplay.moveP2(x);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // localhost -> because it connects locally

		
		
		//ChatClientKeyboard keyboardInit = new ChatClientKeyboard(outputToServer);
		
	}

}
