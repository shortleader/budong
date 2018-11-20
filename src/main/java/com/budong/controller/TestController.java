package com.budong.controller;

import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.TestServiceClass;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	private TestServiceClass testServiceClass;
	
	
	@RequestMapping(value="/realState.do")
	public String index(HttpServletRequest req) {
		System.out.println("ok");
		
		
		return "test/RealState";
	}
	
	@RequestMapping(value="/apt_dealInfo.do")
	public String listInfo(HttpServletRequest req) {

		String str_dealYmd = req.getParameter("deal_ymd");
		str_dealYmd = str_dealYmd.replaceAll("-", "");
		
		int deal_ymd = Integer.parseInt(str_dealYmd);
		String lawd_cd = req.getParameter("lawd_cd");
		System.out.println("deal_ymd - " + deal_ymd + "\nlawd_cd - " + lawd_cd);

		// go service
		Vector<RealEstateAPTDealInfoDTO> v = testServiceClass.listAPTDeal(lawd_cd, deal_ymd);
		
		System.out.println( "v size : " + v.size());
		req.setAttribute("list", v);
		
		
		return "test/APTDealList";
	}
	
}