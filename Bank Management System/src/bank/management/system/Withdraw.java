
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, clear, exit, back;
    String pin;
    
    Withdraw(String pin) {
        
        this.pin = pin;
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("Withdraw Cash");
        setSize(850, 700);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i = ii.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon ii1 = new ImageIcon(i);
        JLabel image = new JLabel(ii1);
        image.setBounds(0,0, 850, 700);
        add(image);
        
        JLabel l1 = new JLabel("ENTER AMOUNT TO WITHDRAW");
        l1.setFont(new Font("times new", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(140,250,300,30);
        image.add(l1);
        
        amount = new JTextField();
        amount.setBackground(Color.decode("#2D5999"));
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("times new", Font.BOLD, 14));
        amount.setBounds(130,298,250,20);
        amount.addActionListener(this);
        image.add(amount);
        
        withdraw = new JButton("withdraw");
        withdraw.setBackground(Color.decode("#2D5999"));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("times new", Font.BOLD, 12));
        withdraw.setBounds(280,333,140,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        clear = new JButton("clear");
        clear.setBackground(Color.decode("#2D5999"));
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("times new", Font.BOLD, 12));
        clear.setBounds(280,368,140,20);
        clear.addActionListener(this);
        image.add(clear);
        
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
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource() == withdraw) {
        
            String amountValue = amount.getText();
            Date date = new Date();
            if(amountValue.equals("")) {
                JOptionPane.showMessageDialog(null, "please enter some amount to withdraw");
            } else {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()) {
                        if(rs.getString("type").equals("deposit")) 
                            balance += Integer.parseInt(rs.getString("amount"));
                        else if(rs.getString("type").equals("withdraw"))  
                            balance -= Integer.parseInt(rs.getString("amount"));
                    }

                    if(balance < Integer.parseInt(amountValue))
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    else {
                        String query = "insert into bank values('"+pin+"', '"+date+"', 'withdraw', '"+amountValue+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "rupees "+amountValue+" withdrawn successfully!");
                        setVisible(false);
                        new Transactions(pin);
                    }
                    
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
            
        } else if(ae.getSource() == clear) {
            amount.setText("");
        } else if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin);
        }
    }
    
    
    public static void main(String[] args) {
        new Withdraw("");
    }
    
}

