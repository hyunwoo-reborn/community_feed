package org.sayscampus.user.ui;

import org.sayscampus.common.ui.Response;
import org.sayscampus.user.application.UserRelationService;
import org.sayscampus.user.application.dto.FollowUserRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/relation")
@RequiredArgsConstructor
public class UserRelationController {

	private final UserRelationService relationService;

	@PostMapping("/follow")
	public Response<Void> followUser(@RequestBody @Valid FollowUserRequestDto dto) {
		relationService.follow(dto);
		return Response.ok(null);
	}

	@PostMapping("/unfollow")
	public Response<Void> unfollowUser(@RequestBody @Valid FollowUserRequestDto dto) {
		relationService.unfollow(dto);
		return Response.ok(null);
	}
}