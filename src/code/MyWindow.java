package code;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    ImageIcon logo = new ImageIcon("src/zasoby/snake_logo.jpg");

    JPanel panel_tytul;

    JPanel panel_przyciski;

    public MyWindow (){
        this.setLayout(new BorderLayout());
        this.setSize(1000,1000);
        this.setTitle("Snake - Tomasz Serafiński");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.white);



        initComponents();

        this.pack();
        setVisible(true);
    }

    public void initComponents(){
        //Panel
        panel_tytul = new JPanel();
        panel_przyciski = new JPanel();

        //Layout
        panel_przyciski.setLayout(new BoxLayout(panel_przyciski,BoxLayout.Y_AXIS));
        panel_tytul.setLayout(new FlowLayout());

        //Kolor
        panel_tytul.setBackground(Color.BLACK);
        panel_przyciski.setBackground(Color.BLACK);

        //Tytuł
        JLabel tytul = new JLabel();
        tytul.setText("Snake! - Tomasz Serafinski");
        tytul.setForeground(Color.WHITE);
        tytul.setHorizontalAlignment(JLabel.CENTER);
        tytul.setVerticalAlignment(JLabel.TOP);
        tytul.setFont(new Font("Jokerman",Font.BOLD,100));

        //Przycisk Start
        JButton przycisk_start = new JButton("Rozpocznij gre!");
        przycisk_start.setFocusable(false);
        przycisk_start.setFont(new Font("Jokerman",Font.BOLD,75));
        przycisk_start.setForeground(Color.white);
        przycisk_start.setBackground(Color.BLACK);
        przycisk_start.setAlignmentX(Component.CENTER_ALIGNMENT);
        //na podstawie research'u - 1 z 3 metod zmieniania wielkości honorowana przez BoxLayout
        przycisk_start.setMaximumSize(new Dimension(1000,333));


        //Przycisk wyników
        JButton przycisk_wynik = new JButton("Wyswietl wyniki!");
        przycisk_wynik.setFocusable(false);
        przycisk_wynik.setFont(new Font("Jokerman",Font.BOLD,75));
        przycisk_wynik.setForeground(Color.WHITE);
        przycisk_wynik.setBackground(Color.BLACK);
        przycisk_wynik.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_wynik.setMaximumSize(new Dimension(1000,333));

        //przycisk Wyjdź z gry
        JButton przycisk_wyjdz = new JButton("Wyjdz z gry!");
        przycisk_wyjdz.setFocusable(false);
        przycisk_wyjdz.setFont(new Font("Jokerman",Font.BOLD,75));
        przycisk_wyjdz.setForeground(Color.white);
        przycisk_wyjdz.setBackground(Color.black);
        przycisk_wyjdz.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_wyjdz.setMaximumSize(new Dimension(1000,333));

        //Dodawanie komponentów
        panel_tytul.add(tytul);
        panel_przyciski.add(przycisk_start);
        panel_przyciski.add(Box.createHorizontalGlue());
        panel_przyciski.add(przycisk_wynik);
        panel_przyciski.add(Box.createHorizontalGlue());
        panel_przyciski.add(przycisk_wyjdz);

        this.add(panel_tytul, BorderLayout.NORTH);
        this.add(panel_przyciski,BorderLayout.CENTER);
    }
}
