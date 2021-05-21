package meng.klj.upms.test.queue;

import io.micrometer.core.instrument.util.TimeUtils;
import lombok.Data;

import java.util.Comparator;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 消息体，定义延时策略
 */
@Data
public class Message implements Delayed {

    private int id;

    private String body;

    private long excuteTime;

    public Message(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.excuteTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Message m = (Message) o;
        return Comparator.comparing(Message::getExcuteTime).compare(this, m);
    }
}
