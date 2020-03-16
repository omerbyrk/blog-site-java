<%@page import="com.service.BlogService"%>
<%@page import="com.service.TagService"%>
<%@page import="com.service.CategoryService"%>
<%@page import="com.gadgets.SpringBeanHolder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="tr">
			<%  
			session.setAttribute("categoryList", SpringBeanHolder.getBean(CategoryService.class).getList());
			session.setAttribute("tagList", SpringBeanHolder.getBean(TagService.class).getListView()); 
			%>
  <head>
  	<base href="${pageContext.request.contextPath}/">
  	<link href="resources/img/profil.jpg" rel="icon" />
  	<link rel="canonical" href="http://www.javalog.com/index" />
  	<meta property="og:title" content="En Sade Java Bloğu | Javalog" />
	<meta property="og:type" content="article" />
	<meta property="og:url" content="http://www.javalog.ml/" />
	<meta property="og:site_name" content="Javalog" />
	<meta property="og:description" content="Bir Javacının Bloğu" />
	<meta property="article:published_time" content="2017-12-25T20:01:49Z" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Bir Javacının Bloğu">
    <meta name="author" content="Ömer Bayrak">
    
    <title>${fn:toUpperCase(fn:substring(title, 0, 1))}${fn:toLowerCase(fn:substring(title, 1,fn:length(title)))} | Javalog</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <link href="resources/css/template.css" rel="stylesheet">
  </head>
  <body>
    <header>
      <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-orange font-menu" style="min-height: 56px">
        <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/"><i class="fa fa-book fa-lg" aria-hidden="true"></i></a>
  
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="">Anasayfa <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about/omer-byrk">Ben kimim ?</a>
            </li>
            <c:if test="${not empty admin}">
            	<li class="nav-item">
	              <a class="nav-link" href="admin/panel/">Panel</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="admin/blogs/unpublished">Yayınlanmamış Blog</a>
	            </li>
            </c:if>
          </ul>
          <form class="form-inline m-0" action="search">
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
              <input type="text" name="query" class="form-control" id="search-box" placeholder="Search">
              <button class="btn btn-secondary input-group-addon cursorable" type="submit"><i class="fa fa-search fa-lg" aria-hidden="true"></i></button>
            </div>
          </form>
        </div>
      </nav>
    </header>

    <div class="container-fluid">
      <div class="row">
        <nav id="sidebar-left" class="sidebar col-3 col-xl-2 bg-inverse sidebar-left custom-hidden-sm-down text-white">
           <div class="sidebar-content mx-1 d-flex flex-column">
             <div class="social-account d-flex justify-content-center mt-3">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a class="fa fa-facebook-official fa-2x text-white" aria-hidden="true" href="https://www.facebook.com/OmerByrk06" target="blank"></a>
                    <a class="fa fa-youtube-play fa-2x ml-4 text-white" aria-hidden="true" href="https://www.youtube.com/channel/UC1qoi-m7O9ba2B0eeHZ5lmg" target="blank"></a>
                    <a class="fa fa-quora fa-2x ml-4 text-white" aria-hidden="true" href="https://www.quora.com/profile/%C3%96mer-Bayrak-3" target="blank"></a>
                </div>
             </div>

             <div class="profil-photo rounded mt-3 mx-4 row justify-content-center">
                <img  src="resources/img/profil.jpg" class="border border-white rounded-circle" width="200px" height="200px">
             </div>
			<hr class="w-100 my-3"/>
             <div class="about-me mx-3 row">
             	<div>
	                <ul class="list-group">
	                  <li>
	                    <div class="list-inline-item list-img fa fa-user fa-lg" aria-hidden="true"></div>
	                    <span class="list-group-item-text ">Ömer Bayrak</span>
	                  </li>
	                  <li>
	                    <div class="list-inline-item list-img fa fa-phone fa-lg" aria-hidden="true"></div>
	                    <span class="list-group-item-text ">0545 760 78 45</span>
	                  </li>
	                  <li data-toggle="tooltip" data-placement="bottom" title="omerbayrak1995@gmail.com">
	                    <div class="list-inline-item list-img fa fa-envelope-o fa-lg" aria-hidden="true"></div>
	                    <abbr class="list-group-item-text" title=""><u>omer...19..ail.com</u></abbr>
	                  </li>
	                </ul>
                </div>
                
                <div class="mt-4 col-xs-12 jumbotron-fluid text-white text-justify">
                  <h6 class="h6">Ben kimim ?</h6>
                  <div style="font-size: 14px">
                    Java hakkında kendimi geliştiriyorum. Elimden geldiğince blog yazıyorum.
                    Freelancer olarak çalışıyorum fakat şuan <span class="text-success">boştayım...</span>
                  </div>
                  <a href="about/omer-byrk" class="button button-border button-tiny float-right mt-3 cursorable">Devamı için tıklayınız</a>
                </div>
              </div>
           </div>
        </nav>

        <main id="main" role="main" class="col-12 bg-light offset-0 offset-md-3 offset-xl-2 col-md-6 col-lg-7 col-xl-8  p-0">
          <button id="sidebar-button-left" type="button" class="button glow button-caution px-2 hidden-md-up sidebar-button" aria-hidden="true" style="left: 0;"> <i class="fa fa-male fa-2x"></i> </button>
          <button id="sidebar-button-right" type="button" class="button button-caution px-2 hidden-md-up sidebar-button" aria-hidden="true" style="right: 0px;"><i class=" fa fa-bars fa-2x"></i></button>
          <header class="main-header" style="height: 300px;">
            <img src="https://i.hizliresim.com/1GzMNY.jpg" height="100%" width="100%">
          </header>

          <section class="main-content p-3">
            <div class="rounded border-orange" style="min-height: 500px">
				
		  
				