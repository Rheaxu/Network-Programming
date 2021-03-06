package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {
	
	public static void main(String[] args) throws IOException
	{
		DatagramSocket clientSocket = new DatagramSocket();
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		while(true)
		{
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			InetAddress IPAddress = InetAddress.getByName("localhost");
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			System.out.println("I've got a data packet");
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("FROM SERVER: "+modifiedSentence);
			clientSocket.close();
		}
		
	}
	
	
	
}
