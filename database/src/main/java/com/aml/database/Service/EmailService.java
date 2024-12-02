package com.aml.database.Service;

public interface EmailService {
    void sendVerificationEmail(String to, String token);
}

