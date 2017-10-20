<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="script/signup.js"></script>
    </head>
    
    <body>
       <div class="container">
           
           <div class="row" id="alert">
               <div class="col-md-offset-3 col-md-7">
                    <div class="alert alert-warning alert-dismissable">
                        <a href="#" class="close">&times;</a>
                        <strong class="col-md-offset-1">Passwords not matched</strong>
                    </div>
               </div>
           </div>
           
           <div class="row" id="alert1">
               <div class="col-md-offset-3 col-md-7">
                    <div class="alert alert-warning alert-dismissable">
                        <a href="#" class="close">&times;</a>
                        <strong class="col-md-offset-1">Password must be more than 6 characters</strong>
                    </div>
               </div>
           </div>
           
           <div class="row">
               <div class="col-md-offset-4 col-md-5" id="signup">
                   <form method="post" action="UserController">
                        
                        <input type="hidden" name="action" value="signup">
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                          <input id="name" type="text" class="form-control" name="name" placeholder="Name" required>
                        </div><br>
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                          <input id="email" type="email" class="form-control" name="email" placeholder="Email" required>
                        </div><br>
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                          <input id="address" type="text" class="form-control" name="address" placeholder="Address" required>
                        </div><br>
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                          <input id="password" type="password" class="form-control" name="password" placeholder="Password" required>
                          <span id="eye" class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>   
                        </div><br>
                        
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                          <input id="retype-password" type="password" class="form-control" name="retype-password" placeholder="Retype Password" required>
                          <span id="eye1" class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span>   
                        </div><br>
                        
                        <button type="submit" class="btn btn-default col-md-offset-5">Submit</button>
                       
                    </form>
               </div>     
           </div>

      </div>
    </body>
</html>