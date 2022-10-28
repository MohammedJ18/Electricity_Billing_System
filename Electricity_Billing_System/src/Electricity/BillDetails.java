package Electricity;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {

    JTable table;
    String header[] = {"Meter Number", "Month", "Units", "Total Bill", "Status"};
    String data[][] = new String[40][8];

    BillDetails(String meter) throws ClassNotFoundException {
        super("Bill Details");
        setSize(700, 650);
        setLocation(600, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        table = new JTable(data, header);

        try {
            Connection con = Conn.connect();
            String s1 = "select * from bill where meter = " + meter;
            PreparedStatement p = con.prepareStatement(s1);
            ResultSet rs = p.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);

    }

}
