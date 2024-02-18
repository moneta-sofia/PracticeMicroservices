package com.example.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @RabbitListener(queues="send-notification")
    public  void  consume( String message){
        logger.info("Received notification "+message);
    }
}
