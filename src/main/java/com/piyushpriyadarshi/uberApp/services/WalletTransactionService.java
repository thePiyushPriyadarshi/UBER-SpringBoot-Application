package com.piyushpriyadarshi.uberApp.services;

import com.piyushpriyadarshi.uberApp.dto.WalletTransactionDto;
import com.piyushpriyadarshi.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);

}
