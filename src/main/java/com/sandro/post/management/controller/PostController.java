package com.sandro.post.management.controller;

import com.sandro.post.management.dto.PostDTO;
import com.sandro.post.management.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostManagementService postManagementService;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return new ResponseEntity(postManagementService.list(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDTO post) {
        return new ResponseEntity(postManagementService.add(post), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity edit(@PathVariable String id, @RequestBody PostDTO post) {
        return new ResponseEntity(postManagementService.edit(id, post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable String id) {
        return new ResponseEntity(postManagementService.delete(id), HttpStatus.OK);
    }
}
