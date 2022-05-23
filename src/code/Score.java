package code;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    ImageIcon logo = new ImageIcon("src/zasoby/snake_logo.jpg");

    JPanel panel_tekst;

    JPanel panel_przycisk_powrotu;

    Score(){
        this.setLayout(new BorderLayout());
        this.setSize(1000,1000);
        this.setTitle("Wyniki");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);


        wyniki();

        //this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void wyniki(){
        //Panel
        panel_tekst = new JPanel();
        panel_przycisk_powrotu = new JPanel();

        //Layout
        panel_tekst.setLayout(new FlowLayout());
        panel_przycisk_powrotu.setLayout(new FlowLayout());

        //Kolor
        panel_tekst.setBackground(Color.BLACK);
        panel_przycisk_powrotu.setBackground(Color.BLACK);

        //Tekst
        JLabel tekst = new JLabel();
        tekst.setText("Tablica wynikow:");
        tekst.setForeground(Color.WHITE);
        tekst.setHorizontalAlignment(JLabel.CENTER);
        tekst.setVerticalAlignment(JLabel.TOP);
        tekst.setFont(new Font("Jokerman",Font.BOLD,70));

        //Przycisk powrotu do menu
        JButton przycisk_powrotu = new JButton();

        przycisk_powrotu.addActionListener(e -> {
            dispose();
            new MyWindow();
        });

        przycisk_powrotu.setText("Wroc do menu glownego!");
        przycisk_powrotu.setFocusable(false);
        przycisk_powrotu.setFont(new Font("Jokerman",Font.BOLD,50));
        przycisk_powrotu.setForeground(Color.WHITE);
        przycisk_powrotu.setBackground(Color.BLACK);
        przycisk_powrotu.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_powrotu.setMaximumSize(new Dimension(1000,200));

        //Dodawanie komponentów
        panel_tekst.add(tekst);
        panel_przycisk_powrotu.add(przycisk_powrotu);

        //lokalizacja paneli w JFrame
        this.add(panel_tekst,BorderLayout.NORTH);
        this.add(panel_przycisk_powrotu,BorderLayout.SOUTH);
    }
}