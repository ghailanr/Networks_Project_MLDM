package Network;



import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reader {


    ReaderConnection rc;
    boolean shouldRun = true;

    public static void main(String[] args){
        new Reader();
    }

    public Reader(){
        try {
            Socket s = new Socket("localhost", 8080);
            rc = new ReaderConnection(s, this);
            rc.start();

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
