package Electricity;

import java.awt.*;
import javax.swing.*;

public class Splash {

    public static void main(String[] args) {
        frame f1 = new frame();
        f1.setVisible(true);
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 8, x += 2) {
            f1.setLocation(800 - ((i + x) / 2), 500 - (i / 2));
            f1.setSize(i + x, i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

class frame extends JFrame implements Runnable {

    Thread thread1;

    frame() {
        super("Electricity Billing System");
        setResizable(false);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/v1.jpg"));
        Image img = c1.getImage().getScaledInstance(768, 512, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);

        JLabel firstImg = new JLabel(i2);
        add(firstImg);
        thread1 = new Thread(this);
        thread1.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            this.setVisible(false);
            Login l = new Login();
            l.setVisible(true);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
