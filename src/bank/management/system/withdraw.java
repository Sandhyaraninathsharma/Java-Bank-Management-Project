package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class withdraw extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1, b2;
    withdraw(String pin){
        this.pin = pin;


        JLabel label1 = new JLabel("ENETR AMOUNT TO WITHDRAW");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(275,180,400,35);
        add(label1);

        textField = new TextField();
        textField.setBounds(275,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(475,362,150,35);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(280,362,150,35);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);




        setLayout(null);
        getContentPane().setBackground(new Color(98, 255, 192, 23));
        setSize(800,800);
        setLocation(400,20);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "', 'Withdrawl', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new mainClass(pin);

                }
            } catch (Exception E) {

            }
        }
        else{
            setVisible(false);
            new mainClass(pin);
        }

    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
