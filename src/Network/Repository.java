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

            RepositoryAcceptConnection acceptConnection = new RepositoryAcceptConnection(serverSocket, this);
            acceptConnection.start();
            while (shouldRun){

                updateReaderList();
                Thread.sleep(1000);

            }

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
            shouldRun = false;
        }
    }

    public void addToReaders(ReaderHandler rh){
        if (!this.readers.contains(rh)){
            this.readers.add(rh);
        }
    }

    public void updateReaderList(){
        readers.removeIf(rh -> !rh.isAlive());
    }

}

