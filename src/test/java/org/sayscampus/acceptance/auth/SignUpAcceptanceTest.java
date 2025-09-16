package org.sayscampus.acceptance.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.sayscampus.acceptance.utils.AcceptanceTestTemplate;
import org.sayscampus.auth.application.dto.SendEmailRequestDto;

import static org.junit.jupiter.api.Assertions.*;
import static org.sayscampus.acceptance.steps.SignUpAcceptanceSteps.requestSendEmail;

class SignUpAcceptanceTest extends AcceptanceTestTemplate {

    private final String email = "email@email.com";

    @BeforeEach
    void setup() {
        this.cleanup();
    }

    @Disabled
    @Test
    void givenEmail_whenSendEmail_thenVerificationTokenSaved() {
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto(email);

        // when
        Integer code = requestSendEmail(dto);

        // then
        String token = this.getEmailToken(email);
        assertNotNull(token);
        assertEquals(0, code);
    }

    @Disabled
    @Test
    void givenInvalidEmail_whenEmailSend_thenVerificationTokenNotSaved() {
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto("sdfdf");

        // when
        Integer code = requestSendEmail(dto);

        // then
        assertEquals(400, code);
    }
}
