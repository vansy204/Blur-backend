package com.blur.chatservice.repository.httpclient;


import com.blur.chatservice.dto.ApiResponse;
import com.blur.chatservice.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profile-service",url = "${app.service.profile.url}")
public interface ProfileClient {
    @GetMapping("/internal/users/{userId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable("userId") String userId);
    @GetMapping("/user/{profileId}")
    ApiResponse<UserProfileResponse> getProfileById(@PathVariable("profileId") String profileId);

}
