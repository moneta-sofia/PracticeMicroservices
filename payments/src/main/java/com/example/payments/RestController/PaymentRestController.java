package com.example.payments.RestController;

import com.example.payments.model.Payment;
import com.example.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payments")
@RestController
public class PaymentRestController {
    Logger logger = LoggerFactory.getLogger(PaymentRestController.class);
    private PaymentService paymentService;

    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public void createPayment(@RequestBody Payment payment){
        paymentService.crearPayment(payment);
    }

    @GetMapping()
    public Payment getPayment(String id){
        logger.info("Intentando obtener payment con id" + id);
        return new Payment(id,10.0f,"asd", "asd1");
    }
}
