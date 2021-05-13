
package BL;

import Models.IPaymentReceiver;
import java.math.BigDecimal;
import java.util.Date;


public class PaymentManager implements IPaymentReceiver{
    
    @Override
    public void startPaymentBundle(String accountNumber, Date paymentDate, String currency) {
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }
    
    @Override
    public void payment(BigDecimal amount, String reference) {
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
 
    }
    
    @Override
    public void endPaymentBundle() {
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    
    }
    
}
