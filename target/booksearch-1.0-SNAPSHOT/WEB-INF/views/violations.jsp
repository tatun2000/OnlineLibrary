<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf8" />
    <title>Violations</title>
</head>
<body>
<h1>List of Violations!</h1><br>
<c:if test="${violations != null}">
    <c:forEach var="violation" items="${violations}">
        <p>${violation}!</p>
    </c:forEach>
</c:if>
</body>
</html>