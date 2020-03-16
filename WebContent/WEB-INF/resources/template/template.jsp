<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="#{pageContext.request.contextPath}/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Template</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Buttons/2.0.0/css/buttons.css" integrity="sha256-IuYj824vGYFmR4cdSuPtcZ+KTtVpEv7t0EkYV9lbWtA=" crossorigin="anonymous" />
    <link href="resources/css/template.css" rel="stylesheet">
  </head>

  <body>
    <header>
      <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-orange" style="min-height: 56px">
        <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Java Blog</a>
  
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Settings</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Help</a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0">
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
              <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Search">
              <button class="button p-3 input-group-addon cursorable" type="submit"><i class="fa fa-search fa-lg" aria-hidden="true"></i></button>
            </div>
          </form>
        </div>
      </nav>
    </header>

    <div class="container-fluid">
      <div class="row">
        <nav id="sidebar-left" class="sidebar col-3 col-lg-2 bg-inverse sidebar-left hidden-sm-down text-white">
           <div class="sidebar-content mx-1 d-flex flex-column">
             <div class="social-account d-flex justify-content-center mt-3">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a class="fa fa-facebook-official fa-2x text-white" aria-hidden="true" href="https://www.facebook.com" target="blank"></a>
                    <a class="fa fa-youtube-play fa-2x ml-4 text-white" aria-hidden="true" href="https://www.youtube.com" target="blank"></a>
                    <a class="fa fa-instagram fa-2x ml-4 text-white" aria-hidden="true" href="https://www.instagram.com" target="blank"></a>
                </div>
             </div>

             <div class="profil-photo rounded mt-3 mx-4" style="height: 240px">
                <img  src="resources/img/profil.jpg" class="border-white" width="100%" height="100%">
             </div>

             <div class="about-me mt-4 mx-2 col-xs-12 text-justify">
                <ul class="list-group px-3">
                  <li class="list-group-item-info text-white bg-inverse">
                    <div class="list-inline-item list-img fa fa-user fa-lg" aria-hidden="true"></div>
                    <span class="list-group-item-text ">Ömer Bayrak</span>
                  </li>
                  <li class="list-group-item-success text-white bg-inverse">
                    <div class="list-inline-item list-img fa fa-phone fa-lg" aria-hidden="true"></div>
                    <span class="list-group-item-text ">0545 760 78 45</span>
                  </li>
                  <li class="list-group-item-success text-white bg-inverse" data-toggle="tooltip" data-placement="bottom" title="omerbayrak1995@gmail.com">
                    <div class="list-inline-item list-img fa fa-envelope-o fa-lg" aria-hidden="true"></div>
                    <abbr class="list-group-item-text" title=""><u>omer...19..ail.com</u></abbr>
                  </li>
                </ul>
                
                <div class="mt-2 col-xs-12 jumbotron-fluid text-white">
                  <h6 class="h6">Ben kimim ?</h6>
                  <div style="font-size: 14px">
                    Java hakkında kendimi geliştiriyorum. Elimden geldiğince blog yazıyorum.
                    Freelancer olarak çalışıyorum fakat şuan <span class="text-success">boştayım...</span>
                  </div>
                  <a href="#" class="button button-border button-tiny float-right mt-3 cursorable">Devamı için tıklayınız</a>
                </div>
              </div>
           </div>
        </nav>

        <main id="main" role="main" class="col-12 bg-light offset-0 offset-md-3 col-md-6 col-lg-8 offset-lg-2 p-0">
          <button id="sidebar-button-left" type="button" class="btn btn-secondary btn-sm hidden-md-up rounded-0 sidebar-button fa fa-male fa-2x" aria-hidden="true" style="left: 0;"></button>
          <button id="sidebar-button-right" type="button" class="btn btn-secondary btn-sm hidden-md-up rounded-0 sidebar-button fa fa-bars fa-2x" aria-hidden="true" style="right: 0px;"></button>
          <header class="main-header" style="height: 300px;">
            <img src="resources/img/header.jpg" height="100%" width="100%">
          </header>

          <section class="main-content p-3">
            <div class="rounded border-orange" style="min-height: 500px">

            </div>
          </section>
        </main>

        <nav id="sidebar-right" class="sidebar col-3 col-lg-2 bg-faded sidebar-right hidden-sm-down bg-inverse text-white m-0">
          <div class="sidebar-content d-flex flex-column p-1">
            
            <h5><i class="fa fa-bars mt-2" aria-hidden="true"></i> Kategoriler</h5>
            <div class="category-list col-sm-12 p-0">
              <a href="#" class="button button-block button-rounded button-3d button-small mt-3 cursorable">Java</a>
              <a href="#" class="button button-block button-rounded button-3d button-small mt-3 cursorable">Java EE</a>
              <a href="#" class="button button-block button-rounded button-3d button-small mt-3 cursorable">Günlük</a>
            </div>

            <h6><i class="fa fa-tags mt-5" aria-hidden="true"></i> Etiketler</h6>

            <div class="tag-list col-sm-12 p-0">
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Spring</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Hibernate</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Java</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Security</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Come</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Aaaaa</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Spring-Boot</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">Boot</a>
              <a href="#" class="button button-rounded button-tiny px-2 cursorable">AKle</a>
            </div>
          </div>
        </nav>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="resources/js/template.js"></script>
  </body>
</html>