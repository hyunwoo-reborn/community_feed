package org.sayscampus.user.repository.jpa;

import java.util.List;

import org.sayscampus.user.repository.entity.UserRelationEntity;
import org.sayscampus.user.repository.entity.UserRelationIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {

	@Query("SELECT u.followingUserId FROM UserRelationEntity u WHERE u.followerUserId = :userId")
	List<Long> findFollowers(Long userId);
}