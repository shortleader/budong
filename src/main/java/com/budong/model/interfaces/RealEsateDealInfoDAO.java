package com.budong.model.interfaces;

import java.util.Vector;

import org.w3c.dom.Element;

import com.budong.model.dto.RealEstateAPTDealInfoDTO;

public interface RealEsateDealInfoDAO {
	Vector<RealEstateAPTDealInfoDTO> getAPTDealInfo(int pageNo, String lawd_cd, int deal_ymd );
	void getAPTDealURL();
	int getTotalCount();
	boolean checkErr();
}
