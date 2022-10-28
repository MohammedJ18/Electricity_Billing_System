package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener {

    JButton b1;

    ViewInformation(String meter) throws SQLException, ClassNotFoundException {
        setBounds(600, 250, 850, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setBounds(70, 80, 100, 20);
        add(name);

        JLabel l11 = new JLabel();
        l11.setBounds(250, 80, 100, 20);
        add(l11);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(70, 140, 100, 20);
        add(meterNumber);

        JLabel l12 = new JLabel();
        l12.setBounds(250, 140, 100, 20);
        add(l12);

        JLabel adress = new JLabel("Address");
        adress.setBounds(70, 200, 100, 20);
        add(adress);

        JLabel l13 = new JLabel();
        l13.setBounds(250, 200, 100, 20);
        add(l13);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(500, 140, 100, 20);
        add(l6);

        JLabel l16 = new JLabel();
        l16.setBounds(650, 140, 150, 20);
        add(l16);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(500, 200, 100, 20);
        add(l7);

        JLabel l17 = new JLabel();
        l17.setBounds(650, 200, 100, 20);
        add(l17);

        try (Connection con = Conn.connect();
                PreparedStatement pr = con.prepareStatement("");) {

            ResultSet rs = pr.executeQuery("select * from customer where meter = '" + meter + "'");
            while (rs.next()) {
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l16.setText(rs.getString(4));
                l17.setText(rs.getString(5));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 290, 100, 25);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(20, 300, 600, 300);
        add(l8);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

}
