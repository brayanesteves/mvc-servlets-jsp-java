<%-- 
    Document   : naturalPerson
    Created on : Nov 26, 2023, 5:50:07 PM
    Author     : brayan
--%>

<%@taglib prefix="naturalperson" uri="http://java.sun.com/jsp/jstl/core" %>%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="0;url=${pageContext.request.contextPath}/NaturalPersonController" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management - Natural Persons</title>
    </head>
    <body>
        <h1>Management - Natural Persons</h1>
        <ul>
            <naturalperson:forEach var="naturalPersons" items="${naturalpersons}">
                <li>${naturalpersons.reference} | ${naturalpersons.identificationDocument}</li>
            </naturalperson:forEach>
        </ul>
    </body>
</html>
