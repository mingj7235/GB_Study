/**
 * 
 */

var policeCnt = 0;
var check = false;

function SuperCar (){
	this.brand = "BMW";
	this.color = "black";
	this.price = 20000;
}

function activeEnter () {
	if(window.event.keyCode == 13) {
		SuperCar.engineStart();
	}
}


SuperCar.prototype.pw = prompt("자동차 초기 비밀번호");

const result = document.getElementById("result");

SuperCar.showInput = function () {
	if(!check) {
		const inputTag = document.getElementById("pw");
		inputTag.style.visibility = "visible";
	} else {
		result.innerHTML = "이미 시동이 켜져있습니다";
	}
}

SuperCar.engineStart = function () {
	const img = document.getElementById("stat");
	const inputTag = document.getElementById("pw");
	var pw = inputTag.value;
	
	if(SuperCar.prototype.pw == pw) {
		policeCnt = 0;
		img.src = "시동켜기.gif";
		inputTag.value = "비밀번호 입력";
		inputTag.style.visibility = "hidden";
		result.innerHTML = "시동켜짐";
		check = true;
	}else {
		policeCnt++;
		
		if (policeCnt == 3) {
			img.src = "경찰.png";
			document.getElementById("on").style.display = "none";
			document.getElementById("off").style.display = "none";
			inputTag.style.display = "none";
			result.innerHTML = "경찰출동";
			
		}else {
			result.innerHTML = "비밀번호 오류" + policeCnt + "회";
		}
	}
}

SuperCar.engineStop = function () {
	if (check) {
		const img = document.getElementById("stat");
		img.src = "시동끄기.gif";
		result.innerHTML = "시동 꺼짐";
		check = false;
	
	} else {
		result.innerHTML = "시동이 꺼져있음";
		
	}
	
}














