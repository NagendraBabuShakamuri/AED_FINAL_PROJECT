/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.BankAccountDirectory;
import business.BusBookingDirectory;
import business.EventBookingDirectory;
import business.MobileActivePlans;
import business.MovieBookingDirectory;
import business.TrainBookingDirectory;
import business.UserDirectory;
import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import static userinterface.UserHomePage.userNameLabel;

/**
 *
 * @author nbabu
 */
public class SpendAnalytics extends javax.swing.JFrame {

    /**
     * Creates new form spendAnalytics
     */
    public SpendAnalytics() {
        initComponents();
        DefaultPieDataset pieDataSet = new DefaultPieDataset();                       
        try
        {
          MySql.createConn();
          ResultSet rs = UserDirectory.getUserId(userNameLabel.getText());
          rs.next();
          int userId = rs.getInt(1);
          rs = BusBookingDirectory.getBusBookings(userId);
          rs.next();
          DefaultTableModel table_model = (DefaultTableModel)spendTable.getModel();
          double sum = 0;
          while(rs.next())
          {
            int busId = rs.getInt(3);
            String date = rs.getString(5);
            ResultSet rs1 = BusBookingDirectory.getFare(busId);
            rs1.next();
            double fare = rs1.getDouble(1);
            sum += fare;
            table_model.addRow(new String[]{date, "Bus Booking", "$ " + fare});            
          }
          pieDataSet.setValue("Bus Booking", sum);
          sum = 0;          
          rs = TrainBookingDirectory.getTrainBookings(userId);
          while(rs.next())
          {
            String date = rs.getString(4);
            double fare = rs.getDouble(7);
            sum += fare;
            table_model.addRow(new String[]{date, "Train Booking", "$ " + fare});
          }
          pieDataSet.setValue("Train Booking", sum);
          sum = 0;
          rs = EventBookingDirectory.getEventBookings(userId);
          while(rs.next())
          {
            int eventId = rs.getInt(3);
            String date = rs.getString(5);            
            ResultSet rs1 = EventBookingDirectory.getPrice(eventId);
            rs1.next();
            double price = rs1.getDouble(1);
            sum += price;
            table_model.addRow(new String[]{date, "Event Booking", "$ " + price});            
          }
          pieDataSet.setValue("Event Booking", sum);
          sum = 0;
          rs = MobileActivePlans.getMobileActivePlans(userId);
          while(rs.next())
          {
            int planId = rs.getInt(4);
            String date = rs.getString(6);
            ResultSet rs1 = MobileActivePlans.getPrice(planId);
            rs1.next();
            double price = rs1.getDouble(1);
            sum += price;
            table_model.addRow(new String[]{date, "Mobile Recharge", "$ " + price}); 
          }
          pieDataSet.setValue("Mobile Recharge", sum);
          sum = 0;
          rs = MovieBookingDirectory.getMovieBookings(userId);
          while(rs.next())
          {
            int screenId = rs.getInt(3);
            String date = rs.getString(5);
            ResultSet rs1 = MovieBookingDirectory.getPrice(screenId);
            rs1.next();
            double price = rs1.getDouble(1);
            sum += price;
            table_model.addRow(new String[]{date, "Movie Booking", "$ " + price});
          }
          pieDataSet.setValue("Movie Booking", sum);
          sum = 0;
          rs = BankAccountDirectory.getMoneyTransfers(userNameLabel.getText());
          while(rs.next())
          {
            double amount = rs.getDouble(1);
            String date = rs.getString(2);
            sum += amount;
            table_model.addRow(new String[]{date, "Friends & Family", "$ " + amount});
          }          
          pieDataSet.setValue("Friends & Family", sum);
          sum = 0;
          rs = UserDirectory.getUtilityTransactions(userNameLabel.getText());
          while(rs.next())
          {
            double amount = rs.getDouble(5);
            String date = rs.getString(4);
            sum += amount;
            table_model.addRow(new String[]{date, "Utility", "$ " + amount});
          }
          pieDataSet.setValue("Utilities", sum);
          spendTable.setAutoCreateRowSorter(true);
          JFreeChart chart = ChartFactory.createPieChart("Pie chart", pieDataSet);
          ChartPanel panel = new ChartPanel(chart, 500, 400, 500, 400, 500, 400, true, true, true, true, false, true);
          panel.setSize(600, 500);
          chartArea.add(panel);
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

        chartArea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        spendTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(chartArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 490));

        spendTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Category", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(spendTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 540, 710, 270));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Spending Transactions");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SpendAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpendAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpendAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpendAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpendAnalytics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel chartArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable spendTable;
    // End of variables declaration//GEN-END:variables
}
