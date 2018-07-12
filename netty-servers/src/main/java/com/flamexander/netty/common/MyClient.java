package com.flamexander.netty.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8189);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
            out.write(new byte[]{10, 21, 32});
            while (true) {
                String x = in.nextLine();
                System.out.println("A: " + x);
                if (x == "65") {
                    break;
                }
            }
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
