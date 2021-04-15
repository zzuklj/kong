package meng.klj.common.kafka;

import java.util.Properties;

public class KafkaProperties extends Properties {

    public KafkaProperties(String bootstrapServers) {
        this.put("bootstrap.servers", bootstrapServers);
        this.put("acks", "all");
        this.put("retries", 0);
        this.put("batch.size", 16384);
        this.put("linger.ms", 1);
        this.put("buffer.memory", 33554432);
        this.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }
}
