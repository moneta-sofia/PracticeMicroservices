package com.example.checkoutservice.repository;

import com.example.checkoutservice.configuration.LoadBalancerConfiguration;
import com.example.checkoutservice.model.DTO.Product;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product-service")
//@LoadBalancerClient(value = "product-service", configuration = LoadBalancerConfiguration.class)
public interface FeignProductsRepository {
    @RequestMapping(method= RequestMethod.GET, value="/products")
    Product getProductsById(@RequestParam  String id);

}
