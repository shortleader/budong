package com.budong.controller;

import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.TestServiceClass;

@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestServiceClass testServiceClass;
	
	
	@RequestMapping("/realState.do")
	public String index(HttpServletRequest req) {
		log.info("path [/test/realState.do] status ok");
		return "test/RealState";
	}
	
	@RequestMapping("/apt_dealInfo.do")
	public String listInfo(HttpServletRequest req) {

		String str_dealYmd = req.getParameter("deal_ymd");
		str_dealYmd = str_dealYmd.replaceAll("-", "");
		
		int deal_ymd = Integer.parseInt(str_dealYmd);
		String lawd_cd = req.getParameter("lawd_cd");

		// go service
		Vector<RealEstateAPTDealInfoDTO> v = testServiceClass.listAPTDeal(lawd_cd, deal_ymd);

		req.setAttribute("list", v);

		log.debug("deal_ymd = " + deal_ymd);
		log.debug("lawd_cd = " + lawd_cd);
		log.debug("v size : " + v.size());

		return "test/APTDealList";
	}
	
}