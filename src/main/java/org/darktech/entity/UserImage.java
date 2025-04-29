package org.darktech.entity;

import jakarta.persistence.*;

@Entity
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Default no-argument constructor (required by JPA)
    public UserImage() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Constructor with parameters (you can keep this if you need it for custom initialization)
    public UserImage(Long id, String imageName, String imageType, byte[] imageData, User user) {
        this.id = id;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
        this.user = user;
    }
}
