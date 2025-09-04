package org.sayscampus.post.repository.entity.post;

import org.hibernate.annotations.ColumnDefault;
import org.sayscampus.common.domain.PositiveIntegerCounter;
import org.sayscampus.common.repository.entity.TimeBaseEntity;
import org.sayscampus.post.domain.Post;
import org.sayscampus.post.domain.content.PostContent;
import org.sayscampus.post.domain.content.PostPublicationState;
import org.sayscampus.user.repository.entity.UserEntity;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="community_post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostEntity extends TimeBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private UserEntity author;

	private String content;

	@Convert(converter = PostPublicationStateConverter.class)
	private PostPublicationState state;
	private Integer likeCounter;

	@ColumnDefault("0")
	private int commentCounter;

	public PostEntity(Post post) {
		this.id = post.getId();
		this.author = new UserEntity(post.getAuthor());
		this.content = post.getContent() ;
		this.state = post.getState();
		this.likeCounter = post.getLikeCount();
	}

	public Post toPost() {
		return Post.builder()
			.id(id)
			.author(author.toUser())
			.content(new PostContent(content))
			.state(state)
			.likeCount(new PositiveIntegerCounter(likeCounter))
			.build();
	}
}
