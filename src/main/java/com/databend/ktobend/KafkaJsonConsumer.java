package com.databend.ktobend;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class KafkaJsonConsumer {
    private KafkaConsumer<String, String> consumer;

    public KafkaJsonConsumer(String topic) {
        // Kafka consumer configuration
        Properties props = new Properties();
        props.put("bootstrap.servers", Config.getKafkaBootstrapServers());
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        this.consumer = new KafkaConsumer<>(props);
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    public KafkaConsumer<String, String> getConsumer() {
        return this.consumer;
    }

    public void closeConsumer() {
        this.consumer.close();
    }
}
