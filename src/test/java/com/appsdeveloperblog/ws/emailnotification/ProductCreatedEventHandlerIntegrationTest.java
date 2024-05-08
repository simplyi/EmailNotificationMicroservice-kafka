package com.appsdeveloperblog.ws.emailnotification;

import java.math.BigDecimal;
import java.util.UUID;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.test.context.EmbeddedKafka;

import com.appsdeveloperblog.ws.core.ProductCreatedEvent;

@EmbeddedKafka
@SpringBootTest(properties="spring.kafka.consumer.bootstrap-servers=${spring.embedded.kafka.brokers}")
public class ProductCreatedEventHandlerIntegrationTest {
	
	@Test
	public void testProductCreatedEventHandler_OnProductCreated_HandlesEvent() {
		
		// Arrange 
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		productCreatedEvent.setPrice(new BigDecimal(10));
		productCreatedEvent.setProductId(UUID.randomUUID().toString());
		productCreatedEvent.setQuantity(1);
		productCreatedEvent.setTitle("Test product");
		
		String messageId = UUID.randomUUID().toString();
		String messageKey = productCreatedEvent.getProductId();
		
		ProducerRecord<String, ProductCreatedEvent> record = new ProducerRecord<>(
				"product-created-events-topic",
				messageKey,
				productCreatedEvent);
		
		record.headers().add("messageId", messageId.getBytes());
		record.headers().add(KafkaHeaders.RECEIVED_KEY, messageKey.getBytes());
		
		// Act 
		
		// Assert
		
	}

}
