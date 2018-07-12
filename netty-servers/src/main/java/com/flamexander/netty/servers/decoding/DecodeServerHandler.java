package com.flamexander.netty.servers.decoding;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DecodeServerHandler extends ChannelInboundHandlerAdapter {
    byte[] arr = new byte[1024];
    int pointer = 0;
    String client = "Java";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        String o = (String)msg;
        System.out.println(o);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        cause.printStackTrace();
        ctx.close();
    }
}
