package com.budong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.model.dto.Local_LawdCodeDTO;
import com.budong.model.dto.RealEstateAPTDealInfoDTO;
import com.budong.model.interfaces.Local_LawdCodeDAO;
import com.budong.model.interfaces.RealEsateDealInfoDAO;
import com.budong.service.interfaces.RealEstateDealInfoService;

@Service
public class RealStateDealInfoServiceImpl implements RealEstateDealInfoService{

	private final RealEsateDealInfoDAO realEasteDealInfoDAO;
    private final Local_LawdCodeDAO localDAO;

	@Autowired
	public RealStateDealInfoServiceImpl(RealEsateDealInfoDAO realEasteDealInfoDAO, Local_LawdCodeDAO localDAO) {
		this.realEasteDealInfoDAO = realEasteDealInfoDAO;
		this.localDAO = localDAO;
	}
	
	@Override
	public List<RealEstateAPTDealInfoDTO> listAPTDeal(String lawd_cd, int deal_ymd) {
		return realEasteDealInfoDAO.getAPTDealInfo(lawd_cd, deal_ymd);
	}

	@Override
	public String getLawdCode(String lawd_name) {
		return localDAO.getLawdCode(new Local_LawdCodeDTO(lawd_name));
	}
}
