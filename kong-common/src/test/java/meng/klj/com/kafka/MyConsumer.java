package meng.klj.com.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MyConsumer {

    private KafkaConsumer<String, String> kafkaConsumer;

    public MyConsumer(){
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.137.75:39092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "klj_test");
        kafkaConsumer = new KafkaConsumer(p);
    }

    public static void main(String[] args) {
        MyConsumer myConsumer = new MyConsumer();
        KafkaConsumer<String, String> kafkaConsumer = myConsumer.kafkaConsumer;
        kafkaConsumer.subscribe(Collections.singletonList(MyProducer.topic));// 订阅消息

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(2));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format("topic:%s,offset:%d,消息:%s", //
                        record.topic(), record.offset(), record.value()));
            }
        }
    }
}
