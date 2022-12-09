import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pig2 extends JFrame{
    int count = 0;

    Pig2() {

    // Button b1
    JButton b1 = new JButton("Pig~");
    b1.setBounds(100, 150, 100, 30);
    b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BufferedImage pig = null;
            try {
                pig = ImageIO.read(new File("C:\\\\Users\\\\USER\\\\Documents\\\\gom.jpg"));
            } catch (IOException e1) {
                System.out.println(e1.toString());
            }


            for (int y = 0; y < pig.getHeight(); y++) {
                for (int x = 0; x < pig.getWidth(); x++) {
                    Color colour = new Color(pig.getRGB(x, y));
//       Choose one from below
//       int Y = (int) (0.299 * colour.getRed() + 0.587 * colour.getGreen() + 0.114 * colour.getBlue());
                    int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
                    pig.setRGB(x, y, new Color(Y, Y, Y).getRGB());
                }
            }

            try {
                ImageIO.write(pig, "jpg", new File("C:\\Users\\USER\\Documents\\gom2.jpg"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    add(b1);
    setTitle("JButton EX");
    setSize(500,400);
    setLayout(null);
    setVisible(true);
    }
    public static void main(String[] args) {
        new Pig2();
    }
}