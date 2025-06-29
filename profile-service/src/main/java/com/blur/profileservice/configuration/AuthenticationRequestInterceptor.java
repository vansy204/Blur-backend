package com.blur.profileservice.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class AuthenticationRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        var authHeader = Objects.requireNonNull(servletRequestAttributes).getRequest().getHeader("Authorization");
        if (StringUtils.hasText(authHeader)) {
            template.header("Authorization", authHeader);
        }
    }
}
