package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempid;
    JLabel name, phone, email;
    JButton delete, back;
    RemoveEmployee(){

        JLabel lempid = new JLabel("Employee ID");
        lempid.setBounds(50,50,100,30);
        lempid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lempid);

        cempid = new Choice();
        cempid.setBounds(200,50,150,30);
        add(cempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lname = new JLabel("Name");
        lname.setBounds(50,100,100,30);
        lname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lname);

        name = new JLabel();
        name.setBounds(200,100,100,30);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        add(name);

        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(50,150,100,30);
        lphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lphone);

        phone = new JLabel();
        phone.setBounds(200,150,100,30);
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(phone);

        JLabel lemail = new JLabel("Email");
        lemail.setBounds(50,200,100,30);
        lemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lemail);

        email = new JLabel();
        email.setBounds(200,200,100,30);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        add(email);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from employee where empid='"+cempid.getSelectedItem()+"'");
            while (rs.next()) {
                name.setText(rs.getString("name"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.statement.executeQuery("select * from employee where empid='"+cempid.getSelectedItem()+"'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80,200,200);
        add(img);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i5 = i4.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0,1120,630);
        add(image);

        setBounds(300,150,1000,400);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empid='"+cempid.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                new Dashboard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

}
