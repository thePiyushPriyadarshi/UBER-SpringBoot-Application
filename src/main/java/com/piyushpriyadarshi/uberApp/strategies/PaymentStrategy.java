package com.piyushpriyadarshi.uberApp.strategies;

import com.piyushpriyadarshi.uberApp.entities.Payment;

public interface PaymentStrategy {

    static final double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
