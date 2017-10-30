import java.io.*;
import java.net.*;
 
public class client1
{
 
    
 
    public static void main(String args[])throws Exception
    {
    
            DatagramSocket socket=new DatagramSocket(9800);
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendData=new byte[1024];
            byte[] recieveData=new byte[1024];
            String sentence = "Message from client...Hello there";
            sendData=sentence.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,address,9876);
            socket.send(sendPacket);
            DatagramPacket receivePacket=new DatagramPacket(recieveData,recieveData.length);
            socket.receive(receivePacket);
            String sentence2=new String(receivePacket.getData());
            System.out.println("From server:"+sentence2);
            socket.close();
            
    }
}
