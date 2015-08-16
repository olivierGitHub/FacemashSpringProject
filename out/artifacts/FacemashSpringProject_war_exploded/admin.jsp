<%--
  Created by IntelliJ IDEA.
  User: oliver
  Date: 06/08/15
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
</c:if>
</body>
</html>
