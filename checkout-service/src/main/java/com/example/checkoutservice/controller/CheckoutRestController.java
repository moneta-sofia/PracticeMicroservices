package com.example.checkoutservice.controller;

import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.service.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id) {
        return new Checkout(id);
    }

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productsIds, @RequestHeader("X-Request-from")String reqFrom, @RequestHeader() Map<String, String> headers) {
        System.out.println("Request from: " + reqFrom);
        if(!reqFrom.equals("gateway")) {
            return null;
        }
        return checkoutService.buildCheckout(productsIds);
    }
}
