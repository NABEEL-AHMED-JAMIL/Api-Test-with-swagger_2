package com.example.demo.controller;


import com.example.demo.exception.DataFormatException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
/**
 * Created by Nabeel on 10/17/2017.
 */
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public
    @ResponseBody
    RestErrorInfo handleDataStoreException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());

        return new RestErrorInfo();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public @ResponseBody RestErrorInfo handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request, HttpServletResponse response) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());

        return new RestErrorInfo();
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    //todo: replace with exception mapping
    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("resource not found");
        }
        return resource;
    }

}
