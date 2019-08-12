package com.xdclass.rocketmq.jms;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.List;

@Component
public class PayConsumer {

    private DefaultMQPushConsumer consumer;

    @Autowired
    private JmsConfig jmsConfig;

    public PayConsumer() throws MQClientException {
        consumer =new DefaultMQPushConsumer(jmsConfig.getConsumerGroup());
        consumer.setNamesrvAddr(jmsConfig.getNameServer());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        consumer.subscribe(jmsConfig.getTopic(),"*");

        consumer.registerMessageListener(new MessageListenerConcurrently(){

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try{

                    Message message = list.get(0);
                    System.out.printf("%s Receive New Message：%s %n",Thread.currentThread().getName(),new String(list.get(0).getBody()));

                    String topic = message.getTopic();
                    String body = new String(message.getBody(), "utf-8");
                    String tags = message.getTags();
                    String keys = message.getKeys();
                    System.out.println(MessageFormat.format("topic={0},tags={1},keys={2},body={3}",topic,tags,keys,body));

                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

            }
        });

        consumer.start();
        System.out.println("consumer start ...");
    }

}
