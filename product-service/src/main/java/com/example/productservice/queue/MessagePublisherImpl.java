package com.example.productservice.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisherImpl implements MessagePublisher {

    private RedisTemplate<String, Object> redisTemplate;
    private ChannelTopic topic;

    public MessagePublisherImpl() {
    }

    @Autowired
    public MessagePublisherImpl(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
