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

    //Glowa
    ActionListener zmienKolorGlowyCzerwony = new CzerwonaG();
    ActionListener zmienKolorGlowyZielonny = new ZielonaG();
    ActionListener zmienKolorGlowyNiebieski = new NiebieskaG();

    //Tuluw
    ActionListener zmienKolorTulowiaCzerwony = new CzerwonyT();
    ActionListener zmienKolorTulowiaZielony = new ZielonyT();
    ActionListener zmienKolorTulowiaNiebieski = new NiebieskiT();

    //Panele
    JPanel panel_tytul;

    JPanel panel_opcje;

    JPanel panel_przycisk_powrotu;

    Options(){
        this.setLayout(new BorderLayout());
        this.setSize(Snake.SZEROKOSC_OKNA, Snake.WYSOKOSC_OKNA);
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
        //Panele
        panel_tytul = new JPanel();
        panel_opcje = new JPanel();
        panel_przycisk_powrotu = new JPanel();

        //Layouty Paneli
        panel_tytul.setLayout(new FlowLayout());
        panel_opcje.setLayout(new BoxLayout(panel_opcje,BoxLayout.Y_AXIS));
        panel_przycisk_powrotu.setLayout(new FlowLayout());

        //Kolor Paneli
        panel_tytul.setBackground(Color.BLACK);
        panel_opcje.setBackground(Color.BLACK);
        panel_przycisk_powrotu.setBackground(Color.BLACK);

        //Główny tytuł
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
        kolor_siatki_przycisk.setFocusable(false);
        kolor_siatki_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_siatki_przycisk.setMaximumSize(new Dimension(200,75));
        kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiNiebieski);

        //WAZ GLOWA PRZYCISK
        kolor_glowy_weza_przycisk = new JButton(glowa_czerwony_waz);
        kolor_glowy_weza_przycisk.setForeground(Color.RED);
        kolor_glowy_weza_przycisk.setFocusable(false);
        kolor_glowy_weza_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_glowy_weza_przycisk.setMaximumSize(new Dimension(200,75));
        kolor_glowy_weza_przycisk.addActionListener(zmienKolorGlowyCzerwony);

        //WAZ CIALO PRZYCISK
        kolor_ciala_weza_przycisk = new JButton(cialo_czerwony_waz);
        kolor_ciala_weza_przycisk.setForeground(Color.RED);
        kolor_ciala_weza_przycisk.setFocusable(false);
        kolor_ciala_weza_przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);
        kolor_ciala_weza_przycisk.setMaximumSize(new Dimension(200,75));
        kolor_ciala_weza_przycisk.addActionListener(zmienKolorTulowiaCzerwony);

        //JABLKO PRZYCISK
        kolor_jablka_przycisk = new JButton(zielone_jablko);
        kolor_jablka_przycisk.setForeground(Color.GREEN);
        kolor_jablka_przycisk.setFocusable(false);
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
        //na podstawie research'u - 1 z 3 metod zmieniania wielkości honorowana przez BoxLayout
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

    //SIATKI LISTENERY
    private class Niebieska implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiNiebieski);
            Snake.kolor_Siatki = 'c';
            kolor_siatki_przycisk.setForeground(Color.RED);
            kolor_siatki_przycisk.setText(czerwona_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiCzerwony);
        }
    }
    private class Czerwona implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiCzerwony);
            Snake.kolor_Siatki = 'z';
            kolor_siatki_przycisk.setForeground(Color.GREEN);
            kolor_siatki_przycisk.setText(zielona_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiZielony);
        }
    }
    private class Zielona implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiZielony);
            Snake.kolor_Siatki = 'b';
            kolor_siatki_przycisk.setForeground(Color.GRAY);
            kolor_siatki_przycisk.setText(biala_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiBialy);
        }
    }
    private class Biala implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiBialy);
            Snake.kolor_Siatki = '0';
            kolor_siatki_przycisk.setForeground(Color.BLACK);
            kolor_siatki_przycisk.setText(brak_siatki);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiBrak);
        }
    }

    private class Brak implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_siatki_przycisk.removeActionListener(zmienKolorSiatkiBrak);
            Snake.kolor_Siatki = 'n';
            kolor_siatki_przycisk.setForeground(Color.BLUE);
            kolor_siatki_przycisk.setText(niebieska_siatka);
            kolor_siatki_przycisk.addActionListener(zmienKolorSiatkiNiebieski);
        }
    }

    //JABŁKA LISTENERY
    private class Zielone implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_jablka_przycisk.removeActionListener(zmienKolorJablkaZielony);
            Snake.kolor_Jablka = 'c';
            kolor_jablka_przycisk.setForeground(Color.RED);
            kolor_jablka_przycisk.setText(czerwone_jablko);
            kolor_jablka_przycisk.addActionListener(zmienKolorJablkaCzerwony);
        }
    }
    private class Czerwone implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_jablka_przycisk.removeActionListener(zmienKolorJablkaCzerwony);
            Snake.kolor_Jablka = 'z';
            kolor_jablka_przycisk.setForeground(Color.GREEN);
            kolor_jablka_przycisk.setText(zielone_jablko);
            kolor_jablka_przycisk.addActionListener(zmienKolorJablkaZielony);
        }
    }

    //GLOWA LISTENERY
    private class CzerwonaG implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_glowy_weza_przycisk.removeActionListener(zmienKolorGlowyCzerwony);
            Snake.kolor_Glowy = 'z';
            kolor_glowy_weza_przycisk.setForeground(Color.GREEN);
            kolor_glowy_weza_przycisk.setText(glowa_zielony_waz);
            kolor_glowy_weza_przycisk.addActionListener(zmienKolorGlowyZielonny);
        }
    }
    private class ZielonaG implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_glowy_weza_przycisk.removeActionListener(zmienKolorGlowyZielonny);
            Snake.kolor_Glowy = 'n';
            kolor_glowy_weza_przycisk.setForeground(Color.BLUE);
            kolor_glowy_weza_przycisk.setText(glowa_niebieski_waz);
            kolor_glowy_weza_przycisk.addActionListener(zmienKolorGlowyNiebieski);
        }
    }
    private class NiebieskaG implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_glowy_weza_przycisk.removeActionListener(zmienKolorGlowyNiebieski);
            Snake.kolor_Glowy = 'c';
            kolor_glowy_weza_przycisk.setForeground(Color.RED);
            kolor_glowy_weza_przycisk.setText(glowa_czerwony_waz);
            kolor_glowy_weza_przycisk.addActionListener(zmienKolorGlowyCzerwony);
        }
    }

    //CIALO LISTENERY
    private class CzerwonyT implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_ciala_weza_przycisk.removeActionListener(zmienKolorTulowiaCzerwony);
            Snake.kolor_Ciala = 'z';
            kolor_ciala_weza_przycisk.setForeground(Color.GREEN);
            kolor_ciala_weza_przycisk.setText(cialo_zielony_waz);
            kolor_ciala_weza_przycisk.addActionListener(zmienKolorTulowiaZielony);
        }
    }
    private class ZielonyT implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_ciala_weza_przycisk.removeActionListener(zmienKolorTulowiaZielony);
            Snake.kolor_Ciala = 'n';
            kolor_ciala_weza_przycisk.setForeground(Color.BLUE);
            kolor_ciala_weza_przycisk.setText(cialo_niebieski_waz);
            kolor_ciala_weza_przycisk.addActionListener(zmienKolorTulowiaNiebieski);
        }
    }
    private class NiebieskiT implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kolor_ciala_weza_przycisk.removeActionListener(zmienKolorTulowiaNiebieski);
            Snake.kolor_Ciala = 'c';
            kolor_ciala_weza_przycisk.setForeground(Color.RED);
            kolor_ciala_weza_przycisk.setText(cialo_czerwony_waz);
            kolor_ciala_weza_przycisk.addActionListener(zmienKolorTulowiaCzerwony);
        }
    }
}
