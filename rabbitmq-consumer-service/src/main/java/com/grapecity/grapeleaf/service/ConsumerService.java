package com.grapecity.grapeleaf.service;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Noah
 */

@Service
public class ConsumerService {

    private static final String QUEUE_NAME = "Log-Queue";
    @Resource
    private MessageChannelFactory factory;

    public void ConsumeMessage() throws IOException, TimeoutException {
        Channel channel = factory.getChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

}
