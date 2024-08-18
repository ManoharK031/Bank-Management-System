
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, withdraw, statement, exit, balance, fastcash, back, pinchange;
    String pin;
    
    Transactions(String pin) {
        this.pin = pin;
        setLayout(null);
        //setUndecorated(true);
        setTitle("ATM");
        setSize(850, 700);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i = ii.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon ii1 = new ImageIcon(i);
        JLabel image = new JLabel(ii1);
        image.setBounds(0, 0, 850, 700);
        add(image);
        
        JLabel text = new JLabel("SELECT YOUR TRANSACTION");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("times new", Font.BOLD, 16));
        text.setBounds(155,250,300,30);
        image.add(text);
        
        deposit = new JButton("deposit");
        deposit.setBackground(Color.decode("#2D5999"));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("times new", Font.BOLD, 12));
        deposit.setBounds(130,298,140,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastcash = new JButton("fast cash");
        fastcash.setBackground(Color.decode("#2D5999"));
        fastcash.setForeground(Color.WHITE);
        fastcash.setFont(new Font("times new", Font.BOLD, 12));
        fastcash.setBounds(280,298,140,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        statement = new JButton("mini statement");
        statement.setBackground(Color.decode("#2D5999"));
        statement.setForeground(Color.WHITE);
        statement.setFont(new Font("times new", Font.BOLD, 12));
        statement.setBounds(130,333,140,20);
        statement.addActionListener(this);
        image.add(statement);
        
        withdraw = new JButton("cash withdrawal");
        withdraw.setBackground(Color.decode("#2D5999"));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("times new", Font.BOLD, 12));
        withdraw.setBounds(280,333,140,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        pinchange = new JButton("PIN change");
        pinchange.setBackground(Color.decode("#2D5999"));
        pinchange.setForeground(Color.WHITE);
        pinchange.setFont(new Font("times new", Font.BOLD, 12));
        pinchange.setBounds(130,368,140,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("balance enquiry");
        balance.setBackground(Color.decode("#2D5999"));
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("times new", Font.BOLD, 12));
        balance.setBounds(280,368,140,20);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("exit");
        exit.setBackground(Color.decode("#2D5999"));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("times new", Font.BOLD, 12));
        exit.setBounds(130,405,140,20);
        exit.addActionListener(this);
        image.add(exit);
   
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin);
        } else if(ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(pin);
        } else if(ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pin);
        } else if(ae.getSource() == pinchange) {
            setVisible(false);
            new ChangePIN(pin);
        } else if(ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pin);
        } else if(ae.getSource() == statement) {
            new MiniStatement(pin);
        }
    }
    
    public static void main(String[] args) {
        
        new Transactions("");
    }
    
}
