<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scope Variables</title>
    </head>
    <body>
        <h1>Scope Variables</h1>
        <br />
        Variable request:
        <br />
        Base: ${rectangleRequest.base}
        <br />
        Height: ${rectangleRequest.height}
        <br />
        Area: ${rectangleRequest.area}
        <br />
        <br />
        Variable session:
        <br />
        Base: ${rectangleSession.base}
        <br />
        Height: ${rectangleSession.height}
        <br />
        Area: ${rectangleSession.area}
        <br />
        <br />
        Variable application:
        <br />
        Base: ${rectangleApplication.base}
        <br />
        Height: ${rectangleApplication.height}
        <br />
        Area: ${rectangleApplication.area}
        <br />
        <a href="${pageContext.request.contextPath}/index.jsp">Back home</a>
    </body>
</html>
