package com.example.model;

import java.util.Date;

public class Material {
    private int id;
    private String title;
    private String description;
    private String filename;
    private Date uploadDate;
    private int userId;

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for filename
    public String getFilename() {
        return filename;
    }

    // Setter for filename
    public void setFilename(String filename) {
        this.filename = filename;
    }

    // Getter for uploadDate
    public Date getUploadDate() {
        return uploadDate;
    }

    // Setter for uploadDate
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Material{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", filename='" + filename + '\'' +
               ", uploadDate=" + uploadDate +
               ", userId=" + userId +
               '}';
    }
}
