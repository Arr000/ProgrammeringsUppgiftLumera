
package Deposit;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
 

public class DepositDecoderTest {
    
    public DepositDecoderTest() {
    }

   @Test
    public void GetDepositStartPost_Should_Decode_StartPost() {
        var data = "00000000001234123456789700000000000000000000000000000000000000000000000000000000";
        DepositPost result = DepositDecoder.GetDepositStartPost(data);

        assertEquals("00", result.getPosttype());
        assertEquals("00000000", result.getReservedNumber1());
        assertEquals("1234", result.getClearingNumber());
        assertEquals("1234567897", result.getAccountNumber());
        assertEquals("00000000000000000000000000000000000000000000000000000000", result.getReservedNumber2());
    }
    
    @Test
    public void GetDepositPaymentPost_Should_Decode_PaymentPost()
    {
        var data ="30000000000000004000000000000000000000009876543210                              ";
        DepositPost result = DepositDecoder.getDepositPaymentPost(data);
        BigDecimal b  = new BigDecimal("400000");
        var amount = b.setScale(2);           
        
        assertEquals("30", result.getPosttype());
        assertEquals(amount, result.getAmount());
        assertEquals("000000000000000000", result.getReservedNumber1());
        assertEquals("9876543210", result.getReference());     
    }

    
}
