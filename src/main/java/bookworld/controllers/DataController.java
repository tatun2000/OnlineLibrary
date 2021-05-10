package bookworld.controllers;

import bookworld.validators.StringValidator;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.commons.lang3.StringEscapeUtils;

@WebServlet(name = "DataController", urlPatterns = "/requesthandler")
public class DataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8"); //For the output of Russian characters

        RequestController requestController =
                RequestController.getRequestParameters(request);

        List<String> violations = requestController.validate();
        requestController.setRequestAttribute(request);

        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
        } else {
            List<String> books = requestController.getBooks(request);
            request.setAttribute("books", books);
        }

        String url = determineUrl(violations);
        request.getRequestDispatcher(url).forward(request, response);
    }

    private String determineUrl(List<String> violations){
        if (!violations.isEmpty())
            return "/WEB-INF/views/violations.jsp";
        else
            return "/WEB-INF/views/listofbooks.jsp";
    }
}

class RequestController{
    private final String nameOfBook;
    private final String author;

    private RequestController(String nameOfBook, String author){

        // Translating html special characters to unicode
        this.nameOfBook = StringEscapeUtils.unescapeHtml4(nameOfBook);
        this.author = StringEscapeUtils.unescapeHtml4(author);
    }
    public static RequestController getRequestParameters(
            HttpServletRequest request){
        return new RequestController(
                request.getParameter("nameOfBook"),
                request.getParameter("author"));
    }

    public void setRequestAttribute(HttpServletRequest request){
        request.setAttribute("author", author);
    }

    // Checking for incorrect user input
    public List<String> validate() {
        List<String> violations = new ArrayList<>();
        if (!StringValidator.validateBook(nameOfBook)){
            violations.add("Incorrect book title");
        }
        if(!StringValidator.validateAuthor(author)){
            violations.add("Invalid author name");
        }
        return violations;
    }

    // Depending on what information the user entered, we give out a list of books
    public List<String> getBooks(HttpServletRequest request){
        List<String> books = new ArrayList<>();
        if (nameOfBook.length() == 0 && author.length() != 0)
            books = HandlerDatabaseQueryConditions.getBooksIfThereOnlyAuthor(
                    author);
        if (author.length() == 0 && nameOfBook.length() != 0)
            books = HandlerDatabaseQueryConditions.getBooksIfThereOnlyNameOfBook(
                    nameOfBook, request);
        if (author.length() != 0 && nameOfBook.length() != 0)
            books = HandlerDatabaseQueryConditions.getBooksIfThereBothATitleAndAuthor(
                    author, nameOfBook);
        return books;
    }
}