package com.batuhan.untils.Models;

import com.batuhan.untils.Models.User;

public class UserTrip {

    private int userTripId;
    private int userId;
    private String tripName;
    private String from;
    private String whereTo;
    private double lat;
    private double lng;
    private String content;
    private String tripImage;

    public UserTrip() {
    }

    public UserTrip(int userTripId, int userId, String tripName, String from, String whereTo, double lat, double lng, String content, String tripImage) {
        this.userTripId = userTripId;
        this.userId = userId;
        this.tripName = tripName;
        this.from = from;
        this.whereTo = whereTo;
        this.lat = lat;
        this.lng = lng;
        this.content = content;
        this.tripImage = tripImage;
    }

    public int getUserTripId() {
        return userTripId;
    }

    public void setUserTripId(int userTripId) {
        this.userTripId = userTripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String tripTitle) {
        this.whereTo = tripTitle;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTripImage() {
        return tripImage;
    }

    public void setTripImage(String tripImage) {
        this.tripImage = tripImage;
    }
}
