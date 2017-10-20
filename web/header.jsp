<%@include file="session_check.jsp" %>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<link rel="stylesheet" type="text/css" href="styles/demo.css" />
<link rel="stylesheet" type="text/css" href="styles/style1.css" />
<script type="text/javascript" src="script/modernizr.custom.86080.js"></script>

<ul class="cb-slideshow">
    <li><span>Image 01</span><div></div></li>
    <li><span>Image 02</span><div></div></li>
    <li><span>Image 03</span><div></div></li>
</ul>

<nav class="navbar navbar-inverse" style="background-color: #696969;">
  <div class="container-fluid">
    <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="login.jsp">Login</a>
    </div>
      <div class="collapse navbar-collapse" id="myNavbar">
           <ul class="nav navbar-nav">
              <li><a href="about.jsp">About Us</a></li>
              <li><a href="#" data-toggle="modal" data-target="#myModal">Contact</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
              <li class="pull-right"><a href="signup.jsp">Sign up</a></li>
          </ul>
      </div>
  </div>
</nav>

<div class="container"> 
 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Contact</h4>
        </div>
        <div class="modal-body">
            <p><strong>Contact Number:</strong> (xxx)xxx-xxxx</p>
            <p><strong>Email:</strong> abc@xxx.com</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>