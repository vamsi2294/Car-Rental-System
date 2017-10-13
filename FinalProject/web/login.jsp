<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="script/login.js"></script>
    </head>
    
    <body>
       <div class="container">
           <c:if test="${requestScope.success=='success'}">
               <div class="row">
                   <div class="col-md-offset-4 col-md-5">
                       <div class="alert alert-success alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Signup successfull</strong>  
                      </div>
                   </div>
               </div>    
           </c:if>
           
           <c:if test="${requestScope.success=='invalid'}">
               <div class="row">
                   <div class="col-md-offset-4 col-md-5">
                       <div class="alert alert-danger alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Invalid login details</strong>
                      </div>
                   </div>
               </div>    
           </c:if>
           
           
           <div class="row">
               <div class="col-md-offset-4 col-md-5" id="login">
                    <form method="post" action="UserController">
                        
                        <input type="hidden" name="action" value="login">
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                          <input id="email" type="email" class="form-control" name="email" placeholder="Email" required>
                        </div><br><br>
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                          <input id="password" type="password" class="form-control" name="password" placeholder="Password" required>
                          <span id="eye" class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>   
                        </div><br>
                        <div class="btn-toolbar">
                            <button type="submit" class="btn btn-default col-md-offset-2">Submit</button>
                            <a href="forgotpassword.jsp" class="btn btn-default pull-right">Forgot Password</a>
                        </div>
                    </form>
               </div>
        
           </div>

      </div>

    </body>
</html>
