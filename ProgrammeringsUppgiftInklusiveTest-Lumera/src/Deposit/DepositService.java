
package Deposit;
import Models.IPaymentReceiver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import Models.IPayService;


public class DepositService implements IPayService{
    
    private IPaymentReceiver _paymentManager;
    private String filePath;
    
    public DepositService(String filePath, IPaymentReceiver paymentManager){
        _paymentManager = paymentManager;
        this.filePath = filePath;
    }

    public void Process() throws IOException
    {
        try{
        DepositDecoder decoder = new DepositDecoder();
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
        var line = reader.readLine();
        var startPost = decoder.GetDepositStartPost(line);
       
        _paymentManager.startPaymentBundle(startPost.getAccountNumber(), startPost.getDate(), startPost.getCurrency());
        
      
        while((line = reader.readLine()) != null )
        {
           
            if(!line.substring(30, 38).equals("00000000"))
            {
                break;
                
            }
    
           var paymentPost = decoder.getDepositPaymentPost(line);
          _paymentManager.payment(paymentPost.getAmount(), paymentPost.getReference().trim());
        }
     
         _paymentManager.endPaymentBundle();
        
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
        
     