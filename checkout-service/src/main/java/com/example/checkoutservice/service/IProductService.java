package com.example.checkoutservice.service;

import com.example.checkoutservice.model.DTO.Product;

public interface IProductService {
    public Product getProduct(String id);
}
