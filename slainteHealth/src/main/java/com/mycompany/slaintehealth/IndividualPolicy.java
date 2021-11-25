package com.mycompany.slaintehealth;

/**
 * @author Denis Perepelyuk
 */

//Class Declaration - Individual Policy Class
public class IndividualPolicy extends Policy {

	//Full Individual Policy Constructor
    public IndividualPolicy(int policyNo, Customer customer, String hospitalCover, String dayToDayExpenses, String policyType)
    {
        super(policyNo, customer, hospitalCover, dayToDayExpenses, policyType);
    }
    
    //Empty Individual Policy Constructor 
    public IndividualPolicy()
    {
    	
    }
    
    //Calculate Insurance Quote
    public float calculatePremium() 
    {
    	super.calculatePremium();
    	return price;
    }

    @Override
    public String toString() 
    {       
        return super.toString();
    }
    
}//end class