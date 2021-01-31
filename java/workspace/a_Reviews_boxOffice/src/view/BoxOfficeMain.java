package view;

import java.io.IOException;
import java.util.Scanner;

import dao.BoxOfficeDao;
import vo.BoxOfficeVo;

public class BoxOfficeMain {
	public static void main(String[] args) {
		BoxOfficeVo bv = new BoxOfficeVo();
		BoxOfficeDao bdao = new BoxOfficeDao();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String mainMsg = "박스오피스 \n"
				+ "1. 현재 박스오피스 조회\n"
				+ "2. 영화 추가\n"
				+ "3. 영화 제목 수정\n"
				+ "4. 영화 삭제\n"
				+ "5. 영화 검색\n"
				+ "6. 종료\n"
				+ "선택 : ";
		
		while (true) {
			System.out.print(mainMsg);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				System.out.println("<현재 박스오피스 순위>");
				try {
					System.out.println(bdao.selectAll());
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			}
			
		}//while end
		
	}
}
