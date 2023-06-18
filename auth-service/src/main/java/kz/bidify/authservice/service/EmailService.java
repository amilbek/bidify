package kz.bidify.authservice.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendVerifyEmail(String id);
}
