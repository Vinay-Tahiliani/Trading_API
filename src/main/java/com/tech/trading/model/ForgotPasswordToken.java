package com.tech.trading.model;

import com.tech.trading.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Data
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    @OneToOne
    private User user;
    private String otp;
    private VerificationType verificationType;
    private String sendTo;

}
