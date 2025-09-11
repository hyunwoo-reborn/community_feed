package org.sayscampus.post.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.sayscampus.post.application.interfaces.PostRepository;
import org.sayscampus.post.domain.Post;

public class FakePostRepository  implements PostRepository {

	private final Map<Long, Post> store = new HashMap<>();

	@Override
	public Post save(Post post) {
		if (post.getId() != null) {
			store.put(post.getId(), post);
			return post;
		}
		long id = store.size() + 1L;
		Post newPost = new Post(id, post.getAuthor(), post.getContentObject());
		store.put(id, newPost);
		return newPost;
	}

	@Override
	public Post findById(Long id) {
		return store.get(id);
	}
}
