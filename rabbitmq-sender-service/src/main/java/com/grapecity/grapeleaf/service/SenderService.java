package com.grapecity.grapeleaf.service;

import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class SenderService {

    private static final String QUEUE_NAME = "Log-Queue";

    @Resource
    private MessageChannelFactory factory;

    public void publishMessage(String message) throws IOException, TimeoutException, InterruptedException {
        Channel channel = factory.getChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //ability
        channel.basicQos(1);

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        //mockProduce(channel, message);
    }


    private void mockProduce(Channel channel, String message) throws IOException, InterruptedException {
        for(int i = 0; i < 50; i++){
            channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes());

            Thread.sleep(100L);
        }
    }
}
