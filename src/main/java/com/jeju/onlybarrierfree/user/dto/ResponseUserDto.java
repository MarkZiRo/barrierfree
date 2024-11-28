package com.jeju.onlybarrierfree.user.dto;

import com.jeju.onlybarrierfree.user.entity.UserEntity;
import lombok.Getter;

import java.util.Objects;

@Getter
public class ResponseUserDto {

    private Long id;
    private String username;
    private String email;
    private String profileImage;

    public static ResponseUserDto fromEntity(UserEntity userEntity){
        return new ResponseUserDto(userEntity);
    }

    public ResponseUserDto(UserEntity userEntity){
        Objects.requireNonNull(userEntity);
        this.id = Objects.requireNonNull(userEntity.getId());
        this.username = Objects.requireNonNull(userEntity.getUsername());
        this.email = Objects.requireNonNull(userEntity.getEmail());
        this.profileImage = Objects.requireNonNull(userEntity.getProfileImage());

    }
}
