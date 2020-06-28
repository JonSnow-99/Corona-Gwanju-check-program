package com.boar.crn.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CoronaUtil {
	private String url;
	
	public CoronaUtil(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Document getDocument() throws IOException{
		Document doc = Jsoup.connect(url).get();
		return doc;
	}

}
