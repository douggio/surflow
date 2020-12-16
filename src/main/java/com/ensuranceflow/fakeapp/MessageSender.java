package com.ensuranceflow.fakeapp;

import com.ensuranceflow.submitter.SubmitterMessageReceiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final SubmitterMessageReceiver receiver;

    @Value("rabbit.exchange")
    public String exchangeName;

    @Value("rabbit.queue")
    public String queueName;

    @Value("rabbit.routingkey")
    public String routingKey;

    public MessageSender(SubmitterMessageReceiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) throws Exception {
        System.out.println("Sending message: " + message);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
