
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back, exit;
    JLabel balance;
    String pin;
    
    BalanceEnquiry(String pin) {
        
        this.pin = pin;
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("Balance Enquiry");
        setSize(850, 700);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i = ii.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon ii1 = new ImageIcon(i);
        JLabel image = new JLabel(ii1);
        image.setBounds(0, 0, 850, 700);
        add(image);
        
        JLabel l1 = new JLabel("Available Funds");
        l1.setBackground(Color.decode("#2D5999"));
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("times new", Font.BOLD, 22));
        l1.setBounds(130, 250,300,30);
        image.add(l1);
        
        balance = new JLabel();
        balance.setBackground(Color.decode("#2D5999"));
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("times new", Font.BOLD, 24));
        balance.setBounds(130,290,300,30);
        image.add(balance);
        
        exit = new JButton("exit");
        exit.setBackground(Color.decode("#2D5999"));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("times new", Font.BOLD, 12));
        exit.setBounds(130,405,140,20);
        exit.addActionListener(this);
        image.add(exit);
        
        back = new JButton("back");
        back.setBackground(Color.decode("#2D5999"));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("times new", Font.BOLD, 12));
        back.setBounds(280,405,140,20);
        back.addActionListener(this);
        image.add(back);
        
        int balanceRemaining = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()) {
                if(rs.getString("type").equals("deposit")) 
                    balanceRemaining += Integer.parseInt(rs.getString("amount"));
                else if(rs.getString("type").equals("withdraw"))  
                    balanceRemaining -= Integer.parseInt(rs.getString("amount"));
            }
            balance.setText("₹ " + balanceRemaining + " /-");
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin);
        }
    }
    
    public static void main(String[] args) {
       new BalanceEnquiry("");
    }
    
}
