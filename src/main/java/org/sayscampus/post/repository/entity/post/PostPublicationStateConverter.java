package org.sayscampus.post.repository.entity.post;

import org.sayscampus.post.domain.content.PostPublicationState;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PostPublicationStateConverter implements AttributeConverter<PostPublicationState, String> {

	@Override
	public String convertToDatabaseColumn(PostPublicationState attribute) {
		return attribute.name();
	}

	@Override
	public PostPublicationState convertToEntityAttribute(String s) {
		return PostPublicationState.valueOf(s);
	}
}