package org.sayscampus.user.domain;

public class UserInfo {

	private final String name;
	private final String profileImageUrl;

	public UserInfo(String name, String profileImageUrl) {

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or empty");
		}
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}
}
