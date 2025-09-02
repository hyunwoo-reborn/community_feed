package org.sayscampus.post.application.dto;

import org.sayscampus.post.domain.content.PostPublicationState;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublicationState state) {
}
