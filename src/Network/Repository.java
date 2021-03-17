package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Repository{

    ServerSocket serverSocket;
    ArrayList<ReaderHandler> readers = new ArrayList<>();
    boolean shouldRun = true;



    public static void main(String[] args){
        new Repository();
    }

    public Repository(){
        try{
            serverSocket = new ServerSocket(8080);
            while (shouldRun){
                Socket s = serverSocket.accept();
                ReaderHandler rh = new ReaderHandler(s, this);
                rh.start();
                readers.add(rh);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

