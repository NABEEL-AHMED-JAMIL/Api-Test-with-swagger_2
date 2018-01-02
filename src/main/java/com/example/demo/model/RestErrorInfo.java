package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nabeel on 10/17/2017.
 */
 @XmlRootElement
public class RestErrorInfo {

    public final String detail;
    public final String message;

    public RestErrorInfo(String detail, Exception exception) {
        this.detail = detail;
        this.message = exception.getMessage();
    }

    public String getDetail() { return detail; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "RestErrorInfo{" + "detail='" + detail + '\'' + ", message='" + message + '\'' + '}';
    }
}
