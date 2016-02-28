package io.baware.baware.POJO;

/**
 * Created by adimoldavski on 27/02/16.
 */

import java.io.Serializable;


public class User implements Serializable {

    private String id;
    private String username;
    private String avatar;
    private int available;

    public User(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
