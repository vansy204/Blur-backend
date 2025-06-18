package com.example.storyservice.repository.httpclient;


import com.example.storyservice.dto.response.ApiResponse;
import com.example.storyservice.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profile-service",url = "${app.service.profile.url}")
public interface ProfileClient {
    @GetMapping("/internal/users/{userId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable("userId") String userId);
    @GetMapping("/users/{profileId}")
    ApiResponse<UserProfileResponse> getProfileByProfileId(@PathVariable String profileId);
}
