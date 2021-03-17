package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReaderConnection extends Thread {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    boolean shouldRun = true;
    Reader reader;


    public ReaderConnection(Socket socket, Reader reader) {
        this.socket = socket;
        this.reader = reader;
    }

    public void sendStringToServer(String text) throws IOException {
        dos.writeUTF(text);
        dos.flush();

    }

    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            while (shouldRun) {
                try {
                    while (dis.available() == 0) { //TODO using "quit" causes an IOException due to dis being closed -> new Thread?
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            shouldRun = false;
                            break;
                        }
                    }
                    String reply = dis.readUTF();
                    System.out.println(reply);

                } catch (IOException e) {
                    e.printStackTrace();
                    shouldRun = false;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }

    }

    public void close(){
        try{
            dis.close();
            dos.close();
            socket.close();
            this.shouldRun = false;
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
