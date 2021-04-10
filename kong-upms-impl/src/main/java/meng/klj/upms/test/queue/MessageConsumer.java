package meng.klj.upms.test.queue;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;

public class MessageConsumer implements Runnable {

    private DelayQueue<Message> queue;

    public MessageConsumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message m = queue.take();
                System.out.println(LocalDateTime.now());
                System.out.println(String.format("消费消息id: %d, 消息体内容：%s", m.getId(), m.getBody()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
