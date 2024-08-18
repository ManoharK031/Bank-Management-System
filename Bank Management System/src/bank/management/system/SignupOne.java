
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    
    int rand;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField;
    JTextField cityTextField, stateTextField, pincodeTextField;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;
    JButton cancel, next;
    
    SignupOne() {
        
        Random ran = new Random();
        rand = Math.abs(ran.nextInt() % 1000);
        
        setLayout(null);
        //setUndecorated(true);
        setTitle("APPLICATION FORM: PAGE 1");
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 700);
        setLocation(250, 10);
        setVisible(true);
        
        JLabel formno = new JLabel("APPLICATION FORM - " + rand);
        formno.setFont(new Font("times new", Font.BOLD, 38));
        formno.setBounds(150,20,500,40);
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("times new", Font.BOLD, 24));
        personaldetails.setBounds(250,80,500,30);
        add(personaldetails);
        
        JLabel name = new JLabel("name:");
        name.setFont(new Font("times new", Font.ITALIC, 16));
        name.setBounds(150,140,200,20);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("times new", Font.ITALIC, 16));
        nameTextField.setBounds(350,140,300,20);
        add(nameTextField);
        
        JLabel fname = new JLabel("father's name:");
        fname.setFont(new Font("times new", Font.ITALIC, 16));
        fname.setBounds(150,180,200,20);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("times new", Font.ITALIC, 16));
        fnameTextField.setBounds(350,180,300,20);
        add(fnameTextField);
        
        JLabel dob = new JLabel("date of birth:");
        dob.setFont(new Font("times new", Font.ITALIC, 16));
        dob.setBounds(150,220,200,20);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("times new", Font.ITALIC, 12));
        dateChooser.setBounds(350, 220, 300, 20);
        dateChooser.setForeground(Color.YELLOW);
        add(dateChooser);
        
        JLabel gender = new JLabel("gender:");
        gender.setFont(new Font("times new", Font.ITALIC, 16));
        gender.setBounds(150,260,200,20);
        add(gender);
        
        male = new JRadioButton("male");
        male.setBackground(Color.WHITE);
        male.setFont(new Font("times new", Font.ITALIC, 16));
        male.setBounds(350, 260, 100, 20);
        add(male);
        
        female = new JRadioButton("female");
        female.setBackground(Color.WHITE);
        female.setFont(new Font("times new", Font.ITALIC, 16));
        female.setBounds(450, 260, 100, 20);
        add(female);
        
        others = new JRadioButton("others");
        others.setBackground(Color.WHITE);
        others.setFont(new Font("times new", Font.ITALIC, 16));
        others.setBounds(550, 260, 100, 20);
        add(others);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);
        
        JLabel email = new JLabel("email address:");
        email.setFont(new Font("times new", Font.ITALIC, 16));
        email.setBounds(150,300,200,20);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("times new", Font.ITALIC, 16));
        emailTextField.setBounds(350,300,300,20);
        add(emailTextField);
        
        JLabel marital = new JLabel("marital status:");
        marital.setFont(new Font("times new", Font.ITALIC, 16));
        marital.setBounds(150,340,200,20);
        add(marital);
        
        married = new JRadioButton("married");
        married.setBackground(Color.WHITE);
        married.setFont(new Font("times new", Font.ITALIC, 16));
        married.setBounds(350, 340, 100, 20);
        add(married);
        
        unmarried = new JRadioButton("unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("times new", Font.ITALIC, 16));
        unmarried.setBounds(450, 340, 100, 20);
        add(unmarried);
        
        ButtonGroup marriageGroup = new ButtonGroup();
        marriageGroup.add(married);
        marriageGroup.add(unmarried);
        
        JLabel address = new JLabel("address:");
        address.setFont(new Font("times new", Font.ITALIC, 16));
        address.setBounds(150,380,200,20);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("times new", Font.ITALIC, 16));
        addressTextField.setBounds(350,380,300,20);
        add(addressTextField);
        
        JLabel city = new JLabel("city:");
        city.setFont(new Font("times new", Font.ITALIC, 16));
        city.setBounds(150,420,200,20);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("times new", Font.ITALIC, 16));
        cityTextField.setBounds(350,420,300,20);
        add(cityTextField);
        
        JLabel state = new JLabel("state:");
        state.setFont(new Font("times new", Font.ITALIC, 16));
        state.setBounds(150,460,200,20);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("times new", Font.ITALIC, 16));
        stateTextField.setBounds(350,460,300,20);
        add(stateTextField);
        
        JLabel pincode = new JLabel("pincode:");
        pincode.setFont(new Font("times new", Font.ITALIC, 16));
        pincode.setBounds(150,500,200,20);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("times new", Font.ITALIC, 16));
        pincodeTextField.setBounds(350,500,300,20);
        add(pincodeTextField);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("new times", Font.BOLD, 24));
        cancel.setBounds(150, 540, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        next = new JButton("NEXT");
        next.setFont(new Font("times new", Font.BOLD, 24));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(550, 540, 150, 30);
        next.addActionListener(this);
        add(next);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == next) {
            String formno, name, fname, dob, gender = null, email, marital_status = null, address, city, state, pincode;

            formno = "" + rand;
            name = nameTextField.getText();
            fname = fnameTextField.getText();
            dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

            if(male.isSelected()) 
                gender = "male";
            else if(female.isSelected())
                gender = "female";
            else if(others.isSelected())
                gender = "others";

            email = emailTextField.getText();

            if(married.isSelected())
                marital_status = "married";
            else if(unmarried.isSelected())
                marital_status = "unmarried";

            address = addressTextField.getText();
            city = cityTextField.getText();
            state = stateTextField.getText();
            pincode = pincodeTextField.getText();

            try {
                Conn c = new Conn();
                //String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital_status+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')"; 
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno);

            } catch (Exception e ) {
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
    
}
