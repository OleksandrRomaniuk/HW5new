package ua.com.sourceit.hw4;

public interface Books <T1, T2, T3, T4, T5, T6, T7 extends Number>
{
    
    public T1 getId();

    public T2 getName();

    public T3 getAuthor();

    public T4 getPublishers();

    public T5 getYear();

    public T6 getPages();

    public T7 getPrice();

    public boolean getCover();

}
