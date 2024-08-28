package com.piyushpriyadarshi.uberApp.strategies.impl;

import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.Payment;
import com.piyushpriyadarshi.uberApp.entities.Rider;
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
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),payment.getAmount(),null, payment.getRide(), TransactionMethod.RIDE);

        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);
        walletService.addMoneyToWallet(driver.getUser(),driverCut,
                null,payment.getRide(),TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }

}
