package com.piyushpriyadarshi.uberApp.strategies;

import com.piyushpriyadarshi.uberApp.entities.enums.PaymentMethod;
import com.piyushpriyadarshi.uberApp.strategies.impl.CashPaymentStrategy;
import com.piyushpriyadarshi.uberApp.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;


    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){

        if(paymentMethod.equals(PaymentMethod.CASH)){
            return cashPaymentStrategy;
        }else{
            return walletPaymentStrategy;
        }
    }

}
