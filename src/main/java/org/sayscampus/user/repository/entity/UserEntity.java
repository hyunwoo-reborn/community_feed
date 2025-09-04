package org.sayscampus.user.repository.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.sayscampus.common.domain.PositiveIntegerCounter;
import org.sayscampus.common.repository.entity.TimeBaseEntity;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.domain.UserInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="community_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@DynamicUpdate
public class UserEntity extends TimeBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String profileImage;
	private Integer followerCount;
	private Integer followingCount;

	public UserEntity(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.profileImage = user.getProfileImage();
		this.followerCount = user.followerCount();
		this.followingCount = user.followingCount();
	}

	public User toUser() {
		return User.builder()
			.id(id)
			.info(new UserInfo(name, profileImage))
			.followerCounter(new PositiveIntegerCounter(followerCount))
			.followingCount(new PositiveIntegerCounter(followingCount))
			.build();
	}
}
