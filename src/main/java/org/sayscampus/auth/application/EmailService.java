package org.sayscampus.auth.application;

import lombok.RequiredArgsConstructor;
import org.sayscampus.auth.application.dto.SendEmailRequestDto;
import org.sayscampus.auth.application.interfaces.EmailSendRepository;
import org.sayscampus.auth.application.interfaces.EmailVerificationRepository;
import org.sayscampus.auth.domain.Email;
import org.sayscampus.auth.domain.RandomTokenGenerator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailSendRepository emailSendRepository;
    private final EmailVerificationRepository emailVerificationRepository;

    public void sendEmail(SendEmailRequestDto dto) {
        Email email = Email.createEmail(dto.email());
        String token = RandomTokenGenerator.generateToken();

        emailSendRepository.sendEmail(email, token);
        emailVerificationRepository.createEmailVerification(email, token);

    }

}
