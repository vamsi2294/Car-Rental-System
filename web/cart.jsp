<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
        <script src="script/cart.js"></script>
    </head>
    
    <body>
        <div class="container">
           
            <c:if test="${cartItemsList==null or cartItemsList.isEmpty()}">
                <div class="jumbotron" id="jumbo">
                    <h1 class="col-md-offset-3">No items in Cart</h1>      
                </div>
            </c:if>
            
            <c:if test="${cartItemsList!=null}">
                
                <c:forEach var="itemslist" items="${cartItemsList}">
                    <div class="media">
                    <div class="media-left">
                      <img src="getimage.jsp?item=${itemslist.item_id}" class="media-object" width="180">
                       <button class="btn btn-danger" name="${itemslist.item_id}">Remove</button>
                   
                    </div>
                    <div class="media-body">
                      <h1 class="media-heading"><c:out value="${itemslist.name}"/>
                      <button class="btn btn-success label-info pull-right">Checkout</button></h1>
                        <ul style="list-style-type:none">
                             <li><span class="label label-success ">Price</span>:  $<c:out value="${itemslist.price}"/></li>
                        </ul>
                        
                    </div>
                  </div>
                    <hr>
                    
                </c:forEach>
            </c:if>
            
        </div>
    </body>
</html>
