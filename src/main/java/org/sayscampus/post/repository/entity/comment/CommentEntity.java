package org.sayscampus.post.repository.entity.comment;

import org.sayscampus.common.domain.PositiveIntegerCounter;
import org.sayscampus.common.repository.entity.TimeBaseEntity;
import org.sayscampus.post.domain.comment.Comment;
import org.sayscampus.post.domain.content.CommentContent;
import org.sayscampus.post.repository.entity.post.PostEntity;
import org.sayscampus.user.repository.entity.UserEntity;

import jakarta.persistence.ConstraintMode;
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
@Table(name="community_commnent")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentEntity extends TimeBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="authorId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private UserEntity author;

	@ManyToOne
	@JoinColumn(name="postId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private PostEntity post;

	private String content;
	private Integer likeCounter;

	public CommentEntity(Comment comment) {
		this.id = comment.getId();
		this.author = new UserEntity(comment.getAuthor());
		this.post = new PostEntity(comment.getPost());
		this.content = comment.getContent();
		this.likeCounter = comment.getLikeCount();
	}

	public Comment toComment() {
		return Comment.builder()
			.id(id)
			.author(author.toUser())
			.post(post.toPost())
			.content(new CommentContent(content))
			.likeCount(new PositiveIntegerCounter(likeCounter))
			.build();
	}
}