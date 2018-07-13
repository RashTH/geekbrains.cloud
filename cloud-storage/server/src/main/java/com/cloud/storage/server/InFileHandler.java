package com.cloud.storage.server;

import com.cloud.storage.common.FileSClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InFileHandler extends ChannelInboundHandlerAdapter {
    String homePath = "D:\\Java_Projects\\";
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FileSClass){
            File file = new File(homePath + ((FileSClass) msg).getName());
            Files.write(file.toPath(), ((FileSClass) msg).getArr(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
