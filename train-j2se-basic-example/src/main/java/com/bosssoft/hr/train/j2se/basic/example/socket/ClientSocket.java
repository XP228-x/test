package com.bosssoft.hr.train.j2se.basic.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @param
 * @author: Administrator
 * @create: 2020-05-28 22:25
 * @since
 **/
@Slf4j
public class ClientSocket implements  Starter{
    @Override
    public boolean start(){
        Selector selector;
        String serverIp="127.0.0.1";
        int port=9981;
        try(SocketChannel channel=SocketChannel.open()) {

            channel.configureBlocking(false);
            //客户端连接服务器，需要调用channel.finishConnect();才能实际完成连接。
            channel.connect(new InetSocketAddress(serverIp, port));
            //获得通道管理器
            selector = Selector.open();
            //为该通道注册SelectionKey.OP_CONNECT事件
            channel.register(selector, SelectionKey.OP_CONNECT);

            log.info("客户端启动");

            while(true){
                //选择注册过的io操作的事件(第一次为SelectionKey.OP_CONNECT)
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //删除已选的key，防止重复处理
                    iterator.remove();
                    if(key.isConnectable()){
                        SocketChannel channel1 = (SocketChannel)key.channel();

                        //如果正在连接，则完成连接
                        if(channel1.isConnectionPending()){
                            channel1.finishConnect();
                        }

                        channel1.configureBlocking(false);
                        //向服务器发送消息
                        channel1.write(ByteBuffer.wrap("hello server.".getBytes()));

                        //连接成功后，注册接收服务器消息的事件
                        channel1.register(selector, SelectionKey.OP_READ);
                        log.info("客户端连接成功");
                        //有可读数据事件
                    }else if(key.isReadable()){
                        SocketChannel channel2 = (SocketChannel)key.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(30);
                        channel2.read(buffer);
                        byte[] data = buffer.array();
                        String message = new String(data);

                        log.info("receive message from server:, size:" + buffer.position() + " msg: " + message);

                        channel2.close();
                        selector.close();
                        log.info("客户端关闭");
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            log.error(e.getLocalizedMessage(),e);
            return false;
        }
    }
}
