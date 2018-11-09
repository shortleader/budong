package com.budong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 일반 사용자
 * */
@Controller
@RequestMapping("/")
public class MainController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String goToIndexPage() {
        log.info("path has [/] reached");
        return "index";
    }
}
