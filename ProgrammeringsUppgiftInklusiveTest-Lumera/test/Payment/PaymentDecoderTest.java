
package Payment;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PaymentDecoderTest {
    
    public PaymentDecoderTest() {
    }
    
    @Test
    public void GetPaymentStartPost_Should_Decode_StartPost() throws ParseException {
         var data = "O5555 5555555555       4711,17         420110315SEK";
         PaymentPost result = PaymentDecoder.GetPaymentStartPost(data);
         BigDecimal sumOfAmount = new BigDecimal("4711.17");
         DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
         var date = dateFormat.parse("20110315");
        
        assertEquals("O", result.getPostType());
        assertEquals("5555 5555555555", result.getClearingAndAccountNumber());
        assertEquals(sumOfAmount, result.getSumOfAmount());
        assertEquals("4", result.getNumberOfPayments());
        assertEquals(date, result.getPaymentDate());
        assertEquals("SEK", result.getCurrency());
        
    }
    
    @Test
    public void GetPaymentPaymentPost_Should_Decode_PaymentPost()
    {
        var data ="B          30001234567890                         ";
        PaymentPost result = PaymentDecoder.getPaymentPost(data);
        BigDecimal amount = new BigDecimal("3000");
        
        assertEquals("B", result.getPostType());
        assertEquals(amount, result.getAmount());
        assertEquals("1234567890", result.getReference());
        
        
    }


    
}
