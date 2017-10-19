package com.example.demo.model;

/**
 * Created by Nabeel on 10/19/2017.
 */
public class CustomerTokenState {

    private String access_token;
    private Long expires_in;

    public CustomerTokenState() {
        this.access_token = null;
        this.expires_in = null;
    }

    public CustomerTokenState(String access_token, Long expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() { return access_token; }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() { return expires_in; }
    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}
