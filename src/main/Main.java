package main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;


public class Main {

	static int portNumber = 8090;
	
	public static void main(String[] args) throws IOException {
		JFrame obj=new JFrame();
		
		Socket socketForServerCommunication = new Socket("localhost",
				portNumber); // localhost -> because it connects locally

		BufferedReader inputFromServer = new BufferedReader(
				new InputStreamReader(
						socketForServerCommunication.getInputStream()));//init inputstream
		
		PrintStream outputToServer = new PrintStream(
				socketForServerCommunication.getOutputStream());//init ouputstream
		
		
		
		Gameplay gamePlay = new Gameplay();
		
		obj.setBounds(10, 10, 800, 630);
		obj.setTitle("Tank 2D");	
		obj.setBackground(Color.gray);
		obj.setResizable(false);
		
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		obj.setVisible(true);

		
		
		
	}

}
