import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;

public class Download {

   public static void main(String[] args) throws Exception {
   
      try{
         String fileName ="cobweb-3725540_960_720.jpg";
         String website ="https://cdn.pixabay.com/photo/2018/10/05/09/45/"+fileName;
         
         System.out.println("Downloading File From: " + website);
         
         URL url = new URL(website);
         InputStream inputStream = url.openStream();
         OutputStream outputStream = new FileOutputStream(fileName);
         byte[] buffer = new byte[2048];
         
         int length = 0;
         
         while ((length = inputStream.read(buffer)) != -1) {
            System.out.println("Buffer Read of length: " + length);
            outputStream.write(buffer, 0, length);
         }
         
         inputStream.close();
         outputStream.close();
         
      } catch(Exception e) {
         System.out.println("Exception: " + e.getMessage());
      }
   }
}