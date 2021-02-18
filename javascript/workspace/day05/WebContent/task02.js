/**
 * 자동차 주행에 필요한 js
 */


var check = false;
var policeCnt = 0;


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

const result = document.getElementById("result");

SuperCar.showInput = function(){ //버튼이 보이고 안보이고 //시동켜기에서 이걸로 onclick을 해줘야함
//시동의 상태를 기억할 수 있는 변수를 만들고, 얘는 계속 기억을 하고 있어야한다. 
//img는 img src 프로퍼티를 가지고와서 변경해주면된다. 
	if(!check) {
		//시동을 켤 수 있는 상태
		//input태그 visible
		const inputTag = document.getElementById("pw");
		inputTag.style.visibility = "visible";
	}else {
		//시동이 이미 켜져 있는 상태
		result.innerHTML ="이미 시동이 켜져있습니다.";
	}
}

//프로토 타입의 메소드 사용방법
//SuperCar.engineStart()
SuperCar.engineStart = function() {
	const img = document.getElementById("stat");
	const inputTag = document.getElementById("pw");
	
	var pw = inputTag.value;
	
	//비밀번호 검사(SuperCar.prototype.pw : 초기비밀번호)
	if(SuperCar.prototype.pw == pw) {
		//비밀번호 오류 초기화
		policeCnt = 0;
		img.src = "시동켜기.gif";
		inputTag.value = "비밀번호 입력";
		inputTag.style.visibility = "hidden";
		result.innerHTML = "시동 켜짐";
		check = true;
		
	}else {
		//연속 3회 오류 시 경찰 출동
		policeCnt++;
		
		if(policeCnt ==3) {
			img.src = "경찰.png";
			document.getElementById("on").style.display = "none"; //영역도 없앰. visibility와 다르다.
			document.getElementById("off").style.display = "none"; //영역도 없앰. visibility와 다르다.
			inputTag.style.display = "none";
			result.innerHTML = "경찰 출동";
		}else {
			result.innerHTML = "비밀번호 오류 : " + policeCnt + "회";
		}
	}
	
}

SuperCar.engineStop = function() {
	//시동을 끌 수 있는 상태
	if(check) {
		const img = document.getElementById("stat");
		img.src = "시동끄기.gif";
		result.innerHTML = "시동 꺼짐";
		check = false;
	}else {
		//시동이 이미 꺼져 있는 상태
		result.innerHTML = "이미 시동이 꺼져있습니다.";
	}
}













