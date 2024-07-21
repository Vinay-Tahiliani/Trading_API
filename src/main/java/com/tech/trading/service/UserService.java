package com.tech.trading.service;

import com.tech.trading.domain.VerificationType;
import com.tech.trading.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService {
    public User findUserByEmail(String email) throws Exception;
    public User findUserProfileByJwt(String jwt) throws Exception;


    User findByUserById(Long Id) throws Exception;

    public User enableTwofactorAuthentication(VerificationType verificationType,String sendTo,User user);
    User updatePassword(User user, String newPassword);
}

