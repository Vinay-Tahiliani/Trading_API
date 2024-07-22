package com.tech.trading.service;

import com.tech.trading.domain.OrderType;
import com.tech.trading.model.Order;
import com.tech.trading.model.User;
import com.tech.trading.model.Wallet;
import com.tech.trading.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getUser(User user) {
        Wallet wallet=walletRepository.findByUserId(user.getId());
        if (wallet==null){
            wallet=new Wallet();
            wallet.setUser(user);
        }
        return wallet;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long amount) {
        BigDecimal balance =wallet.getBalance();
        BigDecimal newBalance=balance.add(BigDecimal.valueOf(amount));
        wallet.setBalance(newBalance);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findById(Long id) throws Exception {
        Optional<Wallet> wallet=walletRepository.findById(id);
        if (wallet.isPresent()){
            return wallet.get();
        }throw new Exception("wallet not found ");

    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet recieverWallet, Long amount) throws Exception {
        Wallet sendersWallet=getUser(sender);
        if (sendersWallet.getBalance().compareTo(BigDecimal.valueOf(amount))<0){
            throw new Exception("Insuffcient balance..");
        }
        BigDecimal senderBalance=sendersWallet.getBalance().subtract(BigDecimal.valueOf(amount));
        sendersWallet.setBalance(senderBalance);
        walletRepository.save(sendersWallet);
        BigDecimal recieverBalance=recieverWallet.getBalance().add(BigDecimal.valueOf(amount));
        recieverWallet.setBalance(recieverBalance);
        walletRepository.save(recieverWallet);
        return sendersWallet;
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) throws Exception {
        Wallet wallet=getUser(user);
        if (order.getOrderType().equals(OrderType.BUY)){
            BigDecimal newBalance=wallet.getBalance().subtract(order.getPrice());
            if (newBalance.compareTo(order.getPrice())<0){
                throw new Exception("Insufficient funds for this transactions");
            }
            wallet.setBalance(newBalance);
        }
        else{
            BigDecimal newBalance=wallet.getBalance().add(order.getPrice());
            wallet.setBalance(newBalance);
        }
        walletRepository.save(wallet);
        return wallet;
    }
}
