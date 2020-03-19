<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/abc39c0b8a.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
<style>
	body, html {
		width: 100%;
		height: 100%;
	}
	
	.mt-30 {
		margin-top: 30px;
	}
	
	.min-w {
		min-width: 400px;
	}
	
	.dropdown-item:focus, .dropdown-item:hover {
		background-color: #33B5E5;
	}
</style>


<title>Mail App</title>
</head>
<body>
	<!--Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #1d2124;">
		<a class="navbar-brand" href="#">NMail</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="home">Message</a></li>
	
				<li class="nav-item"><a class="nav-link" href="msgForm">Add Message</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Update</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Delete</a></li>
			</ul>

			<ul class="navbar-nav ml-auto my-2 my-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user"></i><span
						class="text-uppercase"> ${username}</span> Profile
				</a>

					<div class="dropdown-menu dropdown-menu-right dropdown-info"
						aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">My account</a>
						<div class="dropdown-divider"></div>
						<a id="formSubmit" class="dropdown-item formSubmit" href="logout">Log
							out</a>
					</div></li>

			</ul>
		</div>
	</nav>
	<!--/.Navbar -->
	<div class="mt-30"></div>