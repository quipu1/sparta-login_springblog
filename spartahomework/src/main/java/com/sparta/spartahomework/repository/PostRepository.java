package com.sparta.spartahomework.repository;

import com.sparta.spartahomework.dto.PostResponseDto;
import com.sparta.spartahomework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
