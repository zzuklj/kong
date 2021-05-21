package meng.klj.upms.test.queue;

import java.util.concurrent.*;

public class MessageTest {
    public static void main(String[] args) {
        DelayQueue<Message> queue = new DelayQueue<>();
        Message m1 = new Message(1, "this is m1", 3000);
        Message m2 = new Message(6, "this is m2", 6000);
        Message m3 = new Message(10, "this is m3", 10000);
        Message m4 = new Message(4, "this is m4", 20000);
        queue.offer(m1);
        queue.offer(m2);
        queue.offer(m3);
        queue.offer(m4);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new MessageConsumer(queue));
        executorService.shutdown();

    }

}
