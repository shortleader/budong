<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<div id="test">
	<!-- News -->
        <div class="portfolio-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 portfolio">
	                    <h2>News</h2>
	                   
	                </div>
	            </div>
	            
	            
	            <div>
					<b><a href="#protfolio-container" onclick="test((${date}-1))"> << </a> &nbsp;&nbsp;${date}&nbsp;&nbsp; <a href="#protfolio-container" onclick="test((${date}+1))"> >></a></b>   
				</div>
	            <c:forEach var="item" items="${list}">
					<img src="${item.img}"><a href="#" onclick="test2('${item.url}')">${item.title}</a><br>
					<%-- <a href="<%=request.getContextPath()%>/news?url=${item.url}"> --%>
					${item.content}<br><br>
				</c:forEach>
				
				
	            <div class="row">
	            	<div class="col-sm-12 portfolio-filters">
	            		<a href="#" class="filter-all active">All</a> 
	            		<a href="#" class="filter-web-design">Web design</a> 
	            		<a href="#" class="filter-image-design">Image design</a> 
	            		<a href="#" class="filter-branding">Branding</a> 
	            		<a href="#" class="filter-dtp">DTP</a> 
	            		<a href="#" class="filter-tv-campanies">TV campanies</a>
	            	</div>
	            </div>
	            <div class="row">
	            	<div class="col-sm-12 portfolio-masonry">
		                <div class="portfolio-box web-design">
		                	<img src="assets/img/portfolio/1.jpg" alt="" data-at2x="assets/img/portfolio/1.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box image-design">
		                	<img src="assets/img/portfolio/2.jpg" alt="" data-at2x="assets/img/portfolio/2.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box branding">
		                	<img src="assets/img/portfolio/3.jpg" alt="" data-at2x="assets/img/portfolio/3.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box web-design">
		                	<img src="assets/img/portfolio/4.jpg" alt="" data-at2x="assets/img/portfolio/4.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box image-design">
		                	<img src="assets/img/portfolio/5.jpg" alt="" data-at2x="assets/img/portfolio/5.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box dtp">
		                	<img src="assets/img/portfolio/6.jpg" alt="" data-at2x="assets/img/portfolio/6.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box tv-campanies">
		                	<img src="assets/img/portfolio/7.jpg" alt="" data-at2x="assets/img/portfolio/7.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
		                <div class="portfolio-box branding">
		                	<img src="assets/img/portfolio/8.jpg" alt="" data-at2x="assets/img/portfolio/8.jpg">
		                	<div class="portfolio-box-text-container">
			                	<div class="portfolio-box-text">
			                		<h3>Rio blue parrots</h3>
			                		<p>January 2014</p>
			                	</div>
			                </div>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>
    </div>