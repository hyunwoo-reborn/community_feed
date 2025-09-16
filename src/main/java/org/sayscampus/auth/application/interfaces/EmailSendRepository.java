package org.sayscampus.auth.application.interfaces;

import org.sayscampus.auth.domain.Email;

public interface EmailSendRepository {
    void sendEmail(Email email, String randomToken);
}
