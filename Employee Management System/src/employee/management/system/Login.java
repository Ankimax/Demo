package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;

    JButton login, back;
    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,10,600,400);
        add(img);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,600,300);
        add(image);

//        setSize(600, 300);
//        setLocation(450, 200);
        setBounds(450, 200, 600,300);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = String.valueOf(tpassword.getPassword());

                Conn conn = new Conn();

                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

                ResultSet rs = conn.statement.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
