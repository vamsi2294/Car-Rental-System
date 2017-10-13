<%@page import="java.util.List"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<%@page import="java.sql.Blob" %>
<%@page import="Item.Item" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css">
        <script src="script/items.js"></script>
        <title>Your items</title>
    </head>
    
    <body>
       
        <div class="container">
            <c:if test="${itemsList.isEmpty()}">
                 <div class="jumbotron" id="jumbo">
                    <h1 class="col-md-offset-3">You have uploaded no items</h1>      
                </div>
            </c:if>
            
            <c:if test="${itemsList!=null}">
                
                <c:forEach var="itemslist" items="${itemsList}">
                    <div class="media">
                    <div class="media-left">
                      <img src="getimage.jsp?item=${itemslist.item_id}" class="media-object" width="180">
                      <button class="btn btn-danger pull-middle" name="${itemslist.item_id}">Remove item</button>

                    </div>
                    <div class="media-body">
                        <h2 class="media-heading">${itemslist.name}
                        
                        <c:if test="${itemslist.status==1}">
                            <span class="label label-success pull-right" >Approved</span>
                        </c:if>
                        <c:if test="${itemslist.status==0}">
                            <span class="label label-warning pull-right" >Pending</span>
                        </c:if>   
                      <ul style="list-style-type">
                          <li><p>Type:${itemslist.description}</p></li>
                          <li><p>Price:$${itemslist.price} per day</p></li>
                          <li><p>Type:${itemslist.item_type}</p></li>  
                        </ul>  
                    </div>
                  </div>
                    <hr>
                    
                </c:forEach>
            </c:if>
                    
            
          </div>
           
    </body>
</html>
