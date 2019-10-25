package com.company.springbootrest.controller;

import com.company.springbootrest.entity.Post;
import com.company.springbootrest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.getById(id);
    }

    @PostMapping("/add")
    public void save(@RequestBody Post post) {
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable int id, @RequestBody Post post) {
        post.setId(id);
        postService.edit(post);
    }
}
