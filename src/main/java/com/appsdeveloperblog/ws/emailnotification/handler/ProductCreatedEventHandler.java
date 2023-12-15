package com.appsdeveloperblog.ws.emailnotification.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.ws.core.ProductCreatedEvent;
import com.appsdeveloperblog.ws.emailnotification.error.NotRetryableException;

@Component
@KafkaListener(topics="product-created-events-topic")
public class ProductCreatedEventHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@KafkaHandler
	public void handle(ProductCreatedEvent productCreatedEvent) {
		if(true) throw new NotRetryableException("An error took place. No need to consume this message again.");
		LOGGER.info("Received a new event: " + productCreatedEvent.getTitle());
	}
	
}
