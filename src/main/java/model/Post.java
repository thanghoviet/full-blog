package model;

import java.util.Date;
import java.util.List;

public class Post {
    private int id;
    private String title;
    private String sortContent;
    private String content;
    private String image;
    private Date createDate;
    private Date editDate;
    private User use;
    private int userId;
    private Category category;
    private int categoryId;
    private List<Comment> comments;

    public Post(){}

    public Post(int id) {
        this.id = id;
    }

    public Post(String title, String sortContent, String content, String image, Category category) {
        this.title = title;
        this.sortContent = sortContent;
        this.content = content;
        this.image = image;
        this.category = category;
    }

    public Post(String title, String sortContent, String content, String image, User use, Category category) {
        this.title = title;
        this.sortContent = sortContent;
        this.content = content;
        this.image = image;
        this.use = use;
        this.category = category;
    }

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post(int id, String title, String sortContent, String content,
                String image, Date createDate, Date editDate, User use, int userId, Category category, int categoryId) {
        this.id = id;
        this.title = title;
        this.sortContent = sortContent;
        this.content = content;
        this.image = image;
        this.createDate = createDate;
        this.editDate = editDate;
        this.use = use;
        this.userId = userId;
        this.category = category;
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSortContent() {
        return sortContent;
    }

    public void setSortContent(String sortContent) {
        this.sortContent = sortContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public User getUse() {
        return use;
    }

    public void setUse(User use) {
        this.use = use;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sortContent='" + sortContent + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createDate=" + createDate +
                ", editDate=" + editDate +
                ", use=" + use +
                ", userId=" + userId +
                ", category=" + category +
                ", categoryId=" + categoryId +
                '}';
    }
}
