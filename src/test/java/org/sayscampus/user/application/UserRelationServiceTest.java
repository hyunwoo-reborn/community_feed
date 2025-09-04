package org.sayscampus.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sayscampus.fake.FakeObjectFactory;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.application.dto.FollowUserRequestDto;
import org.sayscampus.user.domain.User;

class UserRelationServiceTest {

	private final UserService userService = FakeObjectFactory.getUserService();
	private final UserRelationService userRelationService = FakeObjectFactory.userRelationService();

	private User user1;
	private User user2;

	private FollowUserRequestDto requestDto;
	@BeforeEach
	void init() {
		CreateUserRequestDto dto = new CreateUserRequestDto("test", "");
		user1 = userService.createUser(dto);
		user2 = userService.createUser(dto);

		this.requestDto = new FollowUserRequestDto(user1.getId(), user2.getId());
	}

	@Test
	void givenCreateTwoUser_whenFollow_thenUserFollowSaved() {
		// When
		userRelationService.follow(requestDto);

		// Then
		assertEquals(1, user1.followingCount());
		assertEquals(1, user2.followerCount());
	}

	@Test
	void givenCreateTwoUserFollowed_whenFollow_thenUserThrowError() {
		// Given
		userRelationService.follow(requestDto);

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(requestDto));
	}

	@Test
	void givenCreateOneUser_whenFollow_thenUserThrowError() {
		// Given
		FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(sameUser));
	}

	@Test
	void givenCreateTwoUserFollow_whenUnFollow_thenUserUnFollowSaved() {
		// Given
		userRelationService.follow(requestDto);

		// When
		userRelationService.unfollow(requestDto);

		// Then
		assertEquals(0, user1.followingCount());
		assertEquals(0, user2.followerCount());
	}

	@Test
	void givenCreateTwoUser_whenUnFollow_thenUserThrowError() {
		// When & Then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(requestDto));
	}

	@Test
	void givenCreateOneUser_whenUnFollowSelf_thenUserThrowError() {
		// Given
		FollowUserRequestDto requestDto = new FollowUserRequestDto(user1.getId(), user1.getId());

		// When & Then
		assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(requestDto));
		}
}