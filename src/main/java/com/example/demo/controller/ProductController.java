package com.example.demo.controller;

import com.example.demo.models.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(path = "/products")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }
}