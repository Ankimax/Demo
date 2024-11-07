package employee.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement statement;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Ank31@Sql1");
            statement = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
