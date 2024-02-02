package com.example.checkoutservice.service.implementation;

import com.example.checkoutservice.model.DTO.Product;
import com.example.checkoutservice.repository.FeignProductsRepository;
import com.example.checkoutservice.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private FeignProductsRepository feignRepository;
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductsRepository feignRepository) {
        this.feignRepository = feignRepository;
    }

    @Override
    @CircuitBreaker(name="product", fallbackMethod="getProductFallBackMethod")
    @Retry(name="product")
    public Product getProduct(String id) {
        logger.info("Obteniendo producto con id "+ id);
        return feignRepository.getProductsById(id, true);
    }

    public Product getProductFallBackMethod(String id, CallNotPermittedException exception){
        logger.error("Circuit breaker open");
        Product product = new Product();
        product.setPrice(0.0);
        return product;
    }
}
