import java.io.*;
import java.net.*;
import java.util.*;

public class MyServer
{
    ServerSocket SS;
    Socket S;
    DataInputStream dis;
    DataOutputStream dos;
    Scanner in;
    public MyServer()
    {
	   in=new Scanner(System.in);
	   try
	   {
              System.out.println("Server started");
		SS=new ServerSocket(8);
		S=SS.accept();
		System.out.println(S);
		System.out.println("Client Connected");
		dis=new DataInputStream(S.getInputStream());
		dos=new DataOutputStream(S.getOutputStream());
		ServerChat();
	   }
	   catch(Exception e)
	   {
			System.out.println(e);
	    }
	}
	public static void main(String st[])
	{
		new MyServer();
	}
	public void ServerChat()throws IOException
	{
		String cstr;
		String sstr;
		do
		{
		    cstr=dis.readUTF();
		    System.out.println("Client msg==>"+cstr);
                     sstr=in.nextLine();
                     dos.writeUTF(sstr);
                      dos.flush();
		}while(!cstr.equals("stop"));

	}
}















