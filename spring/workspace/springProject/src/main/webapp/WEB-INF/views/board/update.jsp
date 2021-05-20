<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Reflex by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<meta name="description" content="" />
        <meta name="keywords" content="" />
		<style>
		a {
			border-bottom: none;
		
		}
		
		
		</style>
		
		
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<nav>
					<ul>
						<li><a href="">Menu</a></li>
					</ul>
				</nav>
			</header>

		<!-- Menu -->
			<nav id="menu">
				<h2>Menu</h2>
				<ul class="links">
					<li><a href="index.html">Home</a></li>
					<li><a href="generic.html">Ipsum veroeros</a></li>
					<li><a href="generic.html">Tempus etiam</a></li>
					<li><a href="generic.html">Consequat dolor</a></li>
					<li><a href="elements.html">Elements</a></li>
				</ul>
				<ul class="actions stacked">
					<li><a href="" class="button fit primary">Get Started</a></li>
					<li><a href="" class="button fit">Log In</a></li>
				</ul>
			</nav>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					<section id="intro" class="wrapper featured style1">
						<div class="inner">
							<span class="image"><img src="/resources/images/pic01.jpg" alt="" /></span>
							<div class="content">
								<header>
									<h1>Reflex</h1>
									<p>Lorem ipsum dolor sit magna consectetur<br />
									adipiscing elit. Duis dapibus rutrum facilisis.<br />
									Class aptent taciti sociosqu torquent.</p>
								</header>
								<footer>
									<ul class="actions">
										<li><a href="#" class="button big">Get Started</a></li>
									</ul>
								</footer>
							</div>
						</div>
					</section>

				<!-- One -->
					<section class="wrapper style2 special">
						<div class="inner">

                  <!-- Elements -->
                     <header class="major">
                        <h1>Board</h1>
                        <p>게시판 수정하기</p>
                     </header>
                              <h3><a href="/board/list${cri.getListLink()}" class="button small">목록 보기</a></h3>
                              <div class="content">
                              	<div class="form">
                              		<form method = "post" action="/board/update">
                              			<input type="hidden" name="pageNum" value="${cri.pageNum}">
                              			<input type="hidden" name="amount" value="${cri.amount}">
                              			<input type="hidden" name="keyword" value="${cri.keyword}">
                              			<input type="hidden" name="type" value="${cri.type}">
                              		
                              			<div class="fields">
                              				<div class="field">
                              					<h3>No.</h3>
                              					<input name="bno" type="text" value="${board.bno}" readonly/>
                              				</div>
                              				<div class="field">
                              					<h3>Title.</h3>
                              					<input name="title" type="text" value="${board.title}"/>
                              				</div>
                              				<div class="field">
                              					<h3>Content</h3>
                              					<textarea name="content" rows="6" style="resize: none;">${board.content}</textarea>
                              				</div>
                              				<div class="field">
                              					<h3>Writer</h3>
                              					<input name="writer" type="text" value="${board.writer}" readonly/>
                              				</div>
                              			</div>
                              			<ul class="actions special">
                              				<li>
                              					<input type="submit" class="button" value="수정 완료">
                              				</li>
                              			</ul>
                              		</form>
                              	</div>
                              </div>
                        </div>
					</section>

				

				<!-- Footer -->
					<section id="footer" class="wrapper split style2">
						<div class="inner">
							<section>
								<header>
									<h3>Magna lorem ipsum</h3>
								</header>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos magna fames ac turpis egestas amet non lorem amet.</p>
								<ul class="icons">
									<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
									<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
								</ul>
							</section>
							<section>
								<form method="post" action="#">
									<div class="fields">
										<div class="field half"><input type="text" name="name" id="name" placeholder="Name" /></div>
										<div class="field half"><input type="email" name="email" id="email" placeholder="Email" /></div>
										<div class="field"><textarea name="message" id="message" placeholder="Message" rows="4"></textarea></div>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" /></li>
									</ul>
								</form>
							</section>
						</div>
						<div class="copyright">
							<p>&copy; Untitled. All rights reserved. Lorem ipsum dolor sit amet nullam.</p>
						</div>
					</section>

			</div>

		<!-- Scripts -->
			<script src="/resources/assets/js/jquery.min.js"></script>
			<script src="/resources/assets/js/browser.min.js"></script>
			<script src="/resources/assets/js/breakpoints.min.js"></script>
			<script src="/resources/assets/js/util.js"></script>
			<script src="/resources/assets/js/main.js"></script>

	</body>
	<script>
	
	
	
	</script>
</html>










