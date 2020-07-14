package com.io.netty.heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInit extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 读空闲 写空闲  读写空闲
        pipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
