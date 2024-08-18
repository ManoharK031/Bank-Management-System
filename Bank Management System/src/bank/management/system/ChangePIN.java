
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ChangePIN extends JFrame implements ActionListener {

    JPasswordField enter, renter;
    JButton change, clear, back, exit;
    String pin;
    
    ChangePIN(String pin) {
       
        this.pin = pin;
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("Change PIN");
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
        
        JLabel label = new JLabel("CHANGE PIN");
        label.setFont(new Font("times new", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setBounds(220, 220,300,30);
        image.add(label);
        
        JLabel l1 = new JLabel("enter new PIN:");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("times new", Font.BOLD, 16));
        l1.setBounds(130,261,140,20);
        image.add(l1);
        
        enter = new JPasswordField();
        enter.setForeground(Color.WHITE);
        enter.setBackground(Color.decode("#2D5999"));
        enter.setFont(new Font("times new", Font.BOLD, 16));
        enter.setBounds(280,261,140,20);
        image.add(enter);
                
        JLabel l2 = new JLabel("re-enter PIN:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("times new", Font.BOLD, 16));
        l2.setBounds(130,298,140,20);
        image.add(l2);
        
        renter = new JPasswordField();
        renter.setForeground(Color.WHITE);
        renter.setBackground(Color.decode("#2D5999"));
        renter.setFont(new Font("times new", Font.BOLD, 16));
        renter.setBounds(280,298,140,20);
        image.add(renter);
        
        change = new JButton("change");
        change.setBackground(Color.decode("#2D5999"));
        change.setForeground(Color.WHITE);
        change.setFont(new Font("times new", Font.BOLD, 12));
        change.setBounds(280,331,140,20);
        change.addActionListener(this);
        image.add(change);
        
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
    
    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource() == exit) 
            System.exit(0);
        else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin);
        } else if(ae.getSource() == clear) {
            enter.setText("");
            renter.setText("");
        } else if(ae.getSource() == change) {
            String npin = enter.getText();
            String rpin = renter.getText();
            if(!npin.equals("") || !rpin.equals("")) {
                if(npin.equals(rpin)) {
                    try {
                        Conn c = new Conn();
                        String query1 = "update signupthree set pin_number = '"+npin+"' where pin_number = '"+pin+"'";
                        String query2 = "update login set pin_number = '"+npin+"' where pin_number = '"+pin+"'";
                        String query3 = "update bank set pin = '"+npin+"' where pin = '"+pin+"'";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        c.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "PIN change successful!");
                        setVisible(false);
                        this.pin = npin;
                        new Transactions(pin);

                    } catch(Exception e) {
                        System.out.println(e);
                    }
                    
                } else
                    JOptionPane.showMessageDialog(null, "Re-entered PIN must be same as New PIN!");
            } else 
                JOptionPane.showMessageDialog(null, "PIN field empty!");
        }
    }
    
    public static void main(String[] args) {
        new ChangePIN("");
    }
    
}
