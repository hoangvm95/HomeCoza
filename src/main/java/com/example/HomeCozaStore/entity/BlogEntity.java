package com.example.HomeCozaStore.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "blog")
    private Set<TagBlogEntity> listTagBlog;

    @OneToMany(mappedBy = "blog")
    private Set<CommentEntity> listComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<TagBlogEntity> getListTagBlog() {
        return listTagBlog;
    }

    public void setListTagBlog(Set<TagBlogEntity> listTagBlog) {
        this.listTagBlog = listTagBlog;
    }

    public Set<CommentEntity> getListComment() {
        return listComment;
    }

    public void setListComment(Set<CommentEntity> listComment) {
        this.listComment = listComment;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
