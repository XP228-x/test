package com.bosssoft.hr.train.j2se.basic.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:25
 * @since
 **/
@Slf4j
public class NIOServerSocket implements Starter{
    @Override
    public boolean start() {
        Selector selector;
        int port = 9981;

        //获取一个ServerSocket通道
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()){
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(port));
            //获取通道管理器
            selector = Selector.open();
            //将通道管理器与通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件
            //只有当该事件到达时，Selector.select()会返回，否则一直阻塞
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);


            log.info("服务器端启动成功");

            //使用轮询访问selector
            while (true) {


                //当有注册的事件到达时，方法返回，否则阻塞
                selector.select();


                //获取selector中的迭代器，选中项为注册的事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //删除已选key，防止重复处理
                    iterator.remove();
                    //客户端请求连接事件
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //获得客户端连接通道
                        SocketChannel channel = server.accept();
                        channel.configureBlocking(false);
                        //向客户端发消息
                        channel.write(ByteBuffer.wrap("hello client".getBytes()));
                        //在与客户端连接成功后，为客户端通道注册SelectionKey.OP_READ事件。
                        channel.register(selector, SelectionKey.OP_READ);

                        log.info("客户端请求连接事件");
                        //有可读数据事件
                    } else if (key.isReadable()) {
                        //获取客户端传输数据可读取消息通道。
                        SocketChannel channel = (SocketChannel) key.channel();
                        //创建读取数据缓冲器
                        ByteBuffer buffer = ByteBuffer.allocate(30);
                        int read = channel.read(buffer);
                        if (read == -1) {
                            channel.close();
                            selector.close();
                            log.info("服务器关闭");
                            return true;
                        }

                        byte[] data = buffer.array();
                        String message = new String(data);

                        log.info("receive message from client, size:" + buffer.position() + ", msg: " + message);
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    }

