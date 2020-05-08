package test.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
           /* Thread c= new Thread(() -> {
                try {
                    Socket s = ss.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

                    String str = reader.readLine();
                    System.out.println(str);
                    reader.close();
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
*/

public class Server {
    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("localhost", 8888));

        boolean start = true;
        while (start) {
            Socket s = ss.accept();
            Thread N = new Thread() {
                @Override
                public void run() {
                    try {

                        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

                        String str = reader.readLine();
                        System.out.println(str);
                        reader.close();
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            };

            N.start();

        }

        ss.close();
    }

}

