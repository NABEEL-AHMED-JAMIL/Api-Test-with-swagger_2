package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Nabeel on 10/17/2017.
 */
// {
//   "timestamp":1489114177875,"status":500,
//   "error":"Internal Server Error",
//   "exception":"java.lang.NullPointerException",
//   "message":"No message available","path":"/user/645"
// }
 @XmlRootElement
public class RestErrorInfo {

    public final String detail;
    public final String message;

    public RestErrorInfo(String detail, Exception exception) {
        this.detail = detail;
        this.message = exception.getMessage();
    }
}
