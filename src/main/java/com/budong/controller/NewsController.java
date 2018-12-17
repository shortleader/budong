package com.budong.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.budong.R;
import com.budong.model.dto.NewsDTO;
import com.budong.service.NewsServiceImpl;

@Controller
public class NewsController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping(R.mapping.news_title)
    public ModelAndView goToTestPage(@RequestParam String param) {
        log.info("param : " + param);
        ModelAndView mav = new ModelAndView(R.path.news_title);

        String url = "https://land.naver.com/news/headline.nhn?bss_ymd=" + param;
        ArrayList<NewsDTO> list = newsService.getTitle(url);

        mav.addObject("list", list);
        mav.addObject("date", param);
        return mav;
    }

    @RequestMapping(R.mapping.news_contents)
    public ModelAndView getNewsbody(@RequestParam String param) {
        ModelAndView mav = new ModelAndView(R.path.news_contents);
        String change = param.replaceAll("!", "&");

        mav.addObject("newsbody", newsService.getContent(change));
        return mav;
    }

}
