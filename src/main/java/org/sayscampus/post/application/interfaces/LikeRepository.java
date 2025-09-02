package org.sayscampus.post.application.interfaces;

import org.sayscampus.post.domain.Post;
import org.sayscampus.post.domain.comment.Comment;
import org.sayscampus.user.domain.User;

public interface LikeRepository {
	boolean checkLike(Post post, User user);
	void like(Post post, User user);
	void unlike(Post post, User user);
	boolean checkLike(Comment comment, User user);
	void like(Comment comment, User user);
	void unlike(Comment comment, User user);
}
