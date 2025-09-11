package org.sayscampus.post.repository.jpa;

import org.sayscampus.post.repository.entity.like.LikeEntity;
import org.sayscampus.post.repository.entity.like.LikeIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLikeRepository extends JpaRepository<LikeEntity, LikeIdEntity> {
}
