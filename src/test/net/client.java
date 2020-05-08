package test.net;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 8888);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("liuhuaqiang");
        bw.newLine();
        bw.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = bufferedReader.readLine();
        System.out.println(str);
        bw.close();


    }
}
