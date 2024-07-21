package com.tech.trading.repository;

import com.tech.trading.model.ForgotPasswordToken;
import com.tech.trading.service.ForgotPasswordService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken,String> {
    ForgotPasswordToken findByUserId(Long userId);
}
