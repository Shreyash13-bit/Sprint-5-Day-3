package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumerService.class);

    @KafkaListener(topics = "user-events", groupId = "event-group")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        logger.info("Consumed event: {}", record.value());
    }
}