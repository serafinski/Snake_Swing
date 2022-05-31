package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame {



    public Game (){

        this.setLayout(new CardLayout());

        this.setTitle("Snake!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(MyWindow.logo.getImage());

        //dodaje w taki sposob, bo nie zamierzam tego używać nigdzie indziej
        this.add(new Snake());

        //pack bo bez tego linie nie narysują się odpowiednio
        this.pack();
        setVisible(true);
        this.setLocationRelativeTo(null);


        //panel.setBackground(Color.BLACK);
        //panel.setBorder(BorderFactory.createLineBorder(Color.RED,3));

        //this.add(panel);
    }

}


/*
    To restart the game with " Enter"  button  add this after the switch in class GamePanel:
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        if(!running) {
        running = true;
        bodyParts = 6;
        newApple();
        applesEaten = 0;
        x[0] = 0;
        y[0] = 0;
        direction = 'R';
        timer.restart();
        new GamePanel();
        repaint();
        }
        }
        }
        }
        }
        you still need to reset x and y array or old body will show

 */