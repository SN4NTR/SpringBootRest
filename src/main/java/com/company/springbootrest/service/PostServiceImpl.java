package com.company.springbootrest.service;

import com.company.springbootrest.entity.Post;
import com.company.springbootrest.entity.User;
import com.company.springbootrest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        postRepository.delete(postRepository.getOne(id));
    }

    @Override
    public Post getById(int id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void edit(Post post) {
        User user = postRepository.getOne(post.getId()).getUser();
        post.setUser(user);
        postRepository.save(post);
    }
}
