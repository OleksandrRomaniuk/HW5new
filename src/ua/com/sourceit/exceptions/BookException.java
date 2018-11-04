package ua.com.sourceit.exceptions;

public class BookException extends Exception
{
    private String message;
    
    public BookException(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        if(message != null)
            return "No message available";
        else
            return message;
    }
}
