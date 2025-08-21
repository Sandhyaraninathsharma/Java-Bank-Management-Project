package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton button1, button2, button3;
    JTextField field1;
    JPasswordField field2;

    Login() {
        super("Bank Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("welcome to ATM");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        JLabel label2 = new JLabel("enter card no:");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setBounds(150, 190, 300, 40);
        add(label2);

        field1 = new JTextField(15);
        field1.setBounds(325, 190, 230, 30);
        field1.setFont(new Font("Arial", Font.BOLD, 14));
        add(field1);

        JLabel label3 = new JLabel("PIN:");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setBounds(150, 250, 300, 40);
        add(label3);

        field2 = new JPasswordField(15);
        field2.setBounds(325, 250, 230, 30);
        field2.setFont(new Font("Arial", Font.BOLD, 14));
        add(field2);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300, 350, 230, 30);
        button3.addActionListener(this);
        add(button3);


        setLayout(null);
        setSize(800, 500);
        setLocation(450, 250);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                Conn c = new Conn();
                String cardno = field1.getText();
                String pin = field2.getText();
                String q = "select * from login where card_no= '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new mainClass(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }


            }else if (e.getSource() == button2){
                field1.setText("");
                field2.setText("");
            }else if (e.getSource() == button3){
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}