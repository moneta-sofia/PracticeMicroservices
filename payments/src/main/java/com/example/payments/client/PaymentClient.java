package com.example.payments.client;

import com.example.payments.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {
    public Boolean createPayment(Payment payment){
        return true;
    }
}
