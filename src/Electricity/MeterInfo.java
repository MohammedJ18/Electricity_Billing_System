package Electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class MeterInfo extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Choice c4, c5;
    JButton b1, b2;

    MeterInfo(String meter) {
        setLocation(600, 200);
        setSize(680, 370);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));

        JLabel title = new JLabel("Meter Information");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        l1 = new JLabel("Meter Number");
        l1.setBounds(100, 80, 100, 20);

        l11 = new JLabel(meter);
        l11.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(l11);


        l4 = new JLabel("Bill Type");
        l4.setBounds(100, 120, 100, 20);
        c4 = new Choice();
        c4.add("residential");
        c4.add("Industrial");
        c4.add("agricultural");
        c4.add("commercial");
        c4.add("government");
        c4.setBounds(240, 120, 200, 20);
        p.add(l4);
        p.add(c4);


        l7 = new JLabel("Note");
        l7.setBounds(100, 160, 100, 20);
        l10 = new JLabel("By Default Bill is calculated for 30 days only");
        l10.setBounds(240, 160, 260, 20);
        p.add(l7);
        p.add(l10);

        b1 = new JButton("Submit");
        b1.setBounds(120, 270, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 270, 100, 25);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());

        add(p, "Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);

        add(l8, "West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String meter_number = l11.getText();
            String bill_type = c4.getSelectedItem();
            String days = "30";

            String q1 = "insert into meter_info values('" + meter_number + "','" + bill_type + "')";
            try (Connection con = Conn.connect();
                    PreparedStatement pr = con.prepareStatement(q1);){
                
                pr.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Meter Info Added Successfully");
                this.setVisible(false);

            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    
}
