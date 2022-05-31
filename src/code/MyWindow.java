package code;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    static final ImageIcon logo = new ImageIcon("src/zasoby/snake_logo.jpg");
    JPanel panel_tytul;

    JPanel panel_przyciski;

    public MyWindow (){
        this.setLayout(new BorderLayout());
        this.setSize(750, 750);
        this.setTitle("Tomasz Serafiński");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);



        initComponents();

        //this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents(){
        //Panel
        panel_tytul = new JPanel();
        panel_przyciski = new JPanel();

        //Layout
        panel_tytul.setLayout(new FlowLayout());
        panel_przyciski.setLayout(new BoxLayout(panel_przyciski,BoxLayout.Y_AXIS));

        //Kolor
        panel_tytul.setBackground(Color.BLACK);
        panel_przyciski.setBackground(Color.BLACK);

        //Tytuł
        JLabel tytul = new JLabel();
        tytul.setText("Snake!");
        tytul.setForeground(Color.WHITE);
        tytul.setHorizontalAlignment(JLabel.CENTER);
        tytul.setVerticalAlignment(JLabel.TOP);
        tytul.setFont(new Font("Jokerman",Font.BOLD,100));

        //Przycisk Start
        JButton przycisk_start = new JButton();

        przycisk_start.addActionListener(e ->{
            dispose();
            new Game();
        });

        przycisk_start.setText("Rozpocznij gre!");
        przycisk_start.setFocusable(false);
        przycisk_start.setFont(new Font("Jokerman",Font.BOLD,50));
        przycisk_start.setBorderPainted(false);
        przycisk_start.setForeground(Color.WHITE);
        przycisk_start.setBackground(Color.BLACK);
        przycisk_start.setAlignmentX(Component.CENTER_ALIGNMENT);

        //na podstawie research'u - 1 z 3 metod zmieniania wielkości honorowana przez BoxLayout
        przycisk_start.setMaximumSize(new Dimension(1000,333));





        //Przycisk wyników
        JButton przycisk_wynik = new JButton();

        przycisk_wynik.addActionListener(e -> {
            dispose();
            new Score();
        });

        przycisk_wynik.setText("Wyswietl wyniki!");
        przycisk_wynik.setFocusable(false);
        przycisk_wynik.setFont(new Font("Jokerman",Font.BOLD,50));
        przycisk_wynik.setBorderPainted(false);
        przycisk_wynik.setForeground(Color.WHITE);
        przycisk_wynik.setBackground(Color.BLACK);
        przycisk_wynik.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_wynik.setMaximumSize(new Dimension(1000,333));





        //przycisk Opcji
        JButton przycisk_opcje = new JButton();

        przycisk_opcje.addActionListener(e -> {
            dispose();
            new Options();
        });

        przycisk_opcje.setText("Opcje!");
        przycisk_opcje.setFocusable(false);
        przycisk_opcje.setFont(new Font("Jokerman",Font.BOLD,50));
        przycisk_opcje.setBorderPainted(false);
        przycisk_opcje.setForeground(Color.white);
        przycisk_opcje.setBackground(Color.black);
        przycisk_opcje.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_opcje.setMaximumSize(new Dimension(1000,333));

        //Dodawanie komponentów
        panel_tytul.add(tytul);
        panel_przyciski.add(przycisk_start);
        panel_przyciski.add(Box.createHorizontalGlue());
        panel_przyciski.add(przycisk_wynik);
        panel_przyciski.add(Box.createHorizontalGlue());
        panel_przyciski.add(przycisk_opcje);

        this.add(panel_tytul, BorderLayout.NORTH);
        this.add(panel_przyciski,BorderLayout.CENTER);
    }
}
