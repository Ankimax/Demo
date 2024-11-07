package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField tfname, taddress, tphone, temail, teducation, tsalary, tdesignation;
    JLabel lname, ldob, laadhar, lempid;
    JButton update, back;
    String empid;
    UpdateEmployee(String empid){

        this.empid = empid;
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        lname = new JLabel();
        lname.setBounds(200, 150, 150, 30);
        lname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(142, 198, 238));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        ldob = new JLabel();
        ldob.setBounds(200,200,150,30);
        ldob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(ldob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(142, 198, 238));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(142, 198, 238));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(142, 198, 238));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(142, 198, 238));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(142, 198, 238));
        add(teducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(142, 198, 238));
        add(tdesignation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        laadhar = new JLabel();
        laadhar.setBounds(600, 350, 150, 30);
        laadhar.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(laadhar);

        JLabel emp = new JLabel("Employee ID");
        emp.setBounds(50, 400, 150, 30);
        emp.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(emp);

        lempid = new JLabel();
        lempid.setBounds(200, 400, 150, 30);
        lempid.setFont(new Font("Tahoma", Font.BOLD, 20));
        lempid.setForeground(Color.red);
        add(lempid);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empid ='" + empid + "'";
            ResultSet rs = c.statement.executeQuery(query);
            while(rs.next()) {
                lname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                ldob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tdesignation.setText(rs.getString("designation"));
                laadhar.setText(rs.getString("aadhar"));
                lempid.setText(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);


        getContentPane().setBackground(new Color(8, 126, 243));
        setBounds(300, 50, 900, 700);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                Conn c = new Conn();
                String query = "update employee set fname='"+fname+"', salary='"+salary+"', address='"+address+"', phone='"+phone+"', email='"+email+"', education='"+education+"', designation='"+designation+"' where empid='"+empid+"'";
                c.statement.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Employee Detail Updated Successfully");
            new ViewEmployee();
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
