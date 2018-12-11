package com.budong.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.budong.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.budong.model.dto.NewsDTO;
import com.budong.service.NewsServiceImpl;

/**
 * 일반 사용자
 */
@Controller
@RequestMapping(R.controller.main)
public class MainController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    private final NewsServiceImpl newsService;

    @Autowired
    public MainController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(R.mapping.INDEX)
    public String goToMainIndex() {
        return R.path.INDEX;
    }

    @RequestMapping(R.mapping.khw_main)
    public ModelAndView goToKhwIndexPage() {
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        String param = date.format(today);

        ModelAndView mav = new ModelAndView(R.path.khw_main);
        String url = "https://land.naver.com/news/headline.nhn?bss_ymd=" + param;
        ArrayList<NewsDTO> list = newsService.getTitle(url);

        mav.addObject("list", list);
        mav.addObject("date", param);
        return mav;
    }
}
