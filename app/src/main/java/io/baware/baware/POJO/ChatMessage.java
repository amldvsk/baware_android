package io.baware.baware.POJO;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by adimoldavski on 27/02/16.
 */
public class ChatMessage implements Serializable {


    private String id;
    private DateTime dataEnterd;
    private String img;
    private String message;
    private User user;
    private boolean isItMe;


    public ChatMessage() {
    }

    public ChatMessage(String id, DateTime dataEnterd, String message, User user, boolean isItMe) {
        this.id = id;
        this.dataEnterd = dataEnterd;
        this.message = message;
        this.user = user;
        this.isItMe = isItMe;
    }

    public String getId() {
        return id;
    }


    public boolean isItMe() {
        return isItMe;
    }

    public void setIsItMe(boolean isItMe) {
        this.isItMe = isItMe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getDataEnterd() {
        return dataEnterd;
    }

    public void setDataEnterd(DateTime dataEnterd) {
        this.dataEnterd = dataEnterd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
