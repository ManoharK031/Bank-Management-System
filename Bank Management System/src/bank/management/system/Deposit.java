
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, clear, exit, back;
    String pin;
    Deposit(String pin) {
        
        this.pin = pin;
        setLayout(null);
        //setUndecorated(true);
        setTitle("Deposit Cash");
        setSize(850, 700);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i = ii.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon ii1 = new ImageIcon(i);
        JLabel image = new JLabel(ii1);
        image.setBounds(0,0, 850, 700);
        add(image);
        
        JLabel l1 = new JLabel("ENTER AMOUNT TO DEPOSIT");
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
        
        deposit = new JButton("deposit");
        deposit.setBackground(Color.decode("#2D5999"));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("times new", Font.BOLD, 12));
        deposit.setBounds(280,333,140,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
    
        if(ae.getSource() == deposit) {
        
            String amountValue = amount.getText();
            Date date = new Date();
            if(amountValue.equals("")) {
                JOptionPane.showMessageDialog(null, "please enter some amount to deposit");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pin+"', '"+date+"', 'deposit', '"+amountValue+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "rupees "+amountValue+" deposited successfully!");
                    setVisible(false);
                    new Transactions(pin);
                    
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
        new Deposit("");
    }
    
}
