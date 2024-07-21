package com.tech.trading.service;

import com.tech.trading.domain.VerificationType;
import com.tech.trading.model.User;
import com.tech.trading.model.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long Id) throws Exception;
    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCode(VerificationCode verificationCode);

}
