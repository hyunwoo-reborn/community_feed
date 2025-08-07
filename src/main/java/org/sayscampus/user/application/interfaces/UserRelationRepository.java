package org.sayscampus.user.application.interfaces;

import org.sayscampus.user.domain.User;

public interface UserRelationRepository {

	boolean isAlreadyFollow(User user, User targetUser);
	void save(User user, User targetUser);
	void delete(User user, User targetUser);
}
