package com.budong.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.budong.R;
import com.budong.util.DistrictCode;
import com.budong.util.DistrictCodeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.service.interfaces.RealEstateDealInfoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(R.controller.real_estate_deal_info)
public class RealEstateDealInfoController {
	private static final Logger log = LoggerFactory.getLogger(RealEstateDealInfoController.class);

	private final RealEstateDealInfoService realEstateDealInfoService;

	private final DistrictCodeSet districtCodeSet;

	@Autowired
	public RealEstateDealInfoController(DistrictCodeSet districtCodeSet, RealEstateDealInfoService realEstateDealInfoService) {
		this.districtCodeSet = districtCodeSet;
		this.realEstateDealInfoService = realEstateDealInfoService;
	}

	@RequestMapping(value= R.mapping.real_estate)
	public String index(HttpServletRequest req) {
		log.info("path [/dealInfo/realState.do] status ok");
		return R.path.real_estate;
	}
	
	@RequestMapping(value= R.mapping.apartment_deal_info)
	public ModelAndView listInfo(@RequestParam("deal_ymd") String str_deal_ymd, @RequestParam String lawd_name) {

	    int deal_ymd = Integer.parseInt(str_deal_ymd.replaceAll("-",""));

		// 한글  -> code로  변환
		// 법정동  코드  db 접근해서  가져옴..
		String lawd_cd = realEstateDealInfoService.getLawdCode(lawd_name);

//		log.info("lawd_cd = " + lawd_cd);
		// go service
		List<RealEstateAPTDealInfoDTO> v = realEstateDealInfoService.listAPTDeal(lawd_cd, deal_ymd);

		// page에  아파트  실거래가 정보  dto setAttribute
        ModelAndView mav = new ModelAndView(R.path.apartment_deal_info);
        mav.addObject("list", v);
/*
		log.debug("deal_ymd = " + deal_ymd);
		log.debug("lawd_cd = " + lawd_cd);
		log.debug("v size : " + v.size());
*/
		return mav;
	}

	/** graph test section */
	@RequestMapping(R.mapping.graph_year_avg)
	public String goToTestGraphYear() {
		return R.path.graph_year;
	}

	@RequestMapping(R.mapping.graph_year_month_avg)
	public String goToTestGraphYearMonth() {
		return R.path.graph_year_month;
	}

	@RequestMapping(R.mapping.graph_year_districtCode_avg)
	public ModelAndView goToTestGraphYearDistrict() {
		List<DistrictCode> districtCodeList = new ArrayList<>(districtCodeSet);
		districtCodeList.sort(Comparator.comparing(DistrictCode::getDistrictName));

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("districtCodeList",districtCodeList);

		return new ModelAndView(R.path.graph_year_districtCode_avg, parameters);
	}

	/* graph test section end*/
}
