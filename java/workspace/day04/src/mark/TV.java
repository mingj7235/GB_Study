package mark;

public class TV {
	
	//애니메이션은 "애니메이션입니다"
	//애니메이션이 아니면 "애니메이션이 아닙니다"
	//라고 println으로 출력하는 메소드
	void checkAni(Video [] arVideo) {
		String msg = null;
		for (int i = 0; i < arVideo.length; i++) {
			if(arVideo[i] instanceof Animation) {
				msg = arVideo[i] + "은(는) 애니메이션 입니다. ";
			}else {
				msg = arVideo[i] + "은(는) 애니메이션이 아닙니다.";
			}
		}
	}
	
	public static void main(String[] args) {
		
		Video[] arVideo = {
				new Zzangu(),
				new Titanic(),
				new Ddolbee(),
				new Dooly()
				
		};
		
		new TV().checkAni(arVideo);
	}
}
