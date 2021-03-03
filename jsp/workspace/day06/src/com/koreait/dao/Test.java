package com.koreait.dao;

import java.util.HashMap;

import com.koreait.vo.MemberVO;

public class Test {
	public static void main(String[] args) {
		//아이디체크
		MemberDAO dao = new MemberDAO();
		/*System.out.println(dao.checkId("joshuara7235"));*/
		
		//로그인
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", "joshuara7235");
		datas.put("pw", "1234");
		System.out.println(dao.login(datas));
		
		//회원가입
		MemberVO vo = new MemberVO();
		
		/*vo.setId("3mins3");
		vo.setName("김민재");
		vo.setPassword("12345");
		vo.setGender("남자");
		vo.setZipcode("123");
		vo.setAddress("서울");
		vo.setAddressDetail("동작구");
		vo.setAddressEtc("대방동");
		
		System.out.println(dao.join(vo));
		*/
		//회원 조회 
		System.out.println(dao.getMember(41));
		
		//아이디로 회원 번호 조회
		System.out.println(dao.getNum("3mins1"));
		
		System.out.println(dao.getPw("3mins1"));
		
		System.out.println(dao.getId(41));
		
		System.out.println(dao.getPwNum(41));
		
		System.out.println(dao.getMemberList());
		
		//수정하는법
		//회원 이름 수정 (회원번호, 새로운 이름)
		//회원 상세보기 (마이페이지-select)를 통해 가져온 모델 객체에 바로 수정하기 때문에
		//수정된 모델객체를 전달받는것이 편하다. 
		MemberVO member = dao.getMember(41);
		member.setName("홍길동");
		
		System.out.println(dao.getMember(41));
		
		System.out.println(dao.delete(41));
	}
}
