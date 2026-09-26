package com.worksync.backend.kafka.producer;

import com.worksync.backend.kafka.event.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeProducer {

    private static final String TOPIC = "employee-created";

    private final KafkaTemplate<String, EmployeeCreatedEvent> kafkaTemplate;

    public void publish(EmployeeCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
