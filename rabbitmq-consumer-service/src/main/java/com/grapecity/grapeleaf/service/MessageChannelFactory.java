package com.grapecity.grapeleaf.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class MessageChannelFactory {


    public Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        return connection.createChannel();
    }
}
