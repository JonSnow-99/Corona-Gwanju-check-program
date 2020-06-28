package com.biz.ex;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Corona_Gj3 {
	
	public static void main(String[] args) {
		String url = "https://www.gwangju.go.kr/c19/c19/contentsView.do?pageId=coronagj2";
		Document doc = null;
		
		Map<Integer, String[]> map = new HashMap<Integer, String[]>();
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		Elements crnDeepList = doc.select("td.txt_left");
		for(Element corona : crnDeepList) {
		String[] crnList = {crnDeepList.get(0).text(),crnDeepList.get(1).text(),
				crnDeepList.get(2).text(), crnDeepList.get(3).text(),
				crnDeepList.get(4).text(), crnDeepList.get(5).text(), 
				crnDeepList.get(6).text(),crnDeepList.get(7).text()};
		map.put(num, crnList);
		num++;
		}
		int count = getMapSize(map)-1;
		for(int i = count; i >= 0; i--) {
			System.out.println(String.format("■번호  : %d", (i + 1)));
			System.out.println("확진자 기본정보");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println(String.format("■ 기본사항 : %s", map.get(i)[0]));
			System.out.println(String.format("■ 감염경로: %s", map.get(i)[1]));
			System.out.println(String.format("■ 증상발현일 : %s", map.get(i)[2]));
			System.out.println(String.format("■ 검체채취일: %s", map.get(i)[3]));
			System.out.println(String.format("■ 확진일: %s", map.get(i)[4]));
			System.out.println(String.format("■ 현재상황: %s", map.get(i)[5]));
			System.out.println(String.format("■ 접촉자 세부현황: %s\n", map.get(i)[6]));
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("확진자 이동 경로");
			System.out.println(String.format("■ 장소: %s\n", map.get(i)[7]));
		}
	}
		private static int getMapSize(Map<Integer, String[]> map) {
			int count = 0;
			for(Integer key : map.keySet()) count++;
			return count;
	}
}


