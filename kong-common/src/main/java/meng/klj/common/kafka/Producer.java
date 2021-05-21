package meng.klj.common.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    static final String TOPIC = "test-klj";
    static final String BOOTSTRAP_SERVERS = "192.168.137.75:39092";

    public static void main(String[] args) {
        KafkaProperties kafkaProperties = new KafkaProperties(BOOTSTRAP_SERVERS);
        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(kafkaProperties);
        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>(TOPIC, Integer.toString(i), Integer.toString(i)));
        producer.close();
    }
}
