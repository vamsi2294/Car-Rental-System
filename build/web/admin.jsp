<%@page import="java.util.List"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="admin_navbar.jsp"%>
<%@page import="java.sql.Blob" %>
<%@page import="Item.Item" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css">
        <script src="script/admin.js"></script>
        <title>Home</title>
    </head>
    
    <body>
       
        <div class="container">
            
            <c:if test="${itemsList.isEmpty()}">
                 <div class="jumbotron" id="jumbo">
                    <h1 class="col-md-offset-3">No items in the market</h1>      
                </div>
            </c:if>
            
            <c:if test="${itemsList!=null and !itemsList.isEmpty()}">
                
                <c:forEach var="itemslist" items="${itemsList}">
                    
                    <div class="col-md-offset-1 col-md-7">
                         <div class="media">
                    <div class="media-left">
                      <img src="getimage.jsp?item=${itemslist.item_id}" class="media-object" width="180">
                   <button id="approve" class="btn btn-success" name="${itemslist.item_id}">approve</button>
                   <button id="delete" class="btn btn-danger" name="${itemslist.item_id}">Delete item</button>
                    </div>
                    <div class="media-body">
                      <h1 class="media-heading">${itemslist.name}</h1>
                        
                         <ul style="list-style-type">
                          <li><p>Type:${itemslist.description}</p></li>
                          <li><p>Price:$${itemslist.price} per day</p></li>
                          <li><p>Type:${itemslist.item_type}</p></li>  
                        </ul> 
                       
                    </div>
                  </div>
                        <hr>
                    </div>
                    
                </c:forEach>
            </c:if>
            
          </div>
           
    </body>
</html>
