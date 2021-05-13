package Deposit;

import java.math.BigDecimal;
import java.util.Date;


public class DepositDecoder {
    
    public static DepositPost GetDepositStartPost(String data)
    {
       DepositPost post = new DepositPost();
       post.setPosttype(data.substring(0, 2));
       post.setReservedNumber1(data.substring(2, 10));
       post.setClearingNumber(data.substring(10, 14));
       post.setAccountNumber(data.substring(14, 24));
       post.setReservedNumber2(data.substring(24, 80));
       var depositDate = new Date();
       post.setDate(depositDate);
       post.setCurrency("SEK");
       return post;
    }
    
    public static DepositPost getDepositPaymentPost(String data)
    {
        DepositPost post = new DepositPost();
        post.setPosttype(data.substring(0, 2));
        String amount = (data.substring(2, 22)); 
        BigDecimal b  = new BigDecimal(amount);
        var correctAmount = b.setScale(2);           
        post.setAmount(correctAmount);
        post.setReservedNumber1(data.substring(22, 40));
        post.setReference(data.substring(40,65).trim());
        
        
        return post;
    }
  
    
}   