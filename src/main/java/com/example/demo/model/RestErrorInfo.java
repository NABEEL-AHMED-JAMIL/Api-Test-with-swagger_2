package com.example.demo.model;

import java.util.Date;

/**
 * Created by Nabeel on 10/17/2017.
 */
public class RestErrorInfo {

    private Date date;
    private String status;
    private String error;
    private String message;
    private String path;


    public RestErrorInfo() {}
    public RestErrorInfo(Date date, String status, String error, String message, String path) {
        this.date = date;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() { return error; }
    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() { return path; }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "RestErrorInfo{" + "date=" + date + ", status='" + status + '\'' +
                ", error='" + error + '\'' + ", message='" + message + '\'' +
                ", path='" + path + '\'' + '}';
    }
}
