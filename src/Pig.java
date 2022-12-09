import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pig extends JFrame{
    BufferedImage pig = null;
    Pig() {

    // Button b1(이미지 파일을 그레이 스케일로 변환)
    JButton b1 = new JButton("[그레이 스케일]");
    b1.setBounds(120, 80, 150, 30);
    b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 이미지 불러오기
            try {
                pig = ImageIO.read(new File("C:\\\\Users\\\\USER\\\\Documents\\\\gom.jpg"));
            } catch (IOException e1) {
                System.out.println(e1.toString());
            }
            // 그레이스케일로 변환하기
            for (int y = 0; y < pig.getHeight(); y++) {
                for (int x = 0; x < pig.getWidth(); x++) {
                    Color colour = new Color(pig.getRGB(x, y));
                    int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
                    pig.setRGB(x, y, new Color(Y, Y, Y).getRGB());
                }
            }
        }
    });
    // button2(저장)
    JButton b2 = new JButton("[저장하기]");
    b2.setBounds(120, 160, 150, 30);
    b2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 변환한 이미지를 gray.jpg로 저장하기
            try {
                ImageIO.write(pig, "jpg", new File("C:\\Users\\USER\\Documents\\gray.jpg"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
         add(b1); add(b2);
         setTitle("JButton 숙제");
         setSize(400,300);
         setLayout(null);
         setVisible(true);
    }

    // 실행
    public static void main(String[] args) {
        new Pig();
    }
}