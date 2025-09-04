package org.sayscampus.user.repository;

import org.sayscampus.user.application.interfaces.UserRepository;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.repository.entity.UserEntity;
import org.sayscampus.user.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final JpaUserRepository jpaUserRepository;

	@Override
	public User save(User user) {
		UserEntity entity = new UserEntity(user);
		entity = jpaUserRepository.save(entity);
		return entity.toUser();
	}

	@Override
	public User findById(Long id) {
		UserEntity entity = jpaUserRepository
			.findById(id)
			.orElseThrow(IllegalArgumentException::new);
		return entity.toUser();
	}
}
