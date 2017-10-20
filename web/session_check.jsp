<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user!=null or admin!=null}">
    <c:redirect url="home.jsp"/>
</c:if>
