package com.appsdeveloperblog.ws.emailnotification.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.ws.core.ProductCreatedEvent;

@Component
@KafkaListener(topics="product-created-events-topic")
public class ProductCreatedEventHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@KafkaHandler
	public void handle(ProductCreatedEvent productCreatedEvent) {
		LOGGER.info("Received a new event: " + productCreatedEvent.getTitle());
	}
	
}
