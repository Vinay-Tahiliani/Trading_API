package com.tech.trading.service;

import com.tech.trading.model.Order;
import com.tech.trading.model.User;
import com.tech.trading.model.Wallet;

public interface WalletService {
    Wallet getUser(User user);
    Wallet addBalance(Wallet wallet,Long amount);
    Wallet findById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender,Wallet recieverWallet,Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;
}
