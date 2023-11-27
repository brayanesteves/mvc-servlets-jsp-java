<%-- 
    Document   : naturalPerson
    Created on : Nov 26, 2023, 5:50:07 PM
    Author     : brayan
--%>

<%@taglib prefix="naturalperson" uri="http://java.sun.com/jsp/jstl/core" %>%>


<jsp:include page="../WEB-INF/pages/commons/buttonNav.jsp" />

<ul>
    <naturalperson:forEach var="naturalPersons" items="${naturalpersons}">
        <li>${naturalpersons.reference} | ${naturalpersons.identificationDocument}</li>
    </naturalperson:forEach>
</ul>