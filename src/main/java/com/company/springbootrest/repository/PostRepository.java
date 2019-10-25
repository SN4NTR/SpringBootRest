package com.company.springbootrest.repository;

import com.company.springbootrest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
