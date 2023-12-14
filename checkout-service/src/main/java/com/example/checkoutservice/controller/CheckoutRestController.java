package com.example.checkoutservice.controller;

import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.service.ICheckoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productsIds) {
        return checkoutService.buildCheckout(productsIds);
    }
}
