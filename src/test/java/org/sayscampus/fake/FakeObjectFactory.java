package org.sayscampus.fake;

import org.sayscampus.post.application.CommentService;
import org.sayscampus.post.application.PostService;
import org.sayscampus.post.application.interfaces.CommentRepository;
import org.sayscampus.post.application.interfaces.LikeRepository;
import org.sayscampus.post.application.interfaces.PostRepository;
import org.sayscampus.post.repository.FakeCommentRepository;
import org.sayscampus.post.repository.FakeLikeRepository;
import org.sayscampus.post.repository.FakePostRepository;
import org.sayscampus.user.application.UserRelationService;
import org.sayscampus.user.application.UserService;
import org.sayscampus.user.application.interfaces.UserRelationRepository;
import org.sayscampus.user.application.interfaces.UserRepository;
import org.sayscampus.user.repository.FakeUserRelationRepository;
import org.sayscampus.user.repository.FakeUserRepository;

public class FakeObjectFactory {

	private static final UserRepository fakeUserRepository = new FakeUserRepository();
	private static final UserRelationRepository fakeUserRelationRepository = new FakeUserRelationRepository();
	private static final PostRepository fakePostRepository = new FakePostRepository();
	private static final CommentRepository fakeCommentRepository = new FakeCommentRepository();
	private static final LikeRepository fakeLikeRepository = new FakeLikeRepository();

	private static final UserService userService = new UserService(fakeUserRepository);
	private static final UserRelationService userRelationService = new UserRelationService(userService, fakeUserRelationRepository);
	private static final PostService postService = new PostService(userService, fakePostRepository, fakeLikeRepository);
	private static final CommentService commentService = new CommentService(userService, postService, fakeCommentRepository, fakeLikeRepository);

	private FakeObjectFactory() {}

	public static UserService getUserService() {
		return userService;
	}

	public static UserRelationService userRelationService() {
		return userRelationService;
	}

	public static PostService postService() {
		return postService;
	}

	public static CommentService commentService() {
		return commentService;
	}
}
