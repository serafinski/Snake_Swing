package code;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    //Panele
    JPanel panel_tekst;

    JPanel panel_wyniki;

    JPanel panel_przycisk_powrotu;

    Score() throws Exception {
        this.setLayout(new BorderLayout());
        this.setSize(Snake.SZEROKOSC_OKNA, Snake.WYSOKOSC_OKNA);
        this.setTitle("Wyniki!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(MyWindow.logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);


        wyniki();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void wyniki() throws Exception {
        //Panele
        panel_tekst = new JPanel();
        panel_wyniki = new JPanel();
        panel_przycisk_powrotu = new JPanel();

        //Layouty Paneli
        panel_tekst.setLayout(new FlowLayout());
        panel_wyniki.setLayout(new FlowLayout());
        panel_przycisk_powrotu.setLayout(new FlowLayout());


        //Kolory Paneli
        panel_tekst.setBackground(Color.BLACK);
        panel_wyniki.setBackground(Color.BLACK);
        panel_przycisk_powrotu.setBackground(Color.BLACK);


        //Główny Tytuł
        JLabel tekst = new JLabel();
        tekst.setText("Ostatnie wyniki:");
        tekst.setForeground(Color.WHITE);
        tekst.setHorizontalAlignment(JLabel.CENTER);
        tekst.setVerticalAlignment(JLabel.TOP);
        tekst.setFont(new Font("Jokerman",Font.BOLD,70));

        //TextArea
        JTextArea textArea = new JTextArea(10,50);

        //Użycie funkcji z klasy Reader do zamiany tekstu z pliku na String
        String data = Reader.plikJakoTekst("topscore.txt");
        //ustawienie tekstu uzyskanego z funkcji jako tekst w JTextArea
        textArea.setText(data);

        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Jokerman",Font.PLAIN,20));
        //uniemożliwienie edycji danych w TextArea
        textArea.setEditable(false);

        //zagnieżdżenie JTextArea w JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700,350));

        //Tytuł — Najlepszy wynik
        JLabel bestScoreTitle = new JLabel();
        bestScoreTitle.setText("Najlepszy wynik:");
        bestScoreTitle.setForeground(Color.WHITE);
        bestScoreTitle.setHorizontalAlignment(JLabel.CENTER);
        bestScoreTitle.setVerticalAlignment(JLabel.TOP);
        bestScoreTitle.setFont(new Font("Jokerman",Font.BOLD,50));

        //Faktyczny najlepszy wynik
        JLabel bestScore = new JLabel();
        //aktywacja funkcji w celu zaczytania danych
        TopScore.top();
        //wyświetlanie wyniku
        bestScore.setText(TopScore.topName + ": " + String.valueOf(TopScore.topVaule));
        bestScore.setForeground(Color.WHITE);
        bestScore.setHorizontalAlignment(JLabel.CENTER);
        bestScore.setVerticalAlignment(JLabel.TOP);
        bestScore.setFont(new Font("Jokerman",Font.BOLD,35));

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
        panel_tekst.add(tekst);
        panel_wyniki.add(scrollPane);
        panel_wyniki.add(bestScoreTitle);
        panel_wyniki.add(bestScore);
        panel_przycisk_powrotu.add(przycisk_powrotu);

        //lokalizacja paneli w JFrame
        this.add(panel_tekst,BorderLayout.NORTH);
        this.add(panel_wyniki, BorderLayout.CENTER);
        this.add(panel_przycisk_powrotu,BorderLayout.SOUTH);
    }
}