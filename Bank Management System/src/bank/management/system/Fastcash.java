
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener{

    JButton l1, l2, l3, l4, l5, l6, exit, back;
    String pin;
    
    Fastcash(String pin) {
        
        this.pin = pin;
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("Fast Cash");
        setSize(850, 700);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i = ii.getImage().getScaledInstance(850, 700,Image.SCALE_DEFAULT);
        ImageIcon ii1 = new ImageIcon(i);
        JLabel image = new JLabel(ii1);
        image.setBounds(0, 0, 850, 700);
        add(image);
        
        JLabel label = new JLabel("ENTER AMOUNT TO WITHDRAW");
        label.setFont(new Font("times new", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setBounds(140,250,300,30);
        image.add(label);
        
        l1 = new JButton("100");
        l1.setBackground(Color.decode("#2D5999"));
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("times new", Font.BOLD, 12));
        l1.setBounds(130,298,140,20);
        l1.addActionListener(this);
        image.add(l1);
        
        l2 = new JButton("500");
        l2.setBackground(Color.decode("#2D5999"));
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("times new", Font.BOLD, 12));
        l2.setBounds(280,298,140,20);
        l2.addActionListener(this);
        image.add(l2);
        
        l3 = new JButton("1000");
        l3.setBackground(Color.decode("#2D5999"));
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("times new", Font.BOLD, 12));
        l3.setBounds(130,333,140,20);
        l3.addActionListener(this);
        image.add(l3);
        
        l4 = new JButton("2000");
        l4.setBackground(Color.decode("#2D5999"));
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("times new", Font.BOLD, 12));
        l4.setBounds(280,333,140,20);
        l4.addActionListener(this);
        image.add(l4);
        
        l5 = new JButton("5000");
        l5.setBackground(Color.decode("#2D5999"));
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("times new", Font.BOLD, 12));
        l5.setBounds(130,368,140,20);
        l5.addActionListener(this);
        image.add(l5);
        
        l6 = new JButton("10000");
        l6.setBackground(Color.decode("#2D5999"));
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("times new", Font.BOLD, 12));
        l6.setBounds(280,368,140,20);
        l6.addActionListener(this);
        image.add(l6);
        
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
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin);
        } else {
            String amountValue = ((JButton) ae.getSource()).getText();
            Date date = new Date();
            Conn c = new Conn();
            try {
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
    }
    
    public static void main(String[] args) {
    
        new Fastcash("");
    }
    
}
