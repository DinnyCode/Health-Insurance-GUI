package com.mycompany.slaintehealth;

/**
 * @author Denis Perepelyuk
 */

import java.util.ArrayList;

//class declaration - TestCorporatePolicy Class
public class TestCorporatePolicy 
{
	public static void main(String[] args) 
    {
		
        //Create ArrayList for healthConditions 
        ArrayList healthConditions = new ArrayList();

        //**************************************
        
        //Create New Corporate Policy - 1
            
        //Add to healthConditions ArrayList
        healthConditions.add("Kidneys");
            
        //Create New Customer Object:
        //Michelle Hogan, Female, 60, Smoker , Kidneys, No Other Health Conditions
        Customer c1 = new Customer ("Michelle","Hogan",60,"Female",true, healthConditions,"None");

        //Create New Corporate Policy Object
        //Comprehensive Hospital Cover, Comprehensive day2day, Corporate Policy, Policy No. 1
        CorporatePolicy cp1 = new CorporatePolicy(1,c1, "Comprehensive", "Comprehensive", "Corporate");
            
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(cp1.outputQuote());
 
        //*************************************

        //Create New Corporate Policy - 2
        
        System.out.println("\n\nCorporate Policy Setter & Getter Methods");
        
        //Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("None");
        
        //Create empty Customer and Corporate Policy Objects
        Customer c2 = new Customer ();
        CorporatePolicy cp2 = new CorporatePolicy();
        
 
        //Setter methods
        //Customer Object Details: Daniel, Kiely, 46, Male, Smoker, No Health Conditions, No Other Health Conditions);
        //Corporate Policy Object Details: Public hospital cover, Standard day2day, Corporate policy, Policy no. 2
        c2.setFirstName("Daniel");
        c2.setSurname("Kiely");
        c2.setAge(46);
        c2.setGender("Male");
        c2.setSmoker(true);
        c2.setHealthConditions(healthConditions);
        c2.setOtherHealthConditions("None");
        cp2.setCustomer(c2);
        cp2.setPolicyNo(2);
        cp2.setHospitalCover("Public");
        cp2.setDayToDayExpenses("Standard");
        cp2.setPolicyType("Corporate");
        cp2.setDiscount(0.9);

        //Output customer and policy details, calculate quote, and output quote
        System.out.println(cp2.outputQuote());
        
        //Getter methods
        System.out.println("\n****************************************"
        		+ "\nGetter Methods:");
        System.out.println(cp2.getPolicyNo());
        System.out.println(c2.getFirstName());
        System.out.println(c2.getSurname());
        System.out.println(c2.getAge());
        System.out.println(c2.getGender());
        System.out.println(c2.getSmoker());
        System.out.println(c2.getHealthConditions());
        System.out.println(c2.getOtherHealthConditions());
        System.out.println(cp2.getHospitalCover());
        System.out.println(cp2.getDayToDayExpenses());
        System.out.println(cp2.getPolicyType());
        System.out.println(cp2.getPrice());        
        
        System.out.println("\nCustomer Getter Method:");
        System.out.println(cp2.getCustomer());
        
        System.out.println("\nDiscount Getter Method:"+cp2.getDiscount());
        
    }//end main
}//end class