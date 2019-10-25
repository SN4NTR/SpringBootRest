package com.company.springbootrest.service;

import com.company.springbootrest.entity.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    void delete(int id);

    Post getById(int id);

    List<Post> getAll();

    void edit(Post post);
}
