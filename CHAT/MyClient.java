import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient
{
    
    Socket S;
    DataInputStream dis;
    DataOutputStream dos;
    Scanner in;
    public MyClient()
    {
	in=new Scanner(System.in);
	 try
	   {
             
		
		S= new Socket("Localhost",8);
		System.out.println(S);
		dis=new DataInputStream(S.getInputStream());
		dos=new DataOutputStream(S.getOutputStream());
		ClientChat();
	   }
	   catch(Exception e)
	    {
			System.out.println(e);
	    }
	}
	public static void main(String std[])
	{
		new MyClient();
	}
	public void ClientChat()throws IOException
	{
	
		String str;
		do
		{
		    str=in.nextLine();
                     dos.writeUTF(str);
                      dos.flush();
			String sstr=dis.readUTF();
			System.out.println("Server msg==>"+sstr);
		}while(!str.equals("stop"));
	}
}

















