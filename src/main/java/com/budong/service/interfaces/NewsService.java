package com.budong.service.interfaces;

import java.util.ArrayList;

import com.budong.model.dto.NewsDTO;

public interface NewsService {
	
	public ArrayList<NewsDTO> getTitle(String url);
	public String getContent(String url);
	

}
