Hello.
In this project, I implemented Client-Server interaction using the Java Servlet API.

To implement this interaction, I created my own web application that can be used to search for books in an online library.

Step-by-step description of the system:
1. The user is provided with 2 fields for entering data (Book title, Last name and First name of the author of the book)(see Image 1).
2. By clicking on the "Search" button, the user will be taken to the corresponding page, where the resulting list of books he needs will be formed (see Images 2-4).

If you enter some information incorrectly, such as the author's name, a corresponding message will be displayed (see Image 5).
If you enter incomplete, inaccurate, or information about the book that is not in the database, the corresponding message will also be displayed (see Image 6).

Note.
All information about books is taken from the MySQL database - see Image 7 (Connected in the module main.java.bookworld.controllers.ConnectDB).

Servlet: main.java.bookworld.controllers.DataController.java

Validator :main.java.bookworld.validators.StringValidator.java
