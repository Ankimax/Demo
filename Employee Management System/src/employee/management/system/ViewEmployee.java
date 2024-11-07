package employee.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cemp ;
    JButton search, print, update, back;
    ViewEmployee(){

        JLabel srch = new JLabel("Search By Employee ID");
        srch.setBounds(20, 20, 150, 20);
        add(srch);

        cemp = new Choice();
        cemp.setBounds(180, 20, 150, 20);
        add(cemp);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            while (rs.next()) {
                cemp.add(rs.getString("empid"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(new Color(25, 196, 182));
        setBounds(300,100,900,700);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empid = '" + cemp.getSelectedItem() +"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch(Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemp.getSelectedItem());

        } else {
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }

}
