package ua.com.sourceit.hw4;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import ua.com.sourceit.exceptions.BookException;

public class BooksManager
{
    private static Book[] books;
    private static BooksManager instance;
    private BooksManager()
    {
    }
    
    public static BooksManager getInstance()
    {
        if (instance == null)
            instance = new BooksManager();
        return instance;
    }
    
    public Book[] getBooks()
    {
        return books;
    }
    
    public void addBook(String name, String author, String publisher, short year, short pages, BigDecimal price, boolean cover)
    {
        
        long id = getId();
        if(books == null)
            {
                books = new Book[1];
                books[0] = new Book(id, name, author, publisher, year, pages, price, cover);
            }
        else
            {
                
                Book[] tempBooks = new Book[books.length + 1]; 
                for(int i = 0; i < books.length; i++)
                    {
                        tempBooks[i] = books[i];
                    }
                tempBooks[books.length] = new Book(id, name, author, publisher, year, pages, price, cover);
                books = tempBooks;
            }
    }
    
    public void addBook()
    {
        long id = getId();
        String name = getName();
        String author = getAuthor();
        String publisher = getPublisher();
        short year = getYear();
        short pages = getPages();
        BigDecimal price = getPrice();
        boolean cover = getCover();
        
        if(books == null)
            {
                books = new Book[1];
                books[0] = new Book(id, name, author, publisher, year, pages, price, cover);
            }
        else
            {
                Book[] tempBooks = new Book[books.length + 1]; 
                for(int i = 0; i < books.length; i++)
                    {
                        tempBooks[i] = books[i];
                    }
                tempBooks[books.length] = new Book(id, name, author, publisher, year, pages, price, cover);
                books = tempBooks;
            }
    }
    
    private long getId()
    { 
        long[] ids = null;
        long id;
        if(books != null)
            {
                ids = new long[books.length];
                
                for(int i = 0; i < books.length; i++)
                {
                   ids[i] = (long) books[i].getId();
                }
                id = getMax(ids) + 1;
            }
        else 
            id = 1;
        
        return id;
    }
    
    private String getName()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the name of the book: ");
        
        String name = sc.next();
        
        return name;
    }
    
    private String getAuthor()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the author of the book: ");
        
        String author = sc.next();
        
        return author;
    }
    
    private String getPublisher()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the publisher of the book: ");
        
        String publisher = sc.next();
        
        return publisher;
    }
    
    private short getYear()
    {
        System.out.print("Please enter the year (numbers only). ");
        
        return (new CheckNumber()).checkNumber("Please enter a number from 0 to "+Calendar.getInstance().get(Calendar.YEAR)+": ", (short)Calendar.getInstance().get(Calendar.YEAR));
    }
    
    private short getPages()
    {
        System.out.print("Please enter the number of pages (numbers only): ");
        
        return (new CheckNumber()).checkNumber("Please enter a number from 0 to 20.000: ", (short) 20000);
    }
    
    private BigDecimal getPrice()
    {
        
        System.out.print("Please enter the price (numbers only): ");
        
        return (new CheckNumber()).checkNumber("Please enter a number from 0 to 1.000.000: ", new BigDecimal(1000000));
    }
    
    private boolean getCover()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the type of binding (soft or hard): ");
        
        String st = sc.next();
        
        while (!st.equals(Covers.Hard.toString().toLowerCase()) &&  !st.equals(Covers.Soft.toString().toLowerCase()))
        {
            System.out.print("Please enter \"soft\" or \"hard\" ");
            sc.next();
        }
        
        if(st.equals(Covers.Hard.toString().toLowerCase()))
            return true;
        else 
            return false;        
    }
    
    private long getMax(long[] id)
    {
        long max = 1;
        for(long item: id)
        {
            if(max < item)
                max = item;
        }
        return max;
    }
}


enum Covers
{
    Hard, Soft;
}
