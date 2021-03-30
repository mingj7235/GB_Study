<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<title>zAccordion Methods Examples</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
		<script src="zaccordion.js"></script>
		<link rel="stylesheet" type="text/css" href="example.css"/>
	</head>

	<body>
		<div id="container">
			<h1>zAccordion Methods Examples</h1>
			<p>There are a number of examples below.  For JavaScript, HTML, and CSS, please view the page source.</p>

			<div id="examples">
				<h2>Example 1 - <code>trigger</code></h2>

				<ul id="example1">
					<li>
						<img src="images/diet01.PNG" width="600" height="270" alt="" />
					</li>
					<li>
						<img src="images/diet02.PNG" width="600" height="270" alt="" />
					</li>
					<li>
						<img src="images/diet03.PNG" width="600" height="270" alt="" />
					</li>
					<li>
						<img src="images/diet01.PNG" width="600" height="270" alt="" />
					</li>
					<li>
						<img src="images/diet02.PNG" width="600" height="270" alt="" />
					</li>
				</ul>

				<script>
					/*jslint sloppy: true, white: true */
					/*globals $, document*/
					var windowWidth = $( window ).width();
					console.log(windowWidth);
					
					$(document).ready(function () {
						var exampleEl = $("#example1"),
							navigationEl;

						navigationEl = $('<ul/>')
							.insertAfter(exampleEl);
						
						if(windowWidth > 1400){
						exampleEl
							.zAccordion({
								auto: true,  //Disable the (automatic) slideshow
								slideWidth: 600,
								width: 1100,
								height: 270
							});
						}else{
							exampleEl
							.zAccordion({
								auto: true,  //Disable the (automatic) slideshow
								slideWidth: 600,
								width: 800,
								height: 270
							});
						}
					});
				</script>
				
			</div>
		</div>
	</body>
</html>