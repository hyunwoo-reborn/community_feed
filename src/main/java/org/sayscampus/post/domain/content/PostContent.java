package org.sayscampus.post.domain.content;

public class PostContent extends Content {

	public static final int MIN_POST_LENGTH = 5;
	public static final int MAX_POST_LENGTH = 500;

	public PostContent(String content) {
		super(content);
	}

	@Override
	protected void checkText(String contentText) {
		if (contentText == null || contentText.isEmpty()) {
			throw new IllegalArgumentException();
		}

		if (contentText.length() > MAX_POST_LENGTH) {
			throw new IllegalArgumentException();
		}

		if (contentText.length() < MIN_POST_LENGTH) {
			throw new IllegalArgumentException();
		}

	}

}
