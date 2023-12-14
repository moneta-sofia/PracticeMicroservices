package com.example.checkoutservice.service.implementation;

import com.example.checkoutservice.model.DTO.Product;
import com.example.checkoutservice.repository.FeignProductsRepository;
import com.example.checkoutservice.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private FeignProductsRepository feignRepository;

    public ProductService(FeignProductsRepository feignRepository) {
        this.feignRepository = feignRepository;
    }

    @Override
    public Product getProduct(String id) {
        return feignRepository.getProductsById(id);
    }
}
