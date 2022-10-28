package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7;
    JLabel l11, l12;
    JButton b1, b2;
    String meter;

    UpdateInformation(String meter) throws SQLException, ClassNotFoundException {
        this.meter = meter;

        setBounds(500, 220, 1000, 420);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("UPDATE CUSTOMER INFORMATION");
        title.setBounds(110, 0, 400, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 70, 100, 20);
        add(l1);

        l11 = new JLabel();
        l11.setBounds(230, 70, 200, 20);
        add(l11);

        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(30, 110, 100, 20);
        add(l2);

        l12 = new JLabel();
        l12.setBounds(230, 110, 200, 20);
        add(l12);

        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(230, 150, 200, 20);
        add(t1);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 190, 100, 20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(230, 190, 200, 20);
        add(t4);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 230, 100, 20);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(230, 230, 200, 20);
        add(t5);

        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(230, 300, 90, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(340, 300, 90, 25);
        b2.addActionListener(this);
        add(b2);

        try (Connection con = Conn.connect();
                PreparedStatement pr = con.prepareStatement("");) {

            ResultSet rs = pr.executeQuery("select * from customer where meter = '" + meter + "'");
            while (rs.next()) {
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                t1.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(550, 50, 400, 300);
        add(l8);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String s3 = t1.getText();
            String s6 = t4.getText();
            String s7 = t5.getText();

            try (Connection con = Conn.connect();
                    PreparedStatement pr = con.prepareStatement("");) {

                pr.executeUpdate("update customer set address = '" + s3 + "', email = '" + s6 + "', phone = '" + s7 + "' where meter = '" + meter + "'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

}
