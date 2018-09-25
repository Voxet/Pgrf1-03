package cz.uhk.fim.pixeltest;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class pixelTest {

    private JFrame window;
    private JPanel panel;
    private BufferedImage img;

    public pixelTest() {
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paintComponents(g);
                g.drawImage(img, 0, 0, null);
            }
        };



        window.add(panel);
        img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_BGR);

        window.setVisible(true);

        drawPixel(100, 50, Color.GREEN.getRGB());

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), Color.yellow.getRGB());
            }
        });
    }

    private void drawPixel(int x, int y, int color) {
        img.setRGB(x, y, color);
        panel.getGraphics().drawImage(img, 0, 0, null);

    }


    public static void main(String[] args) {
        new pixelTest();
    }

}
