package org.sayscampus.post.repository.post_queue;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sayscampus.post.repository.entity.post.PostEntity;
import org.sayscampus.post.repository.entity.post.UserPostQueueEntity;
import org.sayscampus.post.repository.jpa.JpaPostRepository;
import org.sayscampus.post.repository.jpa.JpaUserPostQueueRepository;
import org.sayscampus.user.repository.entity.UserEntity;
import org.sayscampus.user.repository.jpa.JpaUserRelationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final UserQueueRedisRepository redisRepository;

    @Override
    @Transactional
    public void publishPost(PostEntity postEntity) {
        UserEntity userEntity = postEntity.getAuthor();
        List<Long> followersIds = jpaUserRelationRepository.findFollowers(userEntity.getId());
        redisRepository.publishPostToFollowingList(postEntity, followersIds);
    }

    @Override
    @Transactional
    public void saveFollowPost(Long userId, Long targetId) {
        List<PostEntity> postEntities = jpaPostRepository.findAllPostIdsByAuthorId(targetId);
        redisRepository.publishPostListToFollowerUser(postEntities, userId);
    }

    @Override
    @Transactional
    public void deleteUnfollowPost(Long userId, Long targetId) {
        redisRepository.deleteDeleteFeed(userId, targetId);
    }
}
