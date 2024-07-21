package com.tech.trading.service;

import com.tech.trading.domain.VerificationType;
import com.tech.trading.model.ForgotPasswordToken;
import com.tech.trading.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType,String sendTo);
    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);
    void deleteToken(ForgotPasswordToken token);
}
