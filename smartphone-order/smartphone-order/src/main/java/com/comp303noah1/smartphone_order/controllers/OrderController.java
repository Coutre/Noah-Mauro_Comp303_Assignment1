package com.comp303noah1.smartphone_order.controllers;

import com.comp303noah1.smartphone_order.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
public class OrderController {
    @RequestMapping("/orderSummary")
    public String postOrder(@ModelAttribute Order order){
        return "orderSummary";
    }

    @GetMapping("/getModels")
    @ResponseBody
    public List<String> getModels(@RequestParam("brand") String brand) {
        Map<String, List<String>> brandModels = new HashMap<>();
        brandModels.put("iPhone", Arrays.asList("iPhone XR", "iPhone 11 Pro", "iPhone 12"));
        brandModels.put("Samsung", Arrays.asList("Samsung Galaxy S20", "Samsung Galaxy S20 Plus", "Samsung Note 10"));
        brandModels.put("Google", Arrays.asList("Google Pixel 4", "Google Pixel 5"));

        return brandModels.getOrDefault(brand, Collections.emptyList());
    }

}
