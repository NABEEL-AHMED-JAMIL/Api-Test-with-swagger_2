package com.example.demo.controller;

import com.example.demo.model.Product;
import io.swagger.models.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.example.demo.util.RequestMapping.*;

/**
 * Created by Nabeel on 9/24/2017.
 */
public interface IProductController {


    @RequestMapping(value = LIST, method= RequestMethod.GET)
    Iterable<Product> list(Model model) throws Exception;

    @RequestMapping(value = SHOW_PRODUCT, method= RequestMethod.GET)
    Product showProduct(@PathVariable Long id, Model model) throws Exception;

    @RequestMapping(value = SAVE_PRODUCT, method = RequestMethod.POST)
    ResponseEntity saveProduct(@RequestBody Product product) throws Exception;

    @RequestMapping(value = UPDATE_PRODUCT, method = RequestMethod.PUT)
    ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception;

    @RequestMapping(value= DELETE, method = RequestMethod.DELETE)
    ResponseEntity delete(@PathVariable Long id) throws Exception;

}
