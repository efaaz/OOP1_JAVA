import javax.swing.*;

import java.awt.Color;
import java.io.File;

public class Test {
    private JFrame f;

    public Test() {
        f = new JFrame("image");
        f.setSize(1200, 1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        JLabel imageLabel = new JLabel();
        String imagePath = "C:/Users/rahma/Documents/AIUB/oop1_java_classes/Assignments/Problem-2/nm.jpg";
        ImageIcon icon = new ImageIcon(imagePath);

        if (new File(imagePath).exists()) {
            imageLabel.setIcon(icon);
            f.add(imageLabel);
            f.setVisible(true);
        } else {
            System.out.println("Image not found!");
        }
    }
    public static void main(String[] args) {
        new Test();
    }
}