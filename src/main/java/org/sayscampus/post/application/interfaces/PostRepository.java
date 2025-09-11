package org.sayscampus.post.application.interfaces;

import org.sayscampus.post.domain.Post;

public interface PostRepository {

	Post save(Post post);
	Post findById(Long id);
}
