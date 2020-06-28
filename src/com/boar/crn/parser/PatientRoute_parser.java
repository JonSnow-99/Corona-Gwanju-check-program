package com.boar.crn.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PatientRoute_parser {
	
	public Map<Integer, List<String>> getBasicInformation(Document doc){
		Elements routeInfoList = doc.select("tbody tr");
		
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
		int count = 0;
		for(Element infoItem : routeInfoList) {
			Elements routeItemList = infoItem.select("talbe.in_default");
			int size = routeItemList.size();
			
			if(size >= 2) {
				Elements routeList = routeItemList.get(1).select("tbody tr");
				List<String> list = new ArrayList<String>();
				
				for(Element route : routeList) {
					String content = route.select("td").text();
					list.add(content);
				}
				
				if(!list.isEmpty()) {
					map.put(count, list);
					count++;
				}
			}
			
		}
	
		return map;
   }
}