package org.sayscampus.user.application.interfaces;

import java.util.Optional;

import org.sayscampus.user.domain.User;

public interface UserRepository {

	User save(User user);
	Optional<User> findById(Long id);
}
