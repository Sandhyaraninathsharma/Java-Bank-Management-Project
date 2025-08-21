package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainClass extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    mainClass(String pin){
        this.pin=pin;

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(410,274,150,35);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(700,274,150,35);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(410,362,150,35);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(700,362,150,35);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);

        }else if (e.getSource()==b2) {
            new withdraw(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new mainClass("");
    }
}
