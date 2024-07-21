package com.tech.trading.model;

import com.tech.trading.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled=false;
    private VerificationType sendTo;
}
