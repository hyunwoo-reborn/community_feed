package org.sayscampus.post.application.interfaces;

import org.sayscampus.post.domain.comment.Comment;

public interface CommentRepository {

	Comment save(Comment comment);
	Comment findById(Long id);
}
