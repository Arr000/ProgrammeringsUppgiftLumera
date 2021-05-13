
package Payment;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentDecoder {
    
     public static PaymentPost GetPaymentStartPost(String data) throws ParseException
    {
       PaymentPost post = new PaymentPost();
       post.setPostType(data.substring(0,1));
       post.setClearingAndAccountNumber(data.substring(1, 16));
       BigDecimal amount = new BigDecimal(data.substring(17, 30).trim().replace(',', '.'));
       post.setSumOfAmount(amount);
       post.setNumberOfPayments(data.substring(30, 40).trim());
       DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
       var date = dateFormat.parse(data.substring(40, 48));
       post.setPaymentDate(date);
       post.setCurrency(data.substring(48, 51));
       
       return post;
    }
     
     public static PaymentPost getPaymentPost(String data)
     {
         PaymentPost post = new PaymentPost();
         post.setPostType(data.substring(0,1));
         BigDecimal amount = new BigDecimal(data.substring(1, 15).trim().replace(',', '.'));
         post.setAmount(amount);
         post.setReference(data.substring(15, 50).trim());
         
         return post;
     }
    
}
