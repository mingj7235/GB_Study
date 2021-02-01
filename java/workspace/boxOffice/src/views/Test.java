package views;

import java.io.IOException;

import dao.BoxOfficeDao;
import vo.BoxOfficeVo;

public class Test {
	public static void main(String[] args) {
		BoxOfficeDao dao = new BoxOfficeDao();
		BoxOfficeVo film_vo = new BoxOfficeVo();
		
		//오류 수정 재밌네 전체 조회 테스트완료
//		try {
//			dao.selectAll().forEach(film -> {
//				System.out.print(film.getRanking() + "\t");
//				System.out.print(film.getFilmName()+"\t");
//				System.out.print(film.getIncome() +"\t");
//				System.out.print(film.getGuestCnt()+"\t");
//				System.out.println(film.getScreenCnt());
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//검색 테스트완료
//		try {
//			dao.select("7").forEach(film ->{
//				System.out.println(film.getFilmName());
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//추가 삽입 테스트완료
//		film.setRanking(7);
//		film.setFilmName("겨울왕국");
//
//		try {
//			dao.insertOrAppend(film);
//		} catch (IOException e) {;}
		
		//수정 테스트 완료
//		try {
//			if(dao.update("겨울왕국", "여름왕국")) {
//				System.out.println("수정성공");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//삭제 테스트 완료
//		try {
//			if(dao.delete("여름왕국")){
//				System.out.println("삭제성공 ");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
