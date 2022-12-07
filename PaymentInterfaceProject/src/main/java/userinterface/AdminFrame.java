/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.Bus;
import business.BusDirectory;
import business.City;
import business.CityDirectory;
import business.mysql.MySql;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        jTextField8 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
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
            .addGap(0, 869, Short.MAX_VALUE)
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
            .addGap(0, 869, Short.MAX_VALUE)
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
            .addGap(0, 869, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );

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
        jPanel13.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jLabel16.setText("Bus Name:");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel13.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        jLabel17.setText("From city:");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jPanel13.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));

        jLabel18.setText("To city:");
        jPanel13.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jPanel13.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));

        jLabel19.setText("Start At:");
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        jPanel13.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));

        jLabel20.setText("Reach At:");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));
        jPanel13.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 120, -1));

        jLabel21.setText("Fare:");
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        jPanel13.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));

        jLabel22.setText("Travel date:");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));
        jPanel13.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));

        jButton3.setText("Update");
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 210, -1));

        jButton4.setText("Search");
        jPanel13.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jTabbedPane2.addTab("View/Update Buses", jPanel13);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Bus Id:");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 137, -1, -1));
        jPanel14.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, -1));

        jButton2.setText("Delete");
        jPanel14.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, -1));

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
            .addGap(0, 869, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Train Admin", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Recharge Admin", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Utilities Admin", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
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
            .addGap(0, 869, Short.MAX_VALUE)
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
                    JOptionPane.showMessageDialog(this, "City with the given Id does not exist..", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
    private void citySearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citySearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateCityIdField.getText();
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
                JOptionPane.showMessageDialog(this, "Updated the city successfully..", null, JOptionPane.OK_OPTION);
                cityPositionField.setText(cityId);
              }
              else
                JOptionPane.showMessageDialog(this, "City does not exist..", "Alert", JOptionPane.WARNING_MESSAGE);  
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
        if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(busName).matches() && !busName.equals(""))
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
          JOptionPane.showMessageDialog(frame, "Bus Name is not valid.\nOnly Characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
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
    private javax.swing.JLabel cityNameLabel;
    private javax.swing.JTextField cityPositionField;
    private javax.swing.JButton citySearchButton;
    private javax.swing.JButton cityUpdateButton;
    private javax.swing.JButton createBusButton;
    private javax.swing.JTextField createBusFareField;
    private javax.swing.JComboBox<String> createBusFromCityCombo;
    private javax.swing.JTextField createBusIdField;
    private javax.swing.JTextField createBusNameField;
    private javax.swing.JTextField createBusReachAtField;
    private javax.swing.JTextField createBusStartAtField;
    private javax.swing.JComboBox<String> createBusToCityCombo;
    private javax.swing.JTextField createBusTravelDateField;
    private javax.swing.JButton createCityButton;
    private javax.swing.JTextField createCityIdField;
    private javax.swing.JTextField createCityNameField;
    private javax.swing.JButton deleteCityButton;
    private javax.swing.JTextField deleteCityIdField;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField updateCityIdField;
    private javax.swing.JTextField updateCityNameField;
    // End of variables declaration//GEN-END:variables
}
