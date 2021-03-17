package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReaderSocketListener extends Thread{

    ServerSocket ss;
    Reader reader;

    String otherReaderAddress;

    public ReaderSocketListener(ServerSocket socket, Reader reader){
        super("ReaderSocketListener");
        this.ss = socket;
        this.reader = reader;
    }

    public void run(){
        while (reader.shouldRun){
            try {
                Socket socket = ss.accept();
                otherReaderAddress = socket.getRemoteSocketAddress().toString();
                System.out.println("Reader " + otherReaderAddress + " has established a connection with you");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
