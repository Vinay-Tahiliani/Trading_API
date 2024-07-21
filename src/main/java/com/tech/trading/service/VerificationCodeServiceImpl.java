package com.tech.trading.service;

import com.tech.trading.domain.VerificationType;
import com.tech.trading.model.User;
import com.tech.trading.model.VerificationCode;
import com.tech.trading.repository.VerificationCodeRepository;
import com.tech.trading.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
        VerificationCode verificationCode1=new VerificationCode();
        verificationCode1.setOtp(OtpUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);
        return verificationCodeRepository.save(verificationCode1);
    }

    @Override
    public VerificationCode getVerificationCodeById(Long Id) throws Exception {
        Optional<VerificationCode> verificationCode=verificationCodeRepository.findById(Id);
        if (verificationCode.isPresent()){
            return verificationCode.get();
        }
        throw new Exception("verification code not found");


    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCode(VerificationCode verificationCode) {
        verificationCodeRepository.delete(verificationCode);

    }
}
