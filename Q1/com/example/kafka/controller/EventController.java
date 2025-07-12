package com.example.kafka.controller;

import com.example.kafka.service.EventProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducerService producerService;

    public EventController(EventProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> sendEvent(@RequestBody String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Event published to Kafka topic.");
    }
}