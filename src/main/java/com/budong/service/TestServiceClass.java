package com.budong.service;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.model.RealEasteDealInfoDAOImpl;
import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.model.interfaces.RealEsateDealInfoDAO;

@Service
public class TestServiceClass {
	private final RealEsateDealInfoDAO realEasteDealInfoDAO;

	@Autowired
	public TestServiceClass(RealEsateDealInfoDAO realEasteDealInfoDAO) {
		this.realEasteDealInfoDAO = realEasteDealInfoDAO;
	}

	public Vector<RealEstateAPTDealInfoDTO> listAPTDeal(String lawd_cd, int deal_ymd) {
		return (Vector<RealEstateAPTDealInfoDTO>) realEasteDealInfoDAO.getAPTDealInfo(1, lawd_cd, deal_ymd);
	}
	
}