package com.mycompany.slaintehealth;


// @author Denis Perepelyuk


import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class SlainteGUI extends javax.swing.JFrame 
{    
    //Declare instance variables
    //Declare base price 
    static float INPUT_PRICE = 200;
    //Declare discount for corporate policy
    static float DISCOUNT = 0.9f;
    
    //Declare variables to store user input for customer object
    public String inputFirstName;
    public String inputSurname;
    public String inputGender;
    public int inputAge;
    public boolean inputSmoker;
    public ArrayList<String> inputHealthConditions = new ArrayList<String>();
    public String inputOtherConditions;
    
    //Declare variables to store user input for policy objects
    public String inputPolicyType;
    public String inputHospitalCover;
    public String inputDayToDayExpenses;
    //Set policyNo to 1 
    public int inputPolicyNo = 1;
    
    //Declare boolean variable to check whether form has been correctly validated
    boolean formValidated = false;
    
    //Declare customer and policy objects
    public Customer c1;
    public IndividualPolicy ip1;    
    public CorporatePolicy cp1;  
    
    //Declare variable to store quote prices
    float totalPrice;
    
    //Declare constants to represent options in GUI
    
    //Delcare age range constants
    static final int AGE_NOT_SELECTED = -1;
    static final int AGE_PLEASE_SELECT = 0;
    static final int AGE_UNDER_35 = 1;
    static final int AGE_35_TO_55 = 2;
    static final int AGE_56_TO_70 = 3;
    static final int AGE_OVER_70 = 4;
    
    //Delcare policyType coption constants
    static final int POLICY_NOT_SELECTED = -1;
    static final int POLICY_PLEASE_SELECT = 0;
    static final int POLICY_INDIVIDUAL = 1;
    static final int POLICY_CORPORATE = 2;

    //Declare hospitalCover option constants
    static final int HCOVER_NOT_SELECTED = -1;
    static final int HCOVER_PLEASE_SELECT = 0;
    static final int HCOVER_PUBLIC_HOSPITALS = 1;
    static final int HCOVER_SELECTED_PRIVATE = 2;
    static final int HCOVER_COMPREHENSIVE = 3;

    //Declare dayToDayExpenses option constants
    static final int EXPENSES_NOT_SELECTED = -1;
    static final int EXPENSES_PLEASE_SELECT = 0;
    static final int EXPENSES_STANDARD = 1;
    static final int EXPENSES_ENHANCED = 2;
    static final int EXPENSES_COMPREHENSIVE = 3;
    
    
    //Create new JFrame Form 
    public SlainteGUI() 
    {
        initComponents();
    }

    //validateForm Method
    //Method to check if form has been properly filled out by user
    private void validateForm()
    {
        //Create array to retrieve index value of existinghealthConditions options selected by user
        int[]healthConditionsCheck = existingHealthConditionsLstBx.getSelectedIndices();
        
        ArrayList<Integer> healthConCheckArray = new ArrayList<>();
        
        for(int i=0;i<healthConditionsCheck.length;i++)
        {
            healthConCheckArray.add(healthConditionsCheck[i]);
        }
        //Check if user has inputted first name 
        if(firstNameTxtFld.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: First Name",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted surname
        if(surnameTxtFld.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Surname",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted gender inputted
        else if(genderBtnGrp.getSelection()==null)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Gender ",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted age 
        else if(ageCmbBox.getSelectedIndex() == AGE_NOT_SELECTED)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Age",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        else if(ageCmbBox.getSelectedIndex() == AGE_PLEASE_SELECT)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Age",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check for customers over age 70
        else if(ageCmbBox.getSelectedIndex() == AGE_OVER_70)
        {
            JOptionPane.showMessageDialog(this,
                "Policies cannot be sold to customers over 70",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted policy type
        else if(policyTypeCmbBox.getSelectedIndex() == POLICY_NOT_SELECTED)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Polci Type",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        else if(policyTypeCmbBox.getSelectedIndex() == POLICY_PLEASE_SELECT)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Policy Type",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted hospital cover
        else if(hospitalCoverCmbBox.getSelectedIndex() == HCOVER_NOT_SELECTED)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Hospital Cover",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        else if(hospitalCoverCmbBox.getSelectedIndex() == HCOVER_PLEASE_SELECT)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Hospital Cover",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted day to day expenses 
        else if(dayToDayExpensesCmbBox.getSelectedIndex() ==
                EXPENSES_NOT_SELECTED)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Day to Day Expenses",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        else if(dayToDayExpensesCmbBox.getSelectedIndex() ==
                EXPENSES_PLEASE_SELECT)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Day to Day Expenses",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted healthConditions 
        else if(existingHealthConditionsLstBx.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Health Conditions"
                        + "\nIf you don't have any, please select: None ",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted "None" for healthConditions
        //If they have, check to see if they have not inputted any toher options
        else if((healthConCheckArray.contains(0))&&((healthConCheckArray.contains(1))||
           (healthConCheckArray.contains(2))||(healthConCheckArray.contains(3))||
           (healthConCheckArray.contains(4))||(healthConCheckArray.contains(5))||
           (healthConCheckArray.contains(6))||(healthConCheckArray.contains(7))||
           (healthConCheckArray.contains(8))))
        {
            JOptionPane.showMessageDialog(this,
                "If you have selected None from health conditions, you are "
                        + "unable to have other options selected",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Check if user has inputted smoker status
        else if(smokerBtnGrp.getSelection()==null)
        {
            JOptionPane.showMessageDialog(this,
                "You have not selected: Smoker or Non-Smoker",
                "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
        //Assume user has filled out form properly
        else 
        {
             formValidated = true;
        } 
    }//end validate form method
    
    //extractFommDetails method
    //Extract form details to create customer and policy objects
    public void extractFormDetails()
    {
        //Extract first name details
        inputFirstName = firstNameTxtFld.getText();
        //Extract surname input
        inputSurname = surnameTxtFld.getText();
        //Extract gender input
        if(maleRadBtn.isSelected())
        {
            inputGender = "Male";
        }
        else if(femaleRadBtn.isSelected())
        {
            inputGender = "Female";
        }
        //Extract age details
        if(ageCmbBox.getSelectedIndex() == AGE_UNDER_35)
        {
            inputAge = 34;  // under 35
        }
        else if (ageCmbBox.getSelectedIndex() == AGE_35_TO_55) 
        {
            inputAge = 40;  //35 - 55
        }
        else if (ageCmbBox.getSelectedIndex() == AGE_56_TO_70)
        {
            inputAge = 60;  //56 - 70
        }
        else if (ageCmbBox.getSelectedIndex() == AGE_OVER_70) 
        {
            inputAge = 71;  //over 70
        }
        
        //Extract policy type details
        if(policyTypeCmbBox.getSelectedIndex() == POLICY_INDIVIDUAL)
        {
            inputPolicyType = "Individual";
        }
        else if (policyTypeCmbBox.getSelectedIndex() == POLICY_CORPORATE) 
        {
            inputPolicyType = "Corporate";
        }
        //Extract hospital cover details
        if(hospitalCoverCmbBox.getSelectedIndex() == HCOVER_PUBLIC_HOSPITALS)
        {
            inputHospitalCover = "Public";
        }
        else if (hospitalCoverCmbBox.getSelectedIndex() == HCOVER_SELECTED_PRIVATE) 
        {
            inputHospitalCover = "Private";
        }
        else if (hospitalCoverCmbBox.getSelectedIndex() == HCOVER_COMPREHENSIVE) 
        {
            inputHospitalCover = "Comprehensive";
        }
        //Extract day to day expenses details
        if(dayToDayExpensesCmbBox.getSelectedIndex() == EXPENSES_STANDARD)
        {
            inputDayToDayExpenses = "Standard";
        }
        else if (dayToDayExpensesCmbBox.getSelectedIndex() == EXPENSES_ENHANCED) {
            inputDayToDayExpenses = "Enhanced";
        }
        else if (dayToDayExpensesCmbBox.getSelectedIndex() == EXPENSES_COMPREHENSIVE) {
            inputDayToDayExpenses = "Comprehensive";
        }
     
        //Extract health conditions details
        int[]healthConditions = existingHealthConditionsLstBx.getSelectedIndices();

        for(int i=0;i<healthConditions.length;i++)
        {
            if(healthConditions[i]==0)
            {
                inputHealthConditions.add("None");
            }
            else if (healthConditions[i]==1)
            {    
                inputHealthConditions.add("Bone Marrow");
            }
            else if (healthConditions[i]==2)
            {
                inputHealthConditions.add("Cancer");
            }
            else if (healthConditions[i]==3)
            {
                inputHealthConditions.add("Cardiovascular Disease");
            }
            else if (healthConditions[i]==4)
            {
                inputHealthConditions.add("Gastrointestinal");
            }
            else if (healthConditions[i]==5)
            {
                inputHealthConditions.add("Infections");
            }
            else if (healthConditions[i]==6)
            {
                inputHealthConditions.add("Kidneys");
            }  
            else if (healthConditions[i]==7)
            {
                inputHealthConditions.add("Lungs");
            }
            else if (healthConditions[i]==8)
            {
                inputHealthConditions.add("Musculoskeletal");
            }    
        }//end for loop

        //Extract other conditions details
        if(otherTxtFld.getText().equalsIgnoreCase("")){
            inputOtherConditions = "None";
        }
        else if(otherTxtFld.getText().equalsIgnoreCase("none")){
            inputOtherConditions = "None";
        }
        else {
            inputOtherConditions = otherTxtFld.getText();
        }
        //Extract input smoker details
        if(smokerRadBtn.isSelected()){
            inputSmoker = true;
        }
        else if(nonSmokerRadBtn.isSelected()){
            inputSmoker = false;
        }
    }//end validateForm method

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderBtnGrp = new javax.swing.ButtonGroup();
        smokerBtnGrp = new javax.swing.ButtonGroup();
        Quote = new javax.swing.JFrame();
        finalQuotationPnl1 = new javax.swing.JPanel();
        quoteSummaryIdNoLbl = new javax.swing.JLabel();
        quoteSummaryIdNoTFld = new javax.swing.JTextField();
        quoteTotalLbl = new javax.swing.JLabel();
        quoteTotalTFld = new javax.swing.JTextField();
        quotePersonalDetailsPnl = new javax.swing.JPanel();
        customerNameLbl = new javax.swing.JLabel();
        customerGenderLbl = new javax.swing.JLabel();
        customerNameTxtFld = new javax.swing.JTextField();
        customerGenderTxtFld = new javax.swing.JTextField();
        customerAgeLbl = new javax.swing.JLabel();
        quoteAgeTxtFld = new javax.swing.JTextField();
        quoteHealthDetailsPnl1 = new javax.swing.JPanel();
        quotePolicyTypeLbl = new javax.swing.JLabel();
        quoteHCoverLbl = new javax.swing.JLabel();
        quotePolicyTypeTxtFld = new javax.swing.JTextField();
        quoteHCoverTxtFld = new javax.swing.JTextField();
        quoteExpensesLbl = new javax.swing.JLabel();
        quoteExpensesTxtFld = new javax.swing.JTextField();
        quoteBackBtn = new javax.swing.JButton();
        quotePanelTitleLbl = new javax.swing.JLabel();
        quoteHealthDetailsPnl = new javax.swing.JPanel();
        customerBoneMarrowLbl = new javax.swing.JLabel();
        customerCancerLbl = new javax.swing.JLabel();
        quoteBMarrowTFld = new javax.swing.JTextField();
        quoteCancerTFld = new javax.swing.JTextField();
        customerCardDiseaseLbl = new javax.swing.JLabel();
        quoteCDiseaseTFld = new javax.swing.JTextField();
        customerGastroLbl = new javax.swing.JLabel();
        quoteGastroTFld = new javax.swing.JTextField();
        customerInfectionsLbl = new javax.swing.JLabel();
        quoteInfectionsTFld = new javax.swing.JTextField();
        customerKidneysLbl = new javax.swing.JLabel();
        quoteKidneysTFld = new javax.swing.JTextField();
        customerLungsLbl = new javax.swing.JLabel();
        quoteLungsTFld = new javax.swing.JTextField();
        customerMuscuLbl = new javax.swing.JLabel();
        quoteMusculoTFld = new javax.swing.JTextField();
        customerOtherHealthCondLbl = new javax.swing.JLabel();
        quoteOtherTFld = new javax.swing.JTextField();
        customerSmokerStatusLbl = new javax.swing.JLabel();
        quoteSmokerTFld = new javax.swing.JTextField();
        quoteFormIdNoTxtFld = new javax.swing.JTextField();
        headingLbl = new javax.swing.JLabel();
        personalDetailsPnl = new javax.swing.JPanel();
        firstNameLbl = new javax.swing.JLabel();
        firstNameTxtFld = new javax.swing.JTextField();
        surnameLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        surnameTxtFld = new javax.swing.JTextField();
        maleRadBtn = new javax.swing.JRadioButton();
        femaleRadBtn = new javax.swing.JRadioButton();
        ageCmbBox = new javax.swing.JComboBox<>();
        healthDetailsPnl = new javax.swing.JPanel();
        existingHealthConditionsLbl = new javax.swing.JLabel();
        otherLbl = new javax.swing.JLabel();
        otherTxtFld = new javax.swing.JTextField();
        smokerLbl = new javax.swing.JLabel();
        smokerRadBtn = new javax.swing.JRadioButton();
        nonSmokerRadBtn = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        existingHealthConditionsLstBx = new javax.swing.JList<>();
        schemeDetailsPnll = new javax.swing.JPanel();
        PolicyTypeLbl = new javax.swing.JLabel();
        HospitalCoverLbl = new javax.swing.JLabel();
        DayToDayExpensesLbl = new javax.swing.JLabel();
        policyTypeCmbBox = new javax.swing.JComboBox<>();
        hospitalCoverCmbBox = new javax.swing.JComboBox<>();
        dayToDayExpensesCmbBox = new javax.swing.JComboBox<>();
        finalQuotationPnl = new javax.swing.JPanel();
        quoteIdNoLbl = new javax.swing.JLabel();
        quoteIdNoTxtFld = new javax.swing.JTextField();
        totalPriceTxtFld = new javax.swing.JTextField();
        totalPriceLbl = new javax.swing.JLabel();
        calculateBtn = new javax.swing.JButton();
        clearFormBtn = new javax.swing.JButton();
        buyPolicyBtn = new javax.swing.JButton();

        Quote.setTitle("Quote Summary");
        Quote.setMinimumSize(new java.awt.Dimension(820, 600));
        Quote.setUndecorated(true);
        Quote.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                QuoteComponentShown(evt);
            }
        });

        finalQuotationPnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Final Quotation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        quoteSummaryIdNoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteSummaryIdNoLbl.setText("Quote ID No:");

        quoteSummaryIdNoTFld.setEditable(false);

        quoteTotalLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteTotalLbl.setForeground(new java.awt.Color(255, 51, 51));
        quoteTotalLbl.setText("Total:");

        quoteTotalTFld.setEditable(false);

        javax.swing.GroupLayout finalQuotationPnl1Layout = new javax.swing.GroupLayout(finalQuotationPnl1);
        finalQuotationPnl1.setLayout(finalQuotationPnl1Layout);
        finalQuotationPnl1Layout.setHorizontalGroup(
            finalQuotationPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalQuotationPnl1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(quoteSummaryIdNoLbl)
                .addGap(18, 18, 18)
                .addComponent(quoteSummaryIdNoTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quoteTotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quoteTotalTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        finalQuotationPnl1Layout.setVerticalGroup(
            finalQuotationPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalQuotationPnl1Layout.createSequentialGroup()
                .addGroup(finalQuotationPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quoteSummaryIdNoLbl)
                    .addComponent(quoteSummaryIdNoTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quoteTotalLbl)
                    .addComponent(quoteTotalTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        quotePersonalDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        customerNameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerNameLbl.setText("Customer Name:");

        customerGenderLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerGenderLbl.setText("Customer Gender:");
        customerGenderLbl.setToolTipText("");

        customerNameTxtFld.setEditable(false);

        customerGenderTxtFld.setEditable(false);
        customerGenderTxtFld.setToolTipText("");

        customerAgeLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerAgeLbl.setText("Customer Age:");

        quoteAgeTxtFld.setEditable(false);
        quoteAgeTxtFld.setToolTipText("");

        javax.swing.GroupLayout quotePersonalDetailsPnlLayout = new javax.swing.GroupLayout(quotePersonalDetailsPnl);
        quotePersonalDetailsPnl.setLayout(quotePersonalDetailsPnlLayout);
        quotePersonalDetailsPnlLayout.setHorizontalGroup(
            quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotePersonalDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quotePersonalDetailsPnlLayout.createSequentialGroup()
                        .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(customerAgeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quoteAgeTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(customerNameTxtFld)))
                    .addGroup(quotePersonalDetailsPnlLayout.createSequentialGroup()
                        .addComponent(customerGenderLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(customerGenderTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        quotePersonalDetailsPnlLayout.setVerticalGroup(
            quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotePersonalDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameLbl)
                    .addComponent(customerNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerGenderLbl)
                    .addComponent(customerGenderTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quotePersonalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerAgeLbl)
                    .addComponent(quoteAgeTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        quoteHealthDetailsPnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Policy Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        quotePolicyTypeLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quotePolicyTypeLbl.setText("Policy Type:");

        quoteHCoverLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteHCoverLbl.setText("Hospital Cover:");
        quoteHCoverLbl.setToolTipText("");

        quotePolicyTypeTxtFld.setEditable(false);

        quoteHCoverTxtFld.setEditable(false);
        quoteHCoverTxtFld.setToolTipText("");

        quoteExpensesLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteExpensesLbl.setText("Day to Day Expenses:");

        quoteExpensesTxtFld.setEditable(false);
        quoteExpensesTxtFld.setToolTipText("");

        javax.swing.GroupLayout quoteHealthDetailsPnl1Layout = new javax.swing.GroupLayout(quoteHealthDetailsPnl1);
        quoteHealthDetailsPnl1.setLayout(quoteHealthDetailsPnl1Layout);
        quoteHealthDetailsPnl1Layout.setHorizontalGroup(
            quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quoteHealthDetailsPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quotePolicyTypeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quoteHCoverLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quoteExpensesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quotePolicyTypeTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(quoteHCoverTxtFld)
                    .addComponent(quoteExpensesTxtFld))
                .addContainerGap())
        );
        quoteHealthDetailsPnl1Layout.setVerticalGroup(
            quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quoteHealthDetailsPnl1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotePolicyTypeLbl)
                    .addComponent(quotePolicyTypeTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quoteHCoverLbl)
                    .addComponent(quoteHCoverTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quoteExpensesLbl)
                    .addComponent(quoteExpensesTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        quoteBackBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteBackBtn.setText("Back to Previous");
        quoteBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quoteBackBtnActionPerformed(evt);
            }
        });

        quotePanelTitleLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        quotePanelTitleLbl.setText("Slainte Health Insurance Quote No.:");

        quoteHealthDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Health Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        customerBoneMarrowLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerBoneMarrowLbl.setText("Bone Marrow:");

        customerCancerLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerCancerLbl.setText("Cancer:");
        customerCancerLbl.setToolTipText("");

        quoteBMarrowTFld.setEditable(false);

        quoteCancerTFld.setEditable(false);
        quoteCancerTFld.setToolTipText("");

        customerCardDiseaseLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerCardDiseaseLbl.setText("Cardiovascular Disease:");

        quoteCDiseaseTFld.setEditable(false);
        quoteCDiseaseTFld.setToolTipText("");

        customerGastroLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerGastroLbl.setText("Gastrointestinal:");

        quoteGastroTFld.setEditable(false);

        customerInfectionsLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerInfectionsLbl.setText("Infections:");

        quoteInfectionsTFld.setEditable(false);

        customerKidneysLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerKidneysLbl.setText("Kidneys:");

        quoteKidneysTFld.setEditable(false);

        customerLungsLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerLungsLbl.setText("Lungs:");

        quoteLungsTFld.setEditable(false);

        customerMuscuLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerMuscuLbl.setText("Musculoskeletal:");

        quoteMusculoTFld.setEditable(false);

        customerOtherHealthCondLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerOtherHealthCondLbl.setText("Other:");

        quoteOtherTFld.setEditable(false);

        customerSmokerStatusLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        customerSmokerStatusLbl.setText("Smoker:");

        quoteSmokerTFld.setEditable(false);

        javax.swing.GroupLayout quoteHealthDetailsPnlLayout = new javax.swing.GroupLayout(quoteHealthDetailsPnl);
        quoteHealthDetailsPnl.setLayout(quoteHealthDetailsPnlLayout);
        quoteHealthDetailsPnlLayout.setHorizontalGroup(
            quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quoteHealthDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(customerOtherHealthCondLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerMuscuLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerLungsLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerKidneysLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerInfectionsLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerGastroLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerBoneMarrowLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerCancerLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerCardDiseaseLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerSmokerStatusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(quoteOtherTFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(quoteMusculoTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteLungsTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteKidneysTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteInfectionsTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteGastroTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteCDiseaseTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteBMarrowTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteCancerTFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quoteSmokerTFld))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quoteHealthDetailsPnlLayout.setVerticalGroup(
            quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quoteHealthDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerBoneMarrowLbl)
                    .addComponent(quoteBMarrowTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCancerLbl)
                    .addComponent(quoteCancerTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCardDiseaseLbl)
                    .addComponent(quoteCDiseaseTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerGastroLbl)
                    .addComponent(quoteGastroTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerInfectionsLbl)
                    .addComponent(quoteInfectionsTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerKidneysLbl)
                    .addComponent(quoteKidneysTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLungsLbl)
                    .addComponent(quoteLungsTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerMuscuLbl)
                    .addComponent(quoteMusculoTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerOtherHealthCondLbl)
                    .addComponent(quoteOtherTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quoteHealthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerSmokerStatusLbl)
                    .addComponent(quoteSmokerTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        quoteFormIdNoTxtFld.setEditable(false);
        quoteFormIdNoTxtFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quoteFormIdNoTxtFld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout QuoteLayout = new javax.swing.GroupLayout(Quote.getContentPane());
        Quote.getContentPane().setLayout(QuoteLayout);
        QuoteLayout.setHorizontalGroup(
            QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(QuoteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(finalQuotationPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QuoteLayout.createSequentialGroup()
                        .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quotePersonalDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(QuoteLayout.createSequentialGroup()
                                    .addGap(204, 204, 204)
                                    .addComponent(quoteBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(quoteHealthDetailsPnl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QuoteLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(quotePanelTitleLbl)))
                        .addGap(18, 18, 18)
                        .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quoteHealthDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quoteFormIdNoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        QuoteLayout.setVerticalGroup(
            QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotePanelTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quoteFormIdNoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(quoteHealthDetailsPnl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QuoteLayout.createSequentialGroup()
                        .addComponent(quotePersonalDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quoteHealthDetailsPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuoteLayout.createSequentialGroup()
                        .addComponent(quoteBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(finalQuotationPnl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Slainte Health Insurance");

        headingLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headingLbl.setText("Slainte Health Insurance Form");

        personalDetailsPnl.setBackground(new java.awt.Color(204, 204, 204));
        personalDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        personalDetailsPnl.setForeground(new java.awt.Color(102, 102, 102));

        firstNameLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        firstNameLbl.setText("Firstname: ");

        firstNameTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTxtFldActionPerformed(evt);
            }
        });

        surnameLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        surnameLbl.setText("Surname:");

        genderLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        genderLbl.setText("Gender:");

        ageLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ageLbl.setText("Age:");

        genderBtnGrp.add(maleRadBtn);
        maleRadBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        maleRadBtn.setText("Male");
        maleRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadBtnActionPerformed(evt);
            }
        });

        genderBtnGrp.add(femaleRadBtn);
        femaleRadBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        femaleRadBtn.setText("Female");

        ageCmbBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ageCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select...", "Under 35", "35 to 55 inclusive", "56 to 70 inclusive", "Over 70" }));
        ageCmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageCmbBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personalDetailsPnlLayout = new javax.swing.GroupLayout(personalDetailsPnl);
        personalDetailsPnl.setLayout(personalDetailsPnlLayout);
        personalDetailsPnlLayout.setHorizontalGroup(
            personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalDetailsPnlLayout.createSequentialGroup()
                        .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalDetailsPnlLayout.createSequentialGroup()
                                .addComponent(genderLbl)
                                .addGap(18, 18, 18))
                            .addGroup(personalDetailsPnlLayout.createSequentialGroup()
                                .addComponent(ageLbl)
                                .addGap(38, 38, 38)))
                        .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(femaleRadBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalDetailsPnlLayout.createSequentialGroup()
                        .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLbl)
                            .addComponent(surnameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maleRadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        personalDetailsPnlLayout.setVerticalGroup(
            personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPnlLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLbl)
                    .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLbl)
                    .addComponent(maleRadBtn)
                    .addComponent(femaleRadBtn))
                .addGap(18, 18, 18)
                .addGroup(personalDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLbl)
                    .addComponent(ageCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        healthDetailsPnl.setBackground(new java.awt.Color(204, 204, 204));
        healthDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Health Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        existingHealthConditionsLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        existingHealthConditionsLbl.setText("Existing Health Condition:");

        otherLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        otherLbl.setText("If other, please specify:");

        otherTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherTxtFldActionPerformed(evt);
            }
        });

        smokerLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        smokerLbl.setText("Smoker:");

        smokerBtnGrp.add(smokerRadBtn);
        smokerRadBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        smokerRadBtn.setText("Smoker");

        smokerBtnGrp.add(nonSmokerRadBtn);
        nonSmokerRadBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nonSmokerRadBtn.setText("Non-smoker");

        existingHealthConditionsLstBx.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "None", "Bone Marrow", "Cancer", "Cardiovascular Disease", "Gastrointestinal", "Infections", "Kidneys", "Lungs", "Musculoskeletal" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(existingHealthConditionsLstBx);

        javax.swing.GroupLayout healthDetailsPnlLayout = new javax.swing.GroupLayout(healthDetailsPnl);
        healthDetailsPnl.setLayout(healthDetailsPnlLayout);
        healthDetailsPnlLayout.setHorizontalGroup(
            healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                        .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(existingHealthConditionsLbl)
                            .addComponent(smokerLbl))
                        .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                            .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nonSmokerRadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(smokerRadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                        .addComponent(otherLbl)
                        .addGap(34, 34, 34)
                        .addComponent(otherTxtFld)))
                .addContainerGap())
        );
        healthDetailsPnlLayout.setVerticalGroup(
            healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(healthDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existingHealthConditionsLbl)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherLbl)
                    .addComponent(otherTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(healthDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smokerLbl)
                    .addComponent(smokerRadBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nonSmokerRadBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        schemeDetailsPnll.setBackground(new java.awt.Color(204, 204, 204));
        schemeDetailsPnll.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Scheme Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        PolicyTypeLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        PolicyTypeLbl.setText("Policy Type:");

        HospitalCoverLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        HospitalCoverLbl.setText("Hospital Cover:");

        DayToDayExpensesLbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        DayToDayExpensesLbl.setText("Day to Day Expenses:");

        policyTypeCmbBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        policyTypeCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select...", "Individual Policy", "Corporate Policy" }));

        hospitalCoverCmbBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        hospitalCoverCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "Public Hospitals", "Private Hospitals", "Comprehensive" }));
        hospitalCoverCmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalCoverCmbBoxActionPerformed(evt);
            }
        });

        dayToDayExpensesCmbBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dayToDayExpensesCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select...", "Standard", "Enhanced", "Comprehensive" }));

        javax.swing.GroupLayout schemeDetailsPnllLayout = new javax.swing.GroupLayout(schemeDetailsPnll);
        schemeDetailsPnll.setLayout(schemeDetailsPnllLayout);
        schemeDetailsPnllLayout.setHorizontalGroup(
            schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schemeDetailsPnllLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DayToDayExpensesLbl)
                    .addComponent(HospitalCoverLbl)
                    .addComponent(PolicyTypeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(policyTypeCmbBox, 0, 172, Short.MAX_VALUE)
                    .addComponent(dayToDayExpensesCmbBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hospitalCoverCmbBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        schemeDetailsPnllLayout.setVerticalGroup(
            schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schemeDetailsPnllLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PolicyTypeLbl)
                    .addComponent(policyTypeCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HospitalCoverLbl)
                    .addComponent(hospitalCoverCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schemeDetailsPnllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DayToDayExpensesLbl)
                    .addComponent(dayToDayExpensesCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        finalQuotationPnl.setBackground(new java.awt.Color(204, 204, 204));
        finalQuotationPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fianl Quotation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        quoteIdNoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quoteIdNoLbl.setText("Quote ID No:");

        quoteIdNoTxtFld.setEditable(false);

        totalPriceTxtFld.setEditable(false);

        totalPriceLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalPriceLbl.setForeground(new java.awt.Color(255, 51, 51));
        totalPriceLbl.setText("Total:");

        javax.swing.GroupLayout finalQuotationPnlLayout = new javax.swing.GroupLayout(finalQuotationPnl);
        finalQuotationPnl.setLayout(finalQuotationPnlLayout);
        finalQuotationPnlLayout.setHorizontalGroup(
            finalQuotationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalQuotationPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quoteIdNoLbl)
                .addGap(12, 12, 12)
                .addComponent(quoteIdNoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalPriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceTxtFld)
                .addContainerGap())
        );
        finalQuotationPnlLayout.setVerticalGroup(
            finalQuotationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalQuotationPnlLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(finalQuotationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quoteIdNoLbl)
                    .addComponent(quoteIdNoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPriceLbl)
                    .addComponent(totalPriceTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        calculateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        calculateBtn.setText("Calculate");
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateBtnActionPerformed(evt);
            }
        });

        clearFormBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearFormBtn.setText("Clear Form");
        clearFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormBtnActionPerformed(evt);
            }
        });

        buyPolicyBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buyPolicyBtn.setText("Buy Policy");
        buyPolicyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyPolicyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headingLbl)
                    .addComponent(personalDetailsPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(schemeDetailsPnll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finalQuotationPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(healthDetailsPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(calculateBtn)
                .addGap(85, 85, 85)
                .addComponent(clearFormBtn)
                .addGap(116, 116, 116)
                .addComponent(buyPolicyBtn)
                .addGap(0, 123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(headingLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personalDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(schemeDetailsPnll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(healthDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(finalQuotationPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculateBtn)
                    .addComponent(clearFormBtn)
                    .addComponent(buyPolicyBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTxtFldActionPerformed

    private void maleRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadBtnActionPerformed

    private void otherTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherTxtFldActionPerformed

    private void ageCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageCmbBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageCmbBoxActionPerformed

    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateBtnActionPerformed
        //Calcualte Quote Price
        
        //Check that form has been filled out properly by user
        validateForm();

        //Create objects and calculate insurance premium price
        if(formValidated==true)
        {
            //Prevent user from pressing calculate button until clear button
            //has been pressed
            calculateBtn.setEnabled(false);
            
            //Call extractFormDetails method
            extractFormDetails();
            
            //Create new Customer object using extracted form details
            c1 = new Customer(inputFirstName,inputSurname,inputAge,inputGender, inputSmoker
            ,inputHealthConditions,inputOtherConditions);
            
            //Create new Policty object using extracted form details
            //If statement for whether user selected individual or corporate
            if(inputPolicyType.equalsIgnoreCase("Individual"))
            {
                ip1 = new IndividualPolicy(inputPolicyNo,c1,inputHospitalCover
                ,inputDayToDayExpenses,inputPolicyType);
                totalPrice = ip1.calculatePremium();
            }            
            if(inputPolicyType.equalsIgnoreCase("Corporate"))
            {
                cp1 = new CorporatePolicy(inputPolicyNo,c1,inputHospitalCover
                ,inputDayToDayExpenses,inputPolicyType);
                totalPrice = cp1.calculatePremium();
            }
            
            //Set price formatting to currency
            NumberFormat numFormat = NumberFormat.getCurrencyInstance();
            
            //Show insurance price
            totalPriceTxtFld.setText(String.valueOf(numFormat.format(totalPrice)));
 
            //Show quote Id 
            quoteIdNoTxtFld.setText(String.valueOf(inputPolicyNo));
            
            //Change status of boolean variable
            formValidated=false;
            
        }//end if statement
    //end calculateBtnActionPerformed method
    }//GEN-LAST:event_calculateBtnActionPerformed

    private void clearFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormBtnActionPerformed
        //Reset form
        
        //Reset First Name option
        firstNameTxtFld.setText("");
        //Reset Surname option
        surnameTxtFld.setText("");
        //Reset Gender option
        genderBtnGrp.clearSelection();
        //Reset Age option
        ageCmbBox.setSelectedIndex(0);
        //Reset Policy Type option 
        policyTypeCmbBox.setSelectedIndex(0);
        //Reset Hospital Cover option
        hospitalCoverCmbBox.setSelectedIndex(0);
        //Reset Day to Day Expenses option 
        dayToDayExpensesCmbBox.setSelectedIndex(0);
        //Reset Health Conditions options
        existingHealthConditionsLstBx.clearSelection();
        //Reset Other Conditions options
        otherTxtFld.setText("");
        //Reset Smoker Status option
        smokerBtnGrp.clearSelection();
        //Reset Calculate Button Status
        calculateBtn.setEnabled(true);
        //Increase policyNo counter
        inputPolicyNo++;
        //Reset quote id text field
        quoteIdNoTxtFld.setText("");
        //Reset total price text field
        totalPriceTxtFld.setText("");
        //Reset Health Conditions options
        inputHealthConditions.clear();
    }//GEN-LAST:event_clearFormBtnActionPerformed

    private void buyPolicyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyPolicyBtnActionPerformed
        //Create new window to show quote details
        Quote.setVisible(true);
    }//GEN-LAST:event_buyPolicyBtnActionPerformed

    private void quoteBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quoteBackBtnActionPerformed
        //Return to orignal form window
        Quote.setVisible(false);
    }//GEN-LAST:event_quoteBackBtnActionPerformed

    private void QuoteComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_QuoteComponentShown
        //Quote Summary Window
      
        //Set ID No for current policy
        quoteFormIdNoTxtFld.setText(String.valueOf(inputPolicyNo));
        
        //Set Customer Details
        
        //Set customer name
        customerNameTxtFld.setText(firstNameTxtFld.getText()+" "
                +surnameTxtFld.getText());
        
        ////Set customer age
        quoteAgeTxtFld.setText(ageCmbBox.getSelectedItem().toString());
        
        //Set customer gender
        if(maleRadBtn.isSelected())
        {
            customerGenderTxtFld.setText("Male");
        }
        else
        {
            customerGenderTxtFld.setText("Female");
        }
        
        //Set policy type 
        quotePolicyTypeTxtFld.setText
        (policyTypeCmbBox.getSelectedItem().toString());
        
        //Set hospital cover
        quoteHCoverTxtFld.setText(hospitalCoverCmbBox.getSelectedItem().toString());
        
        //Set day to day expenses
        quoteExpensesTxtFld.setText(dayToDayExpensesCmbBox.getSelectedItem().toString());
        
        //Set healthConditions
        if(inputHealthConditions.contains("Bone Marrow"))
        {
            quoteBMarrowTFld.setText("Yes");
        }
        else
        {
            quoteBMarrowTFld.setText("No");
        }
        if(inputHealthConditions.contains("Cancer")){
            
            quoteCancerTFld.setText("Yes");
        }
        else
        {
            quoteCancerTFld.setText("No");
        }
        if(inputHealthConditions.contains("Cardiovascular Disease"))
        {
            quoteCDiseaseTFld.setText("Yes");
        }
        else
        {
            quoteCDiseaseTFld.setText("No");
        }
        if(inputHealthConditions.contains("Gastrointestinal"))
        {
            quoteGastroTFld.setText("Yes");
        }
        else
        {
            quoteGastroTFld.setText("No");
        }
        if(inputHealthConditions.contains("Infections"))
        {
            quoteInfectionsTFld.setText("Yes");
        }
        else
        {
            quoteInfectionsTFld.setText("No");
        }
        if(inputHealthConditions.contains("Kidneys"))
        {
            quoteKidneysTFld.setText("Yes");
        }
        else
        {
            quoteKidneysTFld.setText("No");
        }
        if(inputHealthConditions.contains("Lungs"))
        {
            quoteLungsTFld.setText("Yes");
        }
        else
        {
            quoteLungsTFld.setText("No");
        }
        if(inputHealthConditions.contains("Musculoskeletal"))
        {
            quoteMusculoTFld.setText("Yes");
        }
        else
        {
            quoteMusculoTFld.setText("No");
        }
        
        //Set otherHealthConditions
        if(otherTxtFld.getText().equalsIgnoreCase(""))
        {
            quoteOtherTFld.setText("No");
        }
        else
        {
            quoteOtherTFld.setText(otherTxtFld.getText());
        }
         
        //Set smoker status
        if(smokerRadBtn.isSelected())
        {
            quoteSmokerTFld.setText("Yes");
        }
        else
        {
            quoteSmokerTFld.setText("No");
        }
        
        //Set policy No
        quoteSummaryIdNoTFld.setText(String.valueOf(inputPolicyNo));
        
        //Set quote price
        quoteTotalTFld.setText(totalPriceTxtFld.getText());
        
    //end QuoteComponentShown method
    }//GEN-LAST:event_QuoteComponentShown

    private void hospitalCoverCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalCoverCmbBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalCoverCmbBoxActionPerformed
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SlainteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SlainteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SlainteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SlainteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlainteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayToDayExpensesLbl;
    private javax.swing.JLabel HospitalCoverLbl;
    private javax.swing.JLabel PolicyTypeLbl;
    private javax.swing.JFrame Quote;
    private javax.swing.JComboBox<String> ageCmbBox;
    private javax.swing.JLabel ageLbl;
    private javax.swing.JButton buyPolicyBtn;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JButton clearFormBtn;
    private javax.swing.JLabel customerAgeLbl;
    private javax.swing.JLabel customerBoneMarrowLbl;
    private javax.swing.JLabel customerCancerLbl;
    private javax.swing.JLabel customerCardDiseaseLbl;
    private javax.swing.JLabel customerGastroLbl;
    private javax.swing.JLabel customerGenderLbl;
    private javax.swing.JTextField customerGenderTxtFld;
    private javax.swing.JLabel customerInfectionsLbl;
    private javax.swing.JLabel customerKidneysLbl;
    private javax.swing.JLabel customerLungsLbl;
    private javax.swing.JLabel customerMuscuLbl;
    private javax.swing.JLabel customerNameLbl;
    private javax.swing.JTextField customerNameTxtFld;
    private javax.swing.JLabel customerOtherHealthCondLbl;
    private javax.swing.JLabel customerSmokerStatusLbl;
    private javax.swing.JComboBox<String> dayToDayExpensesCmbBox;
    private javax.swing.JLabel existingHealthConditionsLbl;
    private javax.swing.JList<String> existingHealthConditionsLstBx;
    private javax.swing.JRadioButton femaleRadBtn;
    private javax.swing.JPanel finalQuotationPnl;
    private javax.swing.JPanel finalQuotationPnl1;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JTextField firstNameTxtFld;
    private javax.swing.ButtonGroup genderBtnGrp;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel headingLbl;
    private javax.swing.JPanel healthDetailsPnl;
    private javax.swing.JComboBox<String> hospitalCoverCmbBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maleRadBtn;
    private javax.swing.JRadioButton nonSmokerRadBtn;
    private javax.swing.JLabel otherLbl;
    private javax.swing.JTextField otherTxtFld;
    private javax.swing.JPanel personalDetailsPnl;
    private javax.swing.JComboBox<String> policyTypeCmbBox;
    private javax.swing.JTextField quoteAgeTxtFld;
    private javax.swing.JTextField quoteBMarrowTFld;
    private javax.swing.JButton quoteBackBtn;
    private javax.swing.JTextField quoteCDiseaseTFld;
    private javax.swing.JTextField quoteCancerTFld;
    private javax.swing.JLabel quoteExpensesLbl;
    private javax.swing.JTextField quoteExpensesTxtFld;
    private javax.swing.JTextField quoteFormIdNoTxtFld;
    private javax.swing.JTextField quoteGastroTFld;
    private javax.swing.JLabel quoteHCoverLbl;
    private javax.swing.JTextField quoteHCoverTxtFld;
    private javax.swing.JPanel quoteHealthDetailsPnl;
    private javax.swing.JPanel quoteHealthDetailsPnl1;
    private javax.swing.JLabel quoteIdNoLbl;
    private javax.swing.JTextField quoteIdNoTxtFld;
    private javax.swing.JTextField quoteInfectionsTFld;
    private javax.swing.JTextField quoteKidneysTFld;
    private javax.swing.JTextField quoteLungsTFld;
    private javax.swing.JTextField quoteMusculoTFld;
    private javax.swing.JTextField quoteOtherTFld;
    private javax.swing.JLabel quotePanelTitleLbl;
    private javax.swing.JPanel quotePersonalDetailsPnl;
    private javax.swing.JLabel quotePolicyTypeLbl;
    private javax.swing.JTextField quotePolicyTypeTxtFld;
    private javax.swing.JTextField quoteSmokerTFld;
    private javax.swing.JLabel quoteSummaryIdNoLbl;
    private javax.swing.JTextField quoteSummaryIdNoTFld;
    private javax.swing.JLabel quoteTotalLbl;
    private javax.swing.JTextField quoteTotalTFld;
    private javax.swing.JPanel schemeDetailsPnll;
    private javax.swing.ButtonGroup smokerBtnGrp;
    private javax.swing.JLabel smokerLbl;
    private javax.swing.JRadioButton smokerRadBtn;
    private javax.swing.JLabel surnameLbl;
    private javax.swing.JTextField surnameTxtFld;
    private javax.swing.JLabel totalPriceLbl;
    private javax.swing.JTextField totalPriceTxtFld;
    // End of variables declaration//GEN-END:variables

}
