package ua.com.sourceit.hw4;

import java.math.BigDecimal;

public class Book<T1, T2, T3, T4, T5, T6, T7 extends Number> implements Books 
{
    private final T1 id; 
    private final T2 name;
    private final T3 author;
    private final T4 publishers;
    private final T5 year;
    private final T6 pages;
    private T7 price;
    private final boolean cover;

    public Book(T1 id, T2 name, T3 author, T4 publishers, T5 year, T6 pages, T7 price, boolean cover)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishers = publishers;
        this.year = year;
        this.pages = pages;
        this.cover = cover;
        this.price = price;
    }
    
    public void setPrice(T7 price)
    {
        this.price = price;
    }
    
    public T1 getId()
    {
        return id;
    }

    public T2 getName()
    {
        return name;
    }

    public T3 getAuthor()
    {
        return author;
    }

    public T4 getPublishers()
    {
        return publishers;
    }

    public T5 getYear()
    {
        return year;
    }

    public T6 getPages()
    {
        return pages;
    }

    public T7 getPrice()
    {
        return price;
    }

    public boolean getCover()
    {
        return cover;
    }
}