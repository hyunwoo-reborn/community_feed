package org.sayscampus.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sayscampus.fake.FakeObjectFactory;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.domain.UserInfo;

class UserServiceTest {

	private final UserService userService = FakeObjectFactory.getUserService();

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