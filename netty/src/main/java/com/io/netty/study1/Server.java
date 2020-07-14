package com.io.netty.study1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * netty学习第一个例子，简洁的服务端
 */
public class Server {
    public static void main(String[] args) {

        // 事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 启动工具类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 绑定到两个组
        serverBootstrap.group(bossGroup ,workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("httpServerCodec",new HttpServerCodec())
                                .addLast("serverHandle" , new ServerHandle());
                    }
                });
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
class ServerHandle extends SimpleChannelInboundHandler<HttpObject>{

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        ByteBuf content = Unpooled.copiedBuffer("HelloWorld!", CharsetUtil.UTF_8);
        //构造一个http响应,HttpVersion.HTTP_1_1:采用http1.1协议，HttpResponseStatus.OK：状态码200
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        //如果只是调用write方法，他仅仅是存在缓冲区里，并不会返回客户端
        channelHandlerContext.writeAndFlush(response);
    }
}
