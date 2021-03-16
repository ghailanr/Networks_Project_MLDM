package Network;



import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reader {


    ReaderConnection rc;

    public static void main(String[] args){
        new Reader();
    }

    public Reader(){
        try {
            Socket s = new Socket("localhost", 8080);
            rc = new ReaderConnection(s, this);
            rc.start();

            listenForInput();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void listenForInput() throws IOException {
        Scanner csn = new Scanner(System.in);
        while (true){
            while(!csn.hasNextLine()){
                try{
                    Thread.sleep(1);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            String input = csn.nextLine();

            if (input.toLowerCase().equals("quit")){
                break;
            }

            rc.sendStringToServer(input);
        }
        rc.close();

    }

}
