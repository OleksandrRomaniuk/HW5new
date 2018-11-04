package ua.com.sourceit.hw4;

import java.math.BigDecimal;
import java.util.Scanner;

public class CheckNumber
{
    public <T1 extends Number> T1 checkNumber(String message, T1 criteria)
    {
        Scanner sc = new Scanner(System.in);
        T1 num = null;
        String st = null;
        
        do 
        {
            System.out.print(message);
            st = sc.next();
            
        } while(!isPrimitive(st));
        
            if(criteria instanceof BigDecimal)
                num = (T1) new BigDecimal(st);
            else
                num = (T1) Short.valueOf(st);
                
        if(num.intValue() < 0 || num.intValue() > criteria.intValue())
        {
            num = checkNumber(message, criteria);
        }
        
        return num;
    }
    
    private boolean isPrimitive(String value)
    {
        boolean status=true;
        if(value.length()<1)
            return false;
        for(int i = 0;i<value.length();i++)
        {
            char c=value.charAt(i);
            if(Character.isDigit(c) || c=='.')
            {

            } else
            {
                status=false;
                break;
            }
        }
        return status;
    }
}
