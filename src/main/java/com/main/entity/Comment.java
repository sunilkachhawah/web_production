package com.main.entity;

//Comment.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
 @Id
 private String id;
 private String postId;
 private String content;
 private String author;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPostId() {
	return postId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public String toString() {
	return "Comment [id=" + id + ", postId=" + postId + ", content=" + content + ", author=" + author + "]";
}
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
public Comment(String id, String postId, String content, String author) {
	super();
	this.id = id;
	this.postId = postId;
	this.content = content;
	this.author = author;
}


 
}
