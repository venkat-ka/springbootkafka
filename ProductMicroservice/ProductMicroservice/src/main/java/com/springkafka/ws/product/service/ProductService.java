package com.springkafka.ws.product.service;

import com.springkafka.ws.product.rest.CreateProductRestModel;

public interface ProductService {
 String createProduct(CreateProductRestModel product)throws Exception;
}
