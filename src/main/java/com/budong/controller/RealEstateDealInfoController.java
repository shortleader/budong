package com.budong.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.interfaces.MainService;
import com.budong.service.interfaces.RealEstateDealInfoService;

@Controller
@RequestMapping("/dealInfo")
public class RealEstateDealInfoController {
	private static final Logger log = LoggerFactory.getLogger(RealEstateDealInfoController.class);

	@Autowired
	private RealEstateDealInfoService realEstateDealInfoService;
	
	@RequestMapping("/realEstate.do")
	public String index(HttpServletRequest req) {
		log.info("path [/dealInfo/realState.do] status ok");
		return "dealInfo/RealEstate";
	}
	
	@RequestMapping("/apt_dealInfo.do")
	public String listInfo(HttpServletRequest req) {
		//Korean 처리
		try {
			req.setCharacterEncoding("EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String str_dealYmd = req.getParameter("deal_ymd");
		str_dealYmd = str_dealYmd.replaceAll("-", "");
		
		
		int deal_ymd = Integer.parseInt(str_dealYmd);
		//법정동  코드
		String lawd_name = req.getParameter("lawd_name");
		// 한글  -> code로  변환
		// 법정동  코드  db 접근해서  가져옴..
		String lawd_cd = realEstateDealInfoService.getLawdCode(lawd_name);

//		log.info("lawd_cd = " + lawd_cd);
		// go service
		List<RealEstateAPTDealInfoDTO> v = realEstateDealInfoService.listAPTDeal(lawd_cd, deal_ymd);

		// page에  아파트  실거래가 정보  dto setAttribute
		req.setAttribute("list", v);
/*
		log.debug("deal_ymd = " + deal_ymd);
		log.debug("lawd_cd = " + lawd_cd);
		log.debug("v size : " + v.size());
*/
		return "dealInfo/APTDealList";
	}
}
