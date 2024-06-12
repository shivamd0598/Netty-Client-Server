package org.example.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private ChannelHandlerContext ctx;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        System.out.println("Connection active. Type your messages:");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String response = (String) msg;
        System.out.println("Received: " + response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    public void sendMessage(String message) {
        if (ctx != null) {
            ctx.writeAndFlush(message);
        }
    }
}

