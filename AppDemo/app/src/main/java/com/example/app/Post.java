package com.example.app;

import java.util.Date;
import java.util.List;

public class Post {

    private String documentId;
    private String title;
    private String contents;
    private String username;
    private Date date;
    private List<String> imageUrls;

    public Post() {

    }

    public Post(String documentId, String title, String contents, String username) {
        this.documentId = documentId;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    // Getters and setters

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Post{" +
                "documentId='" + documentId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
