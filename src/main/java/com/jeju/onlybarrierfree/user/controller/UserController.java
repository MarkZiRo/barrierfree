package com.jeju.onlybarrierfree.user.controller;

import com.jeju.onlybarrierfree.user.dto.CreateUserDto;
import com.jeju.onlybarrierfree.user.dto.ResponseUserDto;
import com.jeju.onlybarrierfree.user.dto.UserDto;
import com.jeju.onlybarrierfree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public UserDto signUp(@RequestBody CreateUserDto dto)
    {
        return userService.createUser(dto);
    }

    @GetMapping("/get")
    public ResponseUserDto getMyProfile() {
        return userService.getMyProfile();
    }

}
