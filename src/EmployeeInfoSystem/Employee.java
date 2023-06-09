package EmployeeInfoSystem;

// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class RegistrationForm extends JFrame implements ActionListener {
    final String[] country = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia",
            "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
            "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
            "Cape Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia",
            "Comoros", "Democratic Republic of the Congo", "Republic of the Congo", "Costa Rica", "Cote d’Ivoire", "Croatia", "Cuba",
            "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt",
            "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Swaziland", "Ethiopia", "Fiji", "Finland", "France", "Gabon",
            "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan",
            "Jordan","Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos",
            "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia",
            "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Federated States of Micronesia",
            "Moldova", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands",
            "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Panama",
            "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe",
            "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
            "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "South Sudan", "Suriname", "Sweden", "Switzerland", "Syria",
            "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
            "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan",
            "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};

    final String[] states = {
            "Abia", "Adamawa", "Akwa Ibom", "Anambra",
            "Bauchi", "Bayelsa", "Benue", "Borno",
            "Cross River", "Delta", "Ebonyi,", "Edo",
            "Ekiti", "Enugu", "Imo", "Jigawa",
            "Kaduna", "Kano", "Katsina", "Kebbi",
            "Kogi", "Kwara", "Lagos", "Nasarawa",
            "Niger","Ogun", "Ondo", "Osun",
            "Oyo", "Plateau", "Rivers", "Sokoto",
            "Taraba", "Yobe", "Zamfara", "FCT"
    };

    final String[] years = {"1990",
            "1991", "1992", "1993", "1994",
            "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019"};

    final String[] months = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec"};

    final String[] dates = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};

    final String[] gender = {"Male",  "Female"};

    JFrame frame = new JFrame();

    //  Create objects
    final JLabel title = new JLabel("Employee Registration Form");

    final JLabel nameLabel = new JLabel("Full Name");
    final JTextField nameInput = new JTextField();

    final JLabel employeeIdLabel = new JLabel("Employee Id");
    final JTextField employeeIdInput = new JTextField();

    final JLabel genderLabel = new JLabel("Gender");
    final JComboBox genderInput = new JComboBox(gender);

    final JLabel ageLabel = new JLabel("Age (Yrs)");
    final JTextField ageInput = new JTextField();

    final JLabel emailLabel = new JLabel("Email:");
    final JTextField emailInput = new JTextField();

    final JLabel postLabel = new JLabel("Post");
    final JTextField postInput = new JTextField();

    final JLabel heightLabel = new JLabel("Height (In)");
    final JTextField heightInput = new JTextField();

    final  JLabel dateLabel = new JLabel("D.O.B");
    final JComboBox dayOfBirth = new JComboBox(dates);
    final JComboBox monthOfBirth = new JComboBox(months);
    final JComboBox yearOfBirth = new JComboBox(years);

    final JLabel addressLabel = new JLabel("House Address");
    final JTextArea addressInput = new JTextArea();

    final JLabel cityLabel = new JLabel("City");
    final JTextField cityInput = new JTextField();

    final JLabel stateLabel = new JLabel("State");
    final JComboBox stateInput= new JComboBox(states);

    final JLabel countryLabel = new JLabel("Country");
    final JComboBox countryInput= new JComboBox(country);

    final JButton submitButton= new JButton("Submit");
    final JButton resetButton= new JButton("Reset");

    final JLabel outputArea= new JLabel();


    // constructor, to initialize the components
    // with default values.
    public RegistrationForm()
    {
        createWindow();
        setObjectLayout();
        addObjectsToFrame();
        addActionListener();
        setStyle();
    }

    void createWindow(){
        // Set form title
        frame.setTitle("Employee Information System");
        // Set boundaries for the form
        frame.setBounds(300, 90, 650, 600);
        // Setting the background color
        frame.getContentPane().setBackground(Color.pink);
        // Set the default close operation
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set it to not be resizeable
        frame.setResizable(false);
        // Set layout
        frame.getContentPane().setLayout(null);
        // Make frame visible
        frame.setVisible(true);
    }

    void setObjectLayout(){
        // Set bounds for labels
        title.setBounds(200, 10,  200, 20);
        nameLabel.setBounds(120, 60,  150, 20);
        employeeIdLabel.setBounds(120, 90,  150, 20);
        postLabel.setBounds(120, 120,  150, 20);
        ageLabel.setBounds(120, 150,  150, 20);
        emailLabel.setBounds(120, 180,  150, 20);
        genderLabel.setBounds(120, 210,  150, 20);
        heightLabel.setBounds(120, 240,  150, 20);
        dateLabel.setBounds(120, 270,  150, 20);
        addressLabel.setBounds(120, 300,  150, 20);
        cityLabel.setBounds(120, 360,  150, 20);
        stateLabel.setBounds(120, 390,  150, 20);
        countryLabel.setBounds(120, 420,  150, 20);
        outputArea.setBounds(180, 35,  250, 20);

        // Set bounds for input
        nameInput.setBounds(300, 60,  200, 20);
        employeeIdInput.setBounds(300, 90,  200, 20);
        postInput.setBounds(300, 120,  200, 20);
        ageInput.setBounds(300, 150,  60, 20);
        emailInput.setBounds(300, 180,  200, 20);
        genderInput.setBounds(300, 210,  200, 20);
        heightInput.setBounds(300, 240,  60, 20);
        dayOfBirth.setBounds(300, 270,  40, 20);
        monthOfBirth.setBounds(350, 270,  50, 20);
        yearOfBirth.setBounds(410, 270,  60, 20);
        addressInput.setBounds(300, 300,  200, 50);
        cityInput.setBounds(300, 360,  200, 20);
        stateInput.setBounds(300, 390,  200, 20);
        countryInput.setBounds(300, 420,  200, 20);

        // Set bounds for buttons
        submitButton.setBounds(340, 450,  80, 30);
        resetButton.setBounds(160, 450,  80, 30);

    }

    void addObjectsToFrame(){
        frame.add(title);
        frame.add(nameLabel);
        frame.add(nameInput);
        frame.add(employeeIdLabel);
        frame.add(employeeIdInput);
        frame.add(genderLabel);
        frame.add(genderInput);
        frame.add(ageLabel);
        frame.add(ageInput);
        frame.add(emailLabel);
        frame.add(emailInput);
        frame.add(postLabel);
        frame.add(postInput);
        frame.add(heightLabel);
        frame.add(heightInput);
        frame.add(dateLabel);
        frame.add(dayOfBirth);
        frame.add(monthOfBirth);
        frame.add(yearOfBirth);
        frame.add(addressLabel);
        frame.add(addressInput);
        frame.add(cityLabel);
        frame.add(cityInput);
        frame.add(stateLabel);
        frame.add(stateInput);
        frame.add(countryLabel);
        frame.add(countryInput);
        frame.add(submitButton);
        frame.add(resetButton);
        frame.add(outputArea);
    }

    void addActionListener(){
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    void setStyle(){
        title.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.setBackground(Color.BLUE);
        resetButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        addressInput.setLineWrap(true);
    }

    void resetObjects(){
        nameInput.setText("");
        employeeIdInput.setText("");
        genderInput.setSelectedIndex(0);
        postInput.setText("");
        ageInput.setText("");
        heightInput.setText("");
        emailInput.setText("");
        addressInput.setText("");
        cityInput.setText("");
        dayOfBirth.setSelectedIndex(0);
        monthOfBirth.setSelectedIndex(0);
        yearOfBirth.setSelectedIndex(0);
        stateInput.setSelectedIndex(0);
        countryInput.setSelectedIndex(0);
    }

    boolean checkIfOjectsEmpty(){
        if (nameInput.getText().isEmpty()){
            outputArea.setText("Please enter your full name");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (employeeIdInput.getText().isEmpty()){
            outputArea.setText("Please enter your employee Id");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (postInput.getText().isEmpty()){
            outputArea.setText("Please enter your post");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (emailInput.getText().isEmpty()){
            outputArea.setText("Please enter your email address");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (!emailInput.getText().contains("@") || !emailInput.getText().contains(".")){
            outputArea.setText("Wrong email address format");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (ageInput.getText().isEmpty()){
            outputArea.setText("Please enter your age");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (heightInput.getText().isEmpty()){
            outputArea.setText("Please enter your height");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (addressInput.getText().isEmpty()){
            outputArea.setText("Please enter your house address");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else if (cityInput.getText().isEmpty()){
            outputArea.setText("Please enter your city");
            outputArea.setForeground(Color.RED);
            return false;
        }
        else {
            return true;
        }
    }

    int convertMonth(String month){
        return switch (month) {
            case "Jan" -> 1;
            case "Feb" -> 2;
            case "Mar" -> 3;
            case "Apr" -> 4;
            case "May" -> 5;
            case "Jun" -> 6;
            case "Jul" -> 7;
            case "Aug" -> 8;
            case "Sep" -> 9;
            case "Oct" -> 10;
            case "Nov" -> 11;
            case "Dec" -> 12;
            default -> 0;
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton){
            if (checkIfOjectsEmpty()) {
                // Connect to JDBC
                try {
                    // Create Connection object
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info_system", "root", "");
                    // Create prepared statement
                    PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    // Specifying values of its parameters
                    preparedStatement.setString(1, employeeIdInput.getText());
                    preparedStatement.setString(2, nameInput.getText());
                    preparedStatement.setString(3, postInput.getText());
                    preparedStatement.setString(4, String.valueOf(genderInput.getSelectedItem()));
                    preparedStatement.setString(5, ageInput.getText());
                    preparedStatement.setString(6, emailInput.getText());
                    preparedStatement.setString(7, heightInput.getText());
                    preparedStatement.setString(8, yearOfBirth.getSelectedItem()+ "-" + convertMonth((String) monthOfBirth.getSelectedItem()) + "-" + dayOfBirth.getSelectedItem());
                    preparedStatement.setString(9, addressInput.getText());
                    preparedStatement.setString(10, cityInput.getText());
                    preparedStatement.setString(11, String.valueOf(stateInput.getSelectedItem()));
                    preparedStatement.setString(12, String.valueOf(countryInput.getSelectedItem()));

                    // Execute statement
                    preparedStatement.executeUpdate();

                    // Display message
                    outputArea.setText("Registration Successful");

                    resetObjects();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else if (e.getSource() == resetButton){
            resetObjects();
            outputArea.setText("Reset Successful");
        }
    }

}

// Driver Code
public class Employee {

    public static void main(String[] args) throws Exception
    {
        new RegistrationForm();
    }
}

