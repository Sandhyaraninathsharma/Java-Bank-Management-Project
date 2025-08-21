package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton b1;
    BalanceEnquiry(String pin){

        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(275,180,400,35);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(275,220,400,35);
        add(label2);


        b1 = new JButton("BACK");
        b1.setBounds(475,362,150,35);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        int balance =0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        getContentPane().setBackground(new Color(98, 255, 192, 23));
        setSize(800,800);
        setLocation(400,20);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new mainClass(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
