package code;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    ImageIcon logo = new ImageIcon("src/zasoby/snake_logo.jpg");

    Score(){
        this.setLayout(new BorderLayout());
        this.setSize(1000,1000);
        this.setTitle("Wyniki");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.white);

        //this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
}
