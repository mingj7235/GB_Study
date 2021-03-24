<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>
<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->
					
					<ul class="actions">
						<!-- 세션의 아이디로그인 정보를 이용하여 if문의 조건 검색 -->
						<c:set var="check" value="1" />
						<c:if test="${check eq 1}">					
							<li><a href="#" class="button primary">로그인</a></li>&nbsp;
							<li><a href="#" class="button">회원가입</a></li>
						</c:if>
						<c:if test="${check eq 2}">
							<li><a href="#" class="button primary">로그아웃</a></li>
						</c:if>
						
					</ul>

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
								<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
								<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
							</article>
							<article>
								<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
								<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
							</article>
							<article>
								<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
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
							<li class="icon solid fa-envelope"><a href="#">대표 이메일</a></li>
							<li class="icon solid fa-phone">대표 전화번호</li>
							<li class="icon solid fa-home">주소<br />
							상세주소</li>
						</ul>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">&copy; Untitled. All rights reserved.</p>
					</footer>

			</div>
		</div>	
</body>
</html>