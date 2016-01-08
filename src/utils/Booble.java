package utils;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Booble extends JButton implements Runnable {

    public Booble() {
        super();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage img = ImageIO.read(new File("D://Java/Projects/Med/src/img.png"));
            //g2.clipRect(0, 0, 80, 70);
            //g2.setXORMode(new Color(200, 255, 250));
            g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g2.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2.drawOval(0, 0, this.getWidth(), this.getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(160, 107);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("sleep");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

