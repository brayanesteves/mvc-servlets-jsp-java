<%-- 
    Document   : deployVariables
    Created on : Nov 24, 2023, 7:24:03 PM
    Author     : Brayan Esteves [brayan.esteves93@gmail.com]
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deploy Variables</title>
    </head>
    <body>
        <h1>Deploy Variables</h1>
        Request scope variables: ${message}
        <br />
        Request scope variables: ${messageAction}
        <br />
        Variable scope session
        <br />
        Rectangle:
        <br />
        Base: ${rectangle.base}
        <br />
        Hight: ${rectangle.hight}
        <br />
        Area: ${rectangle.area}
        <br />
        <a href="${pageContext.request.contextPath}/rectangle.jsp">Home</a>
    </body>
</html>
