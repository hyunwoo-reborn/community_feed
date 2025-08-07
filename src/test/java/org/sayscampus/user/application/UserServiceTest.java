package org.sayscampus.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.application.interfaces.UserRepository;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.domain.UserInfo;
import org.sayscampus.user.repository.FakeUserRepository;

class UserServiceTest {

	private final UserRepository userRepository = new FakeUserRepository();
	private final UserService userService = new UserService(userRepository);

	@Test
	void givenUserInfoDto_whenCreateUser_thenCanFindUser() {
		// Given
		CreateUserRequestDto dto = new CreateUserRequestDto("test", "");

		// When
		User savedUser = userService.createUser(dto);

		// Then
		User foundUser = userService.getUser(savedUser.getId());
		UserInfo userInfo = savedUser.getInfo();

		assertEquals(foundUser.getId(), savedUser.getId());
		assertEquals("test", userInfo.getName());
	}

}