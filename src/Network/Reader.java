package Network;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Reader {


    ReaderConnection rc;
    boolean shouldRun = true;
    ServerSocket ss;

    public static void main(String[] args){
        new Reader();
    }

    public Reader(){
        try {
            System.out.println("Choose reader port :\n");
            Scanner scn = new Scanner(System.in);
            int readerPort = Integer.parseInt(scn.nextLine());

            Socket s = new Socket("localhost", 8080);
            ss = new ServerSocket(readerPort);
            rc = new ReaderConnection(s, this);
            rc.start();
            ReaderSocketListener listener = new ReaderSocketListener(ss, this);
            listener.start();

            listenForInput();

            rc.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void listenForInput() throws IOException {
        Scanner csn = new Scanner(System.in);
        while (shouldRun){
            while(!csn.hasNextLine()){
                try{
                    Thread.sleep(1);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            String input = csn.nextLine();
            rc.sendStringToServer(input);

            if (input.equalsIgnoreCase("quit")){
                shouldRun=false;
                break;
            }
        }
        rc.close();

    }

}
