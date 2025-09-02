package org.sayscampus.post.application.dto;

import org.sayscampus.post.domain.content.PostPublicationState;

public record CreatePostRequestDto(Long userId, String content, PostPublicationState state) {
}
