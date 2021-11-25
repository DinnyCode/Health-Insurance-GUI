package com.mycompany.slaintehealth;

import java.util.ArrayList;

/**
 * @author Denis Perepelyuk
 */

//Class Declaration - Policy Class
public class Policy 
{
    
    //Instance Variables
    public Customer customer;
    public int policyNo;
    String hospitalCover;
    String dayToDayExpenses;
    float price;
    String policyType;
    
    //Full Policy Constructor
    public Policy(int policyNo, Customer customer, String hospitalCover, String dayToDayExpenses, String policyType)
    {
        this.policyNo = policyNo;
        this.customer = customer;
        this.hospitalCover = hospitalCover;
        this.dayToDayExpenses = dayToDayExpenses;
        this.policyType = policyType;
    }
    
    //Empty Policy Constructor 
    public Policy ()
    {
        
    }
    
    //toString Method
    public String toString() 
    {
        return 	"\n\nCustomer Details:"
                +customer.toString()
                +"\n\nPolicy Details:"
                +"\nPolicy Type: "+policyType
                +"\nHospital Cover: "+hospitalCover
                +"\nDay to Day Expenses: "+dayToDayExpenses;       
    }
      
    //Output policy details and provide quote
    public String outputQuote() 
    {
    	//Do not provide quote if customer is over 70 years of age
    	if (customer.getAge() > 70)
        {
            price = 0;
            return "\n****************************************"
            		+"\n\nPolciy No.: "+policyNo
            		+ "\n\nQuote Not Available for customers over 70"
            		+ "\nQuote Price: €"+price;
        }//end if 
    	
    	//Calculate Premium, output customer & policy details, output quote  
    	else
    	{
    		calculatePremium();
    		double quote = Math.round(price*100.0)/100.0;
    		return "\n****************************************"
    	            +"\n\nPolciy No.: "+policyNo
    	            +toString()
    	            + "\n\nQuote Price: �"+quote;
    	}//end else
    }//end outputQuote method

    //Calculate insurance premium	
    public float calculatePremium() 
    { 
            //Base quote
            price = 200f;

            //Gender Calculations
            if ("Male".equals(customer.gender) )
            {
                price = price*2;
            }
            if ("Female".equals(customer.gender) )
            {
                price = (float) (price * 0.7);
            }


            //Age Calculations
            if (customer.age < 35)
            {
                price = (float) (price*1.2);
            }
            else if (customer.age >= 35 && customer.age <=55)
            {
                price = (float) (price*1.4);
            }
            else if (customer.age > 55 && customer.age <=70)
            {
                price = (float) (price*1.65);
            }        
            //**If customer over 70, quote not provided**
            //**Dealt with in outputQuote method**
            
            
            //Health Conditions Calculations
            //Create ArrayList to store health conditions
            ArrayList <String> conditions = new ArrayList();

            //Conditions ArrayList will contain what's stored in healthConditions ArrayList
            conditions = (ArrayList) customer.getHealthConditions();

            //For loop to check ArrayList for all conditions
            for (int i=0; i<conditions.size(); i++)
            {
                //Bone Marrow
                if (conditions.get(i).equalsIgnoreCase ("Bone Marrow")) 
                {
                    price = (float) (price*1.2);   
                }
                //Cancer
                else if (conditions.get(i).equalsIgnoreCase ("Cancer")) 
                {
                    price = (float) (price*1.25);   
                }
                //Cardio Vascular
                else if (conditions.get(i).equalsIgnoreCase ("Cardio Vascular")) 
                {
                    price = (float) (price*1.3);
                }
                //Gastrointestinal
                else if (conditions.get(i).equalsIgnoreCase ("Gastrointestinal")) 
                {
                    price = (float) (price*1.1);
                }
                //Infections
                else if (conditions.get(i).equalsIgnoreCase ("Infections")) 
                {
                    price = (float) (price*1.1);
                }
                //Kidneys
                else if (conditions.get(i).equalsIgnoreCase ("Kidneys")) 
                {
                    price = (float) (price*1.25);
                }
                //Lungs
                else if (conditions.get(i).equalsIgnoreCase ("Lungs")) 
                {
                    price = (float) (price*1.25);
                }
                //Musculoskeletal
                else if (conditions.get(i).equalsIgnoreCase ("Musculoskeletal")) 
                {
                    price = (float) (price*1.3);
                }
                //No health conditions from list
                else if (conditions.get(i).equalsIgnoreCase ("None")) 
                {
                    price = price;
                }
                else
                {
                    System.out.println("Error health conditions");
                }
            }//end for loop


            //Other Health Conditions Calculations
            //No other health conditions
            if (customer.otherHealthConditions.equalsIgnoreCase ("None"))
            {
                price = price;
            }
            //Has other health conditions
            if (customer.otherHealthConditions.equalsIgnoreCase ("Other"))
            {
                price = (float) (price*1.5);
            }


            //Smoker Calculations
            if (customer.smoker == true)
            {
                price = price+75;
            }
            //else statement as boolean variable can only be true or false
            else
            {
                price = price-100;
            }


            //Hospital Cover Calculations
            if ( "Public".equals(hospitalCover) )
            {
                price = price; //price is not affected
            }
            else if ( "Private".equals(hospitalCover) )
            {
                price = (float) (price*1.2);
            }
            else if ( "Comprehensive".equals(hospitalCover) )
            {
                price = (float) (price*1.3);
            }


            //Day To Day Expenses Calculations
            if ( "Standard".equals(dayToDayExpenses) )
            {
                price = price; //price is not affected

            }
            else if ( "Enhanced".equals(dayToDayExpenses) )
            {
                price = (float) (price*1.2);
            }
            else
            {
                price = (float) (price*1.3);
            }
 
            return this.price;
            
    }//end calculatePremium method

    
    //setter and getter methods
  
    public Customer getCustomer()
    {
        return this.customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public String getHospitalCover() {
       return this.hospitalCover;
    }

    public void setHospitalCover(String hospitalCover) {
        this.hospitalCover = hospitalCover;
    }

    public String getDayToDayExpenses() {
        return this.dayToDayExpenses;
    }

    public void setDayToDayExpenses(String dayToDayExpenses) {
        this.dayToDayExpenses = dayToDayExpenses;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPolicyNo() {
        return this.policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }    
    
}//end policy super class