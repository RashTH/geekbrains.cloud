package com.flamexander.netty.servers.blockserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Arrays;

public class SecondHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] arr = (byte[])msg;
        for (int i = 0; i < 3; i++) {
            arr[i]++;
        }
        System.out.println("Second var: " + Arrays.toString(arr));
        ctx.fireChannelRead(arr);
    }
}
