package com.doudou.onlinebook.entity.websocket;

/**
 * @author ：zhuyk
 * @date ：Created in 2022-10-10 17:44
 * @modified By：
 * @version: $
 */
public class MyMessageBean {
    public String userId;
    public String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
