package com.budong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 일반 사용자
 * */
@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("/")
    public String goToIndexPage() {
        return "index";
    }
}
