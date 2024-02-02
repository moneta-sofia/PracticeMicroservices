package com.example.productservice.controller;

import com.example.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public Product getProduct(@RequestParam String id, @RequestParam(defaultValue = "false") Boolean throwError)
    {
        if (throwError){
            throw new RuntimeException();
        }
        return new Product(id, "notebook", 2000.00, "i2");
    }
}
