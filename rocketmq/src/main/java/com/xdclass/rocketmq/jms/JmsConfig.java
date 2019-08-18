package com.xdclass.rocketmq.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

public class JmsConfig {

    public static final String nameServer="39.107.79.33:9876";

    public static final String topic="xdclass_pay_test_topic_666";

    public static final String consumerGroup="pay_consumer_group";

    public static final String producerGroup="pay_producer_group";

    }
