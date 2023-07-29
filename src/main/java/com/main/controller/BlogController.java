package com.main.controller;

//BlogController.java
import com.main.entity.BlogPost;
import com.main.entity.Comment;
import com.main.repo.BlogPostRepository;
import com.main.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class BlogController {
	@Autowired
 private final BlogPostRepository blogPostRepository;
 private final CommentRepository commentRepository;

 public BlogController(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
     this.blogPostRepository = blogPostRepository;
     this.commentRepository = commentRepository;
 }

 @GetMapping("/all")
 public List<BlogPost> getAllBlogPosts() {
     return blogPostRepository.findAll();
 }

 // add new blog
 @PostMapping("/add")
 public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
     return blogPostRepository.save(blogPost);
 }
 
 
 //post new
 /*
 @PostMapping("/add")
	public ResponseEntity<String> createBlogPost(@RequestBody BlogPost blogPost) {
		return blogService.addBlog(blogPost);
	}
	*/

 @GetMapping("/{postId}")
 public Optional<BlogPost> getBlogPostById(@PathVariable String postId) {
     return blogPostRepository.findById(postId);
 }

 //update blog
 @PutMapping("update/{postId}")
 public BlogPost updateBlogPost(@PathVariable String postId, @RequestBody BlogPost updatedPost) {
     BlogPost existingPost = blogPostRepository.findById(postId).orElse(null);
     if (existingPost != null) {
         existingPost.setTitle(updatedPost.getTitle());
         existingPost.setContent(updatedPost.getContent());
         existingPost.setAuthor(updatedPost.getAuthor());
         // Update other properties as needed.
         return blogPostRepository.save(existingPost);
     }
     return null;
 }

 @DeleteMapping("delete/{postId}")
 public String deleteBlogPost(@PathVariable String postId) {
     BlogPost existingPost = blogPostRepository.findById(postId).orElse(null);
     if (existingPost != null) {
         blogPostRepository.delete(existingPost);
         return "Blog post deleted successfully.";
     }
     return "Blog post not found.";
 }

 @PostMapping("/{postId}/comments")
 public Comment addCommentToPost(@PathVariable String postId, @RequestBody Comment comment) {
     BlogPost blogPost = blogPostRepository.findById(postId).orElse(null);
     if (blogPost != null) {
         comment.setPostId(postId);
         System.out.println("comment added");
         return commentRepository.save(comment);
     }
     return null;
 }

 @GetMapping("/{postId}/comments")
 public List<Comment> getCommentsByPostId(@PathVariable String postId) {
     return commentRepository.findByPostId(postId);
 }

 @PutMapping("/{postId}/comments/{commentId}")
 public Comment updateComment(@PathVariable String postId, @PathVariable String commentId, @RequestBody Comment updatedComment) {
     Comment existingComment = commentRepository.findById(commentId).orElse(null);
     if (existingComment != null && existingComment.getPostId().equals(postId)) {
         existingComment.setContent(updatedComment.getContent());
         existingComment.setAuthor(updatedComment.getAuthor());
         // Update other properties as needed.
         return commentRepository.save(existingComment);
     }
     return null;
 }

 @DeleteMapping("/{postId}/comments/{commentId}")
 public String deleteComment(@PathVariable String postId, @PathVariable String commentId) {
     Comment existingComment = commentRepository.findById(commentId).orElse(null);
     if (existingComment != null && existingComment.getPostId().equals(postId)) {
         commentRepository.delete(existingComment);
         return "Comment deleted successfully.";
     }
     return "Comment not found.";
 }

 // ... Other endpoints for retrieving, updating, and deleting blog posts and comments ...
}
