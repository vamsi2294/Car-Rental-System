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
        <script src="script/home.js"></script>
        <title>Home</title>
    </head>
    
    <body>
       
            <c:if test="${itemsList.isEmpty()}">
                 <div class="jumbotron" id="jumbo">
                    <h1 class="col-md-offset-3">No items in the market</h1>      
                </div>
            </c:if>
            
            <c:if test="${itemsList!=null and !itemsList.isEmpty()}">
                
                <c:forEach var="itemslist" items="${itemsList}">
                <div class="container" style="margin-top: -100px">
                   <div class="media">                            
                   
                    <div class="media-body">
                  <div class="panel panel-default">
                  <div class="panel-heading"><h1 class="media-heading">${itemslist.name}
                          <button class="btn btn-info  label-success pull-right" name="${itemslist.item_id}">Add to Cart</button>
                 
                      </h1>
                       </div>
      <div class="panel-body">
          <div class="media-left">
                   <img src="getimage.jsp?item=${itemslist.item_id}" class="media-object" width="620" height="350">
                   </div>
                   <div class="media-right">
                   <ul style="list-style-type">
                        <li><h3>Type:<c:out value="${itemslist.description}"/></h3></li>
                        <li><h3>Price:$<c:out value="${itemslist.price}"/> per day</h3></li>
                        <li><h3>Type:<c:out value="${itemslist.item_type}"/></h3></li>
                        </ul>
                   </div>
                     
                       </div>
                     </div>                         
                    </div>
                  </div>
                    </div>    
                </c:forEach>
            </c:if> 
                 
    </body>
</html>
