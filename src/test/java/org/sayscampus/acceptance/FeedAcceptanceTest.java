package org.sayscampus.acceptance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sayscampus.acceptance.utils.AcceptanceTestTemplate;
import org.sayscampus.post.application.dto.CreatePostRequestDto;
import org.sayscampus.post.domain.content.PostPublicationState;
import org.sayscampus.post.ui.dto.GetPostContentResponseDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.sayscampus.acceptance.steps.FeedAcceptanceSteps.requestCreatePost;
import static org.sayscampus.acceptance.steps.FeedAcceptanceSteps.requestFeedList;

class FeedAcceptanceTest extends AcceptanceTestTemplate {

    /**
     * User 1 --- follow ---> User 2
     * User 1 --- follow ---> User 3
     */
    @BeforeEach
    void setUp() {
        super.init();
    }

    /**
     * User 2 create Post 1
     * User 1 Get Post 1 From Feed
     */
    @Test
    void givenUserHasFollowerAndCreatePost_whenFollowingUserRequestFeed_thenFollowerCanGetPostFromFeed() {
        // given
        CreatePostRequestDto dto = new CreatePostRequestDto(2L, "user 1 can get this post", PostPublicationState.PUBLIC);
        Long createdPostId = requestCreatePost(dto);

        // when, 팔로워의 피드 요청
        List<GetPostContentResponseDto> result = requestFeedList(1L);

        // then
        assertEquals(1, result.size());
        assertEquals(createdPostId, result.getFirst().getId());
    }
}
