package com.springkafka.ws.product.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.springkafka.core.ProductCreatedEvent;
import com.springkafka.ws.product.rest.CreateProductRestModel;

@Service
public class ProductServiceImpl implements ProductService {

	KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public String createProduct(CreateProductRestModel product) throws Exception {
		// TODO Auto-generated method stub
		String productId = UUID.randomUUID().toString();
		LOGGER.info("*** Before publishing a productcreatedevent ****");
		// persists product in to database table before publising to event;
		ProductCreatedEvent prEvnt = new ProductCreatedEvent(productId, product.getTitle(), product.getPrice(),
				product.getQty());
		
		ProducerRecord<String, ProductCreatedEvent> recordRes = new ProducerRecord<>("product-created-events-topic", productId, prEvnt);
		
		
//		CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", productId, prEvnt);
//		future.whenComplete((res, exc)->{
//			if(exc != null) {
//				logger.error("Failed to send message"+exc.getMessage());
//			}else {
//				logger.info("Message send successfully"+res.getRecordMetadata());
//			}
//		});
//		
//		// ths method will block currect thread to wait for result
//		// it is basically synchronous 
//		// If we remove the it will be asynchrously
//		// future.join();
		recordRes.headers().add("messageId", UUID.randomUUID().toString().getBytes());
		SendResult<String, ProductCreatedEvent> result = kafkaTemplate.send(recordRes).get();
		
		LOGGER.info("Partition"+result.getRecordMetadata());
		LOGGER.info("Topic"+result.getRecordMetadata().topic());
		LOGGER.info("Topic"+result.getRecordMetadata().offset());
		LOGGER.info("*** Returning ProductId ****");

		return productId;
	}

}
