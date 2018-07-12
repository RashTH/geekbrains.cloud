package com.flamexander.netty.servers.serialization;

import com.flamexander.netty.common.MyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Client {
    static class Msg implements Serializable {
        int a;
        int b;
        byte[] arr;

        public Msg(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Msg msg = new Msg(1, 2);

        ObjectEncoderOutputStream oeos = null;
        try (Socket socket = new Socket("localhost", 8189)) {
            oeos = new ObjectEncoderOutputStream(socket.getOutputStream());
            MyMessage textMessage = new MyMessage("Hello Object");
            oeos.writeObject(msg);
            oeos.flush();
        } catch (Exception e) {
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
