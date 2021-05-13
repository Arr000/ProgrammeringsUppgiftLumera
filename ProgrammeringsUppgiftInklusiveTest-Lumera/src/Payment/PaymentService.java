package Payment;

import Models.IPaymentReceiver;
import java.io.IOException;
import Models.IPayService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class PaymentService implements IPayService{
    
    private IPaymentReceiver _paymentManager;
    private String filePath;
    
    public PaymentService(String filePath, IPaymentReceiver paymentManager){
        _paymentManager = paymentManager;
        this.filePath = filePath;
    }
    
    public void Process() throws IOException, ParseException
    {
        
            PaymentDecoder decoder = new PaymentDecoder();
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            var line = reader.readLine();
            var startPost = decoder.GetPaymentStartPost(line);
            _paymentManager.startPaymentBundle(startPost.getClearingAndAccountNumber(), startPost.getPaymentDate(), startPost.getCurrency());
            
             while((line = reader.readLine()) != null )
             {
                 var paymentPost = decoder.getPaymentPost(line);
                _paymentManager.payment(paymentPost.getAmount(), paymentPost.getReference().trim());
             }  
            
            
            _paymentManager.endPaymentBundle();
    } 
        
       
}
    


