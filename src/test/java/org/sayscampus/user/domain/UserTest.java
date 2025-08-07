package org.sayscampus.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private final UserInfo userInfo = new UserInfo("John Doe", "");
	private User user1;
	private User user2;

	@BeforeEach
	void init() {
		user1 = new User(1L, userInfo);
		user2 = new User(2L, userInfo);
	}

	@Test
	void givenTwoUsers_whenEqual_thenReturnFalse() {
		// When
		boolean value = user1.equals(user2);

		// Then
		assertFalse(value);
	}

	@Test
	void givenTwoSameIdUser_whenEqual_thenReturnTrue() {
		// Given
		User sameUser = new User(1L, userInfo);

		// When
		boolean isSame = user1.equals(sameUser);

		// Then
		assertTrue(isSame);
	}

	@Test
	void givenTwoUser_whenHashCode_thenNotEqual() {
		// When
		int hash1 = user1.hashCode();
		int hash2 = user2.hashCode();

		// Then
		assertNotEquals(hash1, hash2);
	}

	@Test
	void givenTwoUser_whenHashCode_thenEqual() {
		// Given
		User sameUser = new User(1L, userInfo);

		// When
		int hash1 = user1.hashCode();
		int sameUserHash = sameUser.hashCode();

		// Then
		assertEquals(hash1, sameUserHash);
	}

	@Test
	void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
		// When
		user1.follow(user2);

		// Then
		assertEquals(1, user1.followingCount());
		assertEquals(0, user1.followerCount());
		assertEquals(0, user2.followingCount());
		assertEquals(1, user2.followerCount());
	}

	@Test
	void givenTwoUserUser1FollowUser2_whenUnfollow_thenDecreaseUserCount() {
		// Given
		user1.follow(user2);

		// When
		user1.unfollow(user2);

		// Then
		assertEquals(0, user1.followingCount());
		assertEquals(0, user1.followerCount());
		assertEquals(0, user2.followingCount());
		assertEquals(0, user2.followerCount());
	}

	@Test
	void givenTwoUser_whenUnfollow_thenDecreaseUserCount() {
		// When
		user1.unfollow(user2);

		// Then
		assertEquals(0, user1.followingCount());
		assertEquals(0, user1.followerCount());
		assertEquals(0, user2.followingCount());
		assertEquals(0, user2.followerCount());
	}
}