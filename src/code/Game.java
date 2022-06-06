package code;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {



    public Game (){
        //card layout, bo nie zdążyłem zaimplementować wyników w gui tylko w terminalu
        this.setLayout(new CardLayout());

        this.setTitle("Snake!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(MyWindow.logo.getImage());

        //dodaje w taki sposób, bo nie zamierzam tego używać nigdzie indziej
        this.add(new Snake());

        //pack, bo bez tego gra się odpowiednio nie wyświetli
        this.pack();
        setVisible(true);
        this.setLocationRelativeTo(null);
    }

}