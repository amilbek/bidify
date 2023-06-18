package com.example.productservice.queue;

import org.springframework.stereotype.Service;

@Service
public interface MessagePublisher {

    void publish(final String message);
}
