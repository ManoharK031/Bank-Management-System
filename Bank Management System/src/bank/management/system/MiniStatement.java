
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    MiniStatement(String pin) {
        
        this.pin = pin;
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("Mini Statement");
        setSize(500, 600);
        setLocation(400, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        JLabel bank = new JLabel("GENERAL BANK OF INDIA");
        bank.setFont(new Font("times new ", Font.BOLD, 20));
        bank.setBounds(100, 40, 250, 30);
        add(bank);
        
        JLabel cardLabel = new JLabel("CARD NUMBER: ");
        cardLabel.setFont(new Font("times new ", Font.BOLD, 16));
        cardLabel.setBounds(50, 90, 150, 20);
        add(cardLabel);
        
        JLabel cardno = new JLabel();
        cardno.setFont(new Font("times new ", Font.BOLD, 16));
        cardno.setBounds(200, 90, 200, 20);
        add(cardno);
        
        JLabel trans = new JLabel("TRANSACTIONS:");
        trans.setFont(new Font("times new ", Font.BOLD, 16));
        trans.setBounds(50, 130, 200, 20);
        add(trans);
        
        JLabel statement = new JLabel();
        statement.setBounds(50, 160, 400, 200);
        add(statement);
        
        JLabel balance = new JLabel();
        balance.setFont(new Font("times new ", Font.BOLD, 16));
        balance.setBounds(50, 500, 300, 20);
        add(balance);
        
        JButton cancel = new JButton("cancel");
        cancel.setFont(new Font("times new ", Font.BOLD, 16));
        cancel.setBackground(Color.decode("#2D5999"));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 500, 120, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '"+pin+"'");
            while(rs.next()) {
                cardno.setText(rs.getString("card_number").substring(0,4) + "-XXXX-XXXX-" + rs.getString("card_number").substring(12));
            }
            
            ResultSet msrs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(msrs.next()) {
                  statement.setText(statement.getText() + "<html>" + msrs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msrs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msrs.getString("amount") + "<br><br><html>");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn c = new Conn();
            ResultSet msrs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balanceRemaining = 0;
            while(msrs.next()) {
                if(msrs.getString("type").equals("deposit")) 
                    balanceRemaining += Integer.parseInt(msrs.getString("amount"));
                else if(msrs.getString("type").equals("withdraw"))  
                    balanceRemaining -= Integer.parseInt(msrs.getString("amount"));
            }
            balance.setText("your available balance is ₹ " + balanceRemaining + " /-");
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
    }
    
    public static void main(String[] args) {
        
        new MiniStatement("");
    }
    
}
