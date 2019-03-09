package com.batuhan.untils.Models;

import java.util.List;

public class User {

    private int userId;
    private String username;
    private String userEmail;
    private String userPassword;
    private String userImage;
    private List<UserTrip> userTripList;

    public User() {
    }

    public User(int userId, String username, String userEmail, String userPassword, String userImage, List<UserTrip> userTripList) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userTripList = userTripList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public List<UserTrip> getUserTripList() {
        return userTripList;
    }

    public void setUserTripList(List<UserTrip> userTripList) {
        this.userTripList = userTripList;
    }
}
