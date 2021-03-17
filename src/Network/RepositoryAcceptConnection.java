package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RepositoryAcceptConnection extends Thread{

    Repository repository;
    ServerSocket serverSocket;
    boolean shouldRun = true;

    public RepositoryAcceptConnection(ServerSocket serverSocket, Repository repository){
        super("RepositoryAcceptConnection");
        this.serverSocket = serverSocket;
        this.repository = repository;
    }

    public void run(){
        try{
            while(shouldRun){
                Socket socket = serverSocket.accept();
                ReaderHandler rh= new ReaderHandler(socket, this.repository);
                this.repository.addToReaders(rh);
                rh.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
