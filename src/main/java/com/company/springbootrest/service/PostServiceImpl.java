package com.company.springbootrest.service;

import com.company.springbootrest.entity.Post;
import com.company.springbootrest.repository.PostRepository;
import com.company.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        post.setUser(userRepository.findByEmail(username));
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
        postRepository.save(post);
    }
}
