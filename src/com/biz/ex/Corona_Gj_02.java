package com.biz.ex;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Corona_Gj_02 {
	
	public static void main(String[] args) throws IOException {
		String url = "https://www.gwangju.go.kr/c19/c19/contentsView.do?pageId=coronagj2";
		Document doc = Jsoup.connect(url).get();
		Elements crnMvlist = doc.select("tr.line_bg");
		
		Map<Integer, String[]> map = new HashMap<Integer, String[]>();
		
		int num = 0;
		for(Element corona : crnMvlist) {
			Elements crnInfoMvlist = corona.select("td");
			String[] stringList = {crnInfoMvlist.get(0).text(),crnInfoMvlist.get(1).text(),
					crnInfoMvlist.get(2).text(),crnInfoMvlist.get(3).text(),
					crnInfoMvlist.get(4).text(),crnInfoMvlist.get(5).text()};
			
			map.put(num, stringList);
			num++;
		}
		
		int count = getMapSize(map)-1;
		for(int i = count; i >= 0; i--) {
			System.out.println(String.format("■번호  : %d", (i + 1)));
			System.out.println(String.format("■확진자 번호 : %s", map.get(i)[0]));
			System.out.println(String.format("■인적사향 : %s", map.get(i)[1]));
			System.out.println(String.format("■확진 경위 : %s", map.get(i)[2]));
			System.out.println(String.format("■확진일 : %s", map.get(i)[3]));
			System.out.println(String.format("■접촉 : %s", map.get(i)[4]));
			System.out.println(String.format("■격리시설: %s\n", map.get(i)[5]));
			
			
		}
		
	}
	
	private static int getMapSize(Map<Integer, String[]> map) {
		int count = 0;
		for(Integer key : map.keySet()) count++;
		return count;
	}

}
