package com.example.demo.util;

/**
 * Created by Nabeel on 9/24/2017.
 */
public interface RequestMapping {

    String AUTH = "/auth";
    String LOGIN = "/login";
    String LOGOUT = "/logout";
    String REFRESH = "/refresh";

    String PRODUCT = "/product";
    String LIST =  "/list";
    String  SHOW_PRODUCT = "/show/{id}";
    String SAVE_PRODUCT =  "/add";
    String UPDATE_PRODUCT =  "/update/{id}";
    String DELETE =  "/delete/{id}";

    String CUSTOMER = "/customer";
    String FIND_BY_EMAIL = "/email/{email}";
    String CUSTOMER_LIST =  "/customer_list";
    String SAVE_CUSTOMER =  "/add_customer";
    String UPDATE_CUSTOMER =  "/update_customer/{id}";
    String DELETE_CUSTOMER =  "/delete_customer/{id}";

}
