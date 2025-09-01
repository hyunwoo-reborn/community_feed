package org.sayscampus.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CommentContentTest {

	@Test
	void givenContentLengthIsOk_whenCreatedCommentContent_thenReturnTextContent() {
		// given
		String text = "this is a test content";

		CommentContent content = new CommentContent(text);

		// when, then
		assertEquals(text, content.getContentText());
	}

	@Test
	void givenContentLengthIsOver_whenCreatedCommentContent_thenThrowError() {
		// given
		String content = "a".repeat(101);

		// when, then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
	}

	@ParameterizedTest
	@ValueSource(strings = {"뷁", "닭", "긁", "삵", "슢"})
	void givenContentLengthIsOverAndKorean_whenCreatedCommentContent_thenThrowError(String koreanContent) {
		// given
		String content = koreanContent.repeat(101);

		// when, then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void givenContentLengthIsEmptyAndNull_whenCreatedCommentContent_thenThrowError(String content) {
		// when, then
		assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
	}
}