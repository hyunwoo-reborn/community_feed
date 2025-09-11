package org.sayscampus.post.ui;

import lombok.RequiredArgsConstructor;
import org.sayscampus.common.ui.Response;
import org.sayscampus.post.application.PostService;
import org.sayscampus.post.application.dto.CreatePostRequestDto;
import org.sayscampus.post.application.dto.LikeRequestDto;
import org.sayscampus.post.application.dto.UpdatePostRequestDto;
import org.sayscampus.post.domain.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Long> createPost(@RequestBody CreatePostRequestDto dto) {
        Post post = postService.createPost(dto);
        return Response.ok(post.getId());
    }

    @PatchMapping("/{postId}")
    public Response<Long> updatePost(@PathVariable(name = "postId") Long postId, @RequestBody UpdatePostRequestDto dto) {
        Post post = postService.updatePost(postId, dto);
        return Response.ok(post.getId());
    }

    @PostMapping("/like")
    public Response<Long> likePost(@RequestBody LikeRequestDto dto) {
        postService.likePost(dto);
        return Response.ok(null);
    }

    @PostMapping("/unlike")
    public Response<Long> unlikePost(@RequestBody LikeRequestDto dto) {
        postService.unlikePost(dto);
        return Response.ok(null);
    }
}
