package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame {

    //Kolory siatki
    String niebieska_siatka = "Niebieska";
    String czerwona_siatka = "Czerwona";
    String zielona_siatka = "Zielona";
    String biala_siatka = "Biala";
    String brak_siatki = "Brak siatki";

    //Kolory glowy węża
    String glowa_czerwony_waz = "Czerwona";
    String glowa_niebieski_waz = "Niebieska";
    String glowa_zielony_waz = "Zielona";

    //Kolory ciala węża
    String cialo_czerwony_waz = "Czerwone";
    String cialo_niebieski_waz = "Niebieskie";
    String cialo_zielony_waz = "Zielone";

    //Kolor jablka
    String zielone_jablko = "Zielone";
    String czerwone_jablko = "Czerwone";

    JButton kolor_siatki_przycisk;

    JButton kolor_glowy_weza_przycisk;

    JButton kolor_ciala_weza_przycisk;

    JButton kolor_jablka_przycisk;


    //LISTENERY

    //Siatka
    ActionListener zmienKolorSiatkiNiebieski = new Niebieska();
    ActionListener zmienKolorSiatkiCzerwony = new Czerwona();

    ActionListener zmienKolorSiatkiZielony = new Zielona();

    ActionListener zmienKolorSiatkiBialy = new Biala();
    ActionListener zmienKolorSiatkiBrak = new Brak();

    //Jablko
    ActionListener zmienKolorJablkaZielony = new Zielone();
    ActionListener zmienKolorJablkaCzerwony = new Czerwone();
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

        //SIATKA TEKST
        JLabel kolor_siatki_tytul = new JLabel();
        kolor_siatki_tytul.setText("Wybierz kolor siatki");
        kolor_siatki_tytul.setForeground(Color.WHITE);
        kolor_siatki_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_siatki_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //WAZ GLOWA TEKST
        JLabel kolor_glowy_weza_tytul = new JLabel();
        kolor_glowy_weza_tytul.setText("Wybierz kolor glowy weza");
        kolor_glowy_weza_tytul.setForeground(Color.WHITE);
        kolor_glowy_weza_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_glowy_weza_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //WAZ GLOWA TEKST
        JLabel kolor_ciala_weza_tytul = new JLabel();
        kolor_ciala_weza_tytul.setText("Wybierz kolor ciala weza");
        kolor_ciala_weza_tytul.setForeground(Color.WHITE);
        kolor_ciala_weza_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_ciala_weza_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //JABLKO TEKST
        JLabel kolor_jablka_tytul = new JLabel();
        kolor_jablka_tytul.setText("Wybierz kolor jablka");
        kolor_jablka_tytul.setForeground(Color.WHITE);
        kolor_jablka_tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_jablka_tytul.setFont(new Font("Jokerman",Font.BOLD,35));

        //Przyciski opcji

        //SIATKA PRZYCISK
        kolor_siatki_przycisk = new JButton(niebieska_siatka);
        kolor_siatki_przycisk.setForeground(Color.BLUE);
        kolor_siatki_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_siatki_przycisk.setMaximumSize(new Dimension(200,75));
        kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiNiebieski);

        //WAZ GLOWA PRZYCISK
        kolor_glowy_weza_przycisk = new JButton(glowa_czerwony_waz);
        kolor_glowy_weza_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_glowy_weza_przycisk.setMaximumSize(new Dimension(200,75));

        //WAZ CIALO PRZYCISK
        kolor_ciala_weza_przycisk = new JButton(glowa_czerwony_waz);
        kolor_ciala_weza_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_ciala_weza_przycisk.setMaximumSize(new Dimension(200,75));

        //JABLKO PRZYCISK
        kolor_jablka_przycisk = new JButton(zielone_jablko);
        kolor_jablka_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_jablka_przycisk.setMaximumSize(new Dimension(200,75));
        kolor_jablka_przycisk.addActionListener(zmienKolorJablkaZielony);


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

        panel_opcje.add(kolor_siatki_tytul);
        panel_opcje.add(kolor_siatki_przycisk);

        panel_opcje.add(kolor_glowy_weza_tytul);
        panel_opcje.add(kolor_glowy_weza_przycisk);

        panel_opcje.add(kolor_ciala_weza_tytul);
        panel_opcje.add(kolor_ciala_weza_przycisk);

        panel_opcje.add(kolor_jablka_tytul);
        panel_opcje.add(kolor_jablka_przycisk);

        panel_przycisk_powrotu.add(przycisk_powrotu);

        //lokalizacja paneli w JFrame
        this.add(panel_tytul,BorderLayout.NORTH);
        this.add(panel_opcje,BorderLayout.CENTER);
        this.add(panel_przycisk_powrotu,BorderLayout.SOUTH);
    }

    //SIATKI
    private class Niebieska implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiNiebieski);
            Snake.kolor_Siatki = 'c';
            kolor_siatki_przycisk.setText(czerwona_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiCzerwony);
        }
    }
    private class Czerwona implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiCzerwony);
            Snake.kolor_Siatki = 'z';
            kolor_siatki_przycisk.setText(zielona_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiZielony);
        }
    }
    private class Zielona implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiZielony);
            Snake.kolor_Siatki = 'b';
            kolor_siatki_przycisk.setText(biala_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiBialy);
        }
    }
    private class Biala implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiBialy);
            Snake.kolor_Siatki = '0';
            kolor_siatki_przycisk.setText(brak_siatki);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiBrak);
        }
    }

    private class Brak implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiBrak);
            Snake.kolor_Siatki = 'n';
            kolor_siatki_przycisk.setText(niebieska_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiNiebieski);
        }
    }

    //JABŁKA
    private class Zielone implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_jablka_przycisk.removeActionListener(zmienKolorJablkaZielony);
            Snake.kolor_Jablka = 'c';
            kolor_jablka_przycisk.setText(czerwone_jablko);
            kolor_jablka_przycisk.addActionListener(zmienKolorJablkaCzerwony);
        }
    }
    private class Czerwone implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorJablkaCzerwony);
            Snake.kolor_Jablka = 'z';
            kolor_jablka_przycisk.setText(zielone_jablko);
            kolor_jablka_przycisk.addActionListener(zmienKolorJablkaZielony);
        }
    }

    //GLOWA

    
    //CIALO
}