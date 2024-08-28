package com.piyushpriyadarshi.uberApp.dto;

import com.piyushpriyadarshi.uberApp.entities.enums.TransactionMethod;
import com.piyushpriyadarshi.uberApp.entities.enums.TransactionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WalletTransactionDto {

    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;

    private String transactionId;

    private WalletDto wallet;

    private LocalDateTime timeStamp;
}
