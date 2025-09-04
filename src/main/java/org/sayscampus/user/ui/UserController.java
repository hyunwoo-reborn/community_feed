package org.sayscampus.user.ui;

import java.util.List;

import org.sayscampus.common.ui.Response;
import org.sayscampus.user.application.UserService;
import org.sayscampus.user.application.dto.CreateUserRequestDto;
import org.sayscampus.user.application.dto.GetUserListResponseDto;
import org.sayscampus.user.application.dto.GetUserResponseDto;
import org.sayscampus.user.domain.User;
import org.sayscampus.user.repository.jpa.JpaUserListQueryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final JpaUserListQueryRepository userListQueryRepository;

	@PostMapping
	public Response<Long> createUser(@RequestBody CreateUserRequestDto dto) {
		User user = userService.createUser(dto);
		return Response.ok(user.getId());
	}

	@GetMapping("/{userId}")
	public Response<GetUserResponseDto> getUserProfile(@PathVariable(name = "userId") Long userId) {
		return Response.ok(userService.getUserProfile(userId));
	}

	@GetMapping("/{userId}/following")
	public Response<List<GetUserListResponseDto>> getFollowingList(@PathVariable(name = "userId") Long userId) {
		List<GetUserListResponseDto> result = userListQueryRepository.getFollowingUserList(userId);
		return Response.ok(result);
	}

	@GetMapping("/{userId}/follower")
	public Response<List<GetUserListResponseDto>> getFollowerList(@PathVariable(name = "userId") Long userId) {
		List<GetUserListResponseDto> result = userListQueryRepository.getFollowerUserList(userId);
		return Response.ok(result);
	}

}