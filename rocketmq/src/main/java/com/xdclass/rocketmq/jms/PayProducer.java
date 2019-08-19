package com.xdclass.rocketmq.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayProducer {

    private DefaultMQProducer producer;

    public PayProducer() {
        producer = new DefaultMQProducer(JmsConfig.producerGroup);
        producer.setNamesrvAddr(JmsConfig.nameServer);
        start();
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    public void start() {
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
