package Electricity;

import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;

public class CustomerDetails extends JFrame implements ActionListener {

    JTable customerTable;
    JButton b1;
    String header[] = {"Customer Name", "Meter Number", "Address", "Email", "Phone"};
    String data[][] = new String[40][5];
    int row = 0, col = 0;

    CustomerDetails() throws SQLException, ClassNotFoundException {
        super("Customer Details");
        setSize(1200, 650);
        setLocation(400, 150);

        try (Connection con = Conn.connect();
                PreparedStatement pr = con.prepareStatement("select * from customer");) {

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                data[row][col++] = rs.getString("name");
                data[row][col++] = rs.getString("meter");
                data[row][col++] = rs.getString("address");
                data[row][col++] = rs.getString("email");
                data[row][col++] = rs.getString("phone");
                row++;
                col = 0;
            }
            customerTable = new JTable(data, header);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        b1 = new JButton("Print");
        add(b1, "South");
        JScrollPane sp = new JScrollPane(customerTable);
        add(sp);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            customerTable.print();
        } catch (PrinterException e) {
            System.out.println(e.getMessage());
        }
    }

}
