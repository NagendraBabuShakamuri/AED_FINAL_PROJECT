/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.Address;
import business.AddressDirectory;
import business.AddressRequest;
import business.AddressRequestDirectory;
import business.Admin;
import business.AdminDirectory;
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
import business.Event;
import business.EventDirectory;
import business.GasBill;
import business.GasBillDirectory;
import business.MobilePlan;
import business.MobilePlanDirectory;
import business.MobileServiceProvider;
import business.MobileServiceProviderDirectory;
import business.Movie;
import business.MovieDirectory;
import business.Screen;
import business.ScreenDirectory;
import business.Theatre;
import business.TheatreDirectory;
import business.Train;
import business.TrainDirectory;
import business.User;
import business.UserCreditCard;
import business.UserDirectory;
import business.WaterBill;
import business.WaterBillDirectory;
import java.time.LocalDate;
import java.time.LocalTime;
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
    public AdminFrame(String role) {
        initComponents();
        switch (role) {
            case "Banking Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(1);
                break;
            case "Bus Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(2);
                break;
            case "Train Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(3);
                break;
            case "Recharge Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(4);
                break;
             case "Utilities Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(5);
                break;
             case "Events Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(7, false);
                jTabbedPane1.setSelectedIndex(6);
                break;
             case "Movie Admin":
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);
                jTabbedPane1.setEnabledAt(6, false);
                jTabbedPane1.setSelectedIndex(7);
                break;
            default:
                break;         
        }
        CityDirectory cd = new CityDirectory();
        for(City c : cd.getCityList())
        {
          createBusFromCityCombo.addItem(c.getCityName());
          createEventCityCombo.addItem(c.getCityName());
          createTrainFromCityCombo.addItem(c.getCityName());
          createTheatreCityCombo.addItem(c.getCityName());
        }
        createBusFromCityCombo.setSelectedItem(null);
        createEventCityCombo.setSelectedItem(null);
        createTrainFromCityCombo.setSelectedItem(null);
        createTheatreCityCombo.setSelectedItem(null);
        
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
        
        TheatreDirectory td = new TheatreDirectory();
        for(Theatre t : td.getTheatreList())
        {
          createScreenTheatreCombo.addItem(t.getTheatreName());         
        }
        createScreenTheatreCombo.setSelectedItem(null);

        MovieDirectory md = new MovieDirectory();
        for(Movie m : md.getMovieList())
        {
          createScreenMovieCombo.addItem(m.getMovieName());         
        }
        createScreenMovieCombo.setSelectedItem(null);
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
        jLabel60 = new javax.swing.JLabel();
        createRoleCombo = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        createUserNameField = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        createAdminButton = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        createAdminIdField = new javax.swing.JTextField();
        createPasswordField = new javax.swing.JPasswordField();
        sysAdminLogoutButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        updateRoleLabel = new javax.swing.JLabel();
        updateRoleCombo = new javax.swing.JComboBox<>();
        updateUserNameLabel = new javax.swing.JLabel();
        updateUserNameField = new javax.swing.JTextField();
        updatePasswordLabel = new javax.swing.JLabel();
        updateAdminButton = new javax.swing.JButton();
        adminSearchButton = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        updateAdminIdField = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        adminPositionField = new javax.swing.JTextField();
        updatePasswordField = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        deleteAdminIdField = new javax.swing.JTextField();
        deleteAdminButton = new javax.swing.JButton();
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
        bankAdminLogoutButton = new javax.swing.JButton();
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
        busAdminLogoutButton = new javax.swing.JButton();
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
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel37 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        createTrainIdField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        createTrainFromCityCombo = new javax.swing.JComboBox<>();
        createTrainToCityCombo = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        createTrainStartAtField = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        createTrainReachAtField = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        createTrainFareField = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        createTrainTravelDateField = new javax.swing.JTextField();
        createTrainButton = new javax.swing.JButton();
        trainAdminLogoutButton = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        updateTrainIdField = new javax.swing.JTextField();
        updateTrainFromCityLabel = new javax.swing.JLabel();
        updateTrainFromCityCombo = new javax.swing.JComboBox<>();
        updateTrainToCityLabel = new javax.swing.JLabel();
        updateTrainToCityCombo = new javax.swing.JComboBox<>();
        updateTrainStartAtLabel = new javax.swing.JLabel();
        updateTrainStartAtField = new javax.swing.JTextField();
        updateTrainReachAtLabel = new javax.swing.JLabel();
        updateTrainReachAtField = new javax.swing.JTextField();
        updateTrainFareLabel = new javax.swing.JLabel();
        updateTrainFareField = new javax.swing.JTextField();
        updateTrainTravelDateLabel = new javax.swing.JLabel();
        updateTrainTravelDateField = new javax.swing.JTextField();
        updateTrainButton = new javax.swing.JButton();
        updateTrainSearchButton = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        trainPositionField = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        deleteTrainIdField = new javax.swing.JTextField();
        deleteTrainButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        createMSPIdField = new javax.swing.JTextField();
        createMSPNameField = new javax.swing.JTextField();
        createMSPButton = new javax.swing.JButton();
        rechargeAdminLogoutButton = new javax.swing.JButton();
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
        utilitiesAdminLogoutButton = new javax.swing.JButton();
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
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel40 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        createEventIdField = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        createEventNameField = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        createEventCityCombo = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        createEventStartAtField = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        createEventEndAtField = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        createEventFareField = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        createEventTravelDateField = new javax.swing.JTextField();
        createEventButton = new javax.swing.JButton();
        eventAdminLogoutButton = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        updateEventIdField = new javax.swing.JTextField();
        updateEventNameLabel = new javax.swing.JLabel();
        updateEventNameField = new javax.swing.JTextField();
        updateEventCityLabel = new javax.swing.JLabel();
        updateEventCityCombo = new javax.swing.JComboBox<>();
        updateEventStartAtLabel = new javax.swing.JLabel();
        updateEventStartAtField = new javax.swing.JTextField();
        updateEventEndAtLabel = new javax.swing.JLabel();
        updateEventEndAtField = new javax.swing.JTextField();
        updateEventFareLabel = new javax.swing.JLabel();
        updateEventFareField = new javax.swing.JTextField();
        updateEventDateLabel = new javax.swing.JLabel();
        updateEventDateField = new javax.swing.JTextField();
        updateEventButton = new javax.swing.JButton();
        updateEventSearchButton = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        eventPositionField = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        deleteEventIdField = new javax.swing.JTextField();
        deleteEventButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        createMovieIdField = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        createMovieNameField = new javax.swing.JTextField();
        createMovieButton = new javax.swing.JButton();
        movieAdminLogoutButton = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        moviePositionField = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        updateMovieIdField = new javax.swing.JTextField();
        updateMovieSearchButton = new javax.swing.JButton();
        updateMovieNameLabel = new javax.swing.JLabel();
        updateMovieNameField = new javax.swing.JTextField();
        updateMovieButton = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        deleteMovieIdField = new javax.swing.JTextField();
        deleteMovieButton = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        createTheatreIdField = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        createTheatreNameField = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        createTheatreCityCombo = new javax.swing.JComboBox<>();
        createTheatreButton = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        updateTheatreIdField = new javax.swing.JTextField();
        updateTheatreNameLabel = new javax.swing.JLabel();
        updateTheatreNameField = new javax.swing.JTextField();
        updateTheatreCityLabel = new javax.swing.JLabel();
        updateTheatreCityCombo = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        theatrePositionField = new javax.swing.JTextField();
        updateTheatreSearchButton = new javax.swing.JButton();
        updateTheatreButton = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        deleteTheatreIdField = new javax.swing.JTextField();
        deleteTheatreButton = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        createScreenIdField = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        createScreenTheatreCombo = new javax.swing.JComboBox<>();
        jLabel101 = new javax.swing.JLabel();
        createMovieDateField = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        createMovieTimeField = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        createScreenPriceField = new javax.swing.JTextField();
        createScreenButton = new javax.swing.JButton();
        createScreenMovieCombo = new javax.swing.JComboBox<>();
        jPanel51 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        updateScreenIdField = new javax.swing.JTextField();
        updateScreenTheatreNameLabel = new javax.swing.JLabel();
        updateScreenTheatreCombo = new javax.swing.JComboBox<>();
        updateScreenMovieNameLabel = new javax.swing.JLabel();
        updateScreenMovieCombo = new javax.swing.JComboBox<>();
        updateScreenMovieDateLabel = new javax.swing.JLabel();
        updateScreenMovieDate = new javax.swing.JTextField();
        updateScreenMovieTimeLabel = new javax.swing.JLabel();
        updateScreenMovieTime = new javax.swing.JTextField();
        updateScreenPriceLabel = new javax.swing.JLabel();
        updateScreenPriceField = new javax.swing.JTextField();
        updateScreenButton = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        screenPositionField = new javax.swing.JTextField();
        updateScreenSearchButton = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        deleteScreenIdField = new javax.swing.JTextField();
        deleteScreenButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setText("Role:");
        jPanel15.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        createRoleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banking Admin", "Bus Admin", "Train Admin", "Recharge Admin", "Utilities Admin", "Events Admin", "Movie Admin" }));
        jPanel15.add(createRoleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 130, -1));

        jLabel61.setText("Username:");
        jPanel15.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));
        jPanel15.add(createUserNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 130, -1));

        jLabel62.setText("Password:");
        jPanel15.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        createAdminButton.setText("Create");
        createAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAdminButtonActionPerformed(evt);
            }
        });
        jPanel15.add(createAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 210, -1));

        jLabel66.setText("Admin Id:");
        jPanel15.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));
        jPanel15.add(createAdminIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 130, -1));
        jPanel15.add(createPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 130, -1));

        sysAdminLogoutButton.setText("Logout");
        sysAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel15.add(sysAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 110, -1));

        jTabbedPane3.addTab("Create Admin", jPanel15);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateRoleLabel.setText("Role:");
        jPanel9.add(updateRoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));
        updateRoleLabel.setVisible(false);

        updateRoleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banking Admin", "Bus Admin", "Train Admin", "Recharge Admin", "Utilities Admin", "Events Admin", "Movie Admin" }));
        jPanel9.add(updateRoleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 130, -1));
        updateRoleCombo.setVisible(false);

        updateUserNameLabel.setText("Username:");
        jPanel9.add(updateUserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));
        updateUserNameLabel.setVisible(false);
        jPanel9.add(updateUserNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 130, -1));
        updateUserNameField.setVisible(false);

        updatePasswordLabel.setText("Password:");
        jPanel9.add(updatePasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));
        updatePasswordLabel.setVisible(false);

        updateAdminButton.setText("Update");
        updateAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAdminButtonActionPerformed(evt);
            }
        });
        jPanel9.add(updateAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 210, -1));
        updateAdminButton.setVisible(false);

        adminSearchButton.setText("Search");
        adminSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSearchButtonActionPerformed(evt);
            }
        });
        jPanel9.add(adminSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jLabel67.setText("Admin id:");
        jPanel9.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel9.add(updateAdminIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, -1));

        jLabel68.setText("Position:");
        jPanel9.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        adminPositionField.setEnabled(false);
        jPanel9.add(adminPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 130, -1));
        jPanel9.add(updatePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 130, -1));
        updatePasswordField.setVisible(false);

        jTabbedPane3.addTab("View/Update Admin", jPanel9);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setText("Admin id:");
        jPanel10.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel10.add(deleteAdminIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 120, -1));

        deleteAdminButton.setText("Delete");
        deleteAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAdminButtonActionPerformed(evt);
            }
        });
        jPanel10.add(deleteAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 200, -1));

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
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
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

        bankAdminLogoutButton.setText("Logout");
        bankAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel24.add(bankAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

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

        busAdminLogoutButton.setText("Logout");
        busAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel12.add(busAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

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
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bus Admin", jPanel3);

        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setText("Train Id:");
        jPanel37.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel37.add(createTrainIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        jLabel64.setText("From city:");
        jPanel37.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jLabel65.setText("To city:");
        jPanel37.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        createTrainFromCityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                createTrainFromCityComboItemStateChanged(evt);
            }
        });
        jPanel37.add(createTrainFromCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));

        jPanel37.add(createTrainToCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));

        jLabel70.setText("Start At:");
        jPanel37.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        jPanel37.add(createTrainStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));

        jLabel71.setText("Reach At:");
        jPanel37.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));
        jPanel37.add(createTrainReachAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 120, -1));

        jLabel72.setText("Fare:");
        jPanel37.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        jPanel37.add(createTrainFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));

        jLabel73.setText("Travel date:");
        jPanel37.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));
        jPanel37.add(createTrainTravelDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));

        createTrainButton.setText("Create");
        createTrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTrainButtonActionPerformed(evt);
            }
        });
        jPanel37.add(createTrainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 210, -1));

        trainAdminLogoutButton.setText("Logout");
        trainAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel37.add(trainAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        jTabbedPane7.addTab("Create Trains", jPanel37);

        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setText("Train Id:");
        jPanel38.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel38.add(updateTrainIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        updateTrainFromCityLabel.setText("From city:");
        jPanel38.add(updateTrainFromCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));
        updateTrainFromCityLabel.setVisible(false);

        updateTrainFromCityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateTrainFromCityComboItemStateChanged(evt);
            }
        });
        jPanel38.add(updateTrainFromCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));
        updateTrainFromCityCombo.setVisible(false);

        updateTrainToCityLabel.setText("To city:");
        jPanel38.add(updateTrainToCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        updateTrainToCityLabel.setVisible(false);

        jPanel38.add(updateTrainToCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));
        updateTrainToCityCombo.setVisible(false);

        updateTrainStartAtLabel.setText("Start At:");
        jPanel38.add(updateTrainStartAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        updateTrainStartAtLabel.setVisible(false);
        jPanel38.add(updateTrainStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));
        updateTrainStartAtField.setVisible(false);

        updateTrainReachAtLabel.setText("Reach At:");
        jPanel38.add(updateTrainReachAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));
        updateTrainReachAtLabel.setVisible(false);
        jPanel38.add(updateTrainReachAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 120, -1));
        updateTrainReachAtField.setVisible(false);

        updateTrainFareLabel.setText("Fare:");
        jPanel38.add(updateTrainFareLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        updateTrainFareLabel.setVisible(false);
        jPanel38.add(updateTrainFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));
        updateTrainFareField.setVisible(false);

        updateTrainTravelDateLabel.setText("Travel date:");
        jPanel38.add(updateTrainTravelDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));
        updateTrainTravelDateLabel.setVisible(false);
        jPanel38.add(updateTrainTravelDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));
        updateTrainTravelDateField.setVisible(false);

        updateTrainButton.setText("Update");
        updateTrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTrainButtonActionPerformed(evt);
            }
        });
        jPanel38.add(updateTrainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 210, -1));
        updateTrainButton.setVisible(false);

        updateTrainSearchButton.setText("Search");
        updateTrainSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTrainSearchButtonActionPerformed(evt);
            }
        });
        jPanel38.add(updateTrainSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        jLabel75.setText("Position:");
        jPanel38.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        trainPositionField.setEnabled(false);
        jPanel38.add(trainPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jTabbedPane7.addTab("View/Update Trains", jPanel38);

        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setText("Train Id:");
        jPanel39.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 137, -1, -1));
        jPanel39.add(deleteTrainIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, -1));

        deleteTrainButton.setText("Delete");
        deleteTrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTrainButtonActionPerformed(evt);
            }
        });
        jPanel39.add(deleteTrainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 200, -1));

        jTabbedPane7.addTab("Delete Trains", jPanel39);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
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

        rechargeAdminLogoutButton.setText("Logout");
        rechargeAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechargeAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel18.add(rechargeAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

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

        utilitiesAdminLogoutButton.setText("Logout");
        utilitiesAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilitiesAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel32.add(utilitiesAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

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

        jTabbedPane8.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setText("Event Id:");
        jPanel40.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel40.add(createEventIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jLabel78.setText("Event Name:");
        jPanel40.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel40.add(createEventNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        jLabel79.setText("Event city:");
        jPanel40.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jPanel40.add(createEventCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));

        jLabel80.setText("Start At:");
        jPanel40.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        jPanel40.add(createEventStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));

        jLabel81.setText("End At:");
        jPanel40.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));
        jPanel40.add(createEventEndAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, -1));

        jLabel82.setText("Price:");
        jPanel40.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));
        jPanel40.add(createEventFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 120, -1));

        jLabel83.setText("Event date:");
        jPanel40.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));
        jPanel40.add(createEventTravelDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 120, -1));

        createEventButton.setText("Create");
        createEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventButtonActionPerformed(evt);
            }
        });
        jPanel40.add(createEventButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 210, -1));

        eventAdminLogoutButton.setText("Logout");
        eventAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel40.add(eventAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jTabbedPane8.addTab("Create Events", jPanel40);

        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setText("Event Id:");
        jPanel41.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel41.add(updateEventIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        updateEventNameLabel.setText("Event Name:");
        jPanel41.add(updateEventNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        updateEventNameLabel.setVisible(false);
        jPanel41.add(updateEventNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));
        updateEventNameField.setVisible(false);

        updateEventCityLabel.setText("Event city:");
        jPanel41.add(updateEventCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));
        updateEventCityLabel.setVisible(false);

        jPanel41.add(updateEventCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));
        updateEventCityCombo.setVisible(false);

        updateEventStartAtLabel.setText("Start At:");
        jPanel41.add(updateEventStartAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        updateEventStartAtLabel.setVisible(false);
        jPanel41.add(updateEventStartAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));
        updateEventStartAtField.setVisible(false);

        updateEventEndAtLabel.setText("End At:");
        jPanel41.add(updateEventEndAtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, 30));
        updateEventEndAtLabel.setVisible(false);
        jPanel41.add(updateEventEndAtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, -1));
        updateEventEndAtField.setVisible(false);

        updateEventFareLabel.setText("Price:");
        jPanel41.add(updateEventFareLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));
        updateEventFareLabel.setVisible(false);
        jPanel41.add(updateEventFareField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 120, -1));
        updateEventFareField.setVisible(false);

        updateEventDateLabel.setText("Event date:");
        jPanel41.add(updateEventDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));
        updateEventDateLabel.setVisible(false);
        jPanel41.add(updateEventDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 120, -1));
        updateEventDateField.setVisible(false);

        updateEventButton.setText("Update");
        updateEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEventButtonActionPerformed(evt);
            }
        });
        jPanel41.add(updateEventButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 210, -1));
        updateEventButton.setVisible(false);

        updateEventSearchButton.setText("Search");
        updateEventSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEventSearchButtonActionPerformed(evt);
            }
        });
        jPanel41.add(updateEventSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel85.setText("Position:");
        jPanel41.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        eventPositionField.setEnabled(false);
        jPanel41.add(eventPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, -1));

        jTabbedPane8.addTab("View/Update Events", jPanel41);

        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setText("Event Id:");
        jPanel42.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));
        jPanel42.add(deleteEventIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, -1));

        deleteEventButton.setText("Delete");
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });
        jPanel42.add(deleteEventButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, -1));

        jTabbedPane8.addTab("Delete Events", jPanel42);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Events Admin", jPanel7);

        jTabbedPane9.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane9.setPreferredSize(new java.awt.Dimension(900, 900));
        jTabbedPane9.setSize(new java.awt.Dimension(1000, 1000));

        jPanel43.setPreferredSize(new java.awt.Dimension(900, 800));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setText("Movie Id:");
        jPanel43.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel43.add(createMovieIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jLabel88.setText("Movie Name:");
        jPanel43.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        jPanel43.add(createMovieNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        createMovieButton.setText("Create");
        createMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMovieButtonActionPerformed(evt);
            }
        });
        jPanel43.add(createMovieButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 210, -1));

        movieAdminLogoutButton.setText("Logout");
        movieAdminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieAdminLogoutButtonActionPerformed(evt);
            }
        });
        jPanel43.add(movieAdminLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jTabbedPane9.addTab("Create Movie", jPanel43);

        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setText("Position:");
        jPanel44.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        moviePositionField.setEnabled(false);
        jPanel44.add(moviePositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 120, -1));

        jLabel90.setText("Movie Id:");
        jPanel44.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));
        jPanel44.add(updateMovieIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 120, -1));

        updateMovieSearchButton.setText("Search");
        updateMovieSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMovieSearchButtonActionPerformed(evt);
            }
        });
        jPanel44.add(updateMovieSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        updateMovieNameLabel.setText("Movie Name:");
        jPanel44.add(updateMovieNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));
        updateMovieNameLabel.setVisible(false);
        jPanel44.add(updateMovieNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));
        updateMovieNameField.setVisible(false);

        updateMovieButton.setText("Update");
        updateMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMovieButtonActionPerformed(evt);
            }
        });
        jPanel44.add(updateMovieButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 220, -1));
        updateMovieButton.setVisible(false);

        jTabbedPane9.addTab("View/Update Movie", jPanel44);

        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setText("Movie Id:");
        jPanel45.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));
        jPanel45.add(deleteMovieIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 130, -1));

        deleteMovieButton.setText("Delete");
        deleteMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMovieButtonActionPerformed(evt);
            }
        });
        jPanel45.add(deleteMovieButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 210, -1));

        jTabbedPane9.addTab("Delete Movie", jPanel45);

        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setText("Theatre ID");
        jPanel46.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));
        jPanel46.add(createTheatreIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 130, -1));

        jLabel93.setText("Theatre Name");
        jPanel46.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));
        jPanel46.add(createTheatreNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 130, -1));

        jLabel94.setText("City Name");
        jPanel46.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jPanel46.add(createTheatreCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 130, -1));

        createTheatreButton.setText("Create");
        createTheatreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTheatreButtonActionPerformed(evt);
            }
        });
        jPanel46.add(createTheatreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 230, -1));

        jTabbedPane9.addTab("Create Theatre", jPanel46);

        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setText("Theatre ID");
        jPanel47.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));
        jPanel47.add(updateTheatreIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 130, -1));

        updateTheatreNameLabel.setText("Theatre Name");
        jPanel47.add(updateTheatreNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));
        updateTheatreNameLabel.setVisible(false);
        jPanel47.add(updateTheatreNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 130, -1));
        updateTheatreNameField.setVisible(false);

        updateTheatreCityLabel.setText("City Name");
        jPanel47.add(updateTheatreCityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));
        updateTheatreCityLabel.setVisible(false);

        jPanel47.add(updateTheatreCityCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 130, -1));
        updateTheatreCityCombo.setVisible(false);

        jLabel96.setText("Position:");
        jPanel47.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        theatrePositionField.setEnabled(false);
        jPanel47.add(theatrePositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 130, -1));

        updateTheatreSearchButton.setText("Search");
        updateTheatreSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTheatreSearchButtonActionPerformed(evt);
            }
        });
        jPanel47.add(updateTheatreSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        updateTheatreButton.setText("Update");
        updateTheatreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTheatreButtonActionPerformed(evt);
            }
        });
        jPanel47.add(updateTheatreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 230, -1));
        updateTheatreButton.setVisible(false);

        jTabbedPane9.addTab("View/Update Theatre", jPanel47);

        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setText("Theatre Id:");
        jPanel48.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));
        jPanel48.add(deleteTheatreIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 130, -1));

        deleteTheatreButton.setText("Delete");
        deleteTheatreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTheatreButtonActionPerformed(evt);
            }
        });
        jPanel48.add(deleteTheatreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 200, -1));

        jTabbedPane9.addTab("Delete Theatre", jPanel48);

        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setText("Screen Id:");
        jPanel50.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel50.add(createScreenIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        jLabel99.setText("Theatre Name:");
        jPanel50.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel100.setText("Movie Name:");
        jPanel50.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        jPanel50.add(createScreenTheatreCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));

        jLabel101.setText("Movie Date");
        jPanel50.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        jPanel50.add(createMovieDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));

        jLabel102.setText("Movie Time");
        jPanel50.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));
        jPanel50.add(createMovieTimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, -1));

        jLabel103.setText("Price:");
        jPanel50.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));
        jPanel50.add(createScreenPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 120, -1));

        createScreenButton.setText("Create");
        createScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createScreenButtonActionPerformed(evt);
            }
        });
        jPanel50.add(createScreenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 210, -1));

        jPanel50.add(createScreenMovieCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1177, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel49Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel49Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );

        jTabbedPane9.addTab("Create Screen", jPanel49);

        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setText("Screen Id:");
        jPanel51.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));
        jPanel51.add(updateScreenIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, -1));

        updateScreenTheatreNameLabel.setText("Theatre Name:");
        jPanel51.add(updateScreenTheatreNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));
        updateScreenTheatreNameLabel.setVisible(false);

        jPanel51.add(updateScreenTheatreCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, -1));
        updateScreenTheatreCombo.setVisible(false);

        updateScreenMovieNameLabel.setText("Movie Name:");
        jPanel51.add(updateScreenMovieNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));
        updateScreenMovieNameLabel.setVisible(false);

        jPanel51.add(updateScreenMovieCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, -1));
        updateScreenMovieCombo.setVisible(false);

        updateScreenMovieDateLabel.setText("Movie Date");
        jPanel51.add(updateScreenMovieDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));
        updateScreenMovieDateLabel.setVisible(false);
        jPanel51.add(updateScreenMovieDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, -1));
        updateScreenMovieDate.setVisible(false);

        updateScreenMovieTimeLabel.setText("Movie Time");
        jPanel51.add(updateScreenMovieTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));
        updateScreenMovieTimeLabel.setVisible(false);
        jPanel51.add(updateScreenMovieTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, -1));
        updateScreenMovieTime.setVisible(false);

        updateScreenPriceLabel.setText("Price:");
        jPanel51.add(updateScreenPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));
        updateScreenPriceLabel.setVisible(false);
        jPanel51.add(updateScreenPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 120, -1));
        updateScreenPriceField.setVisible(false);

        updateScreenButton.setText("Update");
        updateScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateScreenButtonActionPerformed(evt);
            }
        });
        jPanel51.add(updateScreenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 210, -1));
        updateScreenButton.setVisible(false);

        jLabel105.setText("Position:");
        jPanel51.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        screenPositionField.setEnabled(false);
        jPanel51.add(screenPositionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, -1));

        updateScreenSearchButton.setText("Search");
        updateScreenSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateScreenSearchButtonActionPerformed(evt);
            }
        });
        jPanel51.add(updateScreenSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jTabbedPane9.addTab("View/Update Screen", jPanel51);

        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setText("Screen Id:");
        jPanel52.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));
        jPanel52.add(deleteScreenIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 130, -1));

        deleteScreenButton.setText("Delete");
        deleteScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteScreenButtonActionPerformed(evt);
            }
        });
        jPanel52.add(deleteScreenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 200, -1));

        jTabbedPane9.addTab("Delete Screen", jPanel52);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Movie Admin", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1131, -1));

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
                
            case "adminId":
                updateRoleLabel.setVisible(false);
                updateRoleCombo.setVisible(false);
                updateUserNameLabel.setVisible(false);
                updateUserNameField.setVisible(false);
                updatePasswordLabel.setVisible(false);
                updatePasswordField.setVisible(false);
                updateAdminButton.setVisible(false);
                AdminDirectory ad = new AdminDirectory();
                for(Admin a: ad.getAdminList())
                {
                  if(Integer.parseInt(updateAdminIdField.getText()) == a.getId() && Integer.parseInt(updateAdminIdField.getText()) != 1)
                  { 
                      found = true;
                      position = a.getId();
                      updateRoleLabel.setVisible(true);
                      updateRoleCombo.setVisible(true);
                      updateUserNameLabel.setVisible(true);
                      updateUserNameField.setVisible(true);
                      updatePasswordLabel.setVisible(true);
                      updatePasswordField.setVisible(true);
                      updateAdminButton.setVisible(true);
                      adminPositionField.setText(Integer.valueOf(position).toString());
                      updateRoleCombo.setSelectedItem(a.getRole());                      
                      updateUserNameField.setText(a.getUserName());
                      updatePasswordField.setText(a.getPassword());
                      break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Admin with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "eventId":
                updateEventNameLabel.setVisible(false);
                updateEventCityLabel.setVisible(false);
                updateEventStartAtLabel.setVisible(false);
                updateEventEndAtLabel.setVisible(false);
                updateEventFareLabel.setVisible(false);
                updateEventDateLabel.setVisible(false);
                
                updateEventNameField.setVisible(false);
                updateEventCityCombo.setVisible(false);
                updateEventStartAtField.setVisible(false);
                updateEventEndAtField.setVisible(false);
                updateEventFareField.setVisible(false);
                updateEventDateField.setVisible(false);
                
                updateEventButton.setVisible(false);
                
                EventDirectory ed = new EventDirectory();
                for(Event e : ed.getEventList())
                {
                  if(Integer.parseInt(updateEventIdField.getText()) == e.getId())
                  { 
                        found = true;
                        position = e.getId();
                        updateEventNameLabel.setVisible(true);
                        updateEventCityLabel.setVisible(true);
                        updateEventStartAtLabel.setVisible(true);
                        updateEventEndAtLabel.setVisible(true);
                        updateEventFareLabel.setVisible(true);
                        updateEventDateLabel.setVisible(true);

                        updateEventNameField.setVisible(true);
                        updateEventCityCombo.setVisible(true);
                        updateEventStartAtField.setVisible(true);
                        updateEventEndAtField.setVisible(true);
                        updateEventFareField.setVisible(true);
                        updateEventDateField.setVisible(true);

                        updateEventButton.setVisible(true);
                        
                        eventPositionField.setText(Integer.valueOf(position).toString());
                        updateEventNameField.setText(e.getEventName());
                        CityDirectory city = new CityDirectory();
                        updateEventCityCombo.removeAllItems();
                        for(City c : city.getCityList())
                          updateEventCityCombo.addItem(c.getCityName());
                        updateEventCityCombo.setSelectedItem(e.getEventCity().getCityName());

                        updateEventStartAtField.setText(e.getStartTime().toString());
                        updateEventEndAtField.setText(e.getEndTime().toString());
                        updateEventFareField.setText(String.valueOf(e.getFare()));
                        updateEventDateField.setText(e.getEventDate().toString());
                        break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Event with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break; 
            
            case "trainId":
                updateTrainFromCityLabel.setVisible(false);
                updateTrainToCityLabel.setVisible(false);
                updateTrainStartAtLabel.setVisible(false);
                updateTrainReachAtLabel.setVisible(false);
                updateTrainFareLabel.setVisible(false);
                updateTrainTravelDateLabel.setVisible(false);  
                
                updateTrainFromCityCombo.setVisible(false);
                updateTrainToCityCombo.setVisible(false);
                updateTrainStartAtField.setVisible(false);
                updateTrainReachAtField.setVisible(false);
                updateTrainFareField.setVisible(false);
                updateTrainTravelDateField.setVisible(false);
                
                updateTrainButton.setVisible(false);
                
                TrainDirectory td = new TrainDirectory();
                for(Train t : td.getTrainList())
                {
                  if(Integer.parseInt(updateTrainIdField.getText()) == t.getId())
                  { 
                        found = true;
                        position = t.getId();
                        updateTrainFromCityLabel.setVisible(true);
                        updateTrainToCityLabel.setVisible(true);
                        updateTrainStartAtLabel.setVisible(true);
                        updateTrainReachAtLabel.setVisible(true);
                        updateTrainFareLabel.setVisible(true);
                        updateTrainTravelDateLabel.setVisible(true);
                        
                        updateTrainFromCityCombo.setVisible(true);
                        updateTrainToCityCombo.setVisible(true);
                        updateTrainStartAtField.setVisible(true);
                        updateTrainReachAtField.setVisible(true);
                        updateTrainFareField.setVisible(true);
                        updateTrainTravelDateField.setVisible(true);
                        
                        updateTrainButton.setVisible(true);                        
                        trainPositionField.setText(Integer.valueOf(position).toString());
                        CityDirectory cityd = new CityDirectory();
                        updateTrainFromCityCombo.removeAllItems();
                        for(City c : cityd.getCityList())
                        updateTrainFromCityCombo.addItem(c.getCityName());
                        updateTrainFromCityCombo.setSelectedItem(t.getFromCity().getCityName());
                        updateBusToCityCombo.removeAllItems();
                        for(int i = 0; i < updateTrainFromCityCombo.getItemCount(); i++)
                        {
                          if(updateTrainFromCityCombo.getSelectedItem().toString().equals(updateTrainFromCityCombo.getItemAt(i).toString()))
                            continue;           
                          updateTrainToCityCombo.addItem(updateTrainFromCityCombo.getItemAt(i).toString());
                        }
                        updateTrainToCityCombo.setSelectedItem(t.getToCity().getCityName());
                        updateTrainStartAtField.setText(t.getDepartureTime().toString());
                        updateTrainReachAtField.setText(t.getArrivalTime().toString());
                        updateTrainFareField.setText(String.valueOf(t.getFare()));
                        updateTrainTravelDateField.setText(t.getTravelDate().toString());
                        break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Train with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
            
             case "movieId":
                updateMovieNameLabel.setVisible(false);
                             
                updateMovieNameField.setVisible(false);
                              
                updateMovieButton.setVisible(false);
                
                MovieDirectory md = new MovieDirectory();
                for(Movie m : md.getMovieList())
                {
                  if(Integer.parseInt(updateMovieIdField.getText()) == m.getId())
                  { 
                        found = true;
                        position = m.getId();
                        updateMovieNameLabel.setVisible(true);
                       
                        
                        updateMovieNameField.setVisible(true);
                        
                        updateMovieButton.setVisible(true);
                        
                        moviePositionField.setText(Integer.valueOf(position).toString());
                        updateMovieNameField.setText(m.getMovieName());
                        
                        break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Movie with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "theatreId":
                updateTheatreNameLabel.setVisible(false);
                updateTheatreCityLabel.setVisible(false);
                updateTheatreNameField.setVisible(false);
                updateTheatreCityCombo.setVisible(false);
                updateTheatreButton.setVisible(false);
                
                TheatreDirectory tdy = new TheatreDirectory();
                for(Theatre t : tdy.getTheatreList())
                {
                  if(Integer.parseInt(updateTheatreIdField.getText()) == t.getId())
                  { 
                        found = true;
                        position = t.getId();
                        updateTheatreNameLabel.setVisible(true);
                        updateTheatreCityLabel.setVisible(true);

                        
                        updateTheatreNameField.setVisible(true);
                        updateTheatreCityCombo.setVisible(true);
                        updateTheatreButton.setVisible(true);
                        
                        theatrePositionField.setText(Integer.valueOf(position).toString());
                        updateTheatreNameField.setText(t.getTheatreName());
                        CityDirectory city = new CityDirectory();
                        updateTheatreCityCombo.removeAllItems();
                        for(City c : city.getCityList())
                          updateTheatreCityCombo.addItem(c.getCityName());
                        updateTheatreCityCombo.setSelectedItem(t.getCity().getCityName());

                        
                        break;  
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Theatre with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                break; 
                
            case "screenId":
                updateScreenTheatreNameLabel.setVisible(false);
                updateScreenMovieNameLabel.setVisible(false);
                updateScreenMovieDateLabel.setVisible(false);
                updateScreenMovieTimeLabel.setVisible(false);
                updateScreenPriceLabel.setVisible(false); 
                
                updateScreenTheatreCombo.setVisible(false);
                updateScreenMovieCombo.setVisible(false);
                updateScreenMovieDate.setVisible(false);
                updateScreenMovieTime.setVisible(false);
                updateScreenPriceField.setVisible(false); 
                
                updateScreenButton.setVisible(false);
                
                ScreenDirectory sd = new ScreenDirectory();
                for(Screen s : sd.getScreenList())
                {
                  if(Integer.parseInt(updateScreenIdField.getText()) == s.getId())
                  { 
                        found = true;
                        position = s.getId();
                        updateScreenTheatreNameLabel.setVisible(true);
                        updateScreenMovieNameLabel.setVisible(true);
                        updateScreenMovieDateLabel.setVisible(true);
                        updateScreenMovieTimeLabel.setVisible(true);
                        updateScreenPriceLabel.setVisible(true); 

                        updateScreenTheatreCombo.setVisible(true);
                        updateScreenMovieCombo.setVisible(true);
                        updateScreenMovieDate.setVisible(true);
                        updateScreenMovieTime.setVisible(true);
                        updateScreenPriceField.setVisible(true); 

                        updateScreenButton.setVisible(true);
                        
                        screenPositionField.setText(Integer.valueOf(position).toString());
                        TheatreDirectory ttd = new TheatreDirectory();
                        updateScreenTheatreCombo.removeAllItems();
                        for(Theatre t : ttd.getTheatreList())
                          updateScreenTheatreCombo.addItem(t.getTheatreName());
                        updateScreenTheatreCombo.setSelectedItem(s.getTheatre().getTheatreName());
                        
                        MovieDirectory mmd = new MovieDirectory();
                        updateScreenMovieCombo.removeAllItems();
                        for(Movie m : mmd.getMovieList())
                          updateScreenMovieCombo.addItem(m.getMovieName());
                        updateScreenMovieCombo.setSelectedItem(s.getMovie().getMovieName());


                        updateScreenMovieDate.setText(s.getMovieDate().toString());
                        updateScreenMovieTime.setText(s.getMovieTime().toString());
                        updateScreenPriceField.setText(String.valueOf(s.getPrice()));
                        break;
                  }
                }
                if(!found)
                    JOptionPane.showMessageDialog(this, "Screen with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
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
    public static boolean clientSideValidation1(JFrame frame, String adminId, String username, String password)
    {
        if(Pattern.compile("^[1-9]\\d*$").matcher(adminId).matches() && !adminId.equals(""))
        {
            if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(username).matches() && !username.equals(""))
            {
               System.out.println("User Name is valid.");              
               if(Pattern.compile("^(?=.*\\d).{4,15}$").matcher(password).matches())
                   return true;
               else
                 JOptionPane.showMessageDialog(frame, "Password is not valid.\nPassword must contain at least 4 characters with at least one digit.", "Alert", JOptionPane.WARNING_MESSAGE);                         
            }
            else
               JOptionPane.showMessageDialog(frame, "Username is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        }     
        else
            JOptionPane.showMessageDialog(frame, "City Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);           
      return false;     
    }
    private void createAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAdminButtonActionPerformed
        // TODO add your handling code here:
        String adminId = createAdminIdField.getText().trim();
        String role = createRoleCombo.getSelectedItem().toString();
        String userName = createUserNameField.getText().trim();
        String password = new String(createPasswordField.getPassword());
        boolean passed = clientSideValidation1(this, adminId, userName, password);
        boolean exists = false;
        if(passed)
        {
            AdminDirectory ad = new AdminDirectory();
            for(Admin a: ad.getAdminList())
            {
              if(Integer.parseInt(adminId) == a.getId())
              {
                JOptionPane.showMessageDialog(this, "Admin with the given Id already exists\nPlease give another Id to the Admin.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(userName.equals(a.getUserName()))
              {
                JOptionPane.showMessageDialog(this, "Admin with the given user name already exists\nPlease give another user name to the Admin.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(adminId);
              String name = userName;
              Admin admin = new Admin(id, role, name, password);
              int res = AdminDirectory.addAdmin(admin);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Created a new "+ role + " successfully.", null, JOptionPane.OK_OPTION); 
              }
            }
        }
    }//GEN-LAST:event_createAdminButtonActionPerformed

    private void adminSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateAdminIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Admin Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);        
        if(flag)
            searchData("adminId", searchText.trim());
    }//GEN-LAST:event_adminSearchButtonActionPerformed

    private void updateAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAdminButtonActionPerformed
        // TODO add your handling code here:                        
        String adminId = updateAdminIdField.getText().trim();
        String role = updateRoleCombo.getSelectedItem().toString();
        String userName = updateUserNameField.getText().trim();
        String password = new String(updatePasswordField.getPassword());
        int position = Integer.valueOf(adminPositionField.getText());
        boolean passed = clientSideValidation1(this, adminId, userName, password);
        boolean exists = false;
        if(passed)
        {
            AdminDirectory ad = new AdminDirectory();
            for(Admin a: ad.getAdminList())
            {
              if(Integer.parseInt(adminId) == a.getId() && a.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Admin with the given Id already exists\nPlease give another Id to the Admin.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;              
              }
              else if(userName.equals(a.getUserName()) && a.getId() != position)
              {
                JOptionPane.showMessageDialog(this, "Admin with the given user name already exists\nPlease give another user name to the Admin.", "Alert", JOptionPane.WARNING_MESSAGE);
                exists = true;
                break;
              }
            }
            if(!exists)
            {
              int id = Integer.parseInt(adminId);
              String name = userName;
              Admin admin = new Admin(id, role, name, password);
              int res = AdminDirectory.updateAdmin(admin, position);
              if(res > 0)
              {
                JOptionPane.showMessageDialog(this, "Updated the admin successfully.", null, JOptionPane.OK_OPTION);
                adminPositionField.setText(adminId);
              }
              else
                JOptionPane.showMessageDialog(this, "Admin does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);   
            }
        }
    }//GEN-LAST:event_updateAdminButtonActionPerformed

    private void deleteAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAdminButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteAdminIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Admin Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);       
        if(flag)
        {
          if(Integer.parseInt(deleteText) == 1)
          {
            JOptionPane.showMessageDialog(this, "You can\'t delete the System Admin account.", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
          }
          int res = AdminDirectory.deleteAdmin(Integer.parseInt(deleteText));          
          if(res > 0)
          {
            JOptionPane.showMessageDialog(this, "Deleted the Admin successfully.", null, JOptionPane.OK_OPTION);
          }
          else
            JOptionPane.showMessageDialog(this, "Admin with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteAdminButtonActionPerformed

    private void sysAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_sysAdminLogoutButtonActionPerformed

    private void bankAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_bankAdminLogoutButtonActionPerformed

    private void busAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_busAdminLogoutButtonActionPerformed

    private void rechargeAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechargeAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_rechargeAdminLogoutButtonActionPerformed

    private void utilitiesAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilitiesAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_utilitiesAdminLogoutButtonActionPerformed

    private void createTrainFromCityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_createTrainFromCityComboItemStateChanged
        // TODO add your handling code here:
        if(evt != null && evt.getSource().toString() != null && evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            createTrainToCityCombo.removeAllItems();
            for(int i = 0; i < createTrainFromCityCombo.getItemCount(); i++)
            {
                if(createTrainFromCityCombo.getSelectedItem().toString().equals(createTrainFromCityCombo.getItemAt(i).toString()))
                continue;
                createTrainToCityCombo.addItem(createTrainFromCityCombo.getItemAt(i).toString());
            }
        }
    }//GEN-LAST:event_createTrainFromCityComboItemStateChanged
    public boolean clientSideValidationTrain(JFrame frame, String trainId, String startAt, String endAt, String farePrice, String travelDate)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(trainId).matches())
      {

          if(Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(startAt).matches())
          {
            System.out.println("StartAt is valid.");
            if(Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(endAt).matches())
            {
              System.out.println("Reach At is valid.");
              if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(travelDate).matches() )
              {
                System.out.println("Travel date is valid.");
                if(Pattern.compile("^[0-9.]+$").matcher(farePrice).matches()&& !farePrice.equals(""))
                {
                    System.out.println("Fare is valid.");
                    return true;
                }
                else
                {
                     JOptionPane.showMessageDialog(frame, "Please enter the fare in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
              }
              else
                JOptionPane.showMessageDialog(this, "Travel date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
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
      {
        JOptionPane.showMessageDialog(frame, "Train Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createTrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTrainButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String trainId = createTrainIdField.getText().trim();
            String fromCity = createTrainFromCityCombo.getSelectedItem().toString();
            String toCity = createTrainToCityCombo.getSelectedItem().toString();
            String startAt = createTrainStartAtField.getText().trim();
            String reachAt = createTrainReachAtField.getText().trim();
            String farePrice = createTrainFareField.getText().trim();
            String date = createTrainTravelDateField.getText().trim();
            boolean passed = clientSideValidationTrain(this, trainId, startAt, reachAt, farePrice, date);
            boolean exists = false;
            if(passed)
            {
                TrainDirectory td = new TrainDirectory();
                for(Train t: td.getTrainList())
                {
                    if(Integer.parseInt(trainId) == t.getId())
                    {
                        JOptionPane.showMessageDialog(this, "Train with the given Id already exists\nPlease give another Id to the Train.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(trainId);
                    int fromCityId = CityDirectory.getCityId(fromCity);
                    int toCityId = CityDirectory.getCityId(toCity);
                    City from = new City(fromCityId, fromCity);
                    City to = new City(toCityId, toCity);
                    LocalTime departure = LocalTime.parse(startAt);
                    LocalTime arrival = LocalTime.parse(reachAt);
                    double fare = Double.parseDouble(farePrice);
                    LocalDate travelDate = LocalDate.parse(date);
                    Train train = new Train(id, from, to, departure, arrival, travelDate,fare );
                    int res = TrainDirectory.addTrain(train);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Created a new Train successfully..", null, JOptionPane.OK_OPTION);
                    }
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the from and to locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Travel Date/Time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createTrainButtonActionPerformed

    private void updateTrainFromCityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateTrainFromCityComboItemStateChanged
        // TODO add your handling code here:
        if(evt != null && evt.getSource().toString() != null && evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            updateTrainToCityCombo.removeAllItems();
            for(int i = 0; i < updateTrainFromCityCombo.getItemCount(); i++)
            {
                if(updateTrainFromCityCombo.getSelectedItem().toString().equals(updateTrainFromCityCombo.getItemAt(i).toString()))
                continue;
                updateTrainToCityCombo.addItem(updateTrainFromCityCombo.getItemAt(i).toString());
            }
        }
    }//GEN-LAST:event_updateTrainFromCityComboItemStateChanged

    private void updateTrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTrainButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String trainId = updateTrainIdField.getText().trim();
            String fromCity = updateTrainFromCityCombo.getSelectedItem().toString();
            String toCity = updateTrainToCityCombo.getSelectedItem().toString();
            String startAt = updateTrainStartAtField.getText().trim();
            String reachAt = updateTrainReachAtField.getText().trim();
            String farePrice = updateTrainFareField.getText().trim();
            String date = updateTrainTravelDateField.getText().trim();
            int position = Integer.valueOf(trainPositionField.getText());
            boolean passed = clientSideValidationTrain(this, trainId, startAt, reachAt, farePrice, date);
            boolean exists = false;
            if(passed)
            {
                BusDirectory bd = new BusDirectory();
                for(Bus b: bd.getBusList())
                {
                    if(Integer.parseInt(trainId) == b.getId() && b.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Bus with the given Id already exists\nPlease give another Id to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }

                }
                if(!exists)
                {
                    int id = Integer.parseInt(trainId);
                    int fromCityId = CityDirectory.getCityId(fromCity);
                    int toCityId = CityDirectory.getCityId(toCity);
                    City from = new City(fromCityId, fromCity);
                    City to = new City(toCityId, toCity);
                    LocalTime departure = LocalTime.parse(startAt);
                    LocalTime arrival = LocalTime.parse(reachAt);
                    double fare = Double.parseDouble(farePrice);
                    LocalDate travelDate = LocalDate.parse(date);
                    Train train = new Train(id, from, to, departure, arrival, travelDate, fare );
                    int res = TrainDirectory.updateTrain(train, position);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Updated the Train successfully..", null, JOptionPane.OK_OPTION);
                        trainPositionField.setText(trainId);
                    }
                    else
                    JOptionPane.showMessageDialog(this, "Train does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the from and to locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Travel Date/Time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateTrainButtonActionPerformed

    private void updateTrainSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTrainSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateTrainIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Train Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
            searchData("trainId", searchText.trim());
    }//GEN-LAST:event_updateTrainSearchButtonActionPerformed

    private void deleteTrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTrainButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteTrainIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Train Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
        {
            int res = TrainDirectory.deleteTrain(Integer.parseInt(deleteText));
            if(res > 0)
            {
                JOptionPane.showMessageDialog(this, "Deleted the Train successfully..", null, JOptionPane.OK_OPTION);
            }
            else
            JOptionPane.showMessageDialog(this, "train with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteTrainButtonActionPerformed
    public boolean clientsidevalidation(JFrame frame, String eventId, String eventName, String startAt, String endAt, String farePrice, String eventDate)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(eventId).matches())
      {
        if(Pattern.compile("^[a-zA-Z\\s0-9]*$").matcher(eventName).matches() && !eventName.equals(""))
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
                if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(eventDate).matches())
                {
                    System.out.println("Event date is valid.");
                    return true;
                }
                else
                {
                     JOptionPane.showMessageDialog(frame, "Event date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
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
          JOptionPane.showMessageDialog(frame, "Event Name is not valid.\nOnly Characters, numbers and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "Event Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String eventId = createEventIdField.getText().trim();
            String eventName = createEventNameField.getText().trim();
            String eventCity = createEventCityCombo.getSelectedItem().toString();
            String startAt = createEventStartAtField.getText().trim();
            String endAt = createEventEndAtField.getText().trim();
            String farePrice = createEventFareField.getText().trim();
            String eventDate = createEventTravelDateField.getText().trim();
            boolean passed = clientsidevalidation(this, eventId, eventName, startAt, endAt, farePrice, eventDate);
            boolean exists = false;
            if(passed)
            {
                EventDirectory ed = new EventDirectory();
                for(Event e: ed.getEventList())
                {
                    if(Integer.parseInt(eventId) == e.getId())
                    {
                        JOptionPane.showMessageDialog(this, "Event with the given Id already exists\nPlease give another Id to the Event.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(eventName.equals(e.getEventName()))
                    {
                        JOptionPane.showMessageDialog(this, "Event with the given name already exists\nPlease give another name to the Event.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(eventId);
                    int eventCityId = CityDirectory.getCityId(eventCity);
                    City event_city = new City(eventCityId, eventCity);
                    LocalTime start = LocalTime.parse(startAt);
                    LocalTime reach = LocalTime.parse(endAt);
                    double fare = Double.parseDouble(farePrice);
                    LocalDate event_date = LocalDate.parse(eventDate);
                    Event event = new Event(id, eventName, event_city, start, reach, fare, event_date);
                    int res = EventDirectory.addEvent(event);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Created a new Event successfully..", null, JOptionPane.OK_OPTION);
                    }
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the fields.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date/Time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createEventButtonActionPerformed

    private void updateEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEventButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String eventId = updateEventIdField.getText().trim();
            String eventName = updateEventNameField.getText().trim();
            String eventCity = updateEventCityCombo.getSelectedItem().toString();
            String startAt = updateEventStartAtField.getText().trim();
            String endAt = updateEventEndAtField.getText().trim();
            String farePrice = updateEventFareField.getText().trim();
            String date = updateEventDateField.getText().trim();
            int position = Integer.valueOf(eventPositionField.getText());
            boolean passed = clientsidevalidation(this, eventId, eventName, startAt, endAt, farePrice, date);
            boolean exists = false;
            if(passed)
            {
                EventDirectory ed = new EventDirectory();
                for(Event e: ed.getEventList())
                {
                    if(Integer.parseInt(eventId) == e.getId() && e.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Event with the given Id already exists\nPlease give another Id to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(eventName.equals(e.getEventName()) && e.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Event with the given name already exists\nPlease give another name to the Bus.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(eventId);
                    int fromCityId = CityDirectory.getCityId(eventCity);
                    City event_city = new City(fromCityId, eventCity);
                    LocalTime start = LocalTime.parse(startAt);
                    LocalTime reach = LocalTime.parse(endAt);
                    double fare = Double.parseDouble(farePrice);
                    LocalDate eventDate = LocalDate.parse(date);
                    Event event = new Event(id, eventName, event_city, start, reach, fare, eventDate);
                    int res = EventDirectory.updateEvent(event, position);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Updated the Event successfully..", null, JOptionPane.OK_OPTION);
                        eventPositionField.setText(eventId);
                    }
                    else
                    JOptionPane.showMessageDialog(this, "Event does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the  locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date/Time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateEventButtonActionPerformed

    private void updateEventSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEventSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateEventIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Event Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
            searchData("eventId", searchText.trim());
    }//GEN-LAST:event_updateEventSearchButtonActionPerformed

    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteEventIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Event Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
        {
            int res = EventDirectory.deleteEvent(Integer.parseInt(deleteText));
            if(res > 0)
            {
                JOptionPane.showMessageDialog(this, "Deleted the Event successfully..", null, JOptionPane.OK_OPTION);
            }
            else
            JOptionPane.showMessageDialog(this, "Event with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteEventButtonActionPerformed
    public boolean clientSideValidationMovie(JFrame frame, String movieId, String movieName)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(movieId).matches())
      {
        if(Pattern.compile("^[a-zA-Z\\s0-9]*$").matcher(movieName).matches() && !movieName.equals(""))
        {
            return true;

        }
        else
          JOptionPane.showMessageDialog(frame, "Movie Name is not valid.\nOnly Characters, numbers and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "Movie Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMovieButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String movieId = createMovieIdField.getText().trim();
            String movieName = createMovieNameField.getText().trim();

            boolean passed = clientSideValidationMovie(this, movieId, movieName);
            boolean exists = false;
            if(passed)
            {
                MovieDirectory md = new MovieDirectory();
                for(Movie m: md.getMovieList())
                {
                    if(Integer.parseInt(movieId) == m.getId())
                    {
                        JOptionPane.showMessageDialog(this, "Movie with the given Id already exists\nPlease give another Id to the Movie.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(movieName.equals(m.getMovieName()))
                    {
                        JOptionPane.showMessageDialog(this, "Movie with the given name already exists\nPlease give another name to the Movie.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(movieId);

                    Movie movie = new Movie(id, movieName);
                    int res = MovieDirectory.addMovie(movie);
                    if(res > 0)
                    {                        
                        JOptionPane.showMessageDialog(this, "Created a new Movie successfully.", null, JOptionPane.OK_OPTION);
                        MovieDirectory mdd = new MovieDirectory();
                        createScreenMovieCombo.removeAllItems();
                        for(Movie m: mdd.getMovieList())
                            createScreenMovieCombo.addItem(m.getMovieName());
                    }
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the fields.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createMovieButtonActionPerformed

    private void updateMovieSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMovieSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateMovieIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Movie Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
            searchData("movieId", searchText.trim());
    }//GEN-LAST:event_updateMovieSearchButtonActionPerformed

    private void updateMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMovieButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String movieId = updateMovieIdField.getText().trim();
            String movieName = updateMovieNameField.getText().trim();

            int position = Integer.valueOf(moviePositionField.getText());
            boolean passed = clientSideValidationMovie(this, movieId, movieName);
            boolean exists = false;
            if(passed)
            {
                MovieDirectory md = new MovieDirectory();
                for(Movie m: md.getMovieList())
                {
                    if(Integer.parseInt(movieId) == m.getId() && m.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Movie with the given Id already exists\nPlease give another Id to the Movie.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(movieName.equals(m.getMovieName()) && m.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Movie with the given name already exists\nPlease give another name to the Movie.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(movieId);

                    Movie movie = new Movie(id, movieName);
                    int res = MovieDirectory.updateMovie(movie, position);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Updated the Movie successfully..", null, JOptionPane.OK_OPTION);
                        moviePositionField.setText(movieId);
                    }
                    else
                    JOptionPane.showMessageDialog(this, "Movie does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateMovieButtonActionPerformed

    private void deleteMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMovieButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteMovieIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Movie Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
        {
            int res = MovieDirectory.deleteMovie(Integer.parseInt(deleteText));
            if(res > 0)
            {
                JOptionPane.showMessageDialog(this, "Deleted the Movie successfully..", null, JOptionPane.OK_OPTION);
                MovieDirectory md = new MovieDirectory();                        
                createScreenMovieCombo.removeAllItems();
                for(Movie m: md.getMovieList())
                    createScreenMovieCombo.addItem(m.getMovieName());
            }
            else
               JOptionPane.showMessageDialog(this, "Movie with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteMovieButtonActionPerformed
    public boolean clientSideValidationTheatre(JFrame frame, String theatreId, String theatreName)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(theatreId).matches())
      {
        if(Pattern.compile("^[a-zA-Z\\s0-9]*$").matcher(theatreName).matches() && !theatreName.equals(""))
        {
            return true;

        }
        else
          JOptionPane.showMessageDialog(frame, "Theatre Name is not valid.\nOnly Characters, numbers and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "Theatre Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createTheatreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTheatreButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String theatreId = createTheatreIdField.getText().trim();
            String theatreName = createTheatreNameField.getText().trim();
            String theatreCity = createTheatreCityCombo.getSelectedItem().toString();

            boolean passed = clientSideValidationTheatre(this, theatreId, theatreName);
            boolean exists = false;
            if(passed)
            {
                TheatreDirectory td = new TheatreDirectory();
                for(Theatre t: td.getTheatreList())
                {
                    if(Integer.parseInt(theatreId) == t.getId())
                    {
                        JOptionPane.showMessageDialog(this, "Theatre with the given Id already exists\nPlease give another Id to the Theatre.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(theatreName.equals(t.getTheatreName()))
                    {
                        JOptionPane.showMessageDialog(this, "Theatre with the given name already exists\nPlease give another name to the Theatre.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(theatreId);
                    int theatreCityId = CityDirectory.getCityId(theatreCity);
                    City theatre_city = new City(theatreCityId, theatreCity);

                    Theatre theatre = new Theatre(id, theatreName,theatre_city);
                    int res = TheatreDirectory.addTheatre(theatre);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Created a new Theatre successfully..", null, JOptionPane.OK_OPTION);
                        TheatreDirectory tdd = new TheatreDirectory();
                        createScreenTheatreCombo.removeAllItems();
                        for(Theatre t: tdd.getTheatreList())
                            createScreenTheatreCombo.addItem(t.getTheatreName());
                    }
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select all the fields.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createTheatreButtonActionPerformed

    private void updateTheatreSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTheatreSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateTheatreIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Theatre Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
            searchData("theatreId", searchText.trim());
    }//GEN-LAST:event_updateTheatreSearchButtonActionPerformed

    private void updateTheatreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTheatreButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String theatreId = updateTheatreIdField.getText().trim();
            String theatreName = updateTheatreNameField.getText().trim();
            String theatreCity = updateTheatreCityCombo.getSelectedItem().toString();

            int position = Integer.valueOf(theatrePositionField.getText());
            boolean passed = clientSideValidationTheatre(this, theatreId, theatreName);
            boolean exists = false;
            if(passed)
            {
                TheatreDirectory td = new TheatreDirectory();
                for(Theatre t: td.getTheatreList())
                {
                    if(Integer.parseInt(theatreId) == t.getId() && t.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Theatre with the given Id already exists\nPlease give another Id to the Theatre.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                    else if(theatreName.equals(t.getTheatreName()) && t.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Theatre with the given name already exists\nPlease give another name to the Theatre.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(theatreId);
                    int theatreCityId = CityDirectory.getCityId(theatreCity);
                    City theatre_city = new City(theatreCityId, theatreCity);
                    Theatre theatre = new Theatre(id, theatreName,theatre_city);
                    int res = TheatreDirectory.updateTheatre(theatre, position);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Updated the Theatre successfully..", null, JOptionPane.OK_OPTION);
                        theatrePositionField.setText(theatreId);
                    }
                    else
                    JOptionPane.showMessageDialog(this, "Theatre does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateTheatreButtonActionPerformed

    private void deleteTheatreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTheatreButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteTheatreIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Theatre Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
        {
            int res = TheatreDirectory.deleteTheatre(Integer.parseInt(deleteText));
            if(res > 0)
            {
                JOptionPane.showMessageDialog(this, "Deleted the Theatre successfully..", null, JOptionPane.OK_OPTION);
                TheatreDirectory td = new TheatreDirectory();
                createScreenTheatreCombo.removeAllItems();
                for(Theatre t: td.getTheatreList())
                    createScreenTheatreCombo.addItem(t.getTheatreName());
            }
            else
                JOptionPane.showMessageDialog(this, "Theatre with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_deleteTheatreButtonActionPerformed
    public boolean clientsidevalidationScreen(JFrame frame, String screenId, String movieDate, String movieTime, String price)
    {
      if(Pattern.compile("^[1-9]\\d*$").matcher(screenId).matches())
      {
        if(Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(movieDate).matches())
        {
          if(Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(movieTime).matches())
          {
            System.out.println("MovieTime is valid.");
            if(Pattern.compile("^[0-9.]+$").matcher(price).matches()&& !price.equals(""))
            {
              System.out.println("Price is valid.");
              return true;
            }
            else
            {
               JOptionPane.showMessageDialog(frame, "Please enter the price in positive numbers.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
          }
          else
          {
             JOptionPane.showMessageDialog(frame, "Movie Time is not valid.\nShould be in the format HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
          }
        }
        else
          JOptionPane.showMessageDialog(frame, "Movie date is not valid.\nShould be in the format YYYY-MM-DD.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "Screen Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
      }
      return false;
    }
    private void createScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createScreenButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String screenId = createScreenIdField.getText().trim();
            String theatreName = createScreenTheatreCombo.getSelectedItem().toString();
            String movieName = createScreenMovieCombo.getSelectedItem().toString();
            String movieDate = createMovieDateField.getText().trim();
            String movieTime = createMovieTimeField.getText().trim();
            String price = createScreenPriceField.getText().trim();
            boolean passed = clientsidevalidationScreen(this, screenId, movieDate, movieTime, price);
            boolean exists = false;
            if(passed)
            {
                ScreenDirectory sd = new ScreenDirectory();
                for(Screen s: sd.getScreenList())
                {
                    if(Integer.parseInt(screenId) == s.getId())
                    {
                        JOptionPane.showMessageDialog(this, "Screen with the given Id already exists\nPlease give another Id to the Screen.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(screenId);
                    int theatre_id = TheatreDirectory.getTheatreId(theatreName);
                    String theatre_name = "";
                    City theatreCity = null;
                    TheatreDirectory td = new TheatreDirectory();
                    for(Theatre t : td.getTheatreList())
                    {
                        if(t.getId() == theatre_id)
                        {
                            theatre_name = t.getTheatreName();
                            theatreCity = t.getCity();
                        }
                    }
                    Theatre theatre = new Theatre(theatre_id, theatre_name, theatreCity);

                    int movie_id = MovieDirectory.getMovieId(movieName);
                    String movie_name = "";
                    MovieDirectory md = new MovieDirectory();
                    for(Movie m: md.getMovieList())
                    {
                        if(m.getId() == movie_id)
                        {
                            movie_name = m.getMovieName();
                        }
                    }
                    Movie movie = new Movie(movie_id, movie_name);
                    LocalDate movie_date = LocalDate.parse(movieDate);
                    LocalTime movie_time = LocalTime.parse(movieTime);
                    double fare = Double.parseDouble(price);
                    Screen screen  = new Screen(id, theatre,movie,movie_date,movie_time,fare);
                    int res = ScreenDirectory.addScreen(screen);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Created a new Screen successfully..", null, JOptionPane.OK_OPTION);
                    }
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the fields.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date or time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createScreenButtonActionPerformed

    private void updateScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateScreenButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String screenId = updateScreenIdField.getText().trim();
            String theatreName = updateScreenTheatreCombo.getSelectedItem().toString();
            String movieName = updateScreenMovieCombo.getSelectedItem().toString();
            String movieDate = updateScreenMovieDate.getText().trim();
            String movieTime = updateScreenMovieTime.getText().trim();
            String price = updateScreenPriceField.getText().trim();
            int position = Integer.valueOf(screenPositionField.getText());
            boolean passed = clientsidevalidationScreen(this, screenId, movieDate, movieTime, price);
            boolean exists = false;
            if(passed)
            {
                ScreenDirectory sd = new ScreenDirectory();
                for(Screen s: sd.getScreenList())
                {
                    if(Integer.parseInt(screenId) == s.getId() && s.getId() != position)
                    {
                        JOptionPane.showMessageDialog(this, "Screen with the given Id already exists\nPlease give another Id to the Screen.", "Alert", JOptionPane.WARNING_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if(!exists)
                {
                    int id = Integer.parseInt(screenId);
                    int theatre_id = TheatreDirectory.getTheatreId(theatreName);
                    String theatre_name = "";
                    City theatreCity = null;
                    TheatreDirectory td = new TheatreDirectory();
                    for(Theatre t : td.getTheatreList())
                    {
                        if(t.getId() == theatre_id)
                        {
                            theatre_name = t.getTheatreName();
                            theatreCity = t.getCity();
                        }
                    }
                    Theatre theatre = new Theatre(theatre_id, theatre_name, theatreCity);

                    int movie_id = MovieDirectory.getMovieId(movieName);
                    String movie_name = "";
                    MovieDirectory md = new MovieDirectory();
                    for(Movie m: md.getMovieList())
                    {
                        if(m.getId() == movie_id)
                        {
                            movie_name = m.getMovieName();
                        }
                    }
                    Movie movie = new Movie(movie_id, movie_name);
                    LocalDate movie_date = LocalDate.parse(movieDate);
                    LocalTime movie_time = LocalTime.parse(movieTime);
                    double fare = Double.parseDouble(price);
                    Screen screen  = new Screen(id, theatre,movie,movie_date,movie_time,fare);
                    int res = ScreenDirectory.updateScreen(screen,position);
                    if(res > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Updated the Screen successfully..", null, JOptionPane.OK_OPTION);
                        screenPositionField.setText(screenId);
                    }
                    else
                    JOptionPane.showMessageDialog(this, "Screen does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this, "Please select the  locations.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(DateTimeParseException dtp)
        {
          JOptionPane.showMessageDialog(this, "Date or time is not valid.\nShould be in the format YYYY-MM-DD/HH:MM:SS.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateScreenButtonActionPerformed

    private void updateScreenSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateScreenSearchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = updateScreenIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(searchText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Screen Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
            searchData("screenId", searchText.trim());
    }//GEN-LAST:event_updateScreenSearchButtonActionPerformed

    private void deleteScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteScreenButtonActionPerformed
        // TODO add your handling code here:
        String deleteText = deleteScreenIdField.getText().trim();
        boolean flag = false;
        if(Pattern.compile("^[1-9]\\d*$").matcher(deleteText).matches())
            flag = true;
        else
            JOptionPane.showMessageDialog(this, "Screen Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        if(flag)
        {
            int res = ScreenDirectory.deleteScreen(Integer.parseInt(deleteText));
            if(res > 0)
            {
                JOptionPane.showMessageDialog(this, "Deleted the Screen successfully..", null, JOptionPane.OK_OPTION);
            }
            else
                JOptionPane.showMessageDialog(this, "Screen with the given Id does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteScreenButtonActionPerformed

    private void trainAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_trainAdminLogoutButtonActionPerformed

    private void eventAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_eventAdminLogoutButtonActionPerformed

    private void movieAdminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieAdminLogoutButtonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_movieAdminLogoutButtonActionPerformed

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
                new AdminFrame("").setVisible(true);
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
    private javax.swing.JTextField adminPositionField;
    private javax.swing.JButton adminSearchButton;
    private javax.swing.JButton bankAdminLogoutButton;
    private javax.swing.JButton bankApprovedButton;
    private javax.swing.JButton bankDeniedButton;
    private javax.swing.JButton bankInProgressButton;
    private javax.swing.JTextField bankPositionField;
    private javax.swing.JTable bankRequestsTable;
    private javax.swing.JButton bankSearchButton;
    private javax.swing.JButton busAdminLogoutButton;
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
    private javax.swing.JButton createAdminButton;
    private javax.swing.JTextField createAdminIdField;
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
    private javax.swing.JButton createEventButton;
    private javax.swing.JComboBox<String> createEventCityCombo;
    private javax.swing.JTextField createEventEndAtField;
    private javax.swing.JTextField createEventFareField;
    private javax.swing.JTextField createEventIdField;
    private javax.swing.JTextField createEventNameField;
    private javax.swing.JTextField createEventStartAtField;
    private javax.swing.JTextField createEventTravelDateField;
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
    private javax.swing.JButton createMovieButton;
    private javax.swing.JTextField createMovieDateField;
    private javax.swing.JTextField createMovieIdField;
    private javax.swing.JTextField createMovieNameField;
    private javax.swing.JTextField createMovieTimeField;
    private javax.swing.JPasswordField createPasswordField;
    private javax.swing.JTextField createPlanNameField;
    private javax.swing.JComboBox<String> createRoleCombo;
    private javax.swing.JButton createScreenButton;
    private javax.swing.JTextField createScreenIdField;
    private javax.swing.JComboBox<String> createScreenMovieCombo;
    private javax.swing.JTextField createScreenPriceField;
    private javax.swing.JComboBox<String> createScreenTheatreCombo;
    private javax.swing.JButton createTheatreButton;
    private javax.swing.JComboBox<String> createTheatreCityCombo;
    private javax.swing.JTextField createTheatreIdField;
    private javax.swing.JTextField createTheatreNameField;
    private javax.swing.JButton createTrainButton;
    private javax.swing.JTextField createTrainFareField;
    private javax.swing.JComboBox<String> createTrainFromCityCombo;
    private javax.swing.JTextField createTrainIdField;
    private javax.swing.JTextField createTrainReachAtField;
    private javax.swing.JTextField createTrainStartAtField;
    private javax.swing.JComboBox<String> createTrainToCityCombo;
    private javax.swing.JTextField createTrainTravelDateField;
    private javax.swing.JTextField createUserNameField;
    private javax.swing.JButton deleteAdminButton;
    private javax.swing.JTextField deleteAdminIdField;
    private javax.swing.JButton deleteBankButton;
    private javax.swing.JTextField deleteBankIdField;
    private javax.swing.JButton deleteBusButton;
    private javax.swing.JTextField deleteBusIdField;
    private javax.swing.JButton deleteCardButton;
    private javax.swing.JTextField deleteCardIdField;
    private javax.swing.JButton deleteCityButton;
    private javax.swing.JTextField deleteCityIdField;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JTextField deleteEventIdField;
    private javax.swing.JButton deleteMPButton;
    private javax.swing.JTextField deleteMPIdField;
    private javax.swing.JButton deleteMSPButton;
    private javax.swing.JTextField deleteMSPIdField;
    private javax.swing.JButton deleteMovieButton;
    private javax.swing.JTextField deleteMovieIdField;
    private javax.swing.JButton deleteScreenButton;
    private javax.swing.JTextField deleteScreenIdField;
    private javax.swing.JButton deleteTheatreButton;
    private javax.swing.JTextField deleteTheatreIdField;
    private javax.swing.JButton deleteTrainButton;
    private javax.swing.JTextField deleteTrainIdField;
    private javax.swing.JTextField elecBillAmountField;
    private javax.swing.JTextField elecBillBillingDateField;
    private javax.swing.JTextField elecBillDueDateField;
    private javax.swing.JButton elecBillSendButton;
    private javax.swing.JTextField elecBillTotalKWattsField;
    private javax.swing.JComboBox<String> elecBilluserIdCombo;
    private javax.swing.JButton eventAdminLogoutButton;
    private javax.swing.JTextField eventPositionField;
    private javax.swing.JTextField gasBillAmountField;
    private javax.swing.JTextField gasBillBillingDateField;
    private javax.swing.JTextField gasBillDueDateField;
    private javax.swing.JButton gasBillSendButton;
    private javax.swing.JTextField gasBillTotalGallonsField;
    private javax.swing.JComboBox<String> gasBilluserIdCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
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
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
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
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
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
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JButton movieAdminLogoutButton;
    private javax.swing.JTextField moviePositionField;
    private javax.swing.JButton rechargeAdminLogoutButton;
    private javax.swing.JTextField screenPositionField;
    private javax.swing.JButton searchCardButton;
    private javax.swing.JButton sysAdminLogoutButton;
    private javax.swing.JTextField theatrePositionField;
    private javax.swing.JButton trainAdminLogoutButton;
    private javax.swing.JTextField trainPositionField;
    private javax.swing.JButton updateAdminButton;
    private javax.swing.JTextField updateAdminIdField;
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
    private javax.swing.JButton updateEventButton;
    private javax.swing.JComboBox<String> updateEventCityCombo;
    private javax.swing.JLabel updateEventCityLabel;
    private javax.swing.JTextField updateEventDateField;
    private javax.swing.JLabel updateEventDateLabel;
    private javax.swing.JTextField updateEventEndAtField;
    private javax.swing.JLabel updateEventEndAtLabel;
    private javax.swing.JTextField updateEventFareField;
    private javax.swing.JLabel updateEventFareLabel;
    private javax.swing.JTextField updateEventIdField;
    private javax.swing.JTextField updateEventNameField;
    private javax.swing.JLabel updateEventNameLabel;
    private javax.swing.JButton updateEventSearchButton;
    private javax.swing.JTextField updateEventStartAtField;
    private javax.swing.JLabel updateEventStartAtLabel;
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
    private javax.swing.JButton updateMovieButton;
    private javax.swing.JTextField updateMovieIdField;
    private javax.swing.JTextField updateMovieNameField;
    private javax.swing.JLabel updateMovieNameLabel;
    private javax.swing.JButton updateMovieSearchButton;
    private javax.swing.JPasswordField updatePasswordField;
    private javax.swing.JLabel updatePasswordLabel;
    private javax.swing.JTextField updatePlanNameField;
    private javax.swing.JLabel updatePlanNameLabel;
    private javax.swing.JComboBox<String> updateRoleCombo;
    private javax.swing.JLabel updateRoleLabel;
    private javax.swing.JButton updateScreenButton;
    private javax.swing.JTextField updateScreenIdField;
    private javax.swing.JComboBox<String> updateScreenMovieCombo;
    private javax.swing.JTextField updateScreenMovieDate;
    private javax.swing.JLabel updateScreenMovieDateLabel;
    private javax.swing.JLabel updateScreenMovieNameLabel;
    private javax.swing.JTextField updateScreenMovieTime;
    private javax.swing.JLabel updateScreenMovieTimeLabel;
    private javax.swing.JTextField updateScreenPriceField;
    private javax.swing.JLabel updateScreenPriceLabel;
    private javax.swing.JButton updateScreenSearchButton;
    private javax.swing.JComboBox<String> updateScreenTheatreCombo;
    private javax.swing.JLabel updateScreenTheatreNameLabel;
    private javax.swing.JButton updateTheatreButton;
    private javax.swing.JComboBox<String> updateTheatreCityCombo;
    private javax.swing.JLabel updateTheatreCityLabel;
    private javax.swing.JTextField updateTheatreIdField;
    private javax.swing.JTextField updateTheatreNameField;
    private javax.swing.JLabel updateTheatreNameLabel;
    private javax.swing.JButton updateTheatreSearchButton;
    private javax.swing.JButton updateTrainButton;
    private javax.swing.JTextField updateTrainFareField;
    private javax.swing.JLabel updateTrainFareLabel;
    private javax.swing.JComboBox<String> updateTrainFromCityCombo;
    private javax.swing.JLabel updateTrainFromCityLabel;
    private javax.swing.JTextField updateTrainIdField;
    private javax.swing.JTextField updateTrainReachAtField;
    private javax.swing.JLabel updateTrainReachAtLabel;
    private javax.swing.JButton updateTrainSearchButton;
    private javax.swing.JTextField updateTrainStartAtField;
    private javax.swing.JLabel updateTrainStartAtLabel;
    private javax.swing.JComboBox<String> updateTrainToCityCombo;
    private javax.swing.JLabel updateTrainToCityLabel;
    private javax.swing.JTextField updateTrainTravelDateField;
    private javax.swing.JLabel updateTrainTravelDateLabel;
    private javax.swing.JTextField updateUserNameField;
    private javax.swing.JLabel updateUserNameLabel;
    private javax.swing.JButton utilitiesAdminLogoutButton;
    private javax.swing.JTextField waterBillAmountField;
    private javax.swing.JTextField waterBillBillingDateField;
    private javax.swing.JTextField waterBillDueDateField;
    private javax.swing.JButton waterBillSendButton;
    private javax.swing.JTextField waterBillTotalGallonsField;
    private javax.swing.JComboBox<String> waterBilluserIdCombo;
    // End of variables declaration//GEN-END:variables
}
