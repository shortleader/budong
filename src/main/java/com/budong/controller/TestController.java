package com.budong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.budong.R;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.TestServiceClass;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private final TestServiceClass testServiceClass;

    @Autowired
    public TestController(TestServiceClass testServiceClass) {
        this.testServiceClass = testServiceClass;
    }


    @RequestMapping("/realState.do")
    public String index(HttpServletRequest req) {
        log.info("path [/test/realState.do] status ok");
        return "test/RealState";
    }

    @RequestMapping("/apartmentDealInfo.do")
    public String listInfo(HttpServletRequest req) {

        String str_dealYmd = req.getParameter("deal_ymd");
        str_dealYmd = str_dealYmd.replaceAll("-", "");

        int deal_ymd = Integer.parseInt(str_dealYmd);
        String lawd_cd = req.getParameter("lawd_cd");

        // go service
        List<RealEstateAPTDealInfoDTO> v = testServiceClass.listAPTDeal(lawd_cd, deal_ymd);

        req.setAttribute("list", v);

        log.debug("deal_ymd = " + deal_ymd);
        log.debug("lawd_cd = " + lawd_cd);
        log.debug("vector size = " + v.size());

        return "test/APTDealList";
    }

    @RequestMapping(R.mapping.GRAPH)
    public String goToTestGraph() {
        return R.path.GRAPH;
    }

    @RequestMapping(R.json.GRAPH_MAPPING)
    @ResponseBody
    public String getDataPoints() {
        Gson gson = new Gson();
        List<TestJsonObject> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TestJsonObject tjo = new TestJsonObject();
            tjo.xAxis = testXAxisValue++;
            tjo.yAxis = (long) ((Math.random() * 999) + 1);

            list.add(tjo);
        }

        return gson.toJson(list);
    }

    private static long testXAxisValue = 0;

    private class TestJsonObject {
        @SerializedName("x")
        private long xAxis = 0;

        @SerializedName("y")
        private long yAxis;

        public long getxAxis() {
            return xAxis;
        }

        public void setxAxis(long xAxis) {
            this.xAxis = xAxis;
        }

        public long getyAxis() {
            return yAxis;
        }

        public void setyAxis(long yAxis) {
            this.yAxis = yAxis;
        }
    }

}