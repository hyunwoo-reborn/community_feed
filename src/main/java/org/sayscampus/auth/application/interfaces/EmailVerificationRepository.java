package org.sayscampus.auth.application.interfaces;

import org.sayscampus.auth.domain.Email;

public interface EmailVerificationRepository {
    void createEmailVerification(Email email, String token);
}
