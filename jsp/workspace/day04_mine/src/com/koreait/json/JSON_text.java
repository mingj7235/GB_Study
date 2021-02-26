package com.koreait.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonArray;

public class JSON_text {
	//JSON타입을 문자열로 담아줄 변수
	public String json;
	
	public void jsonAdd() {
		//내부 JSON
		JSONObject jObj_in = new JSONObject();
		
		//외부 JSON
		JSONObject jObj_out = new JSONObject();

		//데이터 3쌍 추가
		//{name:'한동석', gender:'남자',nation:'Republic of Korea'}
		jObj_in.put("name", "한동석");
		jObj_in.put("gender", "남자");
		jObj_in.put("nation", "Republic of Korea");
		
		//
		//{"han":{"name":'한동석', "gender":'남자', "nation":'Republic of Korea'}}
		jObj_out.put("han", jObj_in);
		
		
		json = jObj_out.toJSONString();
		
		System.out.println(json);
	}
	
	public static void main(String[] args) {
		JSON_text j_test = new JSON_text();
		j_test.jsonAdd();
		
		JSONParser p = new JSONParser();
		
		JSONObject jObj_in = new JSONObject();
		JSONObject jObj_out = new JSONObject();
		
		/*JsonArray j_array = new JsonArray();*/
		/*j_array.add(jObj_in);*/
		
		String name = null;
		String gender = null;
		String nation = null;
		
		try {
			//문자열을 JSON타입으로 변경
			jObj_out = (JSONObject)p.parse(j_test.json); //다운케스팅해줘야한다.
			
			//외부JSON의 KEY를 전달해서 내부 JSON가져오기
			jObj_in = (JSONObject)jObj_out.get("han");
			
			//내부 JSON의 요소들에 KEY로 접근
			name = (String)jObj_in.get("name"); //다운케스팅!!!
			gender = (String)jObj_in.get("gender"); //다운케스팅!!!
			nation = (String)jObj_in.get("nation"); //다운케스팅!!!

			System.out.println("이름 : " + name);
			System.out.println("성별 : " + gender);
			System.out.println("국가 : " + nation);
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}












