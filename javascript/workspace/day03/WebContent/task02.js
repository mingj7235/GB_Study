/**
 * 자동차 주행에 필요한 js
 */

//비밀번호 오류 cnt도 전역변수로 바꿈. 

//프로토 타입
function SuperCar() {
	this.brand = "Ferrari";
	this.color = "red";
	this.price = 15000; 
}

function activeEnter () {
	if(window.event.keyCode == 13) { //13번이 엔터임 input테그에서 key event를 걸어주고 
		//시동 켜기
		SuperCar.engineStart();
	}
}

SuperCar.prototype.pw = prompt("자동차 초기 비밀번호 입력");

SuperCar.showInput = function(){ //버튼이 보이고 안보이고 //시동켜기에서 이걸로 onclick을 해줘야함
//시동의 상태를 기억할 수 있는 변수를 만들고, 얘는 계속 기억을 하고 있어야한다. 
//img는 img src 프로퍼티를 가지고와서 변경해주면된다. 
	if() {
		//시동을 켤 수 있는 상태
	}else {
		//시동이 이미 켜져 있는 상태
	}
}

//프로토 타입의 메소드 사용방법
//SuperCar.engineStart()
SuperCar.engineStart = function() {
	//비밀번호 검사(SuperCar.prototype.pw : 초기비밀번호)
	//연속 3회 오류 시 경찰 출동
}

SuperCar.engineStop = function() {
	//시동을 끌 수 있는 상태
	//시동이 이미 꺼져 있는 상태
}













