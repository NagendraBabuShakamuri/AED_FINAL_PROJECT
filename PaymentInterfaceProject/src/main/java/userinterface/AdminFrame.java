/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.Address;
import business.AddressDirectory;
import business.AddressRequest;
import business.AddressRequestDirectory;
import business.Bank;
import business.BankAccount;
import business.BankDirectory;
import business.BankRequest;
import business.BankRequestDirectory;
import business.Bus;
import business.BusDirectory;
import business.City;
import business.CityDirectory;
import business.CreditCard;
import business.CreditCardDirectory;
import business.CreditCardRequest;
import business.CreditCardRequestDirectory;
import business.ElectricityBill;
import business.ElectricityBillDirectory;
import business.GasBill;
import business.GasBillDirectory;
import business.MobilePlan;
import business.MobilePlanDirectory;
import business.MobileServiceProvider;
import business.MobileServiceProviderDirectory;
import business.User;
import business.UserCreditCard;
import business.UserDirectory;
import business.WaterBill;
import business.WaterBillDirectory;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static userinterface.UserHomePage.userNameLabel;

/**
 *
 * @author nbabu
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    public AdminFrame() {
        initComponents();
        CityDirectory cd = new CityDirectory();
        for(City c : cd.getCityList())
        {
          createBusFromCityCombo.addItem(c.getCityName());
        }
        createBusFromCityCombo.setSelectedItem(null);
        
        MobileServiceProviderDirectory mp = new MobileServiceProviderDirectory();
        for(MobileServiceProvider msp : mp.getMSPList())
        {
          createMSPNameCombo.addItem(msp.getProviderName());
        }
        createMSPNameCombo.setSelectedItem(null);
        
        BankRequestDirectory brd = new BankRequestDirectory();
        DefaultTableModel table_model = (DefaultTableModel)bankRequestsTable.getModel();
        for(BankRequest br : brd.getBankRequestList())
        {
            String requestId = String.valueOf(br.getId());
            String userId = String.valueOf(br.getUser().getId());
            String bankId = String.valueOf(br.getBank().getId());
            String accountHolder = br.getAccountHolder();
            String accountNumber = String.valueOf(br.getAccountNumber());
            String status = br.getStatus();
            String table_data[] = {requestId, userId, bankId, accountHolder, accountNumber, status};
            table_model.addRow(table_data);
        }
        
        CreditCardRequestDirectory crd = new CreditCardRequestDirectory();
        table_model = (DefaultTableModel)cardRequestsTable.getModel();
        for(CreditCardRequest cr : crd.getCreditCardRequestList())
        {
            String id = String.valueOf(cr.getId());
            String userId = String.valueOf(cr.getUser().getId());
            String cardId = String.valueOf(cr.getCreditCard().getId());
            String cardHolder = cr.getCardHolder();
            String cardNumber = String.valueOf(cr.getCardNumber());
            String cardExpiry = cr.getCardExpiry();
            String cardCvc = String.valueOf(cr.getCardCVC());
            String status = cr.getStatus();
            String table_data[] = {id, userId, cardId, cardHolder, cardNumber, cardExpiry, cardCvc, status};
            table_model.addRow(table_data);
        }
        
        AddressRequestDirectory ard = new AddressRequestDirectory();
        table_model = (DefaultTableModel)addressRequestsTable.getModel();
        for(AddressRequest ar : ard.getAddressRequestList())
        {
            String id = String.valueOf(ar.getId());
            String userId = String.valueOf(ar.getUser().getId());
            String apartment = ar.getApartment();
            String street = ar.getStreet();
            String city = ar.getCity();
            String state = ar.getState();
            String zipCode = ar.getZipCode();
            String status = ar.getStatus();
            String table_data[] = {id, userId, apartment, street, city, state, zipCode, status};
            table_model.addRow(table_data);
        }
        
        UserDirectory ud = new UserDirectory();
        for(User u : ud.getUserList())
        {
          elecBilluserIdCombo.addItem(String.valueOf(u.getId()));
          waterBilluserIdCombo.addItem(String.valueOf(u.getId()));
          gasBilluserIdCombo.addItem(String.valueOf(u.getId()));
        }
        elecBilluserIdCombo.setSelectedItem(null);
        waterBilluserIdCombo.setSelectedItem(null);
        gasBilluserIdCombo.setSelectedItem(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createCityIdField = new javax.swing.JTextField();
        createCityNameField = new javax.swing.JTextField();
        createCityButton = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        updateCityIdField = new javax.swing.JTextField();
        citySearchButton = new javax.swing.JButton();
        cityNameLabel = new javax.swing.JLabel();
        updateCityNameField = new javax.swing.JTextField();
        cityUpdateButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cityPositionField = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        deleteCityIdField = new javax.swing.JTextField();
        deleteCityButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bankRequestsTable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        bankInProgressButton = new javax.swing.JButton();
        bankApprovedButton = new javax.swing.JButton();
        bankDeniedButton = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cardRequestsTable = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        cardInProgressButton = new javax.swing.JButton();
        cardApprovedButton = new javax.swing.JButton();
        cardDeniedButton = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        createBankIdField = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        createBankNameField = new javax.swing.JTextField();
        createBankButton = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        createBankRoutingNumberField = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        updateBankIdField = new javax.swing.JTextField();
        updateBankNameLabel = new javax.swing.JLabel();
        updateBankNameField = new javax.swing.JTextField();
        updateBankButton = new javax.swing.JButton();
        bankSearchButton = new javax.swing.JButton();
        updateBankRoutingNumberField = new javax.swing.JTextField();
        updateBankRoutingNumberLabel = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        bankPositionField = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        deleteBankIdField = new javax.swing.JTextField();
        deleteBankButton = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        createCardIdField = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        createCardNameField = new javax.swing.JTextField();
        createCardButton = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        updateCardIdLabel = new javax.swing.JLabel();
        updateCardIdField = new javax.swing.JTextField();
        updateCardNameLabel = new javax.swing.JLabel();
        updateCardNameField = new javax.swing.JTextField();
        updateCardButton = new javax.swing.JButton();
        searchCardButton = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        cardPositionField = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        updateCardIdLabel1 = new javax.swing.JLabel();
        deleteCardIdField = new javax.swing.JTextField();
        deleteCardButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        createBusIdField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        createBusNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        createBusFromCityCombo = new javax.swing.JComboBox<>();
        createBusToCityCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        createBusStartAtField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        createBusReachAtField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        createBusFareField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        createBusTravelDateField = new javax.swing.JTextField();
        createBusButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        updateBusIdField = new javax.swing.JTextField();
        updateBusNameLabel = new javax.swing.JLabel();
        updateBusNameField = new javax.swing.JTextField();
        updateBusFromCityLabel = new javax.swing.JLabel();
        updateBusFromCityCombo = new javax.swing.JComboBox<>();
        updateBusToCityLabel = new javax.swing.JLabel();
        updateBusToCityCombo = new javax.swing.JComboBox<>();
        updateBusStartAtLabel = new javax.swing.JLabel();
        updateBusStartAtField = new javax.swing.JTextField();
        updateBusReachAtLabel = new javax.swing.JLabel();
        updateBusReachAtField = new javax.swing.JTextField();
        updateBusFareLabel = new javax.swing.JLabel();
        updateBusFareField = new javax.swing.JTextField();
        updateBusTravelDateLabel = new javax.swing.JLabel();
        updateBusTravelDateField = new javax.swing.JTextField();
        updateBusButton = new javax.swing.JButton();
        updateBusSearchButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        busPositionField = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        deleteBusIdField = new javax.swing.JTextField();
        deleteBusButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        createMSPIdField = new javax.swing.JTextField();
        createMSPNameField = new javax.swing.JTextField();
        createMSPButton = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        updateMSPIdField = new javax.swing.JTextField();
        updateMSPNameLabel = new javax.swing.JLabel();
        updateMSPNameField = new javax.swing.JTextField();
        updateMSPButton = new javax.swing.JButton();
        updateMSPIdSearchButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        MSPPositionField = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        deleteMSPButton = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        deleteMSPIdField = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        createMPIdField = new javax.swing.JTextField();
        createMSPNameCombo = new javax.swing.JComboBox<>();
        createPlanNameField = new javax.swing.JTextField();
        createMPDataField = new javax.swing.JTextField();
        createMPCallsField = new javax.swing.JTextField();
        createMPValidityField = new javax.swing.JTextField();
        createMPPriceField = new javax.swing.JTextField();
        createMPButton = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        updateMPIdSearchButton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        updateMPIdField = new javax.swing.JTextField();
        updateMSPNameComboLabel = new javax.swing.JLabel();
        updateMSPNameCombo = new javax.swing.JComboBox<>();
        updatePlanNameLabel = new javax.swing.JLabel();
        updatePlanNameField = new javax.swing.JTextField();
        updateMPDataLabel = new javax.swing.JLabel();
        updateMPDataField = new javax.swing.JTextField();
        updateMPCallsLabel = new javax.swing.JLabel();
        updateMPCallsField = new javax.swing.JTextField();
        updateMPValidityLabel = new javax.swing.JLabel();
        updateMPValidityField = new javax.swing.JTextField();
        updateMPPriceLabel = new javax.swing.JLabel();
        updateMPPriceField = new javax.swing.JTextField();
        updateMPButton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        MPPositionField = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        deleteMPIdField = new javax.swing.JTextField();
        deleteMPButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel32 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        addressRequestsTable = new javax.swing.JTable();
        addressInProgressButton = new javax.swing.JButton();
        addressApprovedButton = new javax.swing.JButton();
        addressDeniedButton = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressesTable = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        addressRefreshButton = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        elecBilluserIdCombo = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        elecBillBillingDateField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        elecBillTotalKWattsField = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        elecBillAmountField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        elecBillDueDateField = new javax.swing.JTextField();
        elecBillSendButton = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        waterBilluserIdCombo = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        waterBillBillingDateField = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        waterBillTotalGallonsField = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        waterBillAmountField = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        waterBillDueDateField = new javax.swing.JTextField();
        waterBillSendButton = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        gasBilluserIdCombo = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        gasBillBillingDateField = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        gasBillTotalGallonsField = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        gasBillAmountField = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        gasBillDueDateField = new javax.swing.JTextField();
        gasBillSendButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Create Admin", jPanel15);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("View/Update Admin", jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Delete Admin", jPanel10);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("City Id:");
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 61, -1));

        jLabel2.setText("City Name:");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));
        jPanel11.add(createCityIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, -1));
        jPanel11.add(createCityNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 130, -1));

        createCityButton.setText("Create");
        createCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCityButtonActionPerformed(evt);
            }
        });
        jPanel11.add(createCityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 230, -1));

        jTabbedPane3.addTab("Create City", jPanel11);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("City Id:");
        jPanel16.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel16.add(updateCityIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 110, -1));

        citySearchButton.setText("Search");
        citySearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citySearchButtonActionPerformed(evt);
            }
        });
        jPanel16.add(citySearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        cityNameLabel.setText("City Name:");
        jPanel16.add(cityNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));
        cityNameLabel.setVisible(false);
        jPanel16.add(updateCityNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 110, -1));
        updateCityNameField.setVisible(false);

        cityUpdateButton.setText("Update");
        cityUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityUpdateButtonActionPerformed(evt);
            }
        });
        jPanel16.add(cityUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 190, -1));
        cityUpdateButton.setVisible(false);

        jLabel4.setText("Position:");
        jPanel16.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        cityPositionField.setEnabled(false);
        jPanel16.add(cityPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 110, -1));

        jTabbedPane3.addTab("View/Update City", jPanel16);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("City Id:");
        jPanel17.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel17.add(deleteCityIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 130, -1));

        deleteCityButton.setText("Delete");
        deleteCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCityButtonActionPerformed(evt);
            }
        });
        jPanel17.add(deleteCityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 220, -1));

        jTabbedPane3.addTab("Delete City", jPanel17);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("System Admin", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bankRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "User Id", "Bank Id", "Account Holder", "Account Number", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bankRequestsTable);

        jPanel24.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 630, 270));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("Bank requests");
        jPanel24.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        bankInProgressButton.setText("In Progress");
        bankInProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankInProgressButtonActionPerformed(evt);
            }
        });
        jPanel24.add(bankInProgressButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        bankApprovedButton.setText("Approved");
        bankApprovedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankApprovedButtonActionPerformed(evt);
            }
        });
        jPanel24.add(bankApprovedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        bankDeniedButton.setText("Denied");
        bankDeniedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankDeniedButtonActionPerformed(evt);
            }
        });
        jPanel24.add(bankDeniedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jTabbedPane5.addTab("Bank Requests", jPanel24);

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "User Id", "Card Id", "Card Holder", "Card Number", "Card Expiry", "Card CVC", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cardRequestsTable);

        jPanel25.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 140, 670, 260));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setText("Credit card requests");
        jPanel25.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        cardInProgressButton.setText("In Progress");
        cardInProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardInProgressButtonActionPerformed(evt);
            }
        });
        jPanel25.add(cardInProgressButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));

        cardApprovedButton.setText("Approved");
        cardApprovedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardApprovedButtonActionPerformed(evt);
            }
        });
        jPanel25.add(cardApprovedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        cardDeniedButton.setText("Denied");
        cardDeniedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardDeniedButtonActionPerformed(evt);
            }
        });
        jPanel25.add(cardDeniedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        jTabbedPane5.addTab("Credit card Requests", jPanel25);

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setText("Bank Id:");
        jPanel26.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        jPanel26.add(createBankIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 110, -1));

        jLabel35.setText("Bank Name:");
        jPanel26.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));
        jPanel26.add(createBankNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 110, -1));

        createBankButton.setText("Create");
        createBankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBankButtonActionPerformed(evt);
            }
        });
        jPanel26.add(createBankButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 220, -1));

        jLabel37.setText("Routing Number:");
        jPanel26.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));
        jPanel26.add(createBankRoutingNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 110, -1));

        jTabbedPane5.addTab("Create Bank", jPanel26);

        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("Bank Id:");
        jPanel27.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        jPanel27.add(updateBankIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 110, -1));

        updateBankNameLabel.setText("Bank Name:");
        jPanel27.add(updateBankNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));
        updateBankNameLabel.setVisible(false);
        jPanel27.add(updateBankNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 110, -1));
        updateBankNameField.setVisible(false);

        updateBankButton.setText("Update");
        updateBankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBankButtonActionPerformed(evt);
            }
        });
        jPanel27.add(updateBankButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 220, -1));
        updateBankButton.setVisible(false);

        bankSearchButton.setText("Search");
        bankSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankSearchButtonActionPerformed(evt);
            }
        });
        jPanel27.add(bankSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));
        jPanel27.add(updateBankRoutingNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 110, -1));
        updateBankRoutingNumberField.setVisible(false);

        updateBankRoutingNumberLabel.setText("Routing Number:");
        jPanel27.add(updateBankRoutingNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));
        updateBankRoutingNumberLabel.setVisible(false);

        jLabel39.setText("Position:");
        jPanel27.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        bankPositionField.setEnabled(false);
        jPanel27.add(bankPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 110, -1));

        jTabbedPane5.addTab("View/Update Bank", jPanel27);

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Bank Id:");
        jPanel28.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, 20));
        jPanel28.add(deleteBankIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 197, 110, -1));

        deleteBankButton.setText("Delete");
        deleteBankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBankButtonActionPerformed(evt);
            }
        });
        jPanel28.add(deleteBankButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 190, 30));

        jTabbedPane5.addTab("Delete Bank", jPanel28);

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setText("Card Id:");
        jPanel29.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));
        jPanel29.add(createCardIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 110, -1));

        jLabel41.setText("Card Name:");
        jPanel29.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        jPanel29.add(createCardNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 110, -1));

        createCardButton.setText("Create");
        createCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCardButtonActionPerformed(evt);
            }
        });
        jPanel29.add(createCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 220, -1));

        jTabbedPane5.addTab("Create credit card", jPanel29);

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateCardIdLabel.setText("Card Id:");
        jPanel30.add(updateCardIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));
        jPanel30.add(updateCardIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 110, -1));

        updateCardNameLabel.setText("Card Name:");
        jPanel30.add(updateCardNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        updateCardNameLabel.setVisible(false);
        jPanel30.add(updateCardNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 110, -1));
        updateCardNameField.setVisible(false);

        updateCardButton.setText("Update");
        updateCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCardButtonActionPerformed(evt);
            }
        });
        jPanel30.add(updateCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 220, -1));
        updateCardButton.setVisible(false);

        searchCardButton.setText("Search");
        searchCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCardButtonActionPerformed(evt);
            }
        });
        jPanel30.add(searchCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jLabel44.setText("Position:");
        jPanel30.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        cardPositionField.setEnabled(false);
        jPanel30.add(cardPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 110, -1));

        jTabbedPane5.addTab("View/Update Credit card", jPanel30);

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateCardIdLabel1.setText("Card Id:");
        jPanel31.add(updateCardIdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));
        jPanel31.add(deleteCardIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 110, -1));

        deleteCardButton.setText("Delete");
        deleteCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCardButtonActionPerformed(evt);
            }
        });
        jPanel31.add(deleteCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 220, -1));

        jTabbedPane5.addTab("Delete Credit card", jPanel31);

        jPanel2.add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 870));

        jTabbedPane1.addTab("Banking Admin", jPanel2);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Bus Id:");
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel12.add(createBusIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jLabel7.setText("Bus Name:");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel12.add(createBusNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        jLabel8.setText("From city:");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jLabel9.setText("To city:");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        createBusFromCityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                createBusFromCityComboItemStateChanged(evt);
            }
        });
        jPanel12.add(createBusFromCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));

        jPanel12.add(createBusToCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));

        jLabel10.setText("Start At:");
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        jPanel12.add(createBusStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));

        jLabel11.setText("Reach At:");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));
        jPanel12.add(createBusReachAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 120, -1));

        jLabel12.setText("Fare:");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        jPanel12.add(createBusFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));

        jLabel13.setText("Travel date:");
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));
        jPanel12.add(createBusTravelDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));

        createBusButton.setText("Create");
        createBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBusButtonActionPerformed(evt);
            }
        });
        jPanel12.add(createBusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 210, -1));

        jTabbedPane2.addTab("Create Buses", jPanel12);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Bus Id:");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel13.add(updateBusIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        updateBusNameLabel.setText("Bus Name:");
        jPanel13.add(updateBusNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        updateBusNameLabel.setVisible(false);
        jPanel13.add(updateBusNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));
        updateBusNameField.setVisible(false);

        updateBusFromCityLabel.setText("From city:");
        jPanel13.add(updateBusFromCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));
        updateBusFromCityLabel.setVisible(false);

        updateBusFromCityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateBusFromCityComboItemStateChanged(evt);
            }
        });
        jPanel13.add(updateBusFromCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));
        updateBusFromCityCombo.setVisible(false);

        updateBusToCityLabel.setText("To city:");
        jPanel13.add(updateBusToCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        updateBusToCityLabel.setVisible(false);

        jPanel13.add(updateBusToCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));
        updateBusToCityCombo.setVisible(false);

        updateBusStartAtLabel.setText("Start At:");
        jPanel13.add(updateBusStartAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        updateBusStartAtLabel.setVisible(false);
        jPanel13.add(updateBusStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));
        updateBusStartAtField.setVisible(false);

        updateBusReachAtLabel.setText("Reach At:");
        jPanel13.add(updateBusReachAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));
        updateBusReachAtLabel.setVisible(false);
        jPanel13.add(updateBusReachAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 120, -1));
        updateBusReachAtField.setVisible(false);

        updateBusFareLabel.setText("Fare:");
        jPanel13.add(updateBusFareLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        updateBusFareLabel.setVisible(false);
        jPanel13.add(updateBusFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));
        updateBusFareField.setVisible(false);

        updateBusTravelDateLabel.setText("Travel date:");
        jPanel13.add(updateBusTravelDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));
        updateBusTravelDateLabel.setVisible(false);
        jPanel13.add(updateBusTravelDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));
        updateBusTravelDateField.setVisible(false);

        updateBusButton.setText("Update");
        updateBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBusButtonActionPerformed(evt);
            }
        });
        jPanel13.add(updateBusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 210, -1));
        updateBusButton.setVisible(false);

        updateBusSearchButton.setText("Search");
        updateBusSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBusSearchButtonActionPerformed(evt);
            }
        });
        jPanel13.add(updateBusSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel16.setText("Position:");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        busPositionField.setEnabled(false);
        jPanel13.add(busPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, -1));

        jTabbedPane2.addTab("View/Update Buses", jPanel13);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Bus Id:");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 137, -1, -1));
        jPanel14.add(deleteBusIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, -1));

        deleteBusButton.setText("Delete");
        deleteBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBusButtonActionPerformed(evt);
            }
        });
        jPanel14.add(deleteBusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, -1));

        jTabbedPane2.addTab("Delete Buses", jPanel14);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Bus Admin", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Train Admin", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("MSP Id:");
        jPanel18.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jLabel18.setText("MSP Name:");
        jPanel18.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));
        jPanel18.add(createMSPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, -1));
        jPanel18.add(createMSPNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 120, -1));

        createMSPButton.setText("Create");
        createMSPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMSPButtonActionPerformed(evt);
            }
        });
        jPanel18.add(createMSPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 230, -1));

        jTabbedPane4.addTab("Create MSP", jPanel18);

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("MSP Id:");
        jPanel19.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));
        jPanel19.add(updateMSPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, -1));

        updateMSPNameLabel.setText("MSP Name:");
        jPanel19.add(updateMSPNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));
        updateMSPNameLabel.setVisible(false);
        jPanel19.add(updateMSPNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 120, -1));
        updateMSPNameField.setVisible(false);

        updateMSPButton.setText("Update");
        updateMSPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMSPButtonActionPerformed(evt);
            }
        });
        jPanel19.add(updateMSPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 230, -1));
        updateMSPButton.setVisible(false);

        updateMSPIdSearchButton.setText("Search");
        updateMSPIdSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMSPIdSearchButtonActionPerformed(evt);
            }
        });
        jPanel19.add(updateMSPIdSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel28.setText("Position:");
        jPanel19.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        MSPPositionField.setEnabled(false);
        jPanel19.add(MSPPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 120, -1));

        jTabbedPane4.addTab("View/Update MSP", jPanel19);

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteMSPButton.setText("Delete");
        deleteMSPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMSPButtonActionPerformed(evt);
            }
        });
        jPanel20.add(deleteMSPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 230, -1));

        jLabel30.setText("MSP Id:");
        jPanel20.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));
        jPanel20.add(deleteMSPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 120, -1));

        jTabbedPane4.addTab("Delete MSP", jPanel20);

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("MP Id:");
        jPanel21.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        jLabel20.setText("MSP Name:");
        jPanel21.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jLabel21.setText("Plan Name:");
        jPanel21.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        jLabel22.setText("Data:");
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel23.setText("Calls");
        jPanel21.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        jLabel24.setText("Validity:");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel25.setText("Price:");
        jPanel21.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));
        jPanel21.add(createMPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, -1));

        jPanel21.add(createMSPNameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 110, -1));
        jPanel21.add(createPlanNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 110, -1));
        jPanel21.add(createMPDataField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 110, -1));
        jPanel21.add(createMPCallsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 110, -1));
        jPanel21.add(createMPValidityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 110, -1));
        jPanel21.add(createMPPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 110, -1));

        createMPButton.setText("Create");
        createMPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMPButtonActionPerformed(evt);
            }
        });
        jPanel21.add(createMPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 230, -1));

        jTabbedPane4.addTab("Create Mobile Plan", jPanel21);

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateMPIdSearchButton.setText("Search");
        updateMPIdSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMPIdSearchButtonActionPerformed(evt);
            }
        });
        jPanel22.add(updateMPIdSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel26.setText("MP Id:");
        jPanel22.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));
        jPanel22.add(updateMPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 110, -1));

        updateMSPNameComboLabel.setText("MSP Name:");
        jPanel22.add(updateMSPNameComboLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));
        updateMSPNameComboLabel.setVisible(false);

        jPanel22.add(updateMSPNameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 110, -1));
        updateMSPNameCombo.setVisible(false);

        updatePlanNameLabel.setText("Plan Name:");
        jPanel22.add(updatePlanNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));
        updatePlanNameLabel.setVisible(false);
        jPanel22.add(updatePlanNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 110, -1));
        updatePlanNameField.setVisible(false);

        updateMPDataLabel.setText("Data:");
        jPanel22.add(updateMPDataLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));
        updateMPDataLabel.setVisible(false);
        jPanel22.add(updateMPDataField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 110, -1));
        updateMPDataField.setVisible(false);

        updateMPCallsLabel.setText("Calls");
        jPanel22.add(updateMPCallsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));
        updateMPCallsLabel.setVisible(false);
        jPanel22.add(updateMPCallsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 110, -1));
        updateMPCallsField.setVisible(false);

        updateMPValidityLabel.setText("Validity:");
        jPanel22.add(updateMPValidityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));
        updateMPValidityLabel.setVisible(false);
        jPanel22.add(updateMPValidityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 110, -1));
        updateMPValidityField.setVisible(false);

        updateMPPriceLabel.setText("Price:");
        jPanel22.add(updateMPPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));
        updateMPPriceLabel.setVisible(false);
        jPanel22.add(updateMPPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 110, -1));
        updateMPPriceField.setVisible(false);

        updateMPButton.setText("Update");
        updateMPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMPButtonActionPerformed(evt);
            }
        });
        jPanel22.add(updateMPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 200, -1));
        updateMPButton.setVisible(false);

        jLabel29.setText("Position:");
        jPanel22.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        MPPositionField.setEnabled(false);
        jPanel22.add(MPPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 110, -1));

        jTabbedPane4.addTab("View/Update Mobile Plan", jPanel22);

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("MP Id:");
        jPanel23.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));
        jPanel23.add(deleteMPIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 110, -1));

        deleteMPButton.setText("Delete");
        deleteMPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMPButtonActionPerformed(evt);
            }
        });
        jPanel23.add(deleteMPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 230, -1));

        jTabbedPane4.addTab("Delete Mobile Plan", jPanel23);

        jPanel5.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 870));

        jTabbedPane1.addTab("Recharge Admin", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane6.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setText("Address requests");
        jPanel32.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        addressRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "User Id", "Apartment", "Street", "City", "State", "Zip Code", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(addressRequestsTable);

        jPanel32.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 630, 270));

        addressInProgressButton.setText("In Progress");
        addressInProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressInProgressButtonActionPerformed(evt);
            }
        });
        jPanel32.add(addressInProgressButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        addressApprovedButton.setText("Approved");
        addressApprovedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressApprovedButtonActionPerformed(evt);
            }
        });
        jPanel32.add(addressApprovedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        addressDeniedButton.setText("Denied");
        addressDeniedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressDeniedButtonActionPerformed(evt);
            }
        });
        jPanel32.add(addressDeniedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jTabbedPane6.addTab("Address Requests", jPanel32);

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addressesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "Apartment", "Street", "City", "State", "Zip Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(addressesTable);

        jPanel33.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 630, 270));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setText("Addresses");
        jPanel33.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        addressRefreshButton.setText("Refresh");
        addressRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRefreshButtonActionPerformed(evt);
            }
        });
        jPanel33.add(addressRefreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jTabbedPane6.addTab("Addresses", jPanel33);

        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setText("User Id:");
        jPanel34.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jPanel34.add(elecBilluserIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        jLabel46.setText("Billing date:");
        jPanel34.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));
        jPanel34.add(elecBillBillingDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, -1));

        jLabel47.setText("Total KWatts:");
        jPanel34.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));
        jPanel34.add(elecBillTotalKWattsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, -1));

        jLabel48.setText("Amount:");
        jPanel34.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));
        jPanel34.add(elecBillAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 100, -1));

        jLabel49.setText("Due date:");
        jPanel34.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));
        jPanel34.add(elecBillDueDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, -1));

        elecBillSendButton.setText("Send bill");
        elecBillSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecBillSendButtonActionPerformed(evt);
            }
        });
        jPanel34.add(elecBillSendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 200, -1));

        jTabbedPane6.addTab("Electricity bill", jPanel34);

        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setText("User Id:");
        jPanel35.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jPanel35.add(waterBilluserIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        jLabel51.setText("Billing date:");
        jPanel35.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));
        jPanel35.add(waterBillBillingDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, -1));

        jLabel52.setText("Total Gallons:");
        jPanel35.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));
        jPanel35.add(waterBillTotalGallonsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, -1));

        jLabel53.setText("Amount:");
        jPanel35.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));
        jPanel35.add(waterBillAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 100, -1));

        jLabel54.setText("Due date:");
        jPanel35.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));
        jPanel35.add(waterBillDueDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, -1));

        waterBillSendButton.setText("Send bill");
        waterBillSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterBillSendButtonActionPerformed(evt);
            }
        });
        jPanel35.add(waterBillSendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 200, -1));

        jTabbedPane6.addTab("Water bill", jPanel35);

        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setText("User Id:");
        jPanel36.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jPanel36.add(gasBilluserIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        jLabel56.setText("Billing date:");
        jPanel36.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));
        jPanel36.add(gasBillBillingDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, -1));

        jLabel57.setText("Total Gallons:");
        jPanel36.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));
        jPanel36.add(gasBillTotalGallonsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, -1));

        jLabel58.setText("Amount:");
        jPanel36.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));
        jPanel36.add(gasBillAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 100, -1));

        jLabel59.setText("Due date:");
        jPanel36.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));
        jPanel36.add(gasBillDueDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, -1));

        gasBillSendButton.setText("Send bill");
        gasBillSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gasBillSendButtonActionPerformed(evt);
            }
        });
        jPanel36.add(gasBillSendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 200, -1));

        jTabbedPane6.addTab("Gas bill", jPanel36);

        jPanel6.add(jTabbedPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 870));

        jTabbedPane1.addTab("Utilities Admin", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Events Admin", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Movie Admin", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean clientSideValidation(JFrame frame, String cityId, String cityName)
    {
        if(Pattern.compile("^[1-9]\\d*$").matcher(cityId).matches() && !cityId.equals(""))
        {
            if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(cityName).matches() && !cityName.equals(""))
            {
              return true;
            }
            else
              JOptionPane.showMessageDialog(frame, "City Name is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE); 
        }     
        else
            JOptionPane.showMessageDialog(frame, "City Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);  
      return false;
    }
    private void createCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCityButtonActionPerformed
        // TODO add your handling code here:
        String cityId = createCityIdField.getText().trim();
        String cityName = createCityNameField.getText().trim();
        boolean passed = clientSideValidation(this, cityId, cityName);
        boolean exists = false;
        if(passed)
        {
            CityDirectory cd = new CityDirectory();
            for(City c: cd.getCityList())
            {
              if(Integer.parseInt(cityId) == c.getCityId())
              {
                JOptionPane.showMessageDialog(this, "City with the given Id already exists\nPlease give another Id to the City..", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(cityName.equals(c.getCityName()))
              {
                JOptionPane.showMessageDialog(this, "City with the given name already exists\nPlease give another name to the City..", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(cityId);
              String name = cityName;
              City c = new City(id, name);
              int res = CityDirectory.addCity(c);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Created a new city successfully..", null, JOptionPane.OK_OPTION); 
              }
            }
        }
    }//GEN-LAST:event_createCityButtonActionPerformed
    public void searchData(String type, String searchText)
    {
        int position = -1;
        boolean found = false;
        switch (type) 
        {
            case "cityId":
                cityNameLabel.setVisible(false);
                updateCityNameField.setVisible(false);
                cityUpdateButton.setVisible(false);
                CityDirectory cd = new CityDirectory();
                for(City c: cd.getCityList())
                {
                  if(Integer.parseInt(updateCityIdField.getText()) == c.getCityId())
                  { 
                      found = true;
                      position = c.getCityId();
                      cityNameLabel.setVisible(true);
                      updateCityNameField.setVisible(true);
                      cityUpdateButton.setVisible(true);
                      cityPositionField.setText(Integer.valueOf(position).toString());
                      updateCityNameField.setText(c.getCityName());
                      break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "City with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
            case "busId":
                updateBusNameLabel.setVisible(false);
                updateBusFromCityLabel.setVisible(false);
                updateBusToCityLabel.setVisible(false);
                updateBusStartAtLabel.setVisible(false);
                updateBusReachAtLabel.setVisible(false);
                updateBusFareLabel.setVisible(false);
                updateBusTravelDateLabel.setVisible(false);
                
                updateBusNameField.setVisible(false);
                updateBusFromCityCombo.setVisible(false);
                updateBusToCityCombo.setVisible(false);
                updateBusStartAtField.setVisible(false);
                updateBusReachAtField.setVisible(false);
                updateBusFareField.setVisible(false);
                updateBusTravelDateField.setVisible(false);
                
                updateBusButton.setVisible(false);
                
                BusDirectory bd = new BusDirectory();
                for(Bus b : bd.getBusList())
                {
                  if(Integer.parseInt(updateBusIdField.getText()) == b.getId())
                  { 
                        found = true;
                        position = b.getId();
                        updateBusNameLabel.setVisible(true);
                        updateBusFromCityLabel.setVisible(true);
                        updateBusToCityLabel.setVisible(true);
                        updateBusStartAtLabel.setVisible(true);
                        updateBusReachAtLabel.setVisible(true);
                        updateBusFareLabel.setVisible(true);
                        updateBusTravelDateLabel.setVisible(true);

                        updateBusNameField.setVisible(true);
                        updateBusFromCityCombo.setVisible(true);
                        updateBusToCityCombo.setVisible(true);
                        updateBusStartAtField.setVisible(true);
                        updateBusReachAtField.setVisible(true);
                        updateBusFareField.setVisible(true);
                        updateBusTravelDateField.setVisible(true);

                        updateBusButton.setVisible(true);
                        
                        busPositionField.setText(Integer.valueOf(position).toString());
                        updateBusNameField.setText(b.getBusName());
                        CityDirectory cityd = new CityDirectory();
                        updateBusFromCityCombo.removeAllItems();
                        for(City c : cityd.getCityList())
                          updateBusFromCityCombo.addItem(c.getCityName());
                        updateBusFromCityCombo.setSelectedItem(b.getFromCity().getCityName());
                        updateBusToCityCombo.removeAllItems();
                        for(int i = 0; i < updateBusFromCityCombo.getItemCount(); i++)
                        {
                          if(updateBusFromCityCombo.getSelectedItem().toString().equals(updateBusFromCityCombo.getItemAt(i).toString()))
                            continue;           
                          updateBusToCityCombo.addItem(updateBusFromCityCombo.getItemAt(i).toString());
                        }
                        updateBusToCityCombo.setSelectedItem(b.getToCity().getCityName());
                        updateBusStartAtField.setText(b.getDepartureTime());
                        updateBusReachAtField.setText(b.getArrivalTime());
                        updateBusFareField.setText(String.valueOf(b.getFare()));
                        updateBusTravelDateField.setText(b.getTravelDate().toString());
                        break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Bus with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "mspId":
                updateMSPNameLabel.setVisible(false);
                updateMSPNameField.setVisible(false);
                updateMSPButton.setVisible(false);
                MobileServiceProviderDirectory mspd = new MobileServiceProviderDirectory();
                for(MobileServiceProvider msp: mspd.getMSPList())
                {
                  if(Integer.parseInt(updateMSPIdField.getText()) == msp.getId())
                  { 
                      found = true;
                      position = msp.getId();
                      updateMSPNameLabel.setVisible(true);
                      updateMSPNameField.setVisible(true);
                      updateMSPButton.setVisible(true);
                      MSPPositionField.setText(Integer.valueOf(position).toString());
                      updateMSPNameField.setText(msp.getProviderName());
                      break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Mobile service provider with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "mpId":
                updateMSPNameComboLabel.setVisible(false);
                updateMSPNameCombo.setVisible(false);
                updatePlanNameLabel.setVisible(false);
                updatePlanNameField.setVisible(false);
                updateMPDataLabel.setVisible(false);
                updateMPDataField.setVisible(false);
                updateMPCallsLabel.setVisible(false);
                updateMPCallsField.setVisible(false);
                updateMPValidityLabel.setVisible(false);
                updateMPValidityField.setVisible(false);
                updateMPPriceLabel.setVisible(false);
                updateMPPriceField.setVisible(false);
                updateMPButton.setVisible(false);
                
                MobilePlanDirectory mpd = new MobilePlanDirectory();
                for(MobilePlan mp : mpd.getMPList())
                {
                  if(Integer.parseInt(updateMPIdField.getText()) == mp.getId())
                  {
                    found = true;
                    position = mp.getId();
                    updateMSPNameComboLabel.setVisible(true);
                    updateMSPNameCombo.setVisible(true);
                    updatePlanNameLabel.setVisible(true);
                    updatePlanNameField.setVisible(true);
                    updateMPDataLabel.setVisible(true);
                    updateMPDataField.setVisible(true);
                    updateMPCallsLabel.setVisible(true);
                    updateMPCallsField.setVisible(true);
                    updateMPValidityLabel.setVisible(true);
                    updateMPValidityField.setVisible(true);
                    updateMPPriceLabel.setVisible(true);
                    updateMPPriceField.setVisible(true);
                    updateMPButton.setVisible(true);
                    
                    MPPositionField.setText(Integer.valueOf(position).toString());
                    MobileServiceProviderDirectory mspdd = new MobileServiceProviderDirectory();
                    updateMSPNameCombo.removeAllItems();
                    for(MobileServiceProvider msp : mspdd.getMSPList())
                        updateMSPNameCombo.addItem(msp.getProviderName());
                    updateMSPNameCombo.setSelectedItem(mp.getMobileServiceProvider().getProviderName());
                    updatePlanNameField.setText(mp.getPlanName());
                    updateMPDataField.setText(mp.getData());
                    updateMPCallsField.setText(mp.getCalls());
                    updateMPValidityField.setText(String.valueOf(mp.getValidity()));
                    updateMPPriceField.setText(String.valueOf(mp.getPrice()));
                    break;
                  } 
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Mobile plan with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "bankId":
                updateBankNameLabel.setVisible(false);
                updateBankNameField.setVisible(false);
                updateBankRoutingNumberLabel.setVisible(false);
                updateBankRoutingNumberField.setVisible(false);
                updateBankButton.setVisible(false);
                BankDirectory bdd = new BankDirectory();
                for(Bank b: bdd.getBankList())
                {
                  if(Integer.parseInt(updateBankIdField.getText()) == b.getId())
                  { 
                      found = true;
                      position = b.getId();
                      updateBankNameLabel.setVisible(true);
                      updateBankNameField.setVisible(true);
                      updateBankRoutingNumberLabel.setVisible(true);
                      updateBankRoutingNumberField.setVisible(true);
                      updateBankButton.setVisible(true);
                      bankPositionField.setText(Integer.valueOf(position).toString());
                      updateBankNameField.setText(b.getName());
                      updateBankRoutingNumberField.setText(b.getRoutingNumber());
                      break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Bank with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "cardId":
                updateCardNameLabel.setVisible(false);
                updateCardNameField.setVisible(false);
                updateCardButton.setVisible(false);
                CreditCardDirectory ccd = new CreditCardDirectory();
                for(CreditCard c: ccd.getCreditCardList())
                {
                  if(Integer.parseInt(updateCardIdField.getText()) == c.getId())
                  { 
                      found = true;
                      position = c.getId();
                      updateCardNameLabel.setVisible(true);
                      updateCardNameField.setVisible(true);
                      updateCardButton.setVisible(true);
                      cardPositionField.setText(Integer.valueOf(position).toString());
                      updateCardNameField.setText(c.getType());
                      break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Card with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
    private void citySearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citySearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateCityIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "City Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("cityId", searchText.trim());
    }//GEN-LAST:event_citySearchButtonActionPerformed

    private void cityUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityUpdateButtonActionPerformed
        // TODO add your handling code here:
        String cityId = updateCityIdField.getText().trim();
        String cityName = updateCityNameField.getText().trim();
        int position = Integer.valueOf(cityPositionField.getText());
        boolean passed = clientSideValidation(this, cityId, cityName);
        boolean exists = false;
        if(passed)
        {
          CityDirectory cd = new CityDirectory();
          for(City c: cd.getCityList())
            {
              if(Integer.parseInt(cityId) == c.getCityId() && c.getCityId() != position)
              {
                JOptionPane.showMessageDialog(this, "City with the given Id already exists\nPlease give another Id to the City..", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(cityName.equals(c.getCityName()) && c.getCityId() != position)
              {
                JOptionPane.showMessageDialog(this, "City with the given name already exists\nPlease give another name to the City..", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(cityId);
              String name = cityName;
              City c = new City(id, name);
              int res = CityDirectory.updateCity(c, position);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Updated the city successfully.", null, JOptionPane.OK_OPTION);
                cityPositionField.setText(cityId);
              }
              else
                JOptionPane.showMessageDialog(this, "City does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);  
            }
        }
    }//GEN-LAST:event_cityUpdateButtonActionPerformed

    private void deleteCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCityButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteCityIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "City Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = CityDirectory.deleteCity(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the city successfully..", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "City with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteCityButtonActionPerformed

    private void createBusFromCityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_createBusFromCityComboItemStateChanged
        // TODO add your handling code here:
      if(evt != null && evt.getSource().toString() != null && evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
      {
        createBusToCityCombo.removeAllItems();
        for(int i = 0; i < createBusFromCityCombo.getItemCount(); i++)
        {
          if(createBusFromCityCombo.getSelectedItem().toString().equals(createBusFromCityCombo.getItemAt(i).toString()))
            continue;           
          createBusToCityCombo.addItem(createBusFromCityCombo.getItemAt(i).toString());
        }
      }
    }//GEN-LAST:event_createBusFromCityComboItemStateChanged
    public boolean clientSidevalidation(JFrame frame, String busId, String busName, String startAt, String endAt, String farePrice, String travelDate)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(busId).matches())
      {
        if(Pattern.compile("^[a-zA-Z\\s0-9]*$").matcher(busName).matches() && !busName.equals(""))
        {
          if(Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(startAt).matches())
          {
            System.out.println("StartAt is valid.");
            if(Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(endAt).matches())
            {
              System.out.println("Reach At is valid.");
              if(Pattern.compile("^[0-9.]+$").matcher(farePrice).matches() && !farePrice.equals(""))
              {
                System.out.println("Fare is valid.");
                if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(travelDate).matches())
                {
                    System.out.println("Travel date is valid.");
                    return true;
                }
                else
                {
                     JOptionPane.showMessageDialog(frame, "Travel date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
              }
              else
                JOptionPane.showMessageDialog(this, "Please enter the fare in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
               JOptionPane.showMessageDialog(frame, "Reach At is not valid.\nShould be in the format HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
          }
          else
          {
             JOptionPane.showMessageDialog(frame, "Start At is not valid.\nShould be in the format HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
          }
        }
        else
          JOptionPane.showMessageDialog(frame, "Bus Name is not valid.\nOnly Characters, numbers and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "Bus Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBusButtonActionPerformed
        // TODO add your handling code here:
        try
        {
          String busId = createBusIdField.getText().trim();
            String busName = createBusNameField.getText().trim();
            String fromCity = createBusFromCityCombo.getSelectedItem().toString();
            String toCity = createBusToCityCombo.getSelectedItem().toString();
            String startAt = createBusStartAtField.getText().trim();
            String endAt = createBusReachAtField.getText().trim();
            String farePrice = createBusFareField.getText().trim();
            String date = createBusTravelDateField.getText().trim();        
            boolean passed = clientSidevalidation(this, busId, busName, startAt, endAt, farePrice, date);
            boolean exists = false;
            if(passed)
            {
                BusDirectory bd = new BusDirectory();
                for(Bus b: bd.getBusList())
                {
                  if(Integer.parseInt(busId) == b.getId())
                  {
                    JOptionPane.showMessageDialog(this, "Bus with the given Id already exists\nPlease give another Id to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                  else if(busName.equals(b.getBusName()))
                  {
                    JOptionPane.showMessageDialog(this, "Bus with the given name already exists\nPlease give another name to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;
                  }
                }
                if(!exists)
                {
                  int id = Integer.parseInt(busId);
                  int fromCityId = CityDirectory.getCityId(fromCity);
                  int toCityId = CityDirectory.getCityId(toCity);             
                  City from = new City(fromCityId, fromCity);
                  City to = new City(toCityId, toCity);
                  double fare = Double.parseDouble(farePrice);
                  LocalDate travelDate = LocalDate.parse(date);
                  Bus bus = new Bus(id, busName, from, to, startAt, endAt, fare, travelDate);
                  int res = BusDirectory.addBus(bus);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Created a new Bus successfully..", null, JOptionPane.OK_OPTION); 
                  }
                }
            }
        }
        catch(NullPointerException ex)
        {
          JOptionPane.showMessageDialog(this, "Please select the from and to locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createBusButtonActionPerformed

    private void updateBusSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBusSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateBusIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Bus Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("busId", searchText.trim());
    }//GEN-LAST:event_updateBusSearchButtonActionPerformed

    private void updateBusFromCityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateBusFromCityComboItemStateChanged
        // TODO add your handling code here:
        if(evt != null && evt.getSource().toString() != null && evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            updateBusToCityCombo.removeAllItems();
            for(int i = 0; i < updateBusFromCityCombo.getItemCount(); i++)
            {
              if(updateBusFromCityCombo.getSelectedItem().toString().equals(updateBusFromCityCombo.getItemAt(i).toString()))
                continue;           
              updateBusToCityCombo.addItem(updateBusFromCityCombo.getItemAt(i).toString());
            }
        }
    }//GEN-LAST:event_updateBusFromCityComboItemStateChanged

    private void updateBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBusButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String busId = updateBusIdField.getText().trim();
            String busName = updateBusNameField.getText().trim();
            String fromCity = updateBusFromCityCombo.getSelectedItem().toString();
            String toCity = updateBusToCityCombo.getSelectedItem().toString();
            String startAt = updateBusStartAtField.getText().trim();
            String endAt = updateBusReachAtField.getText().trim();
            String farePrice = updateBusFareField.getText().trim();
            String date = updateBusTravelDateField.getText().trim(); 
            int position = Integer.valueOf(busPositionField.getText());
            boolean passed = clientSidevalidation(this, busId, busName, startAt, endAt, farePrice, date);
            boolean exists = false;
            if(passed)
            {
                BusDirectory bd = new BusDirectory();
                for(Bus b: bd.getBusList())
                {
                  if(Integer.parseInt(busId) == b.getId() && b.getId() != position)
                  {
                    JOptionPane.showMessageDialog(this, "Bus with the given Id already exists\nPlease give another Id to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                  else if(busName.equals(b.getBusName()) && b.getId() != position)
                  {
                    JOptionPane.showMessageDialog(this, "Bus with the given name already exists\nPlease give another name to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;
                  }
                }
                if(!exists)
                {
                  int id = Integer.parseInt(busId);
                  int fromCityId = CityDirectory.getCityId(fromCity);
                  int toCityId = CityDirectory.getCityId(toCity);             
                  City from = new City(fromCityId, fromCity);
                  City to = new City(toCityId, toCity);
                  double fare = Double.parseDouble(farePrice);
                  LocalDate travelDate = LocalDate.parse(date);
                  Bus bus = new Bus(id, busName, from, to, startAt, endAt, fare, travelDate);
                  int res = BusDirectory.updateBus(bus, position);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Updated the Bus successfully..", null, JOptionPane.OK_OPTION); 
                    busPositionField.setText(busId);
                  }
                  else
                    JOptionPane.showMessageDialog(this, "Bus does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
          JOptionPane.showMessageDialog(this, "Please select the from and to locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateBusButtonActionPerformed

    private void deleteBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBusButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteBusIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Bus Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = BusDirectory.deleteBus(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the Bus successfully..", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "Bus with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteBusButtonActionPerformed
    public boolean mspClientSideValidation(JFrame frame, String cityId, String cityName)
    {
        if(Pattern.compile("^[1-9]\\d*$").matcher(cityId).matches() && !cityId.equals(""))
        {
            if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(cityName).matches() && !cityName.equals(""))
            {
              return true;
            }
            else
              JOptionPane.showMessageDialog(frame, "MSP Name is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE); 
        }     
        else
            JOptionPane.showMessageDialog(frame, "MSP Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);  
      return false;
    }
    private void createMSPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMSPButtonActionPerformed
        // TODO add your handling code here:
        String MSPId = createMSPIdField.getText().trim();
        String MSPName = createMSPNameField.getText().trim().toUpperCase();
        boolean passed = mspClientSideValidation(this, MSPId, MSPName);
        boolean exists = false;
        if(passed)
        {
            MobileServiceProviderDirectory mspd = new MobileServiceProviderDirectory();
            for(MobileServiceProvider msp: mspd.getMSPList())
            {
              if(Integer.parseInt(MSPId) == msp.getId())
              {
                JOptionPane.showMessageDialog(this, "MSP with the given Id already exists\nPlease give another Id to the MSP.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(MSPName.equals(msp.getProviderName()))
              {
                JOptionPane.showMessageDialog(this, "MSP with the given name already exists\nPlease give another name to the MSP.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(MSPId);
              String name = MSPName;
              MobileServiceProvider msp = new MobileServiceProvider(id, name);
              int res = MobileServiceProviderDirectory.addMSP(msp);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Created a new MSP successfully.", null, JOptionPane.OK_OPTION);
                createMSPNameCombo.addItem(name);
              }
            }
        }
    }//GEN-LAST:event_createMSPButtonActionPerformed
    public boolean mpClientSideValidation(JFrame frame, String mpId, String planName, String data, String calls, String validity, String price)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(mpId).matches())
      {
        if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(planName).matches() && !planName.equals(""))
        {
          if(Pattern.compile("^[a-zA-Z\\s0-9\\/]*$").matcher(data).matches() && !data.equals(""))
          {
            if(Pattern.compile("^[a-zA-Z\\s0-9\\/]*$").matcher(calls).matches() && !calls.equals(""))
            {
              if(Pattern.compile("^[1-9]\\d*$").matcher(validity).matches())
              {
                if(Pattern.compile("^[0-9.]+$").matcher(price).matches())
                {
                    return true;
                }
                else
                {
                     JOptionPane.showMessageDialog(frame, "Price is not valid.\nOnly positive numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
              }
              else
                JOptionPane.showMessageDialog(this, "Validity is not valid.\nOnly numbers are allowed", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
               JOptionPane.showMessageDialog(frame, "Calls is not valid.\nOnly characters, spaces, slashes and numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
          }
          else
          {
             JOptionPane.showMessageDialog(frame, "Data is not valid.\nOnly characters, spaces, slashes and numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
          }
        }
        else
          JOptionPane.showMessageDialog(frame, "Plan name is not valid.\nOnly Characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "MP Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createMPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMPButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String mpId = createMPIdField.getText().trim();
            String mSPName = createMSPNameCombo.getSelectedItem().toString();
            String planName = createPlanNameField.getText().trim().toUpperCase();
            String data = createMPDataField.getText().trim().toUpperCase();
            String calls = createMPCallsField.getText().trim().toUpperCase();
            String validity = createMPValidityField.getText().trim(); 
            String price = createMPPriceField.getText().trim();
            boolean passed = mpClientSideValidation(this, mpId, planName, data, calls, validity, price);
            boolean exists = false;
            if(passed)
            {
                MobilePlanDirectory mpd = new MobilePlanDirectory();
                for(MobilePlan mp: mpd.getMPList())
                {
                  if(Integer.parseInt(mpId) == mp.getId())
                  {
                    JOptionPane.showMessageDialog(this, "Mobile Plan with the given Id already exists\nPlease give another Id to the Mobile Plan.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                  else if(planName.equals(mp.getPlanName()))
                  {
                    JOptionPane.showMessageDialog(this, "Mobile Plan with the given name already exists\nPlease give another name to the Mobile Plan.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;
                  }
                }
                if(!exists)
                {
                  int id = Integer.parseInt(mpId);
                  int mspId = MobileServiceProviderDirectory.getMSPId(mSPName);
                  MobileServiceProvider msp = new MobileServiceProvider(mspId, mSPName);
                  int valid = Integer.parseInt(validity);
                  double amount = Double.parseDouble(price);
                  MobilePlan mp = new MobilePlan(id, msp, planName, data, calls, valid, amount);
                  int res = MobilePlanDirectory.addMP(mp);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Created a new mobile plan successfully..", null, JOptionPane.OK_OPTION); 
                  }
                }
            }
        }
        catch(NullPointerException ex)
        {
          JOptionPane.showMessageDialog(this, "Please select a mobile service provider.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createMPButtonActionPerformed

    private void updateMPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMPButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String mpId = updateMPIdField.getText().trim();
            String mSPName = updateMSPNameCombo.getSelectedItem().toString();
            String planName = updatePlanNameField.getText().trim().toUpperCase();
            String data = updateMPDataField.getText().trim().toUpperCase();
            String calls = updateMPCallsField.getText().trim().toUpperCase();
            String validity = updateMPValidityField.getText().trim(); 
            String price = updateMPPriceField.getText().trim();
            int position = Integer.valueOf(MPPositionField.getText());
            boolean passed = mpClientSideValidation(this, mpId, planName, data, calls, validity, price);
            boolean exists = false;
            if(passed)
            {
                MobilePlanDirectory mpd = new MobilePlanDirectory();
                for(MobilePlan mp: mpd.getMPList())
                {
                  if(Integer.parseInt(mpId) == mp.getId() && mp.getId() != position)
                  {
                    JOptionPane.showMessageDialog(this, "Mobile Plan with the given Id already exists\nPlease give another Id to the Mobile Plan.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                  else if(planName.equals(mp.getPlanName()) && mp.getId() != position)
                  {
                    JOptionPane.showMessageDialog(this, "Mobile Plan with the given name already exists\nPlease give another name to the Mobile Plan.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;
                  }
                }
                if(!exists)
                {
                  int id = Integer.parseInt(mpId);
                  int mspId = MobileServiceProviderDirectory.getMSPId(mSPName);
                  MobileServiceProvider msp = new MobileServiceProvider(mspId, mSPName);
                  int valid = Integer.parseInt(validity);
                  double amount = Double.parseDouble(price);
                  MobilePlan mp = new MobilePlan(id, msp, planName, data, calls, valid, amount);
                  int res = MobilePlanDirectory.updateMP(mp, position);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Updated the mobile plan successfully..", null, JOptionPane.OK_OPTION);
                    MPPositionField.setText(mpId);             
                  }
                  else
                    JOptionPane.showMessageDialog(this, "Mobile Plan does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
          JOptionPane.showMessageDialog(this, "Please select a mobile service provider.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateMPButtonActionPerformed

    private void updateMSPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMSPButtonActionPerformed
        // TODO add your handling code here:
        String MSPId = updateMSPIdField.getText().trim();
        String MSPName = updateMSPNameField.getText().trim().toUpperCase();
        int position = Integer.valueOf(MSPPositionField.getText());
        boolean passed = mspClientSideValidation(this, MSPId, MSPName);
        boolean exists = false;
        if(passed)
        {
            MobileServiceProviderDirectory mspd = new MobileServiceProviderDirectory();
            for(MobileServiceProvider msp: mspd.getMSPList())
            {
              if(Integer.parseInt(MSPId) == msp.getId() && msp.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "MSP with the given Id already exists\nPlease give another Id to the MSP.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(MSPName.equals(msp.getProviderName()) && msp.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "MSP with the given name already exists\nPlease give another name to the MSP.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(MSPId);
              String name = MSPName;
              MobileServiceProvider msp = new MobileServiceProvider(id, name);
              int res = MobileServiceProviderDirectory.updateMSP(msp, position);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Updated the MSP successfully.", null, JOptionPane.OK_OPTION);                
                MSPPositionField.setText(MSPId);
                createMSPNameCombo.removeAllItems();
                MobileServiceProviderDirectory mspdd = new MobileServiceProviderDirectory();
                for(MobileServiceProvider ms : mspdd.getMSPList())
                {
                  createMSPNameCombo.addItem(ms.getProviderName());
                }
              }
              else
                JOptionPane.showMessageDialog(this, "MSP does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);  
            }
        }
    }//GEN-LAST:event_updateMSPButtonActionPerformed

    private void updateMSPIdSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMSPIdSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateMSPIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Mobile service provider Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("mspId", searchText.trim());
    }//GEN-LAST:event_updateMSPIdSearchButtonActionPerformed

    private void updateMPIdSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMPIdSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateMPIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Mobile Plan Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("mpId", searchText.trim());
    }//GEN-LAST:event_updateMPIdSearchButtonActionPerformed

    private void deleteMSPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMSPButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteMSPIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "MSP Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = MobileServiceProviderDirectory.deleteMSP(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the MSP successfully..", null, JOptionPane.OK_OPTION);
            createMSPNameCombo.removeAllItems();
            MobileServiceProviderDirectory mp = new MobileServiceProviderDirectory();
            for(MobileServiceProvider msp : mp.getMSPList())
            {
              createMSPNameCombo.addItem(msp.getProviderName());
            }
            createMSPNameCombo.setSelectedItem(null);
          }
          else
            JOptionPane.showMessageDialog(this, "MSP with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteMSPButtonActionPerformed

    private void deleteMPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMPButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteMPIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Mobile Plan Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = MobilePlanDirectory.deleteMP(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the Mobile Plan successfully..", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "Mobile Plan with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteMPButtonActionPerformed

    private void bankInProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankInProgressButtonActionPerformed
        // TODO add your handling code here:
        int row = bankRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(bankRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = bankRequestsTable.getModel().getValueAt(row, 5).toString();
           if(requestStatus.equals("Initiated"))
           {
                int res = BankRequestDirectory.updateStatusToInProgress(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to In Progress.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)bankRequestsTable.getModel();
                     table_model.setRowCount(0);
                     BankRequestDirectory brd = new BankRequestDirectory();
                     for(BankRequest br : brd.getBankRequestList())
                     {
                         String id = String.valueOf(br.getId());
                         String userId = String.valueOf(br.getUser().getId());
                         String bankId = String.valueOf(br.getBank().getId());
                         String accountHolder = br.getAccountHolder();
                         String accountNumber = String.valueOf(br.getAccountNumber());
                         String status = br.getStatus();
                         String table_data[] = {id, userId, bankId, accountHolder, accountNumber, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("In Progress"))
              JOptionPane.showMessageDialog(this, "Request is already in progress.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bankInProgressButtonActionPerformed

    private void bankApprovedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankApprovedButtonActionPerformed
        // TODO add your handling code here:
        int row = bankRequestsTable.getSelectedRow();
        if(row > -1)
        {
           int requestId = Integer.parseInt(bankRequestsTable.getModel().getValueAt(row, 0).toString());
           int userid = Integer.parseInt(bankRequestsTable.getModel().getValueAt(row, 1).toString());
           int bankid = Integer.parseInt(bankRequestsTable.getModel().getValueAt(row, 2).toString());
           String accountholder = bankRequestsTable.getModel().getValueAt(row, 3).toString();
           String accountnumber = bankRequestsTable.getModel().getValueAt(row, 4).toString();
           String requestStatus = bankRequestsTable.getModel().getValueAt(row, 5).toString();
           String balance = "";
           if(requestStatus.equals("In Progress"))
           {
                while(true)
                {
                     balance = JOptionPane.showInputDialog(this,"Please update the account balance.");
                     if(balance == null)
                         balance = "";
                     if(Pattern.compile("^[0-9.]+$").matcher(balance).matches())
                         break;
                     else
                     {
                         JOptionPane.showMessageDialog(this, "Please enter the amount in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE); 
                         return;
                     }
                }
                User user = new User(userid, "", "", 0, "", 0.0);
                Bank bank = new Bank(bankid, "", "");
                BankAccount ba = new BankAccount(0, user, bank, accountholder, Long.parseLong(accountnumber), Double.parseDouble(balance));      
                int res = BankRequestDirectory.updateStatusToApproved(ba, requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Approved.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)bankRequestsTable.getModel();
                     table_model.setRowCount(0);
                     BankRequestDirectory brd = new BankRequestDirectory();
                     for(BankRequest br : brd.getBankRequestList())
                     {
                         String id = String.valueOf(br.getId());
                         String userId = String.valueOf(br.getUser().getId());
                         String bankId = String.valueOf(br.getBank().getId());
                         String accountHolder = br.getAccountHolder();
                         String accountNumber = String.valueOf(br.getAccountNumber());
                         String status = br.getStatus();
                         String table_data[] = {id, userId, bankId, accountHolder, accountNumber, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Initiated"))
              JOptionPane.showMessageDialog(this, "Please process the request before approving.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_bankApprovedButtonActionPerformed

    private void bankDeniedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankDeniedButtonActionPerformed
        // TODO add your handling code here:
        int row = bankRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(bankRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = bankRequestsTable.getModel().getValueAt(row, 5).toString();
           if(requestStatus.equals("In Progress"))
           {
                int res = BankRequestDirectory.updateStatusToDenied(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Denied.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)bankRequestsTable.getModel();
                     table_model.setRowCount(0);
                     BankRequestDirectory brd = new BankRequestDirectory();
                     for(BankRequest br : brd.getBankRequestList())
                     {
                         String id = String.valueOf(br.getId());
                         String userId = String.valueOf(br.getUser().getId());
                         String bankId = String.valueOf(br.getBank().getId());
                         String accountHolder = br.getAccountHolder();
                         String accountNumber = String.valueOf(br.getAccountNumber());
                         String status = br.getStatus();
                         String table_data[] = {id, userId, bankId, accountHolder, accountNumber, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Initiated"))
              JOptionPane.showMessageDialog(this, "Please process the request before denying.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bankDeniedButtonActionPerformed

    private void cardInProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardInProgressButtonActionPerformed
        // TODO add your handling code here:
        int row = cardRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = cardRequestsTable.getModel().getValueAt(row, 7).toString();
           if(requestStatus.equals("Initiated"))
           {
                int res = CreditCardRequestDirectory.updateStatusToInProgress(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to In Progress.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)cardRequestsTable.getModel();
                     table_model.setRowCount(0);
                     CreditCardRequestDirectory crd = new CreditCardRequestDirectory();
                     for(CreditCardRequest cr : crd.getCreditCardRequestList())
                     {
                         String id = String.valueOf(cr.getId());
                         String userId = String.valueOf(cr.getUser().getId());
                         String cardId = String.valueOf(cr.getCreditCard().getId());
                         String cardHolder = cr.getCardHolder();
                         String cardNumber = String.valueOf(cr.getCardNumber());
                         String cardExpiry = cr.getCardExpiry();
                         String cardCvc = String.valueOf(cr.getCardCVC());
                         String status = cr.getStatus();
                         String table_data[] = {id, userId, cardId, cardHolder, cardNumber, cardExpiry, cardCvc, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("In Progress"))
              JOptionPane.showMessageDialog(this, "Request is already in progress.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_cardInProgressButtonActionPerformed

    private void cardApprovedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardApprovedButtonActionPerformed
        // TODO add your handling code here:
        int row = cardRequestsTable.getSelectedRow();
        if(row > -1)
        {
           int requestId = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 0).toString());
           int userid = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 1).toString());
           int cardid = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 2).toString());
           String cardholder = cardRequestsTable.getModel().getValueAt(row, 3).toString();
           String cardnumber = cardRequestsTable.getModel().getValueAt(row, 4).toString();
           String cardexpiry = cardRequestsTable.getModel().getValueAt(row, 5).toString();
           int cardcvc = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 6).toString());
           String requestStatus = cardRequestsTable.getModel().getValueAt(row, 7).toString();
           String credit = "";
           if(requestStatus.equals("In Progress"))
           {
                while(true)
                {
                     credit = JOptionPane.showInputDialog(this,"Please update the available credit.");
                     if(credit == null)
                         credit = "";
                     if(Pattern.compile("^[0-9.]+$").matcher(credit).matches())
                         break;
                     else
                     {
                         JOptionPane.showMessageDialog(this, "Please enter the credit in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE); 
                         return;
                     }
                }
                User user = new User(userid, "", "", 0, "", 0.0);
                CreditCard creditCard = new CreditCard(cardid, "");
                UserCreditCard uc = new UserCreditCard(0, user, creditCard, cardholder, Long.parseLong(cardnumber), cardexpiry, cardcvc, Double.parseDouble(credit));      
                int res = CreditCardRequestDirectory.updateStatusToApproved(uc, requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Approved.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)cardRequestsTable.getModel();
                     table_model.setRowCount(0);
                     CreditCardRequestDirectory crd = new CreditCardRequestDirectory();
                     for(CreditCardRequest cr : crd.getCreditCardRequestList())
                     {
                         String id = String.valueOf(cr.getId());
                         String userId = String.valueOf(cr.getUser().getId());
                         String cardId = String.valueOf(cr.getCreditCard().getId());
                         String cardHolder = cr.getCardHolder();
                         String cardNumber = String.valueOf(cr.getCardNumber());
                         String cardExpiry = cr.getCardExpiry();
                         String cardCvc = String.valueOf(cr.getCardCVC());
                         String status = cr.getStatus();
                         String table_data[] = {id, userId, cardId, cardHolder, cardNumber, cardExpiry, cardCvc, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Initiated"))
              JOptionPane.showMessageDialog(this, "Please process the request before approving.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_cardApprovedButtonActionPerformed

    private void cardDeniedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardDeniedButtonActionPerformed
        // TODO add your handling code here:
        int row = cardRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(cardRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = cardRequestsTable.getModel().getValueAt(row, 7).toString();
           if(requestStatus.equals("In Progress"))
           {
                int res = CreditCardRequestDirectory.updateStatusToDenied(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Denied.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)cardRequestsTable.getModel();
                     table_model.setRowCount(0);
                     CreditCardRequestDirectory crd = new CreditCardRequestDirectory();
                     for(CreditCardRequest cr : crd.getCreditCardRequestList())
                     {
                         String id = String.valueOf(cr.getId());
                         String userId = String.valueOf(cr.getUser().getId());
                         String cardId = String.valueOf(cr.getCreditCard().getId());
                         String cardHolder = cr.getCardHolder();
                         String cardNumber = String.valueOf(cr.getCardNumber());
                         String cardExpiry = cr.getCardExpiry();
                         String cardCvc = String.valueOf(cr.getCardCVC());
                         String status = cr.getStatus();
                         String table_data[] = {id, userId, cardId, cardHolder, cardNumber, cardExpiry, cardCvc, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Initiated"))
              JOptionPane.showMessageDialog(this, "Please process the request before denying.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_cardDeniedButtonActionPerformed
    public boolean clientSideValidation(JFrame frame, String bankId, String bankName, String routingNumber)
    {
        if(Pattern.compile("^[1-9]\\d*$").matcher(bankId).matches() && !bankId.equals(""))
        {
            if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(bankName).matches() && !bankName.equals(""))
            {
              if(Pattern.compile("^\\d{9}$").matcher(routingNumber).matches() && !routingNumber.equals(""))
              {
                return true;
              }
              else
                JOptionPane.showMessageDialog(frame, "Routing Number is not valid.\nOnly numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);   
            }
            else
              JOptionPane.showMessageDialog(frame, "Bank Name is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE); 
        }     
        else
            JOptionPane.showMessageDialog(frame, "Bank Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);  
      return false;
    }
    private void createBankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBankButtonActionPerformed
        // TODO add your handling code here:
        String bankId = createBankIdField.getText().trim();
        String bankName = createBankNameField.getText().trim();
        String bankRoutingNumber = createBankRoutingNumberField.getText();
        boolean passed = clientSideValidation(this, bankId, bankName, bankRoutingNumber);
        boolean exists = false;
        if(passed)
        {
            BankDirectory bd = new BankDirectory();
            for(Bank b: bd.getBankList())
            {
              if(Integer.parseInt(bankId) == b.getId())
              {
                JOptionPane.showMessageDialog(this, "Bank with the given Id already exists\nPlease give another Id to the Bank.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(bankName.equals(b.getName()))
              {
                JOptionPane.showMessageDialog(this, "Bank with the given name already exists\nPlease give another name to the Bank.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(bankId);
              Bank b = new Bank(id, bankName, bankRoutingNumber);
              int res = BankDirectory.addBank(b);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Created a new bank successfully..", null, JOptionPane.OK_OPTION); 
              }
            }
        }
    }//GEN-LAST:event_createBankButtonActionPerformed

    private void bankSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateBankIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Bank Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("bankId", searchText.trim());
    }//GEN-LAST:event_bankSearchButtonActionPerformed

    private void updateBankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBankButtonActionPerformed
        // TODO add your handling code here:
        String bankId = updateBankIdField.getText().trim();
        String bankName = updateBankNameField.getText().trim();
        String bankRoutingNumber = updateBankRoutingNumberField.getText().trim();
        int position = Integer.valueOf(bankPositionField.getText());
        boolean passed = clientSideValidation(this, bankId, bankName, bankRoutingNumber);
        boolean exists = false;
        if(passed)
        {
          BankDirectory bd = new BankDirectory();
          for(Bank b: bd.getBankList())
            {
              if(Integer.parseInt(bankId) == b.getId() && b.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Bank with the given Id already exists\nPlease give another Id to the Bank.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(bankName.equals(b.getName()) && b.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Bank with the given name already exists\nPlease give another name to the Bank.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(bankId);
              Bank b = new Bank(id, bankName, bankRoutingNumber);
              int res = BankDirectory.updateBank(b, position);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Updated the bank successfully.", null, JOptionPane.OK_OPTION);
                bankPositionField.setText(bankId);
              }
              else
                JOptionPane.showMessageDialog(this, "Bank does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);  
            }
        }
    }//GEN-LAST:event_updateBankButtonActionPerformed

    private void deleteBankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBankButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteBankIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Bank Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = BankDirectory.deleteBank(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the bank successfully..", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "Bank with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteBankButtonActionPerformed

    private void createCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCardButtonActionPerformed
        // TODO add your handling code here:
        String cardId = createCardIdField.getText().trim();
        String cardName = createCardNameField.getText().trim();
        boolean passed = clientSideValidation(this, cardId, cardName);
        boolean exists = false;
        if(passed)
        {
            CreditCardDirectory cd = new CreditCardDirectory();
            for(CreditCard c: cd.getCreditCardList())
            {
              if(Integer.parseInt(cardId) == c.getId())
              {
                JOptionPane.showMessageDialog(this, "Card with the given Id already exists\nPlease give another Id to the card.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(cardName.equals(c.getType()))
              {
                JOptionPane.showMessageDialog(this, "Card with the given name already exists\nPlease give another name to the card.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(cardId);
              CreditCard c = new CreditCard(id, cardName);
              int res = CreditCardDirectory.addCard(c);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Created a new card successfully..", null, JOptionPane.OK_OPTION); 
              }
            }
        }
    }//GEN-LAST:event_createCardButtonActionPerformed

    private void updateCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCardButtonActionPerformed
        // TODO add your handling code here:
        String cardId = updateCardIdField.getText().trim();
        String cardName = updateCardNameField.getText().trim();
        int position = Integer.valueOf(cardPositionField.getText());
        boolean passed = clientSideValidation(this, cardId, cardName);
        boolean exists = false;
        if(passed)
        {
            CreditCardDirectory cd = new CreditCardDirectory();
            for(CreditCard c: cd.getCreditCardList())
            {
              if(Integer.parseInt(cardId) == c.getId() && c.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Card with the given Id already exists\nPlease give another Id to the Card.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(cardName.equals(c.getType()) && c.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Card with the given name already exists\nPlease give another name to the Card.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(cardId);
              CreditCard c = new CreditCard(id, cardName);
              int res = CreditCardDirectory.updateCard(c, position);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Updated the card successfully.", null, JOptionPane.OK_OPTION);
                cardPositionField.setText(cardId);
              }
              else
                JOptionPane.showMessageDialog(this, "Card does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);  
            }
        }
    }//GEN-LAST:event_updateCardButtonActionPerformed

    private void deleteCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCardButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteCardIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Card Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          int res = CreditCardDirectory.deleteCard(Integer.parseInt(deleteText));
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the card successfully.", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "Card with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteCardButtonActionPerformed

    private void searchCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCardButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateCardIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Card Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("cardId", searchText.trim());
    }//GEN-LAST:event_searchCardButtonActionPerformed

    private void addressInProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressInProgressButtonActionPerformed
        // TODO add your handling code here:
        int row = addressRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(addressRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = addressRequestsTable.getModel().getValueAt(row, 7).toString();
           if(requestStatus.equals("Requested"))
           {
                int res = AddressRequestDirectory.updateStatusToInProgress(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to In Progress.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)addressRequestsTable.getModel();
                     table_model.setRowCount(0);
                     AddressRequestDirectory ard = new AddressRequestDirectory();
                     for(AddressRequest ar : ard.getAddressRequestList())
                     {
                         String id = String.valueOf(ar.getId());
                         String userId = String.valueOf(ar.getUser().getId());
                         String apartment = ar.getApartment();
                         String street = ar.getStreet();
                         String city = ar.getCity();
                         String state = ar.getState();
                         String zipCode = ar.getZipCode();
                         String status = ar.getStatus();
                         String table_data[] = {id, userId, apartment, street, city, state, zipCode, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("In Progress"))
              JOptionPane.showMessageDialog(this, "Request is already in progress.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_addressInProgressButtonActionPerformed

    private void addressApprovedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressApprovedButtonActionPerformed
        // TODO add your handling code here:
        int row = addressRequestsTable.getSelectedRow();
        if(row > -1)
        {
           int requestId = Integer.parseInt(addressRequestsTable.getModel().getValueAt(row, 0).toString());
           int userid = Integer.parseInt(addressRequestsTable.getModel().getValueAt(row, 1).toString());
           String apartment = addressRequestsTable.getModel().getValueAt(row, 2).toString();
           String street = addressRequestsTable.getModel().getValueAt(row, 3).toString();
           String city = addressRequestsTable.getModel().getValueAt(row, 4).toString();
           String state = addressRequestsTable.getModel().getValueAt(row, 5).toString();
           String  zipCode = addressRequestsTable.getModel().getValueAt(row, 6).toString();
           String requestStatus = addressRequestsTable.getModel().getValueAt(row, 7).toString();
           if(requestStatus.equals("In Progress"))
           {                
                User user = new User(userid, "", "", 0, "", 0.0);                
                Address address = new Address(user, apartment, street, city, state, zipCode);      
                int res = AddressRequestDirectory.updateStatusToApproved(address, requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Approved.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)addressRequestsTable.getModel();
                     table_model.setRowCount(0);
                     AddressRequestDirectory ard = new AddressRequestDirectory();
                     for(AddressRequest ar : ard.getAddressRequestList())
                     {
                         String id = String.valueOf(ar.getId());
                         String userId = String.valueOf(ar.getUser().getId());
                         String addressApartment = ar.getApartment();
                         String addressStreet = ar.getStreet();
                         String addressCity = ar.getCity();
                         String addressState = ar.getState();
                         String addressZipCode = ar.getZipCode();
                         String status = ar.getStatus();
                         String table_data[] = {id, userId, addressApartment, addressStreet, addressCity, addressState, addressZipCode, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Requested"))
              JOptionPane.showMessageDialog(this, "Please process the request before approving.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_addressApprovedButtonActionPerformed

    private void addressDeniedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressDeniedButtonActionPerformed
        // TODO add your handling code here:
        int row = addressRequestsTable.getSelectedRow();
        if(row > -1)
        {  
           int requestId = Integer.parseInt(addressRequestsTable.getModel().getValueAt(row, 0).toString()); 
           String requestStatus = addressRequestsTable.getModel().getValueAt(row, 7).toString();
           if(requestStatus.equals("In Progress"))
           {
                int res = AddressRequestDirectory.updateStatusToDenied(requestId);
                if(res > 0)
                {
                     JOptionPane.showMessageDialog(this, "Updated the status to Denied.", null, JOptionPane.OK_OPTION);
                     DefaultTableModel table_model = (DefaultTableModel)addressRequestsTable.getModel();
                     table_model.setRowCount(0);
                     AddressRequestDirectory ard = new AddressRequestDirectory();
                     for(AddressRequest ar : ard.getAddressRequestList())
                     {
                         String id = String.valueOf(ar.getId());
                         String userId = String.valueOf(ar.getUser().getId());
                         String apartment = ar.getApartment();
                         String street = ar.getStreet();
                         String city = ar.getCity();
                         String state = ar.getState();
                         String zipCode = ar.getZipCode();
                         String status = ar.getStatus();
                         String table_data[] = {id, userId, apartment, street, city, state, zipCode, status};
                         table_model.addRow(table_data);
                     }
                }
           }
           else if(requestStatus.equals("Requested"))
              JOptionPane.showMessageDialog(this, "Please process the request before denying.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Approved"))
               JOptionPane.showMessageDialog(this, "Request is already approved.", "Alert", JOptionPane.WARNING_MESSAGE);
           else if(requestStatus.equals("Denied"))
               JOptionPane.showMessageDialog(this, "Request is already Denied.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a request.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_addressDeniedButtonActionPerformed

    private void addressRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressRefreshButtonActionPerformed
        // TODO add your handling code here:                
        DefaultTableModel table_model = (DefaultTableModel)addressesTable.getModel();
        table_model.setRowCount(0);
        AddressDirectory ad = new AddressDirectory();
        for(Address a : ad.getAddressList())
        {
            String userId = String.valueOf(a.getUser().getId());
            String apartment = a.getApartment();
            String street = a.getStreet();
            String city = a.getCity();
            String state = a.getState();
            String zipCode = a.getZipCode();
            String table_data[] = {userId, apartment, street, city, state, zipCode};
            table_model.addRow(table_data);
        }
    }//GEN-LAST:event_addressRefreshButtonActionPerformed
    public boolean clientSideValidation(JFrame frame, String billingDate, String totalKWatts, String amount, String dueDate)
    {
        if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(billingDate).matches() && !billingDate.equals(""))
        {
            if(Pattern.compile("^[1-9]\\d*$").matcher(totalKWatts).matches())
            {
              if(Pattern.compile("^[0-9.]+$").matcher(amount).matches() && !amount.equals(""))
              {
                if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(dueDate).matches())
                {
                    return true;
                }
                else
                  JOptionPane.showMessageDialog(frame, "Due date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
              }
              else
                JOptionPane.showMessageDialog(this, "Please enter the amount in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else
              JOptionPane.showMessageDialog(frame, "Please enter the wattage in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE);
          }
        else
          JOptionPane.showMessageDialog(frame, "Billing date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
      return false;
    }    
    private void elecBillSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elecBillSendButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            int userId = Integer.parseInt(elecBilluserIdCombo.getSelectedItem().toString());
            String billingDate = elecBillBillingDateField.getText().trim();
            String totalKWatts = elecBillTotalKWattsField.getText().trim();
            String amount = elecBillAmountField.getText().trim();
            String dueDate = elecBillDueDateField.getText().trim();
            boolean exists = false;
            boolean passed = clientSideValidation(this, billingDate, totalKWatts, amount, dueDate);
            if(passed)
            {
                ElectricityBillDirectory ebd = new ElectricityBillDirectory();
                for(ElectricityBill eb: ebd.getElectricityBillList())
                {
                  if(userId == eb.getUser().getId() && billingDate.equals(eb.getBillingDate().toString()))
                  {
                    JOptionPane.showMessageDialog(this, "Electricity bill was already generated for this user for the given billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }                  
                }
                if(!exists)
                {
                  User user = new User(userId, "", "", 0, "", 0);
                  LocalDate billDate = LocalDate.parse(billingDate);
                  int totalWatts = Integer.parseInt(totalKWatts);
                  double price = Double.parseDouble(amount);                  
                  LocalDate duDate = LocalDate.parse(dueDate);
                  if(billDate.isAfter(duDate))
                  {
                    JOptionPane.showMessageDialog(this, "Due date should be after the billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                  }
                  ElectricityBill eb = new ElectricityBill(0, user, billDate, totalWatts, price, duDate, "Due");
                  int res = ElectricityBillDirectory.addElectricityBill(eb);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Generated a new electricity bill for the user.", null, JOptionPane.OK_OPTION); 
                  }
                }
            }
        }
        catch(NullPointerException ne)
        {
          JOptionPane.showMessageDialog(this, "Please choose a user id to send the bill.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_elecBillSendButtonActionPerformed

    private void waterBillSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterBillSendButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            int userId = Integer.parseInt(waterBilluserIdCombo.getSelectedItem().toString());
            String billingDate = waterBillBillingDateField.getText().trim();
            String totalGallons = waterBillTotalGallonsField.getText().trim();
            String amount = waterBillAmountField.getText().trim();
            String dueDate = waterBillDueDateField.getText().trim();
            boolean exists = false;
            boolean passed = clientSideValidation(this, billingDate, totalGallons, amount, dueDate);
            if(passed)
            {
                WaterBillDirectory wbd = new WaterBillDirectory();
                for(WaterBill wb: wbd.getWaterBillList())
                {
                  if(userId == wb.getUser().getId() && billingDate.equals(wb.getBillingDate().toString()))
                  {                    
                    JOptionPane.showMessageDialog(this, "Water bill was already generated for this user for the given billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                }
                if(!exists)
                {
                  User user = new User(userId, "", "", 0, "", 0);
                  LocalDate billDate = LocalDate.parse(billingDate);
                  int totalgallons = Integer.parseInt(totalGallons);
                  double price = Double.parseDouble(amount);                  
                  LocalDate duDate = LocalDate.parse(dueDate);
                  if(billDate.isAfter(duDate))
                  {
                    JOptionPane.showMessageDialog(this, "Due date should be after the billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                  }
                  WaterBill wb = new WaterBill(0, user, billDate, totalgallons, price, duDate, "Due");
                  int res = WaterBillDirectory.addWaterBill(wb);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Generated a new water bill for the user.", null, JOptionPane.OK_OPTION);
                  }
                }
            }
        }
        catch(NullPointerException ne)
        {
          JOptionPane.showMessageDialog(this, "Please choose a user id to send the bill.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_waterBillSendButtonActionPerformed

    private void gasBillSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gasBillSendButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            int userId = Integer.parseInt(gasBilluserIdCombo.getSelectedItem().toString());
            String billingDate = gasBillBillingDateField.getText().trim();
            String totalGallons = gasBillTotalGallonsField.getText().trim();
            String amount = gasBillAmountField.getText().trim();
            String dueDate = gasBillDueDateField.getText().trim();
            boolean exists = false;
            boolean passed = clientSideValidation(this, billingDate, totalGallons, amount, dueDate);
            if(passed)
            {
                GasBillDirectory gbd = new GasBillDirectory();
                for(GasBill gb: gbd.getGasBillList())
                {
                  if(userId == gb.getUser().getId() && billingDate.equals(gb.getBillingDate().toString()))
                  {
                    JOptionPane.showMessageDialog(this, "Gas bill was already generated for this user for the given billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    exists = true;
                    break;              
                  }
                }
                if(!exists)
                {
                  User user = new User(userId, "", "", 0, "", 0);
                  LocalDate billDate = LocalDate.parse(billingDate);
                  int totalgallons = Integer.parseInt(totalGallons);
                  double price = Double.parseDouble(amount);                  
                  LocalDate duDate = LocalDate.parse(dueDate);
                  if(billDate.isAfter(duDate))
                  {
                    JOptionPane.showMessageDialog(this, "Due date should be after the billing date.", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                  }
                  GasBill gb = new GasBill(0, user, billDate, totalgallons, price, duDate, "Due");
                  int res = GasBillDirectory.addGasBill(gb);
                  if(res > 0)
                  {
                    JOptionPane.showMessageDialog(this, "Generated a new gas bill for the user.", null, JOptionPane.OK_OPTION);
                  }
                }
            }
        }
        catch(NullPointerException ne)
        {
          JOptionPane.showMessageDialog(this, "Please choose a user id to send the bill.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_gasBillSendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MPPositionField;
    private javax.swing.JTextField MSPPositionField;
    private javax.swing.JButton addressApprovedButton;
    private javax.swing.JButton addressDeniedButton;
    private javax.swing.JButton addressInProgressButton;
    private javax.swing.JButton addressRefreshButton;
    private javax.swing.JTable addressRequestsTable;
    private javax.swing.JTable addressesTable;
    private javax.swing.JButton bankApprovedButton;
    private javax.swing.JButton bankDeniedButton;
    private javax.swing.JButton bankInProgressButton;
    private javax.swing.JTextField bankPositionField;
    private javax.swing.JTable bankRequestsTable;
    private javax.swing.JButton bankSearchButton;
    private javax.swing.JTextField busPositionField;
    private javax.swing.JButton cardApprovedButton;
    private javax.swing.JButton cardDeniedButton;
    private javax.swing.JButton cardInProgressButton;
    private javax.swing.JTextField cardPositionField;
    private javax.swing.JTable cardRequestsTable;
    private javax.swing.JLabel cityNameLabel;
    private javax.swing.JTextField cityPositionField;
    private javax.swing.JButton citySearchButton;
    private javax.swing.JButton cityUpdateButton;
    private javax.swing.JButton createBankButton;
    private javax.swing.JTextField createBankIdField;
    private javax.swing.JTextField createBankNameField;
    private javax.swing.JTextField createBankRoutingNumberField;
    private javax.swing.JButton createBusButton;
    private javax.swing.JTextField createBusFareField;
    private javax.swing.JComboBox<String> createBusFromCityCombo;
    private javax.swing.JTextField createBusIdField;
    private javax.swing.JTextField createBusNameField;
    private javax.swing.JTextField createBusReachAtField;
    private javax.swing.JTextField createBusStartAtField;
    private javax.swing.JComboBox<String> createBusToCityCombo;
    private javax.swing.JTextField createBusTravelDateField;
    private javax.swing.JButton createCardButton;
    private javax.swing.JTextField createCardIdField;
    private javax.swing.JTextField createCardNameField;
    private javax.swing.JButton createCityButton;
    private javax.swing.JTextField createCityIdField;
    private javax.swing.JTextField createCityNameField;
    private javax.swing.JButton createMPButton;
    private javax.swing.JTextField createMPCallsField;
    private javax.swing.JTextField createMPDataField;
    private javax.swing.JTextField createMPIdField;
    private javax.swing.JTextField createMPPriceField;
    private javax.swing.JTextField createMPValidityField;
    private javax.swing.JButton createMSPButton;
    private javax.swing.JTextField createMSPIdField;
    private javax.swing.JComboBox<String> createMSPNameCombo;
    private javax.swing.JTextField createMSPNameField;
    private javax.swing.JTextField createPlanNameField;
    private javax.swing.JButton deleteBankButton;
    private javax.swing.JTextField deleteBankIdField;
    private javax.swing.JButton deleteBusButton;
    private javax.swing.JTextField deleteBusIdField;
    private javax.swing.JButton deleteCardButton;
    private javax.swing.JTextField deleteCardIdField;
    private javax.swing.JButton deleteCityButton;
    private javax.swing.JTextField deleteCityIdField;
    private javax.swing.JButton deleteMPButton;
    private javax.swing.JTextField deleteMPIdField;
    private javax.swing.JButton deleteMSPButton;
    private javax.swing.JTextField deleteMSPIdField;
    private javax.swing.JTextField elecBillAmountField;
    private javax.swing.JTextField elecBillBillingDateField;
    private javax.swing.JTextField elecBillDueDateField;
    private javax.swing.JButton elecBillSendButton;
    private javax.swing.JTextField elecBillTotalKWattsField;
    private javax.swing.JComboBox<String> elecBilluserIdCombo;
    private javax.swing.JTextField gasBillAmountField;
    private javax.swing.JTextField gasBillBillingDateField;
    private javax.swing.JTextField gasBillDueDateField;
    private javax.swing.JButton gasBillSendButton;
    private javax.swing.JTextField gasBillTotalGallonsField;
    private javax.swing.JComboBox<String> gasBilluserIdCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JButton searchCardButton;
    private javax.swing.JButton updateBankButton;
    private javax.swing.JTextField updateBankIdField;
    private javax.swing.JTextField updateBankNameField;
    private javax.swing.JLabel updateBankNameLabel;
    private javax.swing.JTextField updateBankRoutingNumberField;
    private javax.swing.JLabel updateBankRoutingNumberLabel;
    private javax.swing.JButton updateBusButton;
    private javax.swing.JTextField updateBusFareField;
    private javax.swing.JLabel updateBusFareLabel;
    private javax.swing.JComboBox<String> updateBusFromCityCombo;
    private javax.swing.JLabel updateBusFromCityLabel;
    private javax.swing.JTextField updateBusIdField;
    private javax.swing.JTextField updateBusNameField;
    private javax.swing.JLabel updateBusNameLabel;
    private javax.swing.JTextField updateBusReachAtField;
    private javax.swing.JLabel updateBusReachAtLabel;
    private javax.swing.JButton updateBusSearchButton;
    private javax.swing.JTextField updateBusStartAtField;
    private javax.swing.JLabel updateBusStartAtLabel;
    private javax.swing.JComboBox<String> updateBusToCityCombo;
    private javax.swing.JLabel updateBusToCityLabel;
    private javax.swing.JTextField updateBusTravelDateField;
    private javax.swing.JLabel updateBusTravelDateLabel;
    private javax.swing.JButton updateCardButton;
    private javax.swing.JTextField updateCardIdField;
    private javax.swing.JLabel updateCardIdLabel;
    private javax.swing.JLabel updateCardIdLabel1;
    private javax.swing.JTextField updateCardNameField;
    private javax.swing.JLabel updateCardNameLabel;
    private javax.swing.JTextField updateCityIdField;
    private javax.swing.JTextField updateCityNameField;
    private javax.swing.JButton updateMPButton;
    private javax.swing.JTextField updateMPCallsField;
    private javax.swing.JLabel updateMPCallsLabel;
    private javax.swing.JTextField updateMPDataField;
    private javax.swing.JLabel updateMPDataLabel;
    private javax.swing.JTextField updateMPIdField;
    private javax.swing.JButton updateMPIdSearchButton;
    private javax.swing.JTextField updateMPPriceField;
    private javax.swing.JLabel updateMPPriceLabel;
    private javax.swing.JTextField updateMPValidityField;
    private javax.swing.JLabel updateMPValidityLabel;
    private javax.swing.JButton updateMSPButton;
    private javax.swing.JTextField updateMSPIdField;
    private javax.swing.JButton updateMSPIdSearchButton;
    private javax.swing.JComboBox<String> updateMSPNameCombo;
    private javax.swing.JLabel updateMSPNameComboLabel;
    private javax.swing.JTextField updateMSPNameField;
    private javax.swing.JLabel updateMSPNameLabel;
    private javax.swing.JTextField updatePlanNameField;
    private javax.swing.JLabel updatePlanNameLabel;
    private javax.swing.JTextField waterBillAmountField;
    private javax.swing.JTextField waterBillBillingDateField;
    private javax.swing.JTextField waterBillDueDateField;
    private javax.swing.JButton waterBillSendButton;
    private javax.swing.JTextField waterBillTotalGallonsField;
    private javax.swing.JComboBox<String> waterBilluserIdCombo;
    // End of variables declaration//GEN-END:variables
}
