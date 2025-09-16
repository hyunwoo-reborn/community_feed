package org.sayscampus.auth.repository;

import org.sayscampus.auth.application.interfaces.EmailSendRepository;
import org.sayscampus.auth.domain.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSendRepositoryImpl implements EmailSendRepository {

    @Override
    public void sendEmail(Email email, String token) {

    }
}
