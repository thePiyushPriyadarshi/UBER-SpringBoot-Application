package com.piyushpriyadarshi.uberApp.dto;

import com.piyushpriyadarshi.uberApp.entities.User;
import com.piyushpriyadarshi.uberApp.entities.WalletTransaction;

import java.util.List;

public class WalletDto {


    private Long id;

    private UserDto user;

    private Double balance;

    private List<WalletTransactionDto> transactions;

}
