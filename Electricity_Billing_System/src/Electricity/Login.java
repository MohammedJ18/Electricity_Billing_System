package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener {

    JLabel lUsername, lPassword, lImg, lLogin;
    JTextField tUsername;
    JPasswordField tPassword;
    JButton bLogin, bCancel, bSginup;
    JPanel p1, p2, p3, p4;
    Choice c1;

    Login() {
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        lUsername = new JLabel("Username");
        lUsername.setBounds(300, 20, 100, 20);
        add(lUsername);
        lPassword = new JLabel("Password");
        lPassword.setBounds(300, 60, 100, 20);
        add(lPassword);

        tUsername = new JTextField(15);
        tUsername.setBounds(400, 20, 150, 20);
        add(tUsername);
        tPassword = new JPasswordField(15);
        tPassword.setBounds(400, 60, 150, 20);
        add(tPassword);

        lLogin = new JLabel("Logging in as");
        lLogin.setBounds(300, 100, 100, 20);
        add(lLogin);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 100, 150, 20);
        add(c1);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bLogin = new JButton("Login", new ImageIcon(i1));
        bLogin.setBounds(330, 160, 100, 20);
        add(bLogin);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bCancel = new JButton("Cancel", new ImageIcon(i2));
        bCancel.setBounds(450, 160, 100, 20);
        add(bCancel);

        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bSginup = new JButton("Signup", new ImageIcon(i4));
        bSginup.setBounds(380, 200, 130, 20);
        add(bSginup);

        bLogin.addActionListener(this);
        bCancel.addActionListener(this);
        bSginup.addActionListener(this);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        lImg = new JLabel(icc3);
        lImg.setBounds(0, 0, 250, 250);
        add(lImg);

        setLayout(new BorderLayout());

        setSize(640, 300);
        setLocation(600, 300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bLogin) {
            try (Connection con = Conn.connect();
                    PreparedStatement pr = con.prepareStatement("");) {

                String a = tUsername.getText();
                String b = tPassword.getText();
                String user = c1.getSelectedItem();
                String q = "select * from login where username = '" + a + "' and password = '" + b + "' and user = '" + user + "'";
                ResultSet rs = pr.executeQuery(q);
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tUsername.setText("");
                    tPassword.setText("");
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());

            }
        } else if (ae.getSource() == bCancel) {
            this.setVisible(false);
        } else if (ae.getSource() == bSginup) {
            this.setVisible(false);
            new Signup().setVisible(true);

        }
    }

}
