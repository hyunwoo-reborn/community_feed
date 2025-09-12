package org.sayscampus.post.repository.post_queue;

import org.sayscampus.post.repository.entity.post.PostEntity;

import java.util.List;

public interface UserQueueRedisRepository {
    void publishPostToFollowingList(PostEntity postEntity, List<Long> userIdList);
    void publishPostListToFollowerUser(List<PostEntity> postEntities, Long userId);
    void deleteDeleteFeed(Long userId, Long authorId);
}
