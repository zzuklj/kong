package meng.klj.common.reactor.siglethread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable{

    final Selector selector;

    final ServerSocketChannel  channel;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(port));
        channel.configureBlocking(false);
        SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT);
        key.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    dispathcer(iterator.next());
                }
            }
        }catch (Exception e){

        }

    }

    private void dispathcer(SelectionKey selectionKey) {
        Runnable r = (Runnable) selectionKey.attachment();
        if(r != null ) r.run();
    }

    class Acceptor implements Runnable{
        @Override
        public void run() {
            try{
                SocketChannel c = channel.accept();
                if(channel != null)  new Handler(selector, c);
            }catch (Exception e){

            }
        }
    }
}
