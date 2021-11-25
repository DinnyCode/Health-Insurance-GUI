package com.mycompany.slaintehealth;

import java.util.ArrayList;

/**
 * @author Denis Perepelyuk
 */

//class declaration - TestIndividualPolicy Class
public class TestIndividualPolicy 
{
 
    public static void main(String[] args) 
    {
        
        //Create ArrayList for healthConditions 
        ArrayList healthConditions = new ArrayList();
        
        //**************************************
        
        //Create New Individual Policy - 1
         
        //Add to healthConditions ArrayList
        healthConditions.add("Bone Marrow");
        healthConditions.add("Lungs");
        
        //Create New Customer Object:
        //Emmet Daly, Male, 32, Smoker, Bone Marrow & Lungs, No Other Health Conditions
        Customer c1 = new Customer ("Emmet","Daly",32,"Male",true, healthConditions,"None");
        
        //Create New Individual Policy Object
        //Public Hospital Cover, Standard day2day, Individual Policy, Policy no. 1
        IndividualPolicy ip1 = new IndividualPolicy(1,c1, "Public", "Standard", "Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip1.outputQuote());
        
        //**************************************
        
        //Create New Individual Policy - 2
        
        //Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("None");  
               
        //Create New Customer Object:
        //Patricia Folan, Female, 40, Non-smoker, No Health Conditions, Other Health Conditions
        Customer c2 = new Customer ("Patricia","Folan",40,"Female",false, healthConditions,"Other");
        
        //Create New Individual Policy Object
        //Comprehensive hospital cover, Enhanced day2day, Individual policy, policy no. 2
        IndividualPolicy ip2 = new IndividualPolicy(2,c2, "Comprehensive", "Enhanced", "Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip2.outputQuote());
        
        //**************************************
        
        //Create New Individual Policy - 3
        
     	//Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("Cancer");  
      
        //Create New Customer Object:
        //Donal Russell, Male, 30, Non-smoker, Cancer, No Other Health Conditions
        Customer c3 = new Customer ("Donal","Russell",30,"Male",false, healthConditions,"None");
        
        //Create New Individual Policy Object:
        //Private Hospital Cover, Standard day2day, Individual Policy, Policy No. 3
        IndividualPolicy ip3 = new IndividualPolicy(3,c3, "Private", "Standard", "Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip3.outputQuote());
        
        //**************************************
        
        //Create New Individual Policy - 4
        
        //Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("Lungs");  
        
        //Create New Customer Object:
        //Paul Kelly, Male, 72, Non-smoker, Lungs, No Health Conditions
        Customer c4 = new Customer ("Paul","Kelly",72,"Male",false, healthConditions,"None");

        //Create New Individual Policy Object:
        //Public hospital cover, Standard day2day, Individual policy, Policy no. 4
        IndividualPolicy ip4 = new IndividualPolicy(4,c4, "Public", "Standard", "Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip4.outputQuote());
        
        //**************************************
        
        //Create New Individual Policy - 5
        
        //Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("Infections");  
        healthConditions.add("Kidneys");        
        
        //Create New Customer Object:
        //Chuck Norris, Male, 29, Non-smoker, Infections & Kidneys, Other Health Conditions
        Customer c5 = new Customer ("Chuck","Norris",29,"Male",false, healthConditions,"Other");
        
        //Create New Individual Policy Object:
        //Private hospital cover, Enhanced day2day, Individual policy, Policy no. 5
        IndividualPolicy ip5 = new IndividualPolicy(5,c5, "Private", "Enhanced", "Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip5.outputQuote());
        
        //**************************************
       
        //Create New Individual Policy - 6
        
        //Clear healthConditions ArrayList and add to ArrayList
        healthConditions.clear();
        healthConditions.add("None"); 
        
        //Create empty Customer and Individual Policy Objects
        Customer c6 = new Customer ();
        IndividualPolicy ip6 = new IndividualPolicy();
        
        //Setter methods
        //Daniel Cooper, Male, 46, Smoker, None, No Health Conditions
        //Public hospital cover, Comprehensive day2day, Individual policy, Policy no. 6
        c6.setFirstName("Daniel");
        c6.setSurname("Cooper");
        c6.setAge(46);
        c6.setGender("Male");
        c6.setSmoker(true);
        c6.setHealthConditions(healthConditions);
        c6.setOtherHealthConditions("None");
        ip6.setCustomer(c6);
        ip6.setPolicyNo(6);
        ip6.setHospitalCover("Public");
        ip6.setDayToDayExpenses("Comprehensive");
        ip6.setPolicyType("Individual");
        
        //Output customer and policy details, calculate quote, and output quote
        System.out.println(ip6.outputQuote());
        
        //Getter Methods
        System.out.println("\n****************************************"
        		+ "\nGetter Methods:");
        System.out.println(ip6.getPolicyNo());
        System.out.println(c6.getFirstName());
        System.out.println(c6.getSurname());
        System.out.println(c6.getAge());
        System.out.println(c6.getGender());
        System.out.println(c6.getSmoker());
        System.out.println(c6.getHealthConditions());
        System.out.println(c6.getOtherHealthConditions());
        //System.out.println(ip6.getCustomer());
        System.out.println(ip6.getHospitalCover());
        System.out.println(ip6.getDayToDayExpenses());
        System.out.println(ip6.getPolicyType());
        System.out.println(ip6.getPrice());        
        System.out.println("\nCustomer Getter Method:");
        System.out.println(ip6.getCustomer());
    }//end main
    
}//end class