package Network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ReaderHandler extends Thread {

    DataInputStream dis;
    DataOutputStream dos;
    Socket s;
    Repository repository;
    boolean shouldRun = true;

    public ReaderHandler(Socket s, Repository repository) {
        super("ReaderHandler");
        this.s = s;
        this.repository = repository;
    }

    public void sendStringToAllClient(String text) throws IOException {
        for (int index = 0; index < repository.readers.size(); index++) {
            ReaderHandler rh = repository.readers.get(index);
            rh.sendStringToClient(text);
        }
    }

    public void sendStringToClient(String text) throws IOException {
        dos.writeUTF(text);
        dos.flush();
    }

    public void sendReaderListToReader(ArrayList<ReaderHandler> list) throws IOException {
        for (ReaderHandler readerHandler : list) {
            dos.writeUTF(readerHandler.getSocket().getRemoteSocketAddress().toString());
            dos.flush();
        }
    }

    @Override
    public void run() {

        try {
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            while (shouldRun) {
                while (dis.available() == 0) {
                    Thread.sleep(1);
                }
                String textIn = dis.readUTF();
                if (textIn.equals("list")){
                    sendReaderListToReader(this.repository.readers);
                }
                sendStringToAllClient(textIn);
            }

            dis.close();
            dos.close();
            s.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket(){
        return this.s;
    }
}
