                
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton signin, clear, signup, exit;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        setTitle("Login");
        setLayout(null);
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setLocation(200,200);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120,120 ,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(70,30,120,120);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO");
        text.setFont(new Font("Oswald", Font.BOLD,27));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel text1 = new JLabel("BANK MANAGEMENT SYSTEM");
        text1.setFont(new Font("Oswald", Font.BOLD,33));
        text1.setBounds(200,80,500,40);
        add(text1);
        
        JLabel cardno = new JLabel("card no:");
        cardno.setFont(new Font("Oswald", Font.BOLD,28));
        cardno.setBounds(120,150,200,40 );
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("times new" , Font.BOLD, 16));
        cardTextField.setBounds(250,150,250,40);
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Oswald", Font.BOLD,28));
        pin.setBounds(120,220,100,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        cardTextField.setFont(new Font("times new" , Font.BOLD, 16));
        pinTextField.setBounds(250,220,250,40);
        add(pinTextField);
        
        signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setBounds(250, 300, 120, 40);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(400, 300, 120, 40);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("NEW A/C");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(250, 350, 120, 40);
        signup.addActionListener(this);
        add(signup);
        
        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(400, 350, 120, 40);
        exit.addActionListener(this);
        add(exit);
        
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == signin) {
            Conn c = new Conn();
            String cardno = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from login where card_number = '"+cardno+"' and pin_number = '"+pin+"'";
            if(cardno.equals("") && pin.equals(""))
                JOptionPane.showMessageDialog(null, "please enter the card number and PIN!");
            else if(cardno.equals(""))
                JOptionPane.showMessageDialog(null, "please enter the card number!");
            else if(pin.equals(""))
                JOptionPane.showMessageDialog(null, "please enter the PIN!");
            
            if(!cardno.equals("") && !pin.equals("")) {
                try {
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()) {
                        setVisible(false);
                        new Transactions(pin);
                    } else {
                        JOptionPane.showMessageDialog(null, "invalid card number or PIN");
                    }

                } catch(Exception e) {
                    System.out.println(e);
                }
            }
            
        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne();
        }
        
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
