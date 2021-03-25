<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<!--
	Faction by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>STforU_Sign_up</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<style>
			.section {width:500px; height: 500px; margin: 20px auto;}
			.section input[id*="slide"] {display:none;}
			.section .slidewrap {max-width:1200px;margin:0 auto;}
			.section .slidelist {white-space:nowrap;font-size:0;overflow:hidden;position:relative;}
			.section .slidelist > li {display:inline-block;vertical-align:middle;width:100%;transition:all .5s;}
			.section .slidelist > li > a {display:block;position:relative;}
			.section .slidelist > li > a img {width:100%;}
			.section .slidelist label {position:absolute;z-index:10;top:50%;transform:translateY(-50%);padding:50px;cursor:pointer;}
			.section .slidelist .textbox {position:absolute;z-index:1;top:50%;left:50%;transform:translate(-50%,-50%);line-height:1.6;text-align:center;}
			.section .slidelist .textbox h3 {font-size:36px;color:#fff;;transform:translateY(30px);transition:all .5s;}
			.section .slidelist .textbox p {font-size:16px;color:#fff;opacity:0;transform:translateY(30px);transition:all .5s;}
			
			/* input에 체크되면 슬라이드 효과 */
			.section input[id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
			.section input[id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
			.section input[id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}
		
			/* input에 체크되면 텍스트 효과 */
			.section input[id="slide01"]:checked ~ .slidewrap li:nth-child(1) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
			.section input[id="slide01"]:checked ~ .slidewrap li:nth-child(1) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}
			.section input[id="slide02"]:checked ~ .slidewrap li:nth-child(2) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
			.section input[id="slide02"]:checked ~ .slidewrap li:nth-child(2) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}
			.section input[id="slide03"]:checked ~ .slidewrap li:nth-child(3) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
			.section input[id="slide03"]:checked ~ .slidewrap li:nth-child(3) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}
		
			/* 좌,우 슬라이드 버튼 */
			.slide-control > div {display:none;}
			.section .left {left:5px;background:url('${pageContext.request.contextPath}/app/member/img/left.png') center center / 100% no-repeat; margin-right:50px; }
			.section .right {right:5px;background:url('${pageContext.request.contextPath}/app/member/img/right.png') center center / 100% no-repeat;}
			.section input[id="slide01"]:checked ~ .slidewrap .slide-control > div:nth-child(1) {display:block;}
			.section input[id="slide02"]:checked ~ .slidewrap .slide-control > div:nth-child(2) {display:block;}
			.section input[id="slide03"]:checked ~ .slidewrap .slide-control > div:nth-child(3) {display:block;}
		
			/* 페이징 */
			.slide-pagelist {text-align:center;padding:5px;}
			.slide-pagelist > li {display:inline-block;vertical-align:middle;}
			.slide-pagelist > li > label {display:block;padding:8px 30px; border: 1px solid #888888;border-radius:30px;background:white;margin:20px 10px;cursor:pointer;}
			.section input[id="slide01"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(1) > label {background:#509ed8;}
			.section input[id="slide02"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(2) > label {background:#509ed8;}
			.section input[id="slide03"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(3) > label {background:#509ed8;}
		</style>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">

				<!-- Logo -->
					<span class="logo">
						<a href="${pageContext.request.contextPath}/member/MemberHome.me">STforU</a>
						<span >Sharing Talent For U</span>
					</span>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="${pageContext.request.contextPath}/member/MemberHome.me">Home</a></li>
							<li>
								<a href="#" class="icon solid fa-angle-down">Dropdown</a>
								<ul>
									<li><a href="#">Option One</a></li>
									<li><a href="#">Option Two</a></li>
									<li><a href="#">Option Three</a></li>
									<li>
										<a href="#">Submenu</a>
										<ul>
											<li><a href="#">Option One</a></li>
											<li><a href="#">Option Two</a></li>
											<li><a href="#">Option Three</a></li>
											<li><a href="#">Option Four</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a href="generic.html">Generic</a></li>
							<li><a href="elements.html">Elements</a></li>
							<li><a href="${pageContext.request.contextPath}/member/MemberLogin.me" class="button">Log In</a></li>
						</ul>
					</nav>

			</header>

		<!-- Wrapper -->
			<div class="wrapper">
				<!-- Main -->
				<div style="margin: 20px; margin-left:100px;">
					<h3>회원가입</h3>
				</div>
				<br>
				<!-- html에서는 jsp처럼 java문법을 사용할수 없다... 이럴경우는?  -->
				<form id = "signupForm" name = "signupForm" action="${pageContext.request.contextPath}/member/MemberSignupOk.me" method="post" >
				<!-- 신의한줄 -->
				<input type="hidden" name="memberPhone">
					<div class="row gtr-uniform">
						<div class="col-6 col-12-xsmall" style = "margin: 20px;">
							<div style="align-items: right">
								<h5>(<span style ="color:red;">*</span>)표시는 필수입니다.</h5>
							</div>
							<h5 style ="width: 400px"><span style ="color:red;">*</span> 아이디 (중복체크를 꼭 해주세요)</h5>
							<div class="col-12 actions" style = "display:flex; justify-content:center; width:400px">
								<input type="text" name="memberId" id="memberId" value="" placeholder="ID" style="width: 300px; margin-right: 5px;" onclick="modifyId()"/>
								<input type="button" value="Check ID" class="primary" style = "width: 95px; text-align: center;" onclick="checkId()"/>
							</div>
								<h6 id="check_id_result" style="width: 400px; margin-top: 10px;"></h6>
								
							<h5><span style ="color:red;">*</span> 이름</h5>
							<input type="text" name="memberName" id="memberName" value="" placeholder="Name" style="width: 400px"/><br>
							
							<h5 style ="width: 400px"><span style ="color:red;">*</span> 이메일주소 </h5>
							<input type="email" name="memberEmail" id="memberEmail" value="" placeholder="ex> abc1234@stforu.com" style="width: 400px; "/><br>
							<h5><span style ="color:red;">*</span> 비밀번호</h5>
							<input type="password" name="memberPw" id="memberPw" value="" placeholder="password" style="width: 400px"/><br>
							<h5><span style ="color:red;">*</span> 비밀번호 확인</h5>
							<input type="password" name="memberPwRe" id="memberPwRe" value="" placeholder="check password" style="width: 400px"/><br>
							<h5><span style ="color:red;">*</span> 전화번호 등록</h5>
							<div style="width:400px; display:flex; ">
								<select name="memberPhoneHead" id="memberPhoneHead" style="width: 95px;margin-right: 5px; ">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
								</select>
								<input type="text" name="memberPhoneMid" id="memberPhoneMid" value=""  style="width: 95px;margin-right: 5px;"/><br>
								<input type="text" name="memberPhoneBottom" id="memberPhoneBottom" value=""  style="width: 95px;margin-right: 5px;"/><br>
								<input type="button" value="인증번호발송" class="primary" style="width: 95px;margin: 5px 2.5px;padding: 0 2px;font-size: 0.7rem;" onclick="checkSms()"/>
							</div>
								<h6 id="check_phone_result" style="width: 400px; margin-top: 10px;"></h6>
							<div style="width:400px; display:flex;">
								<input type="text" name="phoneIdentifyNum" id="phoneIdentifyNum" value="" placeholder="인증번호 입력" style="width: 295px; margin-right: 5px"/>
								<input type="button" value="인증번호확인" class="" style="width: 95px;margin: 5px 2.5px;padding: 0 2px;font-size: 0.7rem;" onclick="checkModifyNum()"/>
							</div>
								<h6 id="check_modifyNum_result" style="width: 400px; margin-top: 10px;"></h6>
							<br>
							<div class="col-12">
								<textarea name="term" id="term" style ="width : 400px; height : 200px; resize: none;" readonly="readonly">
시행일자 : 2021년 2월 18일

제1조 (목적)
본 약관은 김민재 주식회사(이하 '회사')가 고도 사이트(이하 ‘사이트’)를 통하여 인터넷상에서 제공하는 서비스(이하 ‘서비스’)를 이용하는 고객 (이하 '고객')간의 권리와 의무 및 책임 등 기타 제반사항을 규정함을 목적으로 합니다.

제2조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
가. '회원'이라 함은 이 약관에 동의하고 회원가입을 통하여 이용자ID(고유번호)와 비밀번호를 발급받은 자로서, 회사가 제공하는 서비스를 이용할 수 있는 이용자를 말합니다.
나. '이용자ID'라 함은 회원의 식별 및 서비스 이용을 위하여 회원의 신청에 따라 회사가 회원 별로 부여하는 고유한 문자와 숫자의 조합을 말합니다.
다. '비밀번호'라 함은 이용자ID로 식별되는 회원의 본인 여부를 검증하기 위하여 회원이 설정하여 회사에 등록한 고유의 문자와 숫자의 조합을 말합니다.
라. ‘로그인’이라 함은 이용자ID와 비밀번호를 통하여 서비스 신청 및 사용 중 서비스의 세부정보를 확인할 수 있는 행위를 말합니다.
마. '탈퇴'라 함은 회원이 서비스 이용을 해지하는 것을 말합니다.
바. ‘휴면ID’ 라 함은 회사에서 정한 일정 기간 동안 사이트 접속 및 미 로그인 시 고객의 정보 악용방지를 위하여 보호되는 계정입니다.
이 약관에서 사용하는 용어 중 제1항에서 정하지 아니한 것은 관계 법령 및 서비스 별 안내에서 정하는 바에 따르며, 그 외에는 일반 관례에 따릅니다.

제3조 (이용약관의 효력 및 개정)
1. 이 약관은 사이트를 통해 온라인으로 공시하고 회원의 동의로 효력을 발생합니다. 본 약관의 공시는 사이트에 게시하는 방법으로 합니다.
2. 회사는 합리적인 사유가 발생할 경우 관련 법령에 위배되지 않는 범위 내에서 약관을 개정할 수 있습니다. 개정된 약관은 사이트를 통해 공지하거나 기타의 방법으로 회원에게 공지함으로써 그 효력이 발생하며, 이용자의 권리 또는 의무에 관한 변경은 최소한 7일 전에 공지합니다.
3. 변경된 약관에 대한 정보를 알지 못해 발생하는 회원의 피해는 회사에서 책임지지 않습니다.
4. 회원은 변경된 약관에 동의하지 않을 경우 서비스 이용을 중단하고 회원 탈퇴를 요청할 수 있습니다. 단, 이의가 있음에도 불구하고 제 2항에서 정한 바에 따른 회사의 고지가 있은 후 30일 이내에 이용계약을 하지 않은 회원은 변경된 약관에 동의한 것으로 간주합니다. 

제4조 (약관외 준칙)
회사는 필요한 경우 기타 유ㆍ무료 서비스 내의 운영원칙 또는 개별약관(이하 '서비스 별 약관'이라 합니다)를 정할 수 있으며, 본 약관과 서비스 별 약관의 내용이 상충되는 경우에는 서비스 별 약관의 내용을 우선하여 적용합니다.

제5조 (회원 가입)
1. 이 약관의 동의는 회원가입 당시 절차 상의 이용약관 및 개인정보처리방침에 동의한다는 의사표시와 함께 회사가 요청하는 정보를 제공하여 회원가입 신청을 완료함으로써 이루어집니다. 
2. 회원으로 가입하여 서비스를 이용하고자 하는 이용자는 회사에서 요청하는 제반 정보(개인정보처리방침 제 1항 ‘수집하는 개인정보의 항목’)를 제공하여야 합니다.
3. 회원은 반드시 회원 본인의 정보를 제공하여야만 서비스를 이용할 수 있으며, 타인의 정보를 도용하거나 허위의 정보를 등록하는 등 본인의 정확한 정보를 등록하지 않은 회원은 서비스 이용과 관련하여 아무런 권리를 주장할 수 없으며, 관계 법령에 따라 처벌 받을 수 있습니다. 또한 제 3자에게 야기한 손해를 배상할 책임이 있으며, 회사는 허위의 정보를 기재한 회원의 서비스 이용 자격을 제한할 수 있습니다.

제6조 (개인정보의 보호 및 사용)
1. 회사는 관계 법령이 정하는 바에 따라 회원의 개인정보를 보호하기 위해 노력합니다. 개인정보의 보호 및 사용에 관해서는 관계 법령 및 회사의 개인정보처리방침에 정한 바에 의합니다. 단, 회원은 이용자ID 및 비밀번호 등이 타인에게 노출되지 않도록 철저히 관리해야 하며 회사는 회원의 귀책사유로 인해 노출된 정보에 대해서 책임을 지지 않습니다.
2. 회사는 고객이 제공하는 개인정보를 본 서비스 이외의 목적을 위하여 사용할 수 없습니다.
3. 회사는 고객이 제공한 개인정보를 고객의 사전 동의 없이 제 3자에게 제공할 수 없습니다. 단, 다음 각 호에 해당하는 경우에는 예외로 합니다.
가. 도메인이름 검색서비스를 제공하는 경우
나. 전기통신기본법 등 관계법령에 의하여 국가기관의 요청이나 범죄에 대한 수사상의 목적이 있거나 정보통신윤리위원회의 요청이 있는 경우
다. 통계작성, 홍보자료, 시장조사를 위하여 필요한 경우로서 특정 고객임을 식별할 수 없는 형태로 제공되는 경우

제7조 (회원에 대한 통지 및 정보제공)
1. 회사가 회원에 대하여 통지하는 경우 회원이 회사에 등록한 전자우편 주소나 휴대전화번호, 유선전화번호로 할 수 있습니다.
2. 회사는 불특정다수 회원에게 통지를 해야 할 경우 고도 공지게시판을 통해 7일 이상 게시함으로써 개별 통지에 갈음할 수 있습니다.
3. 회사는 회원에게 서비스 이용에 필요가 있다고 인정되는 각종 정보에 대해서 전자우편이나 서신, 우편, SMS, 전화 등의 방법으로 회원에게 제공할 수 있습니다.
4. 회사는 서비스 개선 및 회원 대상의 서비스 소개 등의 목적으로 회원의 동의 하에 관련 법령에 따라 추가적인 개인 정보를 수집할 수 있습니다.

제8조(서비스의 이용 시간 및 중단)
1. 서비스 이용은 회사의 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴, 1일 24시간 운영을 원칙으로 합니다. 단, 회사는 시스템 정기점검, 증설 및 교체를 위해 회사가 정한 날이나 시간에 서비스를 일시 중단할 수 있으며, 예정되어 있는 작업으로 인한 서비스 일시 중단은 고도를 통해 사전에 사이트를 통하여 공지합니다.
2. 회사는 긴급한 시스템 점검, 증설 및 교체, 설비의 장애, 서비스 이용의 폭주, 국가비상사태, 정전 등 부득이한 사유가 발생한 경우 사전 예고 없이 일시적으로 서비스의 전부 또는 일부를 중단할 수 있습니다.
3. 회사는 서비스 개편 등 서비스 운영 상 필요한 경우 전부 또는 일부 서비스의 제공을 중단할 수 있으며 회원에게 사전 예고 또는 사후 통보 합니다.

제9조 (회사의 의무)
1. 회사는 본 약관이 정하는 바에 따라 지속적이고 안정적인 서비스를 제공하기 위해서 노력합니다.
2. 회사는 회원의 개인정보 보호를 위해 보안 시스템을 구축하며 개인정보 처리방침을 공시하고 준수합니다.
3. 회사는 공정하고 건전한 운영을 위해 최선을 다하고 지속적인 연구개발을 통하여 양질의 서비스를 제공함으로써 고객만족을 극대화하여 인터넷 사업 발전에 기여합니다.
4. 회사는 회원으로부터 제기되는 의견이나 불편사항이 정당하다고 객관적으로 인정될 경우에는 적절한 절차를 통해 즉시 처리하여야 합니다. 다만, 신속한 처리가 곤란한 경우는 회원에게 그 사유와 처리일정을 통보하여야 합니다.

제10조 (회원의 의무)
1. 회원은 회원가입 신청 또는 회원정보 변경 시 모든 사항을 사실에 근거하여 본인의 실제 정보로 작성하여야 하며, 허위 또는 타인의 정보를 등록할 경우 이와 관련된 모든 권리를 주장할 수 없습니다.
2. 회원은 본 약관에서 규정하는 사항과 기타 회사가 정한 제반 규정, 공지사항 등 회사가 공지하는 사항 및 관계 법령을 준수하여야 하며, 기타 회사의 업무에 방해가 되는 행위, 회사의 명예를 손상시키는 행위, 타인에게 피해를 주는 행위를 해서는 안됩니다.
3. 회원은 주소, 연락처, 전자우편 주소 등 회원의 이용정보가 변경된 경우에 해당 절차를 거쳐 이를 회사에 즉시 알려야 합니다.
4. 회원은 회원ID, 비밀번호 등이 타인에게 노출되지 않도록 철저한 관리 책임이 있습니다.
5. 회원은 회원ID, 비밀번호 등이 도난 당하거나 제 3자가 사용하고 있음을 인지한 경우에는 즉시 회사에 통보하고 회사의 안내가 있는 경우에는 그에 따라야 합니다.
6. 회사는 회원의 상기 제1항, 제 2항, 제 3항, 제 4항, 제 5항을 위반하여 회원에게 발생한 손해에 대하여 어떠한 책임도 부담하지 않습니다.

제11조 (회원 탈퇴 및 자격 상실)
1. 회원은 회사에 언제든지 회원 탈퇴를 요청할 수 있으며 회사는 요청을 받은 즉시 해당 회원의 회원 탈퇴를 위한 절차를 밟아 고도 개인정보처리방침에 따라 회원 등록을 말소합니다.
2. 회사의 모든 서비스에서 이용중인 서비스의 기간이 남아있는 회원이 탈퇴 요청하였을 경우 회원탈퇴로 인한 서비스의 중지 또는 피해는 회원탈퇴 이용자에게 있습니다.
3. 회원이 서비스 이용에 있어서 본 약관 제 10조 내용을 위반하거나, 다음 각 호의 사유에 해당하는 경우 회사는 직권으로 회원자격 상실 및 회원탈퇴의 조치를 할 수 있습니다.
가. 다른 사람의 명의를 사용하여 가입 신청한 경우
나. 신청 시 필수 작성 사항을 허위로 기재한 경우
다. 관계법령의 위반을 목적으로 신청하거나 그러한 행위를 하는 경우
라. 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청하거나 그러한 행위를 하는 경우
마. 다른 사람의 회사 서비스 이용을 방해하거나 그 정보를 도용하는 등 전자거래질서를 위협하는 경우
바. 관계 법령 위배와 본 약관이 금지하는 행위를 하는 회원 경우
4. 회사가 직권으로 회원탈퇴 처리를 하고자 하는 경우에는 말소 전에 회원에게 소명의 기회를 부여합니다.

제12조 (휴면ID 관리)
1. 회사는 서비스 미 이용 및 1년 이상 사이트 로그인을 하지 않은 경우 해당 이용자ID 및 개인정보를 휴면ID로 별도 관리합니다.
2. 회사는 휴면ID 대상 회원에게 전환 30일 전에 고지의 의무를 다 해야 하며, 휴면ID를 이용하여 사이트 로그인 시도 시 회원가입 당시 요청한 제반 정보 확인 후 바로 이용자 ID로 전환이 이루어집니다.

제13조 (손해배상)
1. 회사는 서비스에서 무료로 제공하는 서비스의 이용과 관련하여 개인정보보호정책에서 정하는 내용에 해당하지 않는 사항에 대하여 어떠한 손해도 책임을 지지 않습니다.

제14조 (면책조항)
1. 회사는 천재지변, 전쟁, 기간통신사업자의 서비스 중지 및 기타 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 대한 책임 지지 않습니다.
2. 회사는 서비스용 설비의 보수, 교체, 정기점검, 공사 등 부득이한 사유로 발생한 손해에 대한 책임이 면제됩니다.
3. 회사는 회원이 서비스에 게재한 정보, 자료, 사실의 정확성, 신뢰성 등 그 내용에 관하여는 어떠한 책임을 부담하지 아니하고, 회원은 자기의 책임아래 서비스를 이용하며, 서비스를 이용하여 게시 또는 전송한 자료 등에 관하여 손해가 발생하거나 자료의 취사선택, 기타 서비스 이용과 관련하여 어떠한 불이익이 발생하더라도 이에 대한 모든 책임은 회원에게 있습니다.
4. 회사가 제공하는 정보와 자료는 거래의 목적으로 이용될 수 없습니다. 따라서 본 서비스의 정보와 자료 등에 근거한 거래는 전적으로 회원자신의 책임과 판단아래 수행되는 것이며, 회사는 회원이 서비스의 이용과 관련하여 기대하는 이익에 관하여 책임을 부담하지 않습니다.
5. 회사는 회원이 서비스를 이용하여 기대하는 수익을 얻지 못하거나 상실한 것에 대하여 책임을 지지 않으며, 서비스를 이용하면서 얻은 자료로 인한 손해에 대하여 책임을 지지 않습니다.
6. 회사는 회원의 게시물을 등록 전에 사전심사 하거나 상시적으로 게시물의 내용을 확인 또는 검토하여야 할 의무가 없으며, 그 결과에 대한 책임을 지지 아니합니다.

제15조 (약관의 해석 및 관할법원)
1. 본 약관에 명시되지 않은 사항은 관계 법령과 상관례에 따릅니다.
2. 회사의 개별 유ㆍ무료 서비스 이용 회원의 경우 당해 서비스와 관련하여서는 회사가 별도로 정한 약관 및 정책에 따릅니다.
3. 회원과 회사 사이에 발생한 분쟁에 대해 소송이 제기되는 경우 관할 법원은 서울중앙지방법원으로 합니다.

제16조 (재판관할 및 준거법)
1. 이 약관에 명시되지 않은 사항은 전기통신사업법 등 대한민국의 관계법령과 상관습에 따릅니다.
2. 회사의 정액 서비스 회원 및 기타 유료 서비스 이용 회원의 경우 당해 서비스와 관련하여서는 회사가 별도로 정한 약관 및 정책에 따릅니다.
3. 이 약관 및 서비스의 이용과 관련된 분쟁에 관한 소송은 회사의 본사 소재지를 관할하는 법원에 제기합니다.


부칙 (시행일)
본 약관은 2020년 11월 16일부터 적용하고, 2016년 5월 2일부터 시행되던 종전의 약관은 본 약관으로 대체합니다.
								</textarea>
							</div>
							<div class="col-6 col-12-small" style="margin-top: 10px; width : 200px;">
								<input type="checkbox" id="human" name="human" checked>
								<label for="human"><span style ="color: red">[필수]</span> 동의합니다.</label>
							</div>
							<hr style="width :400px;">
							
							<!-- Talent 세부 관련 사항 -->
							<h5 style ="width: 400px;">성별</h5>
							<div class="col-4 col-12-small" style ="width : 400px; ">
								<input type="radio" id="memberGender" name="memberGender" value ="남" checked> 
								<label for="priority-low">남</label>
								<input type="radio" id="memberGender" name="memberGender" value ="여"> 
								<label for="priority-normal">여</label>
							</div>
							<h5 style ="width: 400px;">지역</h5>
								<div class="row gtr-uniform" style="width: 400px;">
									<div class="col-9 col-12-small">
										
										<!-- <input type="text" name="query" id="query" value="" placeholder="- 지역검색 - (000동 입력)" style="width: 280px;"/> -->
										<input type="text" name="memberZipcode" class="postcodify_postcode5" value="" readonly placeholder="- 우편번호 (검색버튼 클릭 후 검색)" style="width: 280px;"/>
									</div>
									<div class="col-3 col-12-small">
										<input type="button" id="postcodify_search_button" value="검색" class="fit" style="width: 100px"><br />
								<!-- 		<input type="submit" value="Search" class="fit" style="width: 100px"/> -->
									</div>
								</div>
							</form>
							<input type="text" name="memberAddress" class="postcodify_address" placeholder="- 주소 (우편번호 검색 후 자동입력)" value="" style="width: 400px; margin-top: 10px;" readonly/>
							<input type="text" name="memberAddressDetail" class="postcodify_details" placeholder="- 세부 주소" style="width: 400px; margin-top: 10px;"/>
							<h6 style ="width: 400px;">지역이 구체적일 수록 내 주변의 모임들을 찾기에 좋아요 :)</h6><br>
							
<!-- 							<br>
							<h3 style="width: 400px">Sharing Talent For you</h3>
							<blockquote style="width: 400px">
							당신의 재능은 무엇인가요?<br>
							당신이 나눌수 있는 재능이 무엇이든 선택해주세요. <br>
							또, 당신이 배우고 싶거나 관심있는 분야가 무엇인지 선택해주세요. <br>
							(최소 1가지, 최대 3가지씩 선택이 가능합니다.)
							</blockquote>
							
							<h5 style ="width: 400px;">나의 재능 (<span style ="color:red;">*</span> 최소 1개는 선택해주세요.)</h5>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<br>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option> 
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<br>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<br>
							<h5 style ="width: 400px;">관심 분야 (<span style ="color:red;">*</span> 최소 1개는 선택해주세요.)</h5>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<br>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<br>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px;">
									<option value="">- 카테고리 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div>
							<div class="col-12">
								<select name="category" id="category" style ="width : 400px; margin-top: 10px;">
									<option value="">- 세부분야 -</option>
									<option value="1">운동</option>
									<option value="1">게임</option>
									<option value="1">음악</option>
									<option value="1">자기개발</option>
								</select>
							</div> -->
							<hr style="width :400px;">
							<div class="col-12 actions" style = "display:flex; justify-content:center; width:400px">
									<input type="button" value="Sign up" class="primary" style = "width: 300px;" onclick="signup()"/>
									<input type="reset" value="Reset" style = "width: 300px; "/>
							</div>
						</div>
					</div>
				</form>
				<div class="section">
	<input type="radio" name="slide" id="slide01" checked>
	<input type="radio" name="slide" id="slide02">
	<input type="radio" name="slide" id="slide03">
	
	<div class="slidewrap" style = "position: fixed; width : 500px; height: 500px; ">
		
		<ul class="slidelist">
			<!-- 슬라이드 영역 -->
			<li class="slideitem">
				<a>
					<div class="textbox">
						<h3>첫번째 슬라이드</h3>
						<p>첫번째 슬라이드 입니다.</p>
					</div>
					<img src="${pageContext.request.contextPath}/app/member/img/slide.jpg">
				</a>
			</li>
			<li class="slideitem">
				<a>
					
					<div class="textbox">
						<h3>두번째 슬라이드</h3>
						<p>두번째 슬라이드 입니다.</p>
					</div>
					<img src="${pageContext.request.contextPath}/app/member/img/slide.jpg">
				</a>
			</li>
			<li class="slideitem">
				<a>
					
					<div class="textbox">
						<h3>두번째 슬라이드</h3>
						<p>두번째 슬라이드 입니다.</p>
					</div>
					<img src="${pageContext.request.contextPath}/img/slide.jpg">
				</a>
			</li class="slideitem">

			<!-- 좌,우 슬라이드 버튼 -->
			<div class="slide-control">
				<div>
					<label for="slide03" class="left"></label>
					<label for="slide02" class="right"></label>
				</div>
				<div>
					<label for="slide01" class="left"></label>
					<label for="slide03" class="right"></label>
				</div>
				<div>
					<label for="slide02" class="left"></label>
					<label for="slide01" class="right"></label>
				</div>
			</div>

		</ul>
		<!-- 페이징 -->
		<ul class="slide-pagelist">
			<li><label for="slide01"></label></li>
			<li><label for="slide02"></label></li>
			<li><label for="slide03"></label></li>
		</ul>
	</div>

	
</div>	
			
			</div>
			
			

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<section class="info">
						<h3>About Us</h3>
						<div class="about">
							<p>Morbi mattis mi consectetur tortor elementum, varius pellentesque velit convallis. Aenean tincidunt lectus auctor mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et ex tincidunt, quis lacinia velit aliquet. Duis non efficitur malesuada.</p><p>Sagittis felis ac sagittis semper. Curabitur purus leo donec vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames ac ante ipsum primis.</p>
							<ul class="actions">
								<li><a href="#" class="button">Learn More</a></li>
							</ul>
						</div>
						<div class="team">
							<article>
								<span class="image"><img src="images/pic06.jpg" alt=""></span>
								<p>
									<strong class="name">John Doe</strong>
									<span class="title">Lorem semper magna etiam</span>
								</p>
							</article>
							<article>
								<span class="image"><img src="images/pic07.jpg" alt=""></span>
								<p>
									<strong class="name">Jane Anderson</strong>
									<span class="title">Etiam feugiat adipiscing veroeros</span>
								</p>
							</article>
							<article>
								<span class="image"><img src="images/pic08.jpg" alt=""></span>
								<p>
									<strong class="name">Mike Smith</strong>
									<span class="title">Consequat nulla dolor blandit</span>
								</p>
							</article>
						</div>
					</section>
					<section class="contact">
						<h3>Contact Us</h3>
						<ul class="contact-icons">
							<li class="icon solid fa-home"><a href="#">1234 Somewhere Road #80486<br>Nashville, TN 00000</a></li>
							<li class="icon solid fa-phone"><a href="#">(800) 555-0000 x12345</a></li>
							<li class="icon solid fa-envelope"><a href="#">hello@untitled.tld</a></li>
							<li class="icon brands fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
							<li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
						</ul>
					</section>
				</div>
				<div class="copyright">
					&copy; Untitled. All rights reserved.
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
			<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
			<script>var contextPath = "${pageContext.request.contextPath}";</script>
			<script src = "${pageContext.request.contextPath}/app/member/member.js"></script>
			<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
	</body>
</html>