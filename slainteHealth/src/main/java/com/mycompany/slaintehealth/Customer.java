package com.mycompany.slaintehealth;

/*
 * @author Denis Perepelyuk
 */

import java.util.ArrayList;

//Class Declaration - Customer Class
public class Customer  
{  
    //Instance Variables
    public String firstName;
    public String surname;
    public int age;
    public String gender;
    public boolean smoker;
    public ArrayList healthConditions;
    public String otherHealthConditions;
    
    //Full Customer Constructor
    public Customer(String firstName, String surname, int age, 
            String gender, boolean smoker, ArrayList healthConditions,
            String otherHealthConditions) 
    {
        this.firstName = firstName;
        this.surname = surname; 
        this.age = age;
        this.gender = gender;
        this.smoker = smoker;
        this.healthConditions = healthConditions;
        this.otherHealthConditions = otherHealthConditions;
    }

    //Empty Customer Constructor 
    public Customer ()
    {
    	
    }
        
    //toString Method
    public String toString() 
    {
        return  "\nFirst Name: "+firstName
                +"\nSurname: "+surname
                +"\nAge: "+age
                +"\nGender: "+gender
                +"\nSmoker: "+smoker
                +"\nHealth Conditions: "+healthConditions
                +"\nOther Conditions: "+otherHealthConditions;
    }//end toString method

    
    //setter and getter methods
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getSmoker() {
        return this.smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public ArrayList getHealthConditions() {
        return this.healthConditions;
    }

    public void setHealthConditions(ArrayList healthConditions) {
        this.healthConditions = healthConditions;
    }

    public String getOtherHealthConditions() {
        return this.otherHealthConditions;
    }

    public void setOtherHealthConditions(String otherHealthConditions) {
        this.otherHealthConditions = otherHealthConditions;
    }
    
}//end customer class