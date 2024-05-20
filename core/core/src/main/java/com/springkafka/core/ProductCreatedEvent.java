package com.springkafka.core;

import java.math.BigDecimal;

public class ProductCreatedEvent {
	private String productId;
	private String title;
	private BigDecimal price;
	private int qty;
	
	
	
	public ProductCreatedEvent() {
		
	}



	public ProductCreatedEvent(String productId, String title, BigDecimal price, int qty) {
		
		this.productId = productId;
		this.title = title;
		this.price = price;
		this.qty = qty;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
