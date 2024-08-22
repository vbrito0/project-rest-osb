package br.com.project.rest.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "admin_topic", groupId = "admin-group-id")
    public void consume(String message) {
        System.out.println("Mensagem consumida: " + message);
    }
}
