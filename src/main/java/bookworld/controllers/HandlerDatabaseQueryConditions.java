package bookworld.controllers;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HandlerDatabaseQueryConditions {
    private ConnectDB connectDB;

    // The request contains only the author
    public static List<String> getBooksIfThereOnlyAuthor(String author){
        List<String> books = new ArrayList<>();
        try {
            ConnectDB.statement.executeQuery("USE lybrary;");
            ResultSet resultSet = ConnectDB.statement.executeQuery(
                    "SELECT a.nameOfBook, b.nameOfAuthor " +
                            "FROM LibraryDB AS a " +
                            "INNER JOIN Authors AS b ON a.authorId = b.authorId " +
                            "WHERE b.nameOfAuthor = "+ "\"" + author + "\"" +";");
            while (resultSet.next())
                books.add(resultSet.getString(1));
        }catch (SQLException exc){
            exc.getMessage();
        }
        return books;
    }

    // The request contains only the name of the book
    public static List<String> getBooksIfThereOnlyNameOfBook(String nameOfBook,
                                                      HttpServletRequest request){
        List<String> books = new ArrayList<>();
        try {
            ConnectDB.statement.executeQuery("USE lybrary;");
            ResultSet resultSet = ConnectDB.statement.executeQuery(
                    "SELECT a.nameOfBook, b.nameOfAuthor " +
                            "FROM LibraryDB AS a " +
                            "INNER JOIN Authors AS b ON a.authorId = b.authorId " +
                            "WHERE a.nameOfBook = "+ "\"" + nameOfBook + "\"" +";");
            while (resultSet.next()) {
                books.add(resultSet.getString(1));
                request.setAttribute("author", resultSet.getString(2));
            }
        }catch (SQLException exc){
            exc.getMessage();
        }
        return books;
    }

    // The request contains only the title of the book and the author
    public static List<String> getBooksIfThereBothATitleAndAuthor(String author,
                                                                  String nameOfBook){
        List<String> books = new ArrayList<>();
        try {
            ConnectDB.statement.executeQuery("USE lybrary;");
            ResultSet resultSet = ConnectDB.statement.executeQuery(
                    "SELECT a.nameOfBook, b.nameOfAuthor " +
                            "FROM LibraryDB AS a " +
                            "INNER JOIN Authors AS b ON a.authorId = b.authorId " +
                            "WHERE b.nameOfAuthor = "+ "\"" + author + "\" " +
                            "AND a.nameOfBook = "+ "\"" + nameOfBook + "\"" +";");
            while (resultSet.next())
                books.add(resultSet.getString(1));
        }catch (SQLException exc){
            exc.getMessage();
        }
        return books;
    }
}
