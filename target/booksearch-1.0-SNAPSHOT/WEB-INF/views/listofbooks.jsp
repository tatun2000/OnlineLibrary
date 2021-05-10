<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf8" />
    <title>Result</title>
</head>
<body>
<h1>List of found books</h1><br>
<c:if test="${!books.isEmpty()}">
    <h3>Author: ${author}</h3>
    <c:forEach var="book" items="${books}">
        <p>${book}</p>
    </c:forEach>
</c:if>
<c:if test="${books.isEmpty()}">
    <p>No books found for your search</p>
</c:if>
</body>
</html>