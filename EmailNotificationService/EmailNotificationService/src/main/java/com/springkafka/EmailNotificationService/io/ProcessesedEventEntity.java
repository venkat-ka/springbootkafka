package com.springkafka.EmailNotificationService.io;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="processed-event")
public class ProcessesedEventEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8890907921221755649L;
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, unique=true)
	private String messageId;
	
	@Column(nullable=false)
	private String productId;

	
	
	
	public ProcessesedEventEntity() {
		
	}

	public ProcessesedEventEntity(String messageId, String productId) {
		super();
		this.messageId = messageId;
		this.productId = productId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	

}
