package com.springkafka.ws.product.rest;

import java.math.BigDecimal;

public class CreateProductRestModel {
	private String title;
	private BigDecimal price;
	private int qty;
	
	public CreateProductRestModel(String title, BigDecimal price, int qty) {
		super();
		this.title = title;
		this.price = price;
		this.qty = qty;
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
