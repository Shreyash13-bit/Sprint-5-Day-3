package com.example.kafkadlq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "input-topic", groupId = "dlq-group")
    public void listen(ConsumerRecord<String, String> record) {
        String value = record.value();
        if (value == null || value.contains("bad")) {
            throw new IllegalArgumentException("Bad message: " + value);
        }
        System.out.println("Processed: " + value);
    }
}
