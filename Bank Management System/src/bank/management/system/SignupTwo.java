
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    JComboBox religion_ComboBox, caste_ComboBox, income_ComboBox, qualification_ComboBox, occupation_ComboBox; 
    JTextField panTextField, aadhaarTextField;
    JRadioButton senior_citizen_Yes, senior_citizen_No, existing_acc_Yes, existing_acc_No; 
    JButton cancel, next;
    String formno;
    
    SignupTwo(String formno) {
        
        this.formno = formno;

        setLayout(null);
        setTitle("APPLICATION FORM: PAGE 2");
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 700);
        setLocation(250, 10);
        setVisible(true);
        
      
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("times new", Font.BOLD, 24));
        additionaldetails.setBounds(250,80,500,30);
        add(additionaldetails);
        
        JLabel religion = new JLabel("religion:");
        religion.setFont(new Font("times new", Font.ITALIC, 16));
        religion.setBounds(150,140,200,20);
        add(religion);
        
        String[] religionArr = {"Hindu", "Muslim", "Christian", "Sikh", "Jew", "No Religion"};
        religion_ComboBox = new JComboBox(religionArr);
        religion_ComboBox.setBackground(Color.WHITE);
        religion_ComboBox.setFont(new Font("times new", Font.ITALIC, 14));
        religion_ComboBox.setBounds(350,140,300,20);
        add(religion_ComboBox);
        
        JLabel caste = new JLabel("caste:");
        caste.setFont(new Font("times new", Font.ITALIC, 16));
        caste.setBounds(150,180,200,20);
        add(caste);
        
        String[] casteArr = {"General", "BC", "SC", "ST"};
        caste_ComboBox = new JComboBox(casteArr);
        caste_ComboBox.setBackground(Color.WHITE);
        caste_ComboBox.setFont(new Font("times new", Font.ITALIC, 14));
        caste_ComboBox.setBounds(350,180,300,20);
        add(caste_ComboBox);
        
        JLabel income = new JLabel("income (in rupee):");
        income.setFont(new Font("times new", Font.ITALIC, 16));
        income.setBounds(150,220,200,20);
        add(income);
        
        String[] incomeArr = {"0", "< 1,50,000", "< 4,00,000 ", "< 7,00,000 ", "< 10,00,000 ", "< 15,00,000 "};
        income_ComboBox = new JComboBox(incomeArr);
        income_ComboBox.setBackground(Color.WHITE);
        income_ComboBox.setFont(new Font("times new", Font.ITALIC, 14));
        income_ComboBox.setBounds(350, 220, 300, 20);
        add(income_ComboBox);
        
        JLabel qualification = new JLabel("qualification:");
        qualification.setFont(new Font("times new", Font.ITALIC, 16));
        qualification.setBounds(150,260,200,20);
        add(qualification);
        
        String[] qualificationArr = {"high school", "graduation", "postgraduation", "doctrate ", "other"};
        qualification_ComboBox = new JComboBox(qualificationArr);
        qualification_ComboBox.setBackground(Color.WHITE);
        qualification_ComboBox.setFont(new Font("times new", Font.ITALIC, 14));
        qualification_ComboBox.setBounds(350, 260, 300, 20);
        add(qualification_ComboBox);
        
        JLabel occupation = new JLabel("occupation:");
        occupation.setFont(new Font("times new", Font.ITALIC, 16));
        occupation.setBounds(150,300,200,20);
        add(occupation);
        
        String[] occupationArr = {"salaried employee", "self employed", "business", "student", "not employed", "other"};
        occupation_ComboBox = new JComboBox(occupationArr);
        occupation_ComboBox.setBackground(Color.WHITE);
        occupation_ComboBox.setFont(new Font("times new", Font.ITALIC, 14));
        occupation_ComboBox.setBounds(350, 300, 300, 20);
        add(occupation_ComboBox);
        
        JLabel pan = new JLabel("PAN:");
        pan.setFont(new Font("times new", Font.ITALIC, 16));
        pan.setBounds(150,340,200,20);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("times new", Font.ITALIC, 14));
        panTextField.setBounds(350,340,300,20);
        add(panTextField);
        
        JLabel aadhaar = new JLabel("aadhaar number:");
        aadhaar.setFont(new Font("times new", Font.ITALIC, 16));
        aadhaar.setBounds(150,380,200,20);
        add(aadhaar);
        
        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("times new", Font.ITALIC, 14));
        aadhaarTextField.setBounds(350,380,300,20);
        add(aadhaarTextField);
        
        JLabel senior_citizen = new JLabel("senior citizen:");
        senior_citizen.setFont(new Font("times new", Font.ITALIC, 16));
        senior_citizen.setBounds(150,420,200,20);
        add(senior_citizen);
        
        senior_citizen_Yes = new JRadioButton("yes");
        senior_citizen_Yes.setBackground(Color.WHITE);
        senior_citizen_Yes.setFont(new Font("times new", Font.ITALIC, 14));
        senior_citizen_Yes.setBounds(350, 420, 100, 20);
        add(senior_citizen_Yes);
        
        senior_citizen_No = new JRadioButton("no");
        senior_citizen_No.setBackground(Color.WHITE);
        senior_citizen_No.setFont(new Font("times new", Font.ITALIC, 14));
        senior_citizen_No.setBounds(450, 420, 100, 20);
        add(senior_citizen_No);
        
        ButtonGroup senior_citizen_Group = new ButtonGroup();
        senior_citizen_Group.add(senior_citizen_Yes);
        senior_citizen_Group.add(senior_citizen_No);
        
        
        JLabel existing_acc = new JLabel("existing account:");
        existing_acc.setFont(new Font("times new", Font.ITALIC, 16));
        existing_acc.setBounds(150,460,200,20);
        add(existing_acc);
        
        existing_acc_Yes = new JRadioButton("yes");
        existing_acc_Yes.setBackground(Color.WHITE);
        existing_acc_Yes.setFont(new Font("times new", Font.ITALIC, 14));
        existing_acc_Yes.setBounds(350, 460, 100, 20);
        add(existing_acc_Yes);
        
        existing_acc_No = new JRadioButton("no");
        existing_acc_No.setBackground(Color.WHITE);
        existing_acc_No.setFont(new Font("times new", Font.ITALIC, 14));
        existing_acc_No.setBounds(450, 460, 100, 20);
        add(existing_acc_No);
        
        ButtonGroup existing_acc_Group = new ButtonGroup();
        existing_acc_Group.add(existing_acc_Yes);
        existing_acc_Group.add(existing_acc_No);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("new times", Font.BOLD, 24));
        cancel.setBounds(150, 550, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        next = new JButton("NEXT");
        next.setFont(new Font("times new", Font.BOLD, 24));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(550, 550, 150, 30);
        next.addActionListener(this);
        add(next);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == next) {
            String religion_str, caste_str, income_str, qualification_str, occupation_str, pan_str, aadhaar_str, senior_citizen_str = null, existing_acc_str = null;

            religion_str = (String) religion_ComboBox.getSelectedItem();
            caste_str = (String) caste_ComboBox.getSelectedItem();
            income_str = (String) income_ComboBox.getSelectedItem();
            qualification_str = (String) qualification_ComboBox.getSelectedItem();
            occupation_str = (String) occupation_ComboBox.getSelectedItem();
            pan_str = panTextField.getText();
            aadhaar_str = aadhaarTextField.getText();

            if(senior_citizen_Yes.isSelected()) 
                senior_citizen_str = "yes";
            else if(senior_citizen_No.isSelected())
                senior_citizen_str = "no";

            if(existing_acc_Yes.isSelected())
                existing_acc_str = "yes";
            else if(existing_acc_No.isSelected())
                existing_acc_str = "no";


            try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion_str+"','"+caste_str+"','"+income_str+"','"+qualification_str+"','"+occupation_str+"','"+pan_str+"','"+aadhaar_str+"','"+senior_citizen_str+"','"+existing_acc_str+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno);


            } catch (Exception e ) {
                System.out.println(e);
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login();
        }
        
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    
    
}
