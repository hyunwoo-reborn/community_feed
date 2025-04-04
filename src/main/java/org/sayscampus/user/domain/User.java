package org.sayscampus.user.domain;

import java.util.Objects;

import org.sayscampus.common.domain.PositiveIntegerCounter;

public class User {

	private final Long id;
	private UserInfo info;
	private final PositiveIntegerCounter followingCount;
	private final PositiveIntegerCounter followerCounter;

	public User(Long id, UserInfo userInfo) {
		this.id = id;
		this.info = userInfo;
		this.followingCount = new PositiveIntegerCounter();
		this.followerCounter = new PositiveIntegerCounter();
	}

	public void follow(User targetUser) {
		if (targetUser.equals(this)) {
			throw new IllegalArgumentException();
		}

		followingCount.increase();
		targetUser.increaseFollowerCount();
	}

	public void unfollow(User targetUser) {
		if (this.equals(targetUser)) {
			throw new IllegalArgumentException();
		}

		followingCount.decrease();
		targetUser.decreaseFollowerCount();
	}

	private void increaseFollowerCount() {
		followerCounter.increase();
	}

	private void decreaseFollowerCount() {
		followerCounter.decrease();
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User)o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
