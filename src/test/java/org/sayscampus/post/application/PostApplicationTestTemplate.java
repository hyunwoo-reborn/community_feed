package org.sayscampus.post.application;

import org.sayscampus.fake.FakeObjectFactory;
import org.sayscampus.post.application.dto.CreateCommentRequestDto;
import org.sayscampus.post.application.dto.CreatePostRequestDto;
import org.sayscampus.post.domain.Post;
import org.sayscampus.post.domain.content.PostPublicationState;
import org.sayscampus.user.application.UserService;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.domain.User;

public class PostApplicationTestTemplate {

	final UserService userService = FakeObjectFactory.getUserService();
	final PostService postService = FakeObjectFactory.postService();
	final CommentService commentService = FakeObjectFactory.commentService();

	final User user = userService.createUser(new CreateUserRequestDto("user1", null));
	final User otherUser = userService.createUser(new CreateUserRequestDto("user1", null));

	CreatePostRequestDto postRequestDto = new CreatePostRequestDto(user.getId(), "this is test content",
		PostPublicationState.PUBLIC);
	final Post post = postService.createPost(postRequestDto);

	final String commentContentText = "this is test comment";
	CreateCommentRequestDto commentRequestDto = new CreateCommentRequestDto(user.getId(), post.getId(),
		"this is test comment");
}
