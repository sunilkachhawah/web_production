package com.main.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.main.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
 List<Comment> findByPostId(String postId);
}

