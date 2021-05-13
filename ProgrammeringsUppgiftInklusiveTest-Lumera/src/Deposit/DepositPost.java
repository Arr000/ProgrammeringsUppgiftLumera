package Deposit;

import java.math.BigDecimal;
import java.util.Date;



public class DepositPost {

    private String _postType;
    private String _reservedNumber1;
    private String _clearingNumber;
    private String _accountNumber;
    private String _reservedNumber2;
    private BigDecimal _amount;
    private String _reference;
    private String _numberOfPayments;
    private Date _date;
    private String _currency;
    

    public String getPosttype()
    {
        return _postType;
    }
    public void setPosttype(String postType)
    {
         _postType = postType;
    }
    
    public String getAccountNumber()
    {
        return _accountNumber;
    }
    
    public void setAccountNumber(String accountNumber)  
    {
        _accountNumber = accountNumber;
    }
    
    public String getReservedNumber1()
    {
        return _reservedNumber1;
    }
    
    public void setReservedNumber1(String reservedNumber1)  
    {
        _reservedNumber1 = reservedNumber1;
    }
    
    public String getClearingNumber()
    {
        return _clearingNumber;
    }
    
    public void setClearingNumber(String clearingNumberber)  
    {
        _clearingNumber = clearingNumberber;
    }
    
    public String getReservedNumber2()
    {
        return _reservedNumber2;
    }
    
    public void setReservedNumber2(String reservedNumber2)
    {
        _reservedNumber2 = reservedNumber2;
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
    
    public void setReference(String ref)
    {
        _reference = ref;
    }
    
    public String getNumberOfPayments()
    {
        return _numberOfPayments;
    }
    
    public void setNumberOfPayments(String numberOfPayments)
    {
        _numberOfPayments = numberOfPayments;
    }
     public Date getDate()
    {
        return _date;
    }
    
    public void setDate(Date date)
    {
        _date = date;
    }
      public String getCurrency()
    {
        return _currency;
    }
    
    public void setCurrency(String currency)
    {
        _currency = currency;
    }
}