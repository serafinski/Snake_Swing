package code;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    ImageIcon logo = new ImageIcon("src/zasoby/snake_logo.jpg");

    JPanel panel = new JPanel();

    public Game (){
        this.setLayout(new BorderLayout());
        this.setSize(750,750);
        this.setTitle("Snake!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);

        //this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);

        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED,3));

        this.add(panel);
    }
}
