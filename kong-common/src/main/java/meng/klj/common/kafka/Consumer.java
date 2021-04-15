package meng.klj.common.kafka;

import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import static meng.klj.common.kafka.Producer.*;

public class Consumer {

    static final String filePath = "D:\\klj\\kafka-data.txt";

    public static void main(String[] args) {
        KafkaProperties kafkaProperties = new KafkaProperties(BOOTSTRAP_SERVERS);
        kafkaProperties.put("group.id", "testKljGroup");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProperties);
        consumer.subscribe(Collections.singleton(TOPIC));

        while(true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            consumerRecords.forEach(c ->
                    {
                        try {
                            FileUtils.writeLines(
                                    new File(filePath),
                                    Collections.singleton(String.format("partition = %d,offset = %d, key = %s, value = %s%n",c.partition(), c.offset(), c.key(), c.value())),
                                    true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
    }
}}
