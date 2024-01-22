package DCN_LAB;
import java.io.*;
import java.net.*;
class udpclient{
	public static void main(String args[]) throws Exception{
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket clientsocket=new DatagramSocket();
	InetAddress IPaddress=InetAddress.getByName("location");
	byte[] sendData=new byte[1024];
	byte[] receiveData=new byte[1024];
	String sentence="hello Server";
	sendData=sentence.getBytes();
	DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPaddress,9876);
	clientsocket.send(sendPacket);
	DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
	clientsocket.receive(receivePacket);
	String modifiedsentence=new String(receivePacket.getData());
	System.out.println("from sever"+modifiedsentence);
	clientsocket.close();
	}
}