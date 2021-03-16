package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReaderConnection extends Thread {

    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    boolean shouldRun = true;
    Reader reader;


    public ReaderConnection(Socket socket, Reader reader) {
        s = socket;
        this.reader = reader;
    }

    public void sendStringToServer(String text) throws IOException {
        dos.writeUTF(text);
        dos.flush();

    }

    public void run() {
        try {
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            while (shouldRun) {
                try {
                    while (dis.available() == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;

                        }
                    }
                    String reply = dis.readUTF();
                    System.out.println(reply);

                } catch (IOException e) {
                    e.printStackTrace();
                    close();
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
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
