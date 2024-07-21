package com.tech.trading.service;

import com.tech.trading.config.JwtProvider;
import com.tech.trading.domain.VerificationType;
import com.tech.trading.model.TwoFactorAuth;
import com.tech.trading.model.User;
import com.tech.trading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByEmail(String email) throws Exception {
        //String email=JwtProvider.getEmailFromToken(jwt);
        User user=userRepository.findByEmail(email);
        if (user==null){
            throw new Exception("user not found");
        }

        return user;

    }

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email=JwtProvider.getEmailFromToken(jwt);
        User user=userRepository.findByEmail(email);
        if (user==null){
            throw new Exception("user not found");
        }

        return user;
    }

    @Override
    public User findByUserById(Long Id) throws Exception {
        Optional<User> user =userRepository.findById(Id);
        if (user.isEmpty()){
            throw new Exception("user not found");

        }
        return user.get();
    }

    @Override
    public User enableTwofactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        TwoFactorAuth twoFactorAuth=new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);
        user.setTwoFactorAuth(twoFactorAuth);
        return userRepository.save(user);
    }



    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
}
