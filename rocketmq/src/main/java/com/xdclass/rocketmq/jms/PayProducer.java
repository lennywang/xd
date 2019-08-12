package com.xdclass.rocketmq.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayProducer {

    private DefaultMQProducer producer;

    @Autowired
    private JmsConfig jmsConfig;

    public PayProducer() {
        producer = new DefaultMQProducer(jmsConfig.getProducerGroup());
        producer.setNamesrvAddr(jmsConfig.getNameServer());
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
