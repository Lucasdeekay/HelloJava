package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class Registration extends JFrame implements ActionListener
{
    JLabel title, full_name, email, phone_no, age, height, address, city, state, country;
    JTextField full_name_text = new JTextField();
    JTextField email_text = new JTextField();
    JTextField phone_no_text = new JTextField();
    JTextField age_text = new JTextField();
    JTextField height_text = new JTextField();
    JTextField address_text = new JTextField();
    JTextField city_text = new JTextField();
    JTextField state_text = new JTextField();
    JTextField country_text = new JTextField();
    JButton  btn = new JButton("Submit");

    Registration()
    {
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My Information System");

        title = new JLabel("Employee Registration Form");
        title.setForeground(Color.blue);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        full_name = new JLabel("Full Name:");
        email = new JLabel("Email:");
        phone_no = new JLabel("Phone No:");
        age = new JLabel("Age:");
        height = new JLabel("Height:");
        address = new JLabel("Address:");
        city = new JLabel("City:");
        state = new JLabel("State:");
        country = new JLabel("Country:");

        btn.addActionListener(this);

        title.setBounds(100, 30, 400, 30);
        full_name.setBounds(80, 70, 200, 30);
        email.setBounds(80, 110, 200, 30);
        phone_no.setBounds(80, 150, 200, 30);
        age.setBounds(80, 190, 200, 30);
        height.setBounds(80, 230, 200, 30);
        address.setBounds(80, 270, 200, 30);
        city.setBounds(80, 310, 200, 30);
        state.setBounds(80, 350, 200, 30);
        country.setBounds(80, 390, 200, 30);
        full_name_text.setBounds(300, 70, 200, 30);
        email_text.setBounds(300, 110, 200, 30);
        phone_no_text.setBounds(300, 150, 200, 30);
        age_text.setBounds(300, 190, 200, 30);
        height_text.setBounds(300, 230, 200, 30);
        address_text.setBounds(300, 270, 200, 30);
        city_text.setBounds(300, 310, 200, 30);
        state_text.setBounds(300, 350, 200, 30);
        country_text.setBounds(300, 390, 200, 30);
        btn.setBounds(200, 430, 100, 30);

        add(title);
        add(full_name);
        add(email);
        add(phone_no);
        add(age);
        add(height);
        add(address);
        add(city);
        add(state);
        add(country);
        add(full_name_text);
        add(email_text);
        add(phone_no_text);
        add(age_text);
        add(height_text);
        add(address_text);
        add(city_text);
        add(state_text);
        add(country_text);
        add(btn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {

            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");

                PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");

                preparedStatement.setString(1, phone_no_text.getText());
                preparedStatement.setString(2, full_name_text.getText());
                preparedStatement.setString(3, email_text.getText());
                preparedStatement.setString(4, age_text.getText());
                preparedStatement.setString(5, height_text.getText());
                preparedStatement.setString(6, address_text.getText());
                preparedStatement.setString(7, city_text.getText());
                preparedStatement.setString(8, state_text.getText());
                preparedStatement.setString(9, country_text.getText());

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "True", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);

                phone_no_text.setText("");
                full_name_text.setText("");
                age_text.setText("");
                height_text.setText("");
                address_text.setText("");
                city_text.setText("");
                state_text.setText("");
                country_text.setText("");
                email_text.setText("");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

public class Employee {
    public static void main(String[] args) {
        new Registration();
    }
}
