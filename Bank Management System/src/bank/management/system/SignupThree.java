
package bank.management.system;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingRB, fdRB, currentRB, recurringRB;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, declare;
    JButton cancel, home, submit;
    String formno;
    SignupThree(String formno) {
        
        this.formno = formno;
        setLayout(null);
        setTitle("APPLICATION FORM: PAGE 3");
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 700);
        setLocation(250,0);
        setVisible(true);
        
        JLabel accdetails = new JLabel("Page 3: Account Details");
        accdetails.setFont(new Font("times new", Font.BOLD, 24));
        accdetails.setBounds(250,40,500,30);
        add(accdetails);
        
        JLabel acctypeLabel = new JLabel("Account Type:");
        acctypeLabel.setFont(new Font("times new", Font.ITALIC, 20));
        acctypeLabel.setBounds(150, 100, 200, 20);
        add(acctypeLabel);
        
        savingRB = new JRadioButton("Savings ");
        savingRB.setBackground(Color.WHITE);
        savingRB.setFont(new Font("times new", Font.ITALIC, 14));
        savingRB.setBounds(150, 140, 150, 20);
        add(savingRB);
        
        fdRB = new JRadioButton("Fixed Deposit ");
        fdRB.setBackground(Color.WHITE);
        fdRB.setFont(new Font("times new", Font.ITALIC, 14));
        fdRB.setBounds(300, 140, 150, 20);
        add(fdRB);
        
        currentRB = new JRadioButton("Current ");
        currentRB.setBackground(Color.WHITE);
        currentRB.setFont(new Font("times new", Font.ITALIC, 14));
        currentRB.setBounds(450, 140, 150, 20);
        add(currentRB);
        
        recurringRB = new JRadioButton("Recurring ");
        recurringRB.setBackground(Color.WHITE);
        recurringRB.setFont(new Font("times new", Font.ITALIC, 14));
        recurringRB.setBounds(600, 140, 150, 20);
        add(recurringRB);
        
        ButtonGroup acctypeGrp = new ButtonGroup();
        acctypeGrp.add(savingRB);
        acctypeGrp.add(fdRB);
        acctypeGrp.add(currentRB);
        acctypeGrp.add(recurringRB);
        
        JLabel cardnoLabel = new JLabel("Card Number:");
        cardnoLabel.setFont(new Font("times new", Font.ITALIC, 20));
        cardnoLabel.setBounds(150, 200, 200, 20);
        add(cardnoLabel);
        
        JLabel cardValLabel = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardValLabel.setFont(new Font("times new", Font.BOLD, 16));
        cardValLabel.setBounds(350, 200, 200, 20);
        add(cardValLabel);
        
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("times new", Font.ITALIC, 20));
        pinLabel.setBounds(150, 260, 200, 20);
        add(pinLabel);
        
        JLabel pinValLabel = new JLabel("XXXX");
        pinValLabel.setFont(new Font("times new", Font.BOLD, 16));
        pinValLabel.setBounds(350, 260, 200, 20);
        add(pinValLabel);
        
        JLabel servicesLabel = new JLabel("Services Required:");
        servicesLabel.setFont(new Font("times new", Font.ITALIC, 20));
        servicesLabel.setBounds(150, 320, 200, 20);
        add(servicesLabel);
        
        cb1 = new JCheckBox("Debit Card");
        cb1.setFont(new Font("times new", Font.ITALIC, 16));
        cb1.setBounds(150, 360, 200, 20);
        cb1.setBackground(Color.WHITE);
        add(cb1);
        
        cb2 = new JCheckBox("Cheque Book");
        cb2.setFont(new Font("times new", Font.ITALIC, 16));
        cb2.setBounds(350, 360, 200, 20);
        cb2.setBackground(Color.WHITE);
        add(cb2);
        
        cb3 = new JCheckBox("SMS & e-mail alerts");
        cb3.setFont(new Font("times new", Font.ITALIC, 16));
        cb3.setBounds(550, 360, 200, 20);
        cb3.setBackground(Color.WHITE);
        add(cb3);
        
        cb4 = new JCheckBox("NetBanking");
        cb4.setFont(new Font("times new", Font.ITALIC, 16));
        cb4.setBounds(150, 420, 200, 20);
        cb4.setBackground(Color.WHITE);
        add(cb4);
        
        cb5 = new JCheckBox("Mobile Banking");
        cb5.setFont(new Font("times new", Font.ITALIC, 16));
        cb5.setBounds(350, 420, 200, 20);
        cb5.setBackground(Color.WHITE);
        add(cb5);
        
        cb6 = new JCheckBox("e-statement");
        cb6.setFont(new Font("times new", Font.ITALIC, 16));
        cb6.setBounds(550, 420, 200, 20);
        cb6.setBackground(Color.WHITE);
        add(cb6);
        
        declare = new JCheckBox("I hereby declare that the above entered details are correct.");
        declare.setFont(new Font("times new", Font.BOLD, 20));
        declare.setBounds(150, 500, 600, 20);
        declare.setBackground(Color.WHITE);
        add(declare);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("new times", Font.BOLD, 24));
        cancel.setBounds(150, 550, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("new times", Font.BOLD, 24));
        submit.setBounds(550, 550, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)  {
    
        String accType = "", cardno = "", pinno = "", services = "";
        
        
        if(ae.getSource() == cancel) {
            setVisible(false);
            new Login();
            
        } else if(ae.getSource() == submit) {
            
            if(savingRB.isSelected()) {
                accType = "saving account";
            } else if(fdRB.isSelected()) {
                accType = "fixed deposit account";
            } else if(currentRB.isSelected()) {
                accType = "current account";
            } else if(recurringRB.isSelected()) {
                accType = "recurring account";
            }
            
            Random random = new Random();
            cardno = "" + Math.abs(random.nextLong() % 90000000L + 3579000000000000L);
            pinno = "" + Math.abs(random.nextLong() % 9000L + 1000L);
            
            if(cb1.isSelected()) {
                services += " Debit Card";
            } else if(cb2.isSelected()) {
                services += " Cheque Book";
            } else if(cb3.isSelected()) {
                services += " SMS & e-mail alerts";
            } else if(cb4.isSelected()) {
                services += " NetBanking";
            } else if(cb5.isSelected()) {
                services += " Mobile Banking";
            } else if(cb6.isSelected()) {
                services += " e-statement";
            } 
        
            try {
                if(accType.equals("")) {
                    JOptionPane.showMessageDialog(null, "please enter account type");
                } else if(declare.isSelected()) {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accType+"', '"+cardno+"', '"+pinno+"', '"+services+"')";
                    c.s.executeUpdate(query1);

                    String query2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pinno+"')";
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Your Credentials are\ncard number: " + cardno + "\nPIN: " + pinno);
                    setVisible(false);
                    new Login();
                    
                }

            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }

}
