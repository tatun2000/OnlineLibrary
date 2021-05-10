package bookworld.validators;

public class StringValidator {
    public static boolean validateBook(String str) {
        // Checking for 10 or more digits in the book title
        if (str.matches("(.*[0-9]{10,}.*)"))
            return false;
        return true;
    }
    public static boolean validateAuthor(String str) {
        // Checking for the presence of at least one digit in the author's name
        if (str.matches("(.*[0-9]+.*)"))
            return false;
        return true;
    }
}
