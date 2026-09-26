package com.worksync.backend.kafka.consumer;

import com.worksync.backend.kafka.event.EmployeeCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class employeeConsumer {


    @KafkaListener(
            topics = "employee-created",
            groupId = "worksync-group"
    )
    public void consume(EmployeeCreatedEvent event) {
        System.out.println("==============================");
        System.out.println("Employee Created Event Received");
        System.out.println("Employee No : " + event.getEmployeeNo());
        System.out.println("Full Name   : " + event.getFullName());
        System.out.println("Department  : " + event.getDepartment());
        System.out.println("Position    : " + event.getPosition());
        System.out.println("==============================");
    }
}
