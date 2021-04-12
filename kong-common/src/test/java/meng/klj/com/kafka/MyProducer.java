package meng.klj.com.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class MyProducer {

    public static String topic = "klj_test";//定义主题

    private KafkaProducer<String, String> kafkaProducer;

    public MyProducer(){
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.137.75:39092");//kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProducer = new KafkaProducer<>(p);
    }

    public static void main(String[] args) throws InterruptedException {
        MyProducer myProducer = new MyProducer();
        KafkaProducer<String, String> kafkaProducer = myProducer.kafkaProducer;
        List<PartitionInfo> partitionInfos = kafkaProducer.partitionsFor(topic);
        try {
            Integer i = 10;
            while (i > 0) {
                String msg = "Hello," + i--;
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg);
                kafkaProducer.send(record);
                System.out.println("消息发送成功:" + msg);
                Thread.sleep(1000);
            }
        } finally {
            kafkaProducer.close();
        }


    }
}
