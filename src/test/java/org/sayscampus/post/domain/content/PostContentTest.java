package org.sayscampus.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PostContentTest {
	@Test
	void givenContentLengthIsOk_whenCreated_ThenReturnTextContent() {
		// given
		String text = "this is a test";

		PostContent content = new PostContent(text);

		// when, then
		assertEquals(text, content.getContentText());
	}

	@Test
	void givenContentLengthIsOver_whenCreated_thenThrowError() {
		// given
		String content = "a".repeat(501);

		// when, then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
	}

	@ParameterizedTest
	@ValueSource(strings = "뷁, 닭, 긁, 삵, 슢")
	void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {
		// given
		String content = koreanWord.repeat(501);

		// when, then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
	}

	@Test
	void givenContentLengthIsUnder_whenCreated_thenThrowError() {
		// given
		String content = "a".repeat(4);

		// when, then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void givenContentIsEmpty_whenCreated_thenThrowError(String content) {
		// when, then
		assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
	}

	@Test
	void givenContentLengthIsOk_whenUpdated_ThenReturnUpdatedTextContent() {
		// given
		String content = "this is a test content";
		PostContent postContent = new PostContent(content);

		// when
		String updatedContent = "this is updated content";
		postContent.updateContent(updatedContent);

		// then
		assertEquals(updatedContent, postContent.getContentText());
	}

	@Test
	void givenContentLengthIsOver_whenUpdated_thenThrowError() {
		// given
		String content = "this is a test content";
		PostContent postContent = new PostContent(content);

		// when, then
		String value = "a".repeat(501);
		assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
	}

	@ParameterizedTest
	@ValueSource(strings = "뷁, 닭, 긁, 삵, 슢")
	void givenContentLengthIsOverAndKorean_whenUpdated_thenThrowError(String koreanWord) {
		// given
		String content = "this is a test content";
		PostContent postContent = new PostContent(content);

		// when, then
		String value = koreanWord.repeat(501);
		assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
	}

	@Test
	void givenContentLengthIsUnder_whenUpdated_thenThrowError() {
		// given
		String content = "this is a test content";
		PostContent postContent = new PostContent(content);

		// when, then
		String value = "a".repeat(4);
		assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
	}

}