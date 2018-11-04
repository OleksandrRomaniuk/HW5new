package ua.com.sourceit.hw4;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        BooksManager item = BooksManager.getInstance();
        item.addBook("War and peace", "Leo", "Lux", (short)1991, (short)10000, new BigDecimal(1000), true);
        item.addBook("War", "Leo", "Ukr", (short)2017, (short)999, new BigDecimal(1000), false);
        item.addBook("Peace", "Kate", "Ukr", (short)2014, (short)876, new BigDecimal(1000), false);
        item.addBook("Star wars", "Alex", "Lux", (short)2011, (short)1988, new BigDecimal(1000.89), true);
        item.addBook("Luxembourg", "Matt", "Lux", (short)2001, (short)986, new BigDecimal(1000.89), true);
        item.addBook("Germany", "Leo", "Lux", (short)2017, (short)10000, new BigDecimal(1000.89), true);
        item.addBook();
        
        BookFilter bf = new BookFilter(BooksManager.getInstance().getBooks());
        bf.printAll();
        
        bf.filterByAuthor();
        bf.filterByPublisher();
        bf.filterByYear();
        
    }

}
