<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Editorial by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo"><strong>Editorial</strong> by Pixelarity</a>
									<ul class="icons">
										<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
									</ul>
								</header>

				
				<!-- 회원가입 페이지시작  -->
				<!-- 
						MEMBERID VARCHAR2(300),
						MEMBERPW VARCHAR2(300),
						MEMBERNAME VARCHAR2(300),
						MEMBERPHONE VARCHAR2(300),
						MEMBEREMAIL VARCHAR2(300),
						MEMBERGENDER VARCHAR2(300),
						MEMBERZIPCODE VARCHAR2(300),
						MEMBERADDRESS VARCHAR2(300),
						MEMBERADDRESSDETAIL VARCHAR2(500),
						MEMBERADDRESSETC VARCHAR2(300)
				 -->
				 <section>
					<header class="major">
						<img src="${pageContext.request.contextPath}/images/logo_1.png" />
					</header>
					<div class="features">
						<form method="post" action="#">
						<div style="align-items: right">
								<h5>(<span style ="color:#ffaec9;">*</span>)표시는 필수입니다.</h5>
						</div>
							<div class="row gtr-uniform">
								<div class="col-6 col-12-xsmall">
									<h4 style="margin-bottom: 0px;"><span style ="color:#ffaec9;">*</span>아이디</h4>
									<input type="text" name="memberId" id="memberId" value="" placeholder="이름" style="margin-bottom: 8px;"/>
									
									<h4 style="margin-bottom: 0px;"><span style ="color:#ffaec9;">*</span>비밀번호</h4>
									<input type="password" name="memberId" id="memberId" value="" placeholder="비밀번호" style="margin-bottom: 8px;"/>
									
									<h4 style="margin-bottom: 0px;"><span style ="color:#ffaec9;">*</span>비밀번호 확인</h4>
									<input type="password" name="memberId" id="memberId" value="" placeholder="비밀번호 확인" style="margin-bottom: 8px;"/>
									
									<h4 style="margin-bottom: 0px;"><span style ="color:#ffaec9;">*</span>전화번호 등록</h4>
									<div style="display:flex; ">
										<select name="memberPhoneHead" id="memberPhoneHead" style="width: 25%;margin-right: 5px; ">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
										</select>
										<input type="text" name="memberPhoneMid" id="memberPhoneMid" value=""  style="width: 25%; margin-right: 5px;"/><br>
										<input type="text" name="memberPhoneBottom" id="memberPhoneBottom" value=""  style="width: 25%;margin-right: 5px;"/><br>
										<input type="button" value="인증번호발송" class="primary" style="width: 25%;;padding: 0 2px;font-size: 0.7rem;" onclick=""/>
									</div>
										<!-- 인증번호 발송 후 db조회 후에 dom으로 꽂기  -->
										<h6 id="check_phone_result" style="width: 400px; margin-top: 10px;"></h6>
									<div style="display:flex;">
										<input type="text" name="phoneIdentifyNum" id="phoneIdentifyNum" value="" placeholder="인증번호 입력" style="width: 75%; margin-right: 5px"/>
										<input type="button" value="인증번호확인" class="" style="width: 25%;padding: 0 2px;font-size: 0.7rem;" onclick=""/>
									</div>
										<!-- 인증번호 발송 후 db조회 후에 dom으로 꽂기  -->
										<h6 id="check_modifyNum_result" style="width: 400px; margin-top: 10px;"></h6>
									<br>
									<!-- Break -->
									<div class="col-12">
										<select name="demo-category" id="demo-category">
											<option value="">- Category -</option>
											<option value="1">Manufacturing</option>
											<option value="1">Shipping</option>
											<option value="1">Administration</option>
											<option value="1">Human Resources</option>
										</select>
									</div>
								</div>
								<!-- Break -->
								<div class="col-4 col-12-small">
									<input type="radio" id="demo-priority-low" name="demo-priority" checked>
									<label for="demo-priority-low">Low</label>
								</div>
								<div class="col-4 col-12-small">
									<input type="radio" id="demo-priority-normal" name="demo-priority">
									<label for="demo-priority-normal">Normal</label>
								</div>
								<div class="col-4 col-12-small">
									<input type="radio" id="demo-priority-high" name="demo-priority">
									<label for="demo-priority-high">High</label>
								</div>
								<!-- Break -->
								<div class="col-6 col-12-small">
									<input type="checkbox" id="demo-copy" name="demo-copy">
									<label for="demo-copy">Email me a copy</label>
								</div>
								<div class="col-6 col-12-small">
									<input type="checkbox" id="demo-human" name="demo-human" checked>
									<label for="demo-human">I am a human</label>
								</div>
								<!-- Break -->
								<div class="col-12">
									<textarea name="demo-message" id="demo-message" placeholder="Enter your message" rows="6"></textarea>
								</div>
								<!-- Break -->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="primary" /></li>
										<li><input type="reset" value="Reset" /></li>
									</ul>
								</div>
							</div>
						</form>
					</div>
				</section>

				
							

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="index.html">Homepage</a></li>
										<li><a href="generic.html">Generic</a></li>
										<li><a href="elements.html">Elements</a></li>
										<li>
											<span class="opener">Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Etiam Dolore</a></li>
										<li><a href="#">Adipiscing</a></li>
										<li>
											<span class="opener">Another Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Maximus Erat</a></li>
										<li><a href="#">Sapien Mauris</a></li>
										<li><a href="#">Amet Lacinia</a></li>
									</ul>
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Ante interdum</h2>
									</header>
									<div class="mini-posts">
										<article>
											<a href="#" class="image"><img src="${pageContext.request.contextPath}/images/pic07.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="${pageContext.request.contextPath}/images/pic08.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="${pageContext.request.contextPath}/images/pic09.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
									</div>
									<ul class="actions">
										<li><a href="#" class="button">More</a></li>
									</ul>
								</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
										<li class="icon solid fa-phone">(000) 000-0000</li>
										<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script>var contextPath = "${pageContext.request.contextPath}";</script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>

	</body>
</html>