<%@include file="header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    </head>
    
    <body>
         <div class="container">
             
             <c:if test="${Message!=null}">
                 <div class="row">
                   <div class="col-md-offset-4 col-md-5">
                       <div class="alert alert-info alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>${Message}</strong>  
                      </div>
                   </div>
               </div> 
             </c:if>  
             
            <div class="row">
                <div class="col-md-offset-3 col-md-7">
            
                    <div class="panel panel-default">
                        <div class="panel-heading">Enter email:</div>
                        <div class="panel-body">
                            <form method="post" action="SendEmail">
                                <input type="hidden" name="action" value="login">
                        
                                <div class="input-group">
                                  <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                  <input id="email" type="email" class="form-control" name="email" placeholder="Email" required>
                                </div><br>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>   
                    </div>
                
                </div>
            
            </div>
        </div>

    </body>
</html>

