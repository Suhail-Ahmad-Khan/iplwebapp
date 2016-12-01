<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="robots" content="NOODP">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title><spring:message code="browser.title" text="Test Application"></spring:message></title>
<link rel="shortcut icon" type="image/x-icon" href="portal/image/favicon.png" />
<link href="portal/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header_wrapper">
	<div class="header">
		<div class="name-logo">
				
		</div>
		
		<div class="header-right" style="float:right;">
		</div>
	</div> <!-- CLOSED header -->
	<div class="menu">
		<div class="main_menu">
			<ul class="style2">
				<!-- spring:message is used to read message from properties file
					for Locale support
				 -->
				<li><a href="home"><spring:message code="menu.item.1"/></a></li>
				<li><a href="user-list"><spring:message code="menu.item.2"/></a></li>
				<li><a href="user-add"><spring:message code="menu.item.3"/></a></li>
				<li><a href="#">ABOUT US</a></li>
				<li><a href="#">CONTACT US</a></li>
			</ul>
		</div>
	</div>
	
</div>  <!-- CLOSED header-wrapper -->


<%-- 
	These two div (wrapper and container) are closed in footer.
	All the content except header and footer are written in side container div
	 <!-- CLOSED container div -->
--%>
<div class="wrapper">
	<div class="container">
