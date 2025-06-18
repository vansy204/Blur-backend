package com.postservice.controller;

import com.postservice.dto.request.PostRequest;
import com.postservice.dto.response.ApiResponse;
import com.postservice.dto.response.PostResponse;
import com.postservice.entity.PostLike;
import com.postservice.service.PostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    PostService postService;

    @PostMapping("/create")
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest post) {
        return ApiResponse.<PostResponse>builder()
                .result(postService.createPost(post))
                .build();
    }

    @GetMapping("/my-posts")
    public ApiResponse<List<PostResponse>> getMyPosts() {
        return ApiResponse.<List<PostResponse>>builder()
                .result(postService.getMyPosts())
                .build();
    }

    @PutMapping("/{postId}/like")
    public ApiResponse<String> likePost(@PathVariable String postId) {
        return ApiResponse.<String>builder()
                .result(postService.likePost(postId))
                .build();
    }
    @PutMapping("/{postId}/unlike")
    public ApiResponse<String> unlikePost(@PathVariable String postId) {
        return ApiResponse.<String>builder()
                .result(postService.unlikePost(postId))
                .build();
    }
    @PutMapping("/{postId}/update")
    public ApiResponse<PostResponse> updatePost(@PathVariable String postId,
                                                @RequestBody PostRequest post) {
        return ApiResponse.<PostResponse>builder()
                .result(postService.updatePost(postId, post))
                .build();
    }
    @DeleteMapping("/{postId}/delete")
    public ApiResponse<String> deletePost(@PathVariable String postId) {
        return ApiResponse.<String>builder()
                .result(postService.deletePost(postId))
                .build();
    }
    @GetMapping("/all")
    public ApiResponse<List<PostResponse>> getAllPosts() {
        return ApiResponse.<List<PostResponse>>builder()
                .result(postService.getAllPosts())
                .build();
    }
    @GetMapping("/{postId}/likes")
    public ApiResponse<List<PostLike>> getPostLikes(@PathVariable String postId) {
        return ApiResponse.<List<PostLike>>builder()
                .result(postService.getPostLikesByPostId(postId))
                .build();
    }
    @GetMapping("/users/posts/{userId}")
    public ApiResponse<List<PostResponse>> getUserPosts(@PathVariable String userId) {
        var result = postService.getPostsByUserId(userId);
        return ApiResponse.<List<PostResponse>>builder()
                .result(result)
                .build();
    }
}
