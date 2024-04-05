
import java.net.*;
import java.io.*;

class client{
    public static void main(String arg[])throws IOException{
        ServerSocket ss = new ServerSocket(1212);
        Socket s = ss.accept();
        System.out.println("Client Connected");
    }
}