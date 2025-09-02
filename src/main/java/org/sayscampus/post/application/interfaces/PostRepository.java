package org.sayscampus.post.application.interfaces;

import java.util.Optional;

import org.sayscampus.post.domain.Post;

public interface PostRepository {

	Post save(Post post);
	Optional<Post> findById(Long id);
}
