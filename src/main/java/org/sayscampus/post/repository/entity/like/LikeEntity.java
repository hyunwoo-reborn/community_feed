package org.sayscampus.post.repository.entity.like;

import org.sayscampus.common.repository.entity.TimeBaseEntity;
import org.sayscampus.post.domain.Post;
import org.sayscampus.post.domain.comment.Comment;
import org.sayscampus.user.domain.User;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="community_like")
@NoArgsConstructor
@Getter
public class LikeEntity extends TimeBaseEntity {

	@EmbeddedId
	private LikeIdEntity id;

	public LikeEntity(Post post, User likeedUser) {
		this.id = new LikeIdEntity(post.getId(), likeedUser.getId(), LikeTarget.POST.name());
	}

	public LikeEntity(Comment comment, User likeedUser) {
		this.id = new LikeIdEntity(comment.getId(), likeedUser.getId(), LikeTarget.COMMENT.name());
	}
}