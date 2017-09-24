package com.example.demo.util;

/**
 * Created by Nabeel on 9/24/2017.
 */
public interface RequestMapping {

    String PRODUCT = "/product";
    String LIST =  "/list";
    String  SHOW_PRODUCT = "/show/{id}";
    String SAVE_PRODUCT =  "/add";
    String UPDATE_PRODUCT =  "/update/{id}";
    String DELETE =  "/delete/{id}";
}
