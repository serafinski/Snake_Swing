package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame {

    //Predkosci odswierzania
    String p_100 = "100%";
    String p_110 = "110%";
    String p_125 = "125%";
    String p_150 = "150%";
    String p_50 = "50%";
    String p_75 = "75%";

    //Kolory siatki
    String niebieska_siatka = "Niebieska";
    String czerwona_siatka = "Czerwona";
    String zielona_siatka = "Zielona";
    String biala_siatka = "Biala";
    String brak_siatki = "Brak siatki";

    //Kolory węża
    String czerwony_waz = "Czerwony";
    String niebieski_waz = "Niebieski";
    String zielony_waz = "Zielony";

    //Kolor jablka
    String zielone_jablko = "Zielone";
    String czerwone_jablko = "Czerwone";


    JButton kolor_weza_przycisk;
    JButton predkosc_przycisk;

    //ActionListener zmienKolorWeza1 = new kolor_weza1();
    //ActionListener zmienKolorWeza2 = new kolor_weza2();

    JPanel panel_tytul;

    JPanel panel_opcje;

    JPanel panel_przycisk_powrotu;

    Options(){
        this.setLayout(new BorderLayout());
        this.setSize(750, 750);
        this.setTitle("Opcje!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(MyWindow.logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);

        wybor();

        this.setLocationRelativeTo(null);
        setVisible(true);
    }
    public void wybor(){
        //Panel
        panel_tytul = new JPanel();
        panel_opcje = new JPanel();
        panel_przycisk_powrotu = new JPanel();

        //Layout
        panel_tytul.setLayout(new FlowLayout());
        panel_opcje.setLayout(new BoxLayout(panel_opcje,BoxLayout.Y_AXIS));
        panel_przycisk_powrotu.setLayout(new FlowLayout());

        //Kolor
        panel_tytul.setBackground(Color.BLACK);
        panel_opcje.setBackground(Color.BLACK);
        panel_przycisk_powrotu.setBackground(Color.BLACK);

        //Tytul
        JLabel tytul = new JLabel();
        tytul.setText("Opcje:");
        tytul.setForeground(Color.WHITE);
        tytul.setHorizontalAlignment(JLabel.CENTER);
        tytul.setVerticalAlignment(JLabel.TOP);
        tytul.setFont(new Font("Jokerman",Font.BOLD,70));

        //Tytuly opcji

        //PREDKOSC TEXT
        JLabel predkosc_tytul = new JLabel();
        predkosc_tytul.setText("Wybierz predkosc");
        predkosc_tytul.setForeground(Color.WHITE);
        predkosc_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        predkosc_tytul.setFont(new Font("Jokerman",Font.BOLD,35));


        //SIATKA TEKST
        JLabel kolor_siatki_tytul = new JLabel();
        kolor_siatki_tytul.setText("Wybierz kolor siatki");
        kolor_siatki_tytul.setForeground(Color.WHITE);
        kolor_siatki_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_siatki_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //WAZ TEKST
        JLabel kolor_weza_tytul = new JLabel();
        kolor_weza_tytul.setText("Wybierz kolor weza");
        kolor_weza_tytul.setForeground(Color.WHITE);
        kolor_weza_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_weza_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //JABLKO TEKST
        JLabel kolor_jablka_tytul = new JLabel();
        kolor_jablka_tytul.setText("Wybierz kolor jablka");
        kolor_jablka_tytul.setForeground(Color.WHITE);
        kolor_jablka_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_jablka_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //Przyciski opcji



        //PREDKOSC PRZYCISK
        JButton predkosc_przycisk = new JButton(p_100);
        predkosc_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        predkosc_przycisk.setMaximumSize(new Dimension(200,75));


        //SIATKA PRZYCISK
        JButton kolor_siatki_przycisk = new JButton(niebieska_siatka);
        kolor_siatki_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_siatki_przycisk.setMaximumSize(new Dimension(200,75));

        //WAZ PRZYCISK
        JButton kolor_weza_przycisk = new JButton(czerwony_waz);
        kolor_weza_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_weza_przycisk.setMaximumSize(new Dimension(200,75));
        //kolor_weza_przycisk.addActionListener(zmienKolorWeza1);

        //JABLKO PRZYCISK
        JButton kolor_jablka_przycisk = new JButton(zielone_jablko);
        kolor_jablka_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_jablka_przycisk.setMaximumSize(new Dimension(200,75));


        //Przycisk powrotu do menu
        JButton przycisk_powrotu = new JButton();

        przycisk_powrotu.addActionListener(e -> {
            dispose();
            new MyWindow();
        });

        przycisk_powrotu.setText("Wroc do menu glownego!");
        przycisk_powrotu.setFocusable(false);
        przycisk_powrotu.setFont(new Font("Jokerman",Font.BOLD,50));
        przycisk_powrotu.setBorderPainted(false);
        przycisk_powrotu.setForeground(Color.WHITE);
        przycisk_powrotu.setBackground(Color.BLACK);
        przycisk_powrotu.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk_powrotu.setMaximumSize(new Dimension(1000,200));

        //Dodawanie komponentów
        panel_tytul.add(tytul);

        panel_opcje.add(predkosc_tytul);
        panel_opcje.add(predkosc_przycisk);

        panel_opcje.add(kolor_siatki_tytul);
        panel_opcje.add(kolor_siatki_przycisk);

        panel_opcje.add(kolor_weza_tytul);
        panel_opcje.add(kolor_weza_przycisk);

        panel_opcje.add(kolor_jablka_tytul);
        panel_opcje.add(kolor_jablka_przycisk);

        panel_przycisk_powrotu.add(przycisk_powrotu);

        //lokalizacja paneli w JFrame
        this.add(panel_tytul,BorderLayout.NORTH);
        this.add(panel_opcje,BorderLayout.CENTER);
        this.add(panel_przycisk_powrotu,BorderLayout.SOUTH);
    }


    /*private class kolor_weza1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Game.kolor = new Color(255,0,0);
            kolor_weza_przycisk.removeActionListener(zmienKolorWeza1);
            kolor_weza_przycisk.setText(niebieski_waz);
            kolor_weza_przycisk.addActionListener(zmienKolorWeza2);
        }
    }

    private class kolor_weza2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Game.kolor = new Color(0,0,255);
            kolor_weza_przycisk.removeActionListener(zmienKolorWeza2);
            kolor_weza_przycisk.setText(czerwony_waz);
            kolor_weza_przycisk.addActionListener(zmienKolorWeza1);
        }
    }

     */
}
