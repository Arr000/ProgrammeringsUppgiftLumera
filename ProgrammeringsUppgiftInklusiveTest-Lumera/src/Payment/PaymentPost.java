
package Payment;

import java.math.BigDecimal;
import java.util.Date;


public class PaymentPost {
    private String _postType;
    private String _clearingAccountNumber;
    private BigDecimal _sumOfAmount;
    private String _numberOfPayments;
    private Date _paymentDate;
    private String _currency;
    private BigDecimal _amount;
    private String _reference;
    
    
    public String getPostType()
    {
        return _postType;
    }
    
    public void setPostType(String posttype)
    {
        _postType = posttype;
    }
    
    public String getClearingAndAccountNumber()
    {
        return _clearingAccountNumber;
    }
    
    public void setClearingAndAccountNumber(String clearingAndAccount)
    {
        _clearingAccountNumber = clearingAndAccount;
    }
    
    public BigDecimal getSumOfAmount()
    {
        return _sumOfAmount;
    }
    
    public void setSumOfAmount(BigDecimal sumOfAmount)
    {
        _sumOfAmount = sumOfAmount;
    }
   
    public String getNumberOfPayments()
    {
        return _numberOfPayments;
    }
    
    public void setNumberOfPayments(String numberOfPayments)
    {
        _numberOfPayments = numberOfPayments;
    }
    
    public Date getPaymentDate()
    {
        return _paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate)
    {
        _paymentDate = paymentDate;
    }
    
    public String getCurrency()
    {
        return _currency;
    }
    
    public void setCurrency(String currency)
    {
        _currency = currency;
    }
    public BigDecimal getAmount()
    {
        return _amount;
    }
    
    public void setAmount(BigDecimal amount)
    {
        _amount = amount;
    }
    public String getReference()
    {
        return _reference;
    }
    
    public void setReference(String reference)
    {
        _reference = reference;
    }
    
}
