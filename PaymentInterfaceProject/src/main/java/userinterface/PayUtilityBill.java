/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.Mail;
import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static userinterface.UserHomePage.balanceLabel;
import static userinterface.UserHomePage.userNameLabel;

/**
 *
 * @author devsh
 */
public class PayUtilityBill extends javax.swing.JFrame {

    /**
     * Creates new form PayElectricityBill
     */
    public PayUtilityBill(String utility) {
        initComponents();
        switch (utility) {
            case "Electricity":
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                break;
            case "Water":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setSelectedIndex(1);
                jTabbedPane1.setEnabledAt(2, false);
                break;
            case "Gas":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setSelectedIndex(2);
                break;
            default:
                break;         
        }
        try
        {
          MySql.createConn();
          String query = "select userid, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
          ResultSet rs = MySql.selectQuery(query);
          rs.next();
          int user_id = rs.getInt(1);
          query = "select * from electricity_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          DefaultTableModel table_model = (DefaultTableModel)electricityBillTable.getModel();
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalKWatts = rs.getString(4) + " KWatts";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalKWatts, amount, dueDate, status});
          }
          
          query = "select * from water_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          table_model = (DefaultTableModel)waterBillTable.getModel();
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalGallons = rs.getString(4) + " Gallons";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalGallons, amount, dueDate, status});
          }
          
          query = "select * from gas_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          table_model = (DefaultTableModel)gasBillTable.getModel();
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalGallons = rs.getString(4) + " Gallons";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalGallons, amount, dueDate, status});
          }
        }
        catch(SQLException ex)
        {
          System.out.println(ex);
        }
        finally
        {
          MySql.shutDownConn();
        }
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
        jPanel2 = new javax.swing.JPanel();
        payElectricityBill = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        electricityBillTable = new javax.swing.JTable();
        getElectricityBillsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        waterBillTable = new javax.swing.JTable();
        getWaterBillsButton = new javax.swing.JButton();
        payWaterBill = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        payGasBill = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        gasBillTable = new javax.swing.JTable();
        getGasBillsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        apartmentField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stateField = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        addAddressButton = new javax.swing.JButton();
        cityField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        payElectricityBill.setText("Pay Due Bill");
        payElectricityBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payElectricityBillActionPerformed(evt);
            }
        });
        jPanel2.add(payElectricityBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel45.setText("Payment History");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        electricityBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "Billing Date", "Total KWatts", "Amount", "Due Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane6.setViewportView(electricityBillTable);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, 173));

        getElectricityBillsButton.setText("Refresh");
        getElectricityBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getElectricityBillsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(getElectricityBillsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jTabbedPane1.addTab("Electricity Bill", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setText("Payment History");
        jPanel3.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        waterBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "Billing Date", "Total Gallons", "Amount", "Due Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane7.setViewportView(waterBillTable);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, 173));

        getWaterBillsButton.setText("Refresh");
        getWaterBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getWaterBillsButtonActionPerformed(evt);
            }
        });
        jPanel3.add(getWaterBillsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        payWaterBill.setText("Pay Due Bill");
        payWaterBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payWaterBillActionPerformed(evt);
            }
        });
        jPanel3.add(payWaterBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jTabbedPane1.addTab("Water Bill", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        payGasBill.setText("Pay Due Bill");
        payGasBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payGasBillActionPerformed(evt);
            }
        });
        jPanel4.add(payGasBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel61.setText("Payment History");
        jPanel4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        gasBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "Billing Date", "Total Gallons", "Amount", "Due Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane8.setViewportView(gasBillTable);

        jPanel4.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, 173));

        getGasBillsButton.setText("Refresh");
        getGasBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getGasBillsButtonActionPerformed(evt);
            }
        });
        jPanel4.add(getGasBillsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jTabbedPane1.addTab("Gas Bill", jPanel4);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Apartment, Suite, etc:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));
        jPanel1.add(apartmentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 200, -1));

        jLabel2.setText("Street Address:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 100, -1));
        jPanel1.add(streetField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 200, -1));

        jLabel3.setText("City:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 40, -1));

        jLabel4.setText("State:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        stateField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Alabama", " Alaska", " Arizona", " Arkansas", " California", " Colorado", " Connecticut", " Delaware", " Florida", " Georgia", " Hawaii", " Idaho", " Illinois", " Indiana", " Iowa", " Kansas", " Kentucky", " Louisiana", " Maine", " Maryland", " Massachusetts", " Michigan", " Minnesota", " Mississippi", " Missouri", " Montana", " Nebraska", " Nevada", " New Hampshire", " New Jersey", " New Mexico", " New York", " North Carolina", " North Dakota", " Ohio", " Oklahoma", " Oregon", " Pennsylvania", " Rhode Island", " South Carolina", " South Dakota", " Tennessee", " Texas", " Utah", " Vermont", " Virginia", " Washington", " West Virginia", " Wisconsin", " Wyoming" }));
        jPanel1.add(stateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 200, -1));

        jLabel5.setText("Zip code:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));
        jPanel1.add(zipCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 200, -1));

        addAddressButton.setText("Add/Update");
        addAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddressButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addAddressButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 200, -1));
        jPanel1.add(cityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 200, -1));

        jTabbedPane1.addTab("Address", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payGasBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payGasBillActionPerformed
        // TODO add your handling code here:
        int row = gasBillTable.getSelectedRow();
        if(row > -1)
        {
          int billId = Integer.parseInt(gasBillTable.getModel().getValueAt(row, 0).toString());
          String billingDate = gasBillTable.getModel().getValueAt(row, 1).toString();
          int totalGallons = Integer.parseInt(gasBillTable.getModel().getValueAt(row, 2).toString().split(" Gallons")[0]);
          double amount  = Double.parseDouble(gasBillTable.getModel().getValueAt(row, 3).toString().substring(2));
          String dueDate = gasBillTable.getModel().getValueAt(row, 4).toString();
          String status = gasBillTable.getModel().getValueAt(row, 5).toString();
          if(!status.equals("Paid"))
          {
            try
            {
              MySql.createConn();
              String query = "select balance, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
              ResultSet rs = MySql.selectQuery(query);
              rs.next();           
              double balance = rs.getDouble(1);
              String email = rs.getString(2);
              double available_balance = balance - amount;
              if(available_balance < 0)
              {
               JOptionPane.showMessageDialog(this, "The available wallet balance is less than the amount\nthat you're trying to pay.", "Alert", JOptionPane.WARNING_MESSAGE);
               return;
              }
              query = "update gas_bill set status = " + "\'" + "Paid" + "\'" + " where id = " + billId + ";";
              int res = MySql.insertUpdateQuery(query);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Bill Paid successfully.", null, JOptionPane.OK_OPTION);
                query = "update users set balance = balance - " + amount + " where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
                res = MySql.insertUpdateQuery(query);
                if(res > 0)
                {
                  balanceLabel.setText("$ " + available_balance);
                  String message = "You have just paid the following Gas bill:\n";
                  message += "Bill Id: " + billId;
                  message += "\nBilling Date: " + billingDate;
                  message += "\nTotal Gallons: " + totalGallons;
                  message += "\nAmount: " + amount;
                  message += "\nDue Date: " + dueDate;
                  Mail.sendMail(email, message);
                }
              }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            finally
            {
              MySql.shutDownConn();
            }
          }
          else
            JOptionPane.showMessageDialog(this, "You have already cleared this bill.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a bill to pay.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_payGasBillActionPerformed
    public boolean clientSideValidation(JFrame frame, String apartment, String street, String city, String zipCode)
    {
      if(Pattern.compile("^[a-zA-Z0-9\\s]*$").matcher(apartment).matches() && !apartment.equals(""))
         {
           if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(street).matches()&& !street.equals(""))
           {
             if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(city).matches() && !city.equals(""))
             {
                if(Pattern.compile("^\\d{5}$").matcher(zipCode).matches())
                    return true;
                else
                    JOptionPane.showMessageDialog(frame, "Zip code is not valid.\nZipcode must contain 5 digits.", "Alert", JOptionPane.WARNING_MESSAGE);    
             } 
             else
              JOptionPane.showMessageDialog(frame, "City is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
           }
           else
            JOptionPane.showMessageDialog(frame, "Street address is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);      
         }
         else
            JOptionPane.showMessageDialog(frame, "Apartment is not valid.\nOnly characters, digits and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE); 
      return false;
    }                        
    private void addAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddressButtonActionPerformed
        // TODO add your handling code here:
        String apartment = apartmentField.getText().trim();
        String street = streetField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getSelectedItem().toString();
        String zipCode = zipCodeField.getText().trim();
        boolean passed = clientSideValidation(this, apartment, street, city, zipCode);
        if(passed)
        {
          try
          {
            MySql.createConn();
            String query = "select userid, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
            ResultSet rs = MySql.selectQuery(query);
            rs.next();
            int user_id = rs.getInt(1);
            String email = rs.getString(2);
            query = "select count(*) from addresses where user_id = " + user_id + " and apartment = " + "\'" + apartment + "\'" + "and street = " + "\'" + street + "\'" + "and city = " + "\'" + city + "\'" + "and state = " + "\'" + state + "\'" + "and zipcode = " + "\'" + zipCode + "\'" + ";";
            rs = MySql.selectQuery(query);
            rs.next();
            if(rs.getInt(1) == 0)
            {
                String code ="";
                for(int i = 0; i < 6; i++)
                    code += (int)(Math.random() * 6);
                Mail mail = new Mail(email, code);
                mail.sendMail();
                while(true)
                {
                  String userCode = JOptionPane.showInputDialog(this,"Please enter the code that is sent to your Email Id."); 
                  if(userCode.equals(code))
                  {
                    query = "INSERT INTO address_requests(user_id, apartment, street, city, state, zipcode, status) VALUES(" + user_id + "," + "\'" + apartment + "\'" + "," + "\'" + street + "\'" + "," + "\'" + city + "\'" + "," + "\'" + state + "\'" + "," + "\'" + zipCode + "\'" + "," + "\'" + "Requested" + "\'"+ ");";
                    int res = MySql.insertUpdateQuery(query);
                    if(res > 0)
                    {
                      JOptionPane.showMessageDialog(this, "Request to add/update the address is sent to the admin.\nAddress will be added/updated once the request is approved.", null, JOptionPane.OK_OPTION);
                      break;
                    }
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(this, "The code entered is incorrect, please enter the correct code.", "Alert", JOptionPane.WARNING_MESSAGE);
                  }
                }              
            }
            else
               JOptionPane.showMessageDialog(this, "The address that you're trying to add was already added.", "Alert", JOptionPane.WARNING_MESSAGE);
          }
          catch(SQLException ex)
          {
            System.out.println(ex);
          }
          finally
          {
              MySql.shutDownConn();
          }
        }
    }//GEN-LAST:event_addAddressButtonActionPerformed

    private void getElectricityBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getElectricityBillsButtonActionPerformed
        // TODO add your handling code here:
        try
        {
          MySql.createConn();
          String query = "select userid, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
          ResultSet rs = MySql.selectQuery(query);
          rs.next();
          int user_id = rs.getInt(1);
          query = "select * from electricity_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          DefaultTableModel table_model = (DefaultTableModel)electricityBillTable.getModel();
          table_model.setRowCount(0);
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalKWatts = rs.getString(4) + " KWatts";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalKWatts, amount, dueDate, status});
          }
        }
        catch(SQLException ex)
        {
          System.out.println(ex);
        }
        finally
        {
          MySql.shutDownConn();
        }
    }//GEN-LAST:event_getElectricityBillsButtonActionPerformed

    private void getWaterBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getWaterBillsButtonActionPerformed
        // TODO add your handling code here:
        try
        {
          MySql.createConn();
          String query = "select userid, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
          ResultSet rs = MySql.selectQuery(query);
          rs.next();
          int user_id = rs.getInt(1);
          query = "select * from water_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          DefaultTableModel table_model = (DefaultTableModel)waterBillTable.getModel();
          table_model.setRowCount(0);
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalGallons = rs.getString(4) + " Gallons";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalGallons, amount, dueDate, status});
          }
        }
        catch(SQLException ex)
        {
          System.out.println(ex);
        }
        finally
        {
          MySql.shutDownConn();
        }
    }//GEN-LAST:event_getWaterBillsButtonActionPerformed

    private void getGasBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getGasBillsButtonActionPerformed
        // TODO add your handling code here:
        try
        {
          MySql.createConn();
          String query = "select userid, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
          ResultSet rs = MySql.selectQuery(query);
          rs.next();
          int user_id = rs.getInt(1);
          query = "select * from gas_bill where userid = " + user_id + ";";
          rs = MySql.selectQuery(query);
          DefaultTableModel table_model = (DefaultTableModel)gasBillTable.getModel();
          table_model.setRowCount(0);
          while(rs.next())
          {            
            String billId = rs.getString(1);
            String billingDate = rs.getString(3);
            String totalGallons = rs.getString(4) + " Gallons";
            String amount = "$ " + rs.getString(5);
            String dueDate = rs.getString(6);
            String status = rs.getString(7);
            table_model.addRow(new String[]{billId, billingDate, totalGallons, amount, dueDate, status});
          }
        }
        catch(SQLException ex)
        {
          System.out.println(ex);
        }
        finally
        {
          MySql.shutDownConn();
        }
    }//GEN-LAST:event_getGasBillsButtonActionPerformed

    private void payElectricityBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payElectricityBillActionPerformed
        // TODO add your handling code here:
        int row = electricityBillTable.getSelectedRow();
        if(row > -1)
        {
          int billId = Integer.parseInt(electricityBillTable.getModel().getValueAt(row, 0).toString());
          String billingDate = electricityBillTable.getModel().getValueAt(row, 1).toString();
          int totalKWatts = Integer.parseInt(electricityBillTable.getModel().getValueAt(row, 2).toString().split(" KWatts")[0]);          
          double amount  = Double.parseDouble(electricityBillTable.getModel().getValueAt(row, 3).toString().substring(2));            
          String dueDate = electricityBillTable.getModel().getValueAt(row, 4).toString();
          String status = electricityBillTable.getModel().getValueAt(row, 5).toString();
          if(!status.equals("Paid"))
          {
            try
            {
              MySql.createConn();
              String query = "select balance, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
              ResultSet rs = MySql.selectQuery(query);
              rs.next();           
              double balance = rs.getDouble(1);
              String email = rs.getString(2);
              double available_balance = balance - amount;
              if(available_balance < 0)
              {
               JOptionPane.showMessageDialog(this, "The available wallet balance is less than the amount\nthat you're trying to pay.", "Alert", JOptionPane.WARNING_MESSAGE);
               return;
              }
              query = "update electricity_bill set status = " + "\'" + "Paid" + "\'" + " where id = " + billId + ";";
              int res = MySql.insertUpdateQuery(query);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Bill Paid successfully.", null, JOptionPane.OK_OPTION);
                query = "update users set balance = balance - " + amount + " where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
                res = MySql.insertUpdateQuery(query);
                if(res > 0)
                {
                  balanceLabel.setText("$ " + available_balance);
                  String message = "You have just paid the following electricity bill:\n";
                  message += "Bill Id: " + billId;
                  message += "\nBilling Date: " + billingDate;
                  message += "\nTotal KWatts: " + totalKWatts;
                  message += "\nAmount: " + amount;
                  message += "\nDue Date: " + dueDate;
                  Mail.sendMail(email, message);
                }
              }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            finally
            {
              MySql.shutDownConn();
            }
          }
          else
            JOptionPane.showMessageDialog(this, "You have already cleared this bill.", "Alert", JOptionPane.WARNING_MESSAGE);  
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a bill to pay.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_payElectricityBillActionPerformed

    private void payWaterBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payWaterBillActionPerformed
        // TODO add your handling code here:
        int row = waterBillTable.getSelectedRow();
        if(row > -1)
        {
          int billId = Integer.parseInt(waterBillTable.getModel().getValueAt(row, 0).toString());
          String billingDate = waterBillTable.getModel().getValueAt(row, 1).toString();
          int totalGallons = Integer.parseInt(waterBillTable.getModel().getValueAt(row, 2).toString().split(" Gallons")[0]);
          double amount  = Double.parseDouble(waterBillTable.getModel().getValueAt(row, 3).toString().substring(2));
          String dueDate = waterBillTable.getModel().getValueAt(row, 4).toString();
          String status = waterBillTable.getModel().getValueAt(row, 5).toString();
          if(!status.equals("Paid"))
          {
            try
            {
              MySql.createConn();
              String query = "select balance, email from users where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
              ResultSet rs = MySql.selectQuery(query);
              rs.next();           
              double balance = rs.getDouble(1);
              String email = rs.getString(2);
              double available_balance = balance - amount;
              if(available_balance < 0)
              {
               JOptionPane.showMessageDialog(this, "The available wallet balance is less than the amount\nthat you're trying to pay.", "Alert", JOptionPane.WARNING_MESSAGE);
               return;
              }
              query = "update water_bill set status = " + "\'" + "Paid" + "\'" + " where id = " + billId + ";";
              int res = MySql.insertUpdateQuery(query);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Bill Paid successfully.", null, JOptionPane.OK_OPTION);
                query = "update users set balance = balance - " + amount + " where username = " + "\'" + userNameLabel.getText() + "\'" + ";";
                res = MySql.insertUpdateQuery(query);
                if(res > 0)
                {
                  balanceLabel.setText("$ " + available_balance);
                  String message = "You have just paid the following Water bill:\n";
                  message += "Bill Id: " + billId;
                  message += "\nBilling Date: " + billingDate;
                  message += "\nTotal Gallons: " + totalGallons;
                  message += "\nAmount: " + amount;
                  message += "\nDue Date: " + dueDate;
                  Mail.sendMail(email, message);
                }
              }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            finally
            {
              MySql.shutDownConn();
            }
          }
          else
            JOptionPane.showMessageDialog(this, "You have already cleared this bill.", "Alert", JOptionPane.WARNING_MESSAGE);  
        }
        else
           JOptionPane.showMessageDialog(this, "Please select a bill to pay.", "Alert", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_payWaterBillActionPerformed

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
            java.util.logging.Logger.getLogger(PayUtilityBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayUtilityBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayUtilityBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayUtilityBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayUtilityBill("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAddressButton;
    private javax.swing.JTextField apartmentField;
    private javax.swing.JTextField cityField;
    private javax.swing.JTable electricityBillTable;
    private javax.swing.JTable gasBillTable;
    private javax.swing.JButton getElectricityBillsButton;
    private javax.swing.JButton getGasBillsButton;
    private javax.swing.JButton getWaterBillsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton payElectricityBill;
    private javax.swing.JButton payGasBill;
    private javax.swing.JButton payWaterBill;
    private javax.swing.JComboBox<String> stateField;
    private javax.swing.JTextField streetField;
    private javax.swing.JTable waterBillTable;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
