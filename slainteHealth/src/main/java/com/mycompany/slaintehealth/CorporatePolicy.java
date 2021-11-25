package com.mycompany.slaintehealth;

/**
 * @author Denis Perepelyuk
 */

//Class Declaration - Corporate Policy Class
public class CorporatePolicy extends Policy 
{
	//Instance Variable
    private double discount;
    
 	//Full Corporate Policy Constructor
    public CorporatePolicy(int policyNo, Customer customer, String hospitalCover, String dayToDayExpenses, String policyType) 
    {
        super(policyNo,customer, hospitalCover, dayToDayExpenses, policyType);
    }
    
    //Empty Corporate Policy Constructor 
    public CorporatePolicy()
    {
    	
    }
    
    //Calculate Insurance Quote
    public float calculatePremium() 
    {
    	discount = 0.9;
        super.calculatePremium();
    	price = (float) (price*discount);
    	return price;      
    }

    @Override
    public String toString() 
    {
    	return super.toString();

    }
    
    //Setter & Getter Methods
    public double getDiscount() 
    {
        return this.discount;
    }

    public void setDiscount(double discount) 
    {
    	this.discount = discount;
    }
    
}//end class