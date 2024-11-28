package com.jeju.onlybarrierfree.auth.config;


import com.jeju.onlybarrierfree.user.Repository.UserRepository;
import com.jeju.onlybarrierfree.user.entity.UserEntity;
import com.jeju.onlybarrierfree.user.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFacade {

    private final UserRepository userRepository;

    public Authentication getAuth()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public UserEntity extractUser()
    {
        try{
            CustomUserDetails userDetails = (CustomUserDetails) getAuth().getPrincipal();
            return userDetails.getEntity();
        }catch (Exception e)
        {
            throw new AuthenticationServiceException("로그인이 필요합니다.");
        }
    }
 }
