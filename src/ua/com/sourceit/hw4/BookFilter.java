package ua.com.sourceit.hw4;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import ua.com.sourceit.exceptions.BookException;

public class BookFilter
{
    private Books[] array = null;
    
    private BookFilter(){}
    
    public BookFilter(Books[] array)
    {
        this.array = array;
    }
    
    public void filterByAuthor()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of author to filter: ");
        String author = sc.next();
        printBooks(filterAuthor(author));
    }
    
    public void filterByPublisher()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of publisher to filter: ");
        String publisher = sc.next();
        printBooks(filterPublisher(publisher));
    }
    
    public void filterByYear()
    {
        System.out.print("Please enter the year to filter: ");
        
        short year = (new CheckNumber()).checkNumber("Please enter a number from 0 to "+Calendar.getInstance().get(Calendar.YEAR)+": ", (short)Calendar.getInstance().get(Calendar.YEAR));
        
        printBooks(filterYear(year));
    }
    
    public void printAll()
    {
        System.out.println("All books: ");
        printBooks(array);
    }
    
    private Books[] filterAuthor(String author)
    {
        Books[] books = Arrays.stream(array).filter(book -> book.getAuthor().equals(author)).toArray(Books[]::new);
    
        return books;
    }
    
    private Books[] filterPublisher(String publisher)
    {
        Books[] books = Arrays.stream(array).filter(book -> book.getPublishers().equals(publisher)).toArray(Books[]::new);
    
        return books;
    }
    
    private Books[] filterYear(short year)
    {
        Books[] books = Arrays.stream(array).filter(book -> (short)book.getYear() > year).toArray(Books[]::new);
    
        return books;
    }
    
    private void printBooks(Books[] books)
    {
        for(Books book: books)
        {
            String cover = null;
            if(book.getCover())
                cover = "hard";
            else
                cover = "soft";
            
            System.out.println(book.getId()+" - "+book.getName()+" - "+book.getAuthor()+" - "+book.getPublishers()+" - "+book.getPages()+" - "+book.getYear()+" - "+cover+" - "+book.getPrice());
        }
    }
    
}
