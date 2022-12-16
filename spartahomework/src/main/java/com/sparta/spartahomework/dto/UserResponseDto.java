package com.sparta.spartahomework.dto;

import com.sparta.spartahomework.entity.Post;
import com.sparta.spartahomework.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserResponseDto {
    private String username;
    List<Post> posts = new ArrayList<>();

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.posts = user.getPosts();
    }
}
