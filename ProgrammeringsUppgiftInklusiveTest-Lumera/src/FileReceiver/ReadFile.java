package FileReceiver;
import BL.PaymentManager;
import Payment.PaymentService;
import Deposit.DepositService;
import java.io.*;
import Models.IPayService;
import java.text.ParseException;

public class ReadFile {
    
    public static void main(String args[]) throws IOException, ParseException
    {
        //Exempelfil_betalningsservice.txt
        //Exempelfil_inbetalningstjansten.txt
        
        if(!Validate(args))
        {
            Usage();
            return;
        }
        
        //File f = new File(args[0]);
        
        File f = new File("C:\Users\nene5\OneDrive\Skrivbord\ProgrammeringsUppgiftInklusiveTest-Lumera\\Exempelfil_inbetalningstjansten.txt");
        
        var service = GetService(f.getAbsolutePath());
        service.Process();

}
    
    private static IPayService GetService(String filePath)
    {
        File file= new File(filePath);
        String fileName = file.getName();
        fileName = fileName.substring(fileName.lastIndexOf('_'));    
        switch(fileName)
        {
            case "_betalningsservice.txt":
            {
                
                return new PaymentService(filePath, new PaymentManager());
            }
            case "_inbetalningstjansten.txt":
            {
                return new DepositService(filePath, new PaymentManager());
            }
/*            case "XXXXXXX":
            {
                return new FuturePaymentService(filePath, new PaymentManager());
            }
*/
            
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    public  static boolean Validate(String args[]){
        //if (!file.exists())

        return true;
    }
    
    private static void Usage(){
        System.out.println("error Filename");
    }

}


