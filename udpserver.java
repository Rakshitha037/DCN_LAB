package DCN_LAB;
import java.io.*;
import java.net.*;
class udpserver{
	public static void main(String args[]) throws Exception{
		DatagramSocket serversocket=new DatagramSocket(9876);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		byte[] receivedData=new byte[1024];
		byte[] sendData=new byte[1024];
		DatagramPacket receivePacket=new DatagramPacket(receivedData,receivedData.length);
		serversocket.receive(receivePacket);
		String sentence=new String(receivePacket.getData());
		System.out.println("RECEIVED:"+sentence);
		InetAddress IPaddress=receivePacket.getAddress();
		int port=receivePacket.getPort();
		System.out.println("\nEnter the message");
		String data=br.readLine();
		sendData=data.getBytes();
		DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPaddress,port);
		serversocket.send(sendPacket);
		serversocket.close();
		}
}