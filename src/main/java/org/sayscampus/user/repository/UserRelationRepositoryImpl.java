package org.sayscampus.user.repository;

import java.util.List;

import org.sayscampus.user.application.interfaces.UserRelationRepository;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.repository.entity.UserEntity;
import org.sayscampus.user.repository.entity.UserRelationEntity;
import org.sayscampus.user.repository.entity.UserRelationIdEntity;
import org.sayscampus.user.repository.jpa.JpaUserRelationRepository;
import org.sayscampus.user.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRelationRepositoryImpl implements UserRelationRepository {
	private final JpaUserRepository jpaUserRepository;
	private final JpaUserRelationRepository jpaUserRelationRepository;

	@Override
	public boolean isAlreadyFollow(User user, User targetUser) {
		UserRelationIdEntity id = new UserRelationIdEntity(user.getId(), targetUser.getId());
		return jpaUserRelationRepository.existsById(id);
	}

	@Override
	@Transactional
	public void save(User user, User targetUser) {
		UserRelationEntity entity = new UserRelationEntity(user.getId(), targetUser.getId());
		jpaUserRelationRepository.save(entity);
		jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));
	}

	@Override
	@Transactional
	public void delete(User user, User targetUser) {
		UserRelationIdEntity id = new UserRelationIdEntity(user.getId(), targetUser.getId());
		jpaUserRelationRepository.deleteById(id);
		jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));
	}
}