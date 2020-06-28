package com.boar.crn.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PatientList_parser {
	
	public Map<Integer, List<String>> getBasicInformation(Document doc){
		Elements patienList = doc.select("tr.line_bg");
		
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
		int num = 0;
		for(Element patient : patienList) {
			Elements pattentInfoList = patient.select("td");
			List<String> list = new ArrayList<String>();
			list.add(pattentInfoList.get(0).text());
			list.add(pattentInfoList.get(1).text());
			list.add(pattentInfoList.get(2).text());
			list.add(pattentInfoList.get(3).text());
			list.add(pattentInfoList.get(4).text());
			list.add(pattentInfoList.get(5).text());
			
			map.put(num, list);
			num++;
		}
		return map;
	}

}
