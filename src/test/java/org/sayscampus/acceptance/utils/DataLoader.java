package org.sayscampus.acceptance.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.application.dto.FollowUserRequestDto;
import org.springframework.stereotype.Component;

import static org.sayscampus.acceptance.steps.UserAcceptanceSteps.createUser;
import static org.sayscampus.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    public void loadData() {
        // user 1, 2, 3 생성 및 user 1 follow user 2, user 3
        CreateUserRequestDto user = new CreateUserRequestDto("test user", "");
        createUser(user);
        createUser(user);
        createUser(user);

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }

    public String getEmailToken(String email) {
        return entityManager.createNativeQuery("SELECT token FROM community_email_verification WHERE email = ?", String.class)
                .setParameter(1, email)
                .getSingleResult()
                .toString();
    }
}