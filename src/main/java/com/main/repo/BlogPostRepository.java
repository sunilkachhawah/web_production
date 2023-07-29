package com.main.repo;
import com.main.entity.BlogPost;
//BlogPostRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
}
