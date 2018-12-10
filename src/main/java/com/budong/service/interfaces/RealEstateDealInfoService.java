package com.budong.service.interfaces;

import java.util.List;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;

public interface RealEstateDealInfoService {

	public List<RealEstateAPTDealInfoDTO> listAPTDeal(String lawd_cd, int deal_ymd);
    String getLawdCode(String lawd_name);

}
