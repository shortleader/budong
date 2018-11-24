package com.budong.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.budong.model.dto.NewsDTO;
import com.budong.service.interfaces.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	private String naverUrl = "https://land.naver.com";
	// https://land.naver.com/news/headline.nhn  -> 네이버 부동산 뉴스  main page
	@Override
	public ArrayList<NewsDTO> getTitle(String url) {
		Document doc = null;
		ArrayList<NewsDTO> list = new ArrayList<NewsDTO>();
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Elements elem = doc.select(".headline_list dl");
		for(Element e : elem) {
			NewsDTO dto = new NewsDTO();
			String path = naverUrl + e.getElementsByAttribute("href").attr("href");
			String img = e.getElementsByAttribute("src").attr("src");
			String title = e.getElementsByIndexEquals(1).text();
			String content = e.getElementsByTag("dd").text();
			String writing = e.getElementsByClass("writing").text();
			String date = e.getElementsByClass("date").text();
			int temp = writing.length() + date.length() +2;
			
			content = content.substring(0, content.length() - temp);

			dto.setContent(content);
			dto.setDate(date);
			dto.setImg(img);
			dto.setTitle(title);
			String change = path.replaceAll("&", "!");
			dto.setUrl(change);
			dto.setWriting(writing);
			list.add(dto);
			
		}
		return list;
	}
	@Override
	public String getContent(String url) {
		String val = "";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements elem = doc.select("#articleBody");
			for(Element e : elem) {
				val += e.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			return val;
	}

}
