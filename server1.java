import java.io.*;
import java.net.*;
 
public class server1
{
 
    public static void main(String[] args)throws Exception
    {
 
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] sendData=new byte[1024];
            byte[] receiveData=new byte[1024];
              InetAddress ip = InetAddress.getByName("localhost");  
                
                DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
                socket.receive(receivePacket);
                String sentence=new String(receivePacket.getData());
                System.out.println("Recieved:"+sentence);
                
                
                String returnMessage="Message from server";
                sendData=returnMessage.getBytes();
                DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,ip,9800);
                socket.send(sendPacket);
                socket.close();
      
    }
}
