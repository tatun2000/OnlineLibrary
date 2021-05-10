<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf8" />
    <title>Search</title>
</head>
<body>
    <h1>Book Search</h1><br>
    <h3>Please, enter the author or name of book</h3><br>
    <form action="${pageContext.request.contextPath}/requesthandler" method="post">
        <fieldset>
            <legend>Information about the book</legend>
            <label for="nameOfBook">Enter the name of the book</label>
            <input id="nameOfBook" type="text" name="nameOfBook" autofocus><br>
            <label for="author">Enter the author of the book</label>
            <input id="author" type="text" name="author" autofocus><br>
            <input type="submit" value="Search">
        </fieldset>
    </form>
    <br><br>
</body>
</html>