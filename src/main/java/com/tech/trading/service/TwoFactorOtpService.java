package com.tech.trading.service;

import com.tech.trading.model.TwoFactorOTP;
import com.tech.trading.model.User;

public interface TwoFactorOtpService {
    TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt);
    TwoFactorOTP findByUser(Long userId);
    TwoFactorOTP findBYId(String id);
    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP,String otp);
    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
