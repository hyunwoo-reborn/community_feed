package org.sayscampus.user.repository.jpa;

import java.util.List;

import org.sayscampus.user.application.dto.GetUserListResponseDto;
import org.sayscampus.user.repository.entity.QUserEntity;
import org.sayscampus.user.repository.entity.QUserRelationEntity;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaUserListPagingQueryRepository {

	private final JPAQueryFactory jpaQueryFactory;
	private static final QUserEntity user = QUserEntity.userEntity;
	private static final QUserRelationEntity relation = QUserRelationEntity.userRelationEntity;

	public List<GetUserListResponseDto> getFollowerList(Long userId, Long lastFollowerId) {
		return jpaQueryFactory
			.select(
				Projections.fields(
					GetUserListResponseDto.class,
					user.name,
					user.profileImage)
			)
			.from(relation)
			.join(user).on(relation.followingUserId.eq(user.id))
			.where(
				relation.followerUserId.eq(user.id),
				hasLastDate(lastFollowerId)
			)
			.orderBy(user.id.desc())
			.limit(20)
			.fetch();
	}

	private BooleanExpression hasLastDate(Long lastId) {
		if(lastId == null) {
			return null;
		}

		return user.id.lt(lastId);
	}
}
