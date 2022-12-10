/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.City;
import business.CityDirectory;
import business.Mail;
import business.MovieBooking;
import business.MovieBookingDirectory;
import business.Screen;
import business.ScreenDirectory;
import business.Theatre;
import business.TheatreDirectory;
import business.User;
import business.UserDirectory;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import static userinterface.UserHomePage.balanceLabel;
import static userinterface.UserHomePage.userNameLabel;

/**
 *
 * @author nbabu
 */
public class BookMovieTickets extends javax.swing.JFrame {

    /**
     * Creates new form BookEventTickets
     */
    ArrayList<Theatre> theatreDirectory = new ArrayList<>();
    ArrayList<Screen> screenDirectory = new ArrayList<>();
    ArrayList<City> cityDirectory = new ArrayList<>();
    public BookMovieTickets() {
        initComponents();
        CityDirectory cd = new CityDirectory();
        System.out.println(cityComboBox.getItemListeners()[0]);
        for(City c : cd.getCityList())
        {
          cityComboBox.addItem(c.getCityName());
          cityDirectory.add(c);
        }
        cityComboBox.setSelectedItem(null);
        
        TheatreDirectory td = new TheatreDirectory();
        for(Theatre t: td.getTheatreList())
        {
          theatreDirectory.add(t);
        }
        ScreenDirectory sd = new ScreenDirectory();
        for(Screen s: sd.getScreenList())
        {
          screenDirectory.add(s);
        }        
        
        ItemListener timeItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                    int screenId = Integer.parseInt(screensComboBox.getSelectedItem().toString());
                    String movieName = movieComboBox.getSelectedItem().toString();
                    String movieDate = dateComboBox.getSelectedItem().toString();
                    String movieTime = timeComboBox.getSelectedItem().toString();
                    seatComboBox.setEnabled(true);
                    priceField.setText("");
                    seatComboBox.removeAllItems();
                    ScreenDirectory sd = new ScreenDirectory();
                    for(Screen s : sd.getScreenList())
                    {
                      if(s.getId() == screenId && s.getMovie().getMovieName().equals(movieName) && s.getMovieDate().toString().equals(movieDate) && s.getMovieTime().toString().equals(movieTime))
                      {
                        priceField.setText(String.valueOf(s.getPrice()));
                      }           
                    }
                    ArrayList<Integer> seats = new ArrayList<>();
                    for(int i = 1; i < 61 ; i++)
                    {                  
                      seats.add(i);
                    }
//                    for(MovieBooking mb : movieBookingDirectory)
//                    {
//                      if(mb.getScreen().getId() == screenId)
//                      {
//                        seats.remove(Integer.valueOf(mb.getSeatNumber()));
//                      }              
//                    }
                    seatComboBox.removeAllItems();
                    for(int i : seats)
                    {
                      int res = MovieBookingDirectory.seatFilled(screenId, i);
                      if(res == 0)
                      {
                        seatComboBox.addItem(String.valueOf(i));
                      }                      
                    } 
                }
            }          
        };        
        ItemListener dateItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                    timeComboBox.setEnabled(true);
                    int screenId = Integer.parseInt(screensComboBox.getSelectedItem().toString());
                    String movieName = movieComboBox.getSelectedItem().toString();
                    String movieDate = dateComboBox.getSelectedItem().toString();
                    timeComboBox.removeAllItems();
                    priceField.setText("");
                    seatComboBox.removeAllItems();
                    timeComboBox.removeItemListener(timeItemStateListener);
                    for(Screen s : screenDirectory)
                    {
                      if(s.getId() == screenId && s.getMovie().getMovieName().equals(movieName) && s.getMovieDate().toString().equals(movieDate))
                      {
                        timeComboBox.addItem(s.getMovieTime().toString());
                      }            
                    }
                    timeComboBox.setSelectedItem(null);
                    timeComboBox.addItemListener(timeItemStateListener);
                }
            }          
        };        
         ItemListener movieItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                    dateComboBox.setEnabled(true);
                    int screenId = Integer.parseInt(screensComboBox.getSelectedItem().toString());
                    String movieName = movieComboBox.getSelectedItem().toString();
                    dateComboBox.removeAllItems();
                    timeComboBox.removeAllItems();
                    priceField.setText("");
                    seatComboBox.removeAllItems();
                    dateComboBox.removeItemListener(dateItemStateListener);
                    for(Screen s : screenDirectory)
                    {
                      if(s.getId() == screenId && s.getMovie().getMovieName().equals(movieName))
                      {
                        if(s.getMovieDate().isAfter(LocalDate.now()))
                        {
                          dateComboBox.addItem(s.getMovieDate().toString());
                        }
                      }            
                    }
                    dateComboBox.setSelectedItem(null);
                    dateComboBox.addItemListener(dateItemStateListener);
                }
            }          
        };        
        ItemListener screenItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                    movieComboBox.setEnabled(true);
                    int screenId = Integer.parseInt(screensComboBox.getSelectedItem().toString());
                    movieComboBox.removeAllItems();
                    dateComboBox.removeAllItems();
                    timeComboBox.removeAllItems();
                    priceField.setText("");
                    seatComboBox.removeAllItems();
                    movieComboBox.removeItemListener(movieItemStateListener);
                    for(Screen s : screenDirectory)
                    {
                      if(s.getId() == screenId)
                      {
                        movieComboBox.addItem(s.getMovie().getMovieName());
                      }            
                    }
                    movieComboBox.setSelectedItem(null);
                    movieComboBox.addItemListener(movieItemStateListener);
                }
            }          
        };        
        ItemListener theatreItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                    screensComboBox.setEnabled(true);
                    String theatreName = theatresComboBox.getSelectedItem().toString();
                    screensComboBox.removeAllItems();
                    movieComboBox.removeAllItems();
                    dateComboBox.removeAllItems();
                    timeComboBox.removeAllItems();
                    priceField.setText("");
                    seatComboBox.removeAllItems();
                    screensComboBox.removeItemListener(screenItemStateListener);
                    for(Screen s : screenDirectory)
                    {
                      if(s.getTheatre().getTheatreName().equals(theatreName))
                      {
                        screensComboBox.addItem(String.valueOf(s.getId()));
                      }            
                    }
                    screensComboBox.setSelectedItem(null);
                    screensComboBox.addItemListener(screenItemStateListener);
                }
            }          
        };        
         
        ItemListener cityItemStateListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event != null && event.getSource().toString() != null && event.getStateChange() == java.awt.event.ItemEvent.SELECTED) 
                {
                  theatresComboBox.setEnabled(true);
                  String cityName = cityComboBox.getSelectedItem().toString();
                  theatresComboBox.removeAllItems();
                  screensComboBox.removeAllItems();
                  movieComboBox.removeAllItems();
                  dateComboBox.removeAllItems();
                  timeComboBox.removeAllItems();
                  priceField.setText("");
                  seatComboBox.removeAllItems();
                  theatresComboBox.removeItemListener(theatreItemStateListener);
                  for(Theatre t : theatreDirectory)
                  {
                    if(t.getCity().getCityName().equals(cityName))
                    {
                      theatresComboBox.addItem(t.getTheatreName());
                    }            
                  }
                  theatresComboBox.setSelectedItem(null);
                  theatresComboBox.addItemListener(theatreItemStateListener);
                }
            }          
        };
        cityComboBox.addItemListener(cityItemStateListener);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        theatresComboBox = new javax.swing.JComboBox<>();
        cityComboBox = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        bookTicketButton = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        seatComboBox = new javax.swing.JComboBox<>();
        nL = new javax.swing.JLabel();
        mL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        movieComboBox = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        screensComboBox = new javax.swing.JComboBox<>();
        dateComboBox = new javax.swing.JComboBox<>();
        timeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingHistoryTable = new javax.swing.JTable();
        showHistoryButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        movieIdField = new javax.swing.JTextField();
        cancelBookingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Book Movie Tickets");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("City:");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        theatresComboBox.setBackground(new java.awt.Color(0, 0, 0));
        theatresComboBox.setForeground(new java.awt.Color(204, 204, 204));
        theatresComboBox.setEnabled(false);
        jPanel1.add(theatresComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 140, -1));

        cityComboBox.setBackground(new java.awt.Color(0, 0, 0));
        cityComboBox.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 140, -1));

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Theatres");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Select seat number");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        jLabel43.setBackground(new java.awt.Color(0, 0, 0));
        jLabel43.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("Select a date");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        clearButton.setBackground(new java.awt.Color(102, 204, 255));
        clearButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 110, 30));

        bookTicketButton.setBackground(new java.awt.Color(102, 204, 255));
        bookTicketButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        bookTicketButton.setForeground(new java.awt.Color(255, 255, 255));
        bookTicketButton.setText("Book Ticket");
        bookTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTicketButtonActionPerformed(evt);
            }
        });
        jPanel1.add(bookTicketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 110, 30));

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("Price");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        priceField.setBackground(new java.awt.Color(0, 0, 0));
        priceField.setForeground(new java.awt.Color(204, 204, 204));
        priceField.setEnabled(false);
        jPanel1.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 140, -1));

        seatComboBox.setBackground(new java.awt.Color(0, 0, 0));
        seatComboBox.setForeground(new java.awt.Color(204, 204, 204));
        seatComboBox.setEnabled(false);
        jPanel1.add(seatComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 140, -1));
        jPanel1.add(nL, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 20, 20));
        jPanel1.add(mL, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 20, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/popcorn.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 140, 130));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tickets.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 130, 130));

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Movie Name");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        movieComboBox.setBackground(new java.awt.Color(0, 0, 0));
        movieComboBox.setForeground(new java.awt.Color(204, 204, 204));
        movieComboBox.setEnabled(false);
        jPanel1.add(movieComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 140, -1));

        jLabel46.setBackground(new java.awt.Color(0, 0, 0));
        jLabel46.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("Screens");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        screensComboBox.setBackground(new java.awt.Color(0, 0, 0));
        screensComboBox.setForeground(new java.awt.Color(204, 204, 204));
        screensComboBox.setEnabled(false);
        jPanel1.add(screensComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 140, -1));

        dateComboBox.setBackground(new java.awt.Color(0, 0, 0));
        dateComboBox.setForeground(new java.awt.Color(204, 204, 204));
        dateComboBox.setEnabled(false);
        jPanel1.add(dateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 140, -1));

        timeComboBox.setBackground(new java.awt.Color(0, 0, 0));
        timeComboBox.setForeground(new java.awt.Color(204, 204, 204));
        timeComboBox.setEnabled(false);
        jPanel1.add(timeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 140, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Select a time");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 80, -1));

        jTabbedPane1.addTab("Book Movie Tickets", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 204, 255));
        jLabel3.setText(" Booking History");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        bookingHistoryTable.setBackground(new java.awt.Color(51, 51, 51));
        bookingHistoryTable.setForeground(new java.awt.Color(204, 204, 204));
        bookingHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Screen", "Theatre", "City", "Movie", "Date", "Show time", "Seat Number", "Booking date", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookingHistoryTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 750, 200));

        showHistoryButton.setBackground(new java.awt.Color(102, 204, 255));
        showHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        showHistoryButton.setText("Show");
        showHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHistoryButtonActionPerformed(evt);
            }
        });
        jPanel2.add(showHistoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jTabbedPane1.addTab("Show Bookings", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setText("CANCEL Bookings");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 14, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Enter the Movie booking ID");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        movieIdField.setBackground(new java.awt.Color(0, 0, 0));
        movieIdField.setForeground(new java.awt.Color(204, 204, 204));
        movieIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieIdFieldActionPerformed(evt);
            }
        });
        jPanel3.add(movieIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 120, -1));

        cancelBookingButton.setBackground(new java.awt.Color(102, 204, 255));
        cancelBookingButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelBookingButton.setText("Cancel");
        cancelBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelBookingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 70, -1));

        jTabbedPane1.addTab("Delete Bookings", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        cityComboBox.setSelectedItem(null);
        theatresComboBox.removeAllItems();
        theatresComboBox.setEnabled(false);
        screensComboBox.removeAllItems();
        screensComboBox.setEnabled(false);
        movieComboBox.removeAllItems();
        movieComboBox.setEnabled(false);
        dateComboBox.removeAllItems();
        dateComboBox.setEnabled(false);
        timeComboBox.removeAllItems();
        timeComboBox.setEnabled(false);
        priceField.setText("");
        seatComboBox.removeAllItems();
        seatComboBox.setEnabled(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void bookTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTicketButtonActionPerformed
        // TODO add your handling code here:
        try
        {         
            String city = cityComboBox.getSelectedItem().toString();
            String theatre = theatresComboBox.getSelectedItem().toString();
            String screenId = screensComboBox.getSelectedItem().toString();
            String movie = movieComboBox.getSelectedItem().toString();
            String date = dateComboBox.getSelectedItem().toString();
            String time = timeComboBox.getSelectedItem().toString();
            int seatNumber = Integer.parseInt(seatComboBox.getSelectedItem().toString());
            double price = Double.parseDouble(priceField.getText());
            UserDirectory ud = new UserDirectory();
            int userId = 0;
            double balance = 0;
            String email = "";
            for(User user : ud.getUserList())
            {
              if(user.getUserName().equals(userNameLabel.getText()))
              {
                userId = user.getId();
                balance = user.getWallet_balance();
                email = user.getEmail();
              }
            }
            double available_balance = balance - price;
            if(available_balance < 0)
            {
              JOptionPane.showMessageDialog(this, "The available wallet balance is less than the amount \nthat you're trying to transfer.", "Alert", JOptionPane.WARNING_MESSAGE);
              return;
            }
            int res = MovieBookingDirectory.seatFilled(Integer.parseInt(screenId), seatNumber);
            if(res > 0)
            {
               JOptionPane.showMessageDialog(this, "Someone had already booked the seat, please book another seat.", "Alert", JOptionPane.WARNING_MESSAGE);
               return;
            }
            User user = new User(userId, "", "", 0, "", balance);           
            Screen screen = new Screen(Integer.parseInt(screenId), null, null, null, null, 0);
            MovieBooking mb = new MovieBooking(0, user, screen, seatNumber, null);
            int res1 = MovieBookingDirectory.addMovieBooking(mb);
            if(res1 > 0)
            {
               JOptionPane.showMessageDialog(this, "Booked the ticket successfully.", null, JOptionPane.OK_OPTION);
               int res2 = UserDirectory.updateBalance(userId, available_balance);
               if(res2 > 0)
               {
                 balanceLabel.setText("$ " + available_balance);
                 String message = "****************************\n";
                 message += "**********Movie TICKET*********\n";
                 message += "*****************************\n";
                 message += "City: " + city + "\n";
                 message += "Theatre: " + theatre + "\n";
                 message += "Screen: " + screenId + "\n";
                 message += "Movie: " + movie + "\n";
                 message += "Date: " + date + "\n";
                 message += "Time: " + time + "\n";
                 message += "Price: " + price + "\n";
                 message += "seat: " + seatNumber + "\n"; 
                 message += "**********^^^^^^^^^**********\n";
                 message += "******Thank You Come Again!!******\n";
                 Mail.sendMail(email, message);
               }
            }
        }
        catch(NullPointerException np)
        {
           JOptionPane.showMessageDialog(this, "Please fill all the necessary fields.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bookTicketButtonActionPerformed

    private void movieIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieIdFieldActionPerformed

    private void showHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showHistoryButtonActionPerformed
        // TODO add your handling code here:        
        MovieBookingDirectory mbd = new MovieBookingDirectory();
        DefaultTableModel table_model = (DefaultTableModel)bookingHistoryTable.getModel();
        table_model.setRowCount(0);
        for(MovieBooking mb : mbd.getMovieBookingList())
        {
          if(mb.getUser().getUserName().equals(userNameLabel.getText()))
          {
            String bookingId = String.valueOf(mb.getId());
            String screenId = String.valueOf(mb.getScreen().getId());
            String theatreName = mb.getScreen().getTheatre().getTheatreName();
            String cityName = mb.getScreen().getTheatre().getCity().getCityName();
            String movieName = mb.getScreen().getMovie().getMovieName();
            String showDate = mb.getScreen().getMovieDate().toString();
            String showTime = mb.getScreen().getMovieTime().toString();
            String seatNumber = String.valueOf(mb.getSeatNumber());            
            String bookingDate = mb.getBookinDate().toString();
            String price = String.valueOf(mb.getScreen().getPrice());
            String table_data[]={bookingId, screenId, theatreName, cityName, movieName, showDate, showTime, seatNumber, bookingDate, price};
            table_model.addRow(table_data);
          }          
        }
    }//GEN-LAST:event_showHistoryButtonActionPerformed
    public boolean clientSideValidation(JFrame frame, String bookingId) {
        if (Pattern.compile("^[1-9]\\d*$").matcher(bookingId).matches()) 
        {
            return true;
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Booking Id is not valid.\nOnly numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    private void cancelBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingButtonActionPerformed
        // TODO add your handling code here:
        String movieBookingID = movieIdField.getText().trim();
        boolean passed = clientSideValidation(this, movieBookingID);
        if (passed)
        {
            UserDirectory ud = new UserDirectory();
            int userId = 0;
            String email = "";
            double balance = 0;
            for(User user: ud.getUserList())
            {
              if(user.getUserName().equals(userNameLabel.getText()))
              {
                userId = user.getId();
                email = user.getEmail();
                balance = user.getWallet_balance();
                break;
              }
            }
            double price = 0;
            LocalDate movieDate = null;
            boolean exists = false;
            MovieBookingDirectory mbd = new MovieBookingDirectory();
            for(MovieBooking mb: mbd.getMovieBookingList())
            {
              if(mb.getUser().getId() == userId && mb.getId() == Integer.parseInt(movieBookingID))
              {
                exists = true;
                price = mb.getScreen().getPrice();
                movieDate = mb.getScreen().getMovieDate();
                break;
              }
            }
            if(!exists)
            {
               JOptionPane.showMessageDialog(this, "You don't have a movie ticket booking with the given id.", "Alert", JOptionPane.WARNING_MESSAGE);
               return;
            }
            double available_balance = balance + price;
            if(movieDate.isAfter(LocalDate.now()))
            {
              int res = MovieBookingDirectory.deleteMovieBooking(Integer.parseInt(movieBookingID));
              if(res > 0)
              {
                int res1 = UserDirectory.updateBalance(userId, available_balance);
                if(res1 > 0)
                {
                    JOptionPane.showMessageDialog(this, "Cancelled the movie ticket successfully.", null, JOptionPane.OK_OPTION);                    
                    balanceLabel.setText("$ " + available_balance);
                    Mail.sendMail(email, "You have cancelled your movie ticket with the Id: " + movieBookingID + "\nRefund has been added to your wallet balance.");
                }
              }
            }
            else
              JOptionPane.showMessageDialog(this, "You can't cancel the ticket now.", "Alert", JOptionPane.WARNING_MESSAGE);  
        }
    }//GEN-LAST:event_cancelBookingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BookMovieTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookMovieTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookMovieTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookMovieTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookMovieTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookTicketButton;
    private javax.swing.JTable bookingHistoryTable;
    private javax.swing.JButton cancelBookingButton;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mL;
    private javax.swing.JComboBox<String> movieComboBox;
    private javax.swing.JTextField movieIdField;
    private javax.swing.JLabel nL;
    private javax.swing.JTextField priceField;
    private javax.swing.JComboBox<String> screensComboBox;
    private javax.swing.JComboBox<String> seatComboBox;
    private javax.swing.JButton showHistoryButton;
    private javax.swing.JComboBox<String> theatresComboBox;
    private javax.swing.JComboBox<String> timeComboBox;
    // End of variables declaration//GEN-END:variables

}
