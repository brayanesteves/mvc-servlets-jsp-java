<%-- 
    Document   : index
    Created on : Nov 24, 2023, 7:42:54 PM
    Author     : Brayan Esteves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rectangle</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Rectangle</h1>
        <br />
        <a href="${pageContext.request.contextPath}/RectangleController">Link to Servlet controller deploy variables.</a>
        <br />
        <a href="${pageContext.request.contextPath}/RectangleController?action=addVariables">Add</a>
        <br />
        <a href="${pageContext.request.contextPath}/RectangleController?action=listVariables">List</a>
    </body>
</html>