package model;

import java.util.Date;

public class Comment {
private int id;
private String content;
private String email;
private Date createDate;
private Post post;
private int postId;

    public Comment(){}

    public Comment(String content) {
        this.content = content;
    }

    public Comment(String content, String email, Post post) {
        this.content = content;
        this.email = email;
        this.post = post;
    }

    public Comment(int id, String content, String email, Date createDate, Post post) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.createDate = createDate;
        this.post = post;
    }

    public Comment(int id, String content, String email, Date createDate, Post post, int postId) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.createDate = createDate;
        this.post = post;
        this.postId = postId;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", post=" + post +
                ", postId=" + postId +
                '}';
    }
}
