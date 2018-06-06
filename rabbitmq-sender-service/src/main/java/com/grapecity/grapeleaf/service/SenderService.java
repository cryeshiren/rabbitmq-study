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

    public void publishMessage(String message) throws IOException, TimeoutException {
        Channel channel = factory.getChannel();

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    }
}
