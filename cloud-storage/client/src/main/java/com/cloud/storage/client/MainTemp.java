package com.cloud.storage.client;

import com.cloud.storage.common.FileSClass;
import com.cloud.storage.common.ServerConst;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.net.Socket;

public class MainTemp implements ServerConst {
    public static void main(String[] args) {
        FileSClass fileSClass = new FileSClass("D:\\08 Come and Get Your Love.m4a");

        ObjectEncoderOutputStream oeos = null;
        try {
            Socket socket = new Socket(SERVER_URL, PORT);
            oeos = new ObjectEncoderOutputStream(socket.getOutputStream());
            oeos.writeObject(fileSClass);
            oeos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oeos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
