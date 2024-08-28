package com.piyushpriyadarshi.uberApp.strategies.impl;

import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.Payment;
import com.piyushpriyadarshi.uberApp.entities.enums.PaymentStatus;
import com.piyushpriyadarshi.uberApp.entities.enums.TransactionMethod;
import com.piyushpriyadarshi.uberApp.repositories.PaymentRepository;
import com.piyushpriyadarshi.uberApp.services.PaymentService;
import com.piyushpriyadarshi.uberApp.services.WalletService;
import com.piyushpriyadarshi.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platFormCommission = payment.getAmount()*PLATFORM_COMMISSION;
        walletService.deductMoneyFromWallet(driver.getUser(),platFormCommission,null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
