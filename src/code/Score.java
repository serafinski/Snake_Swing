package code;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {

    JPanel panel_tekst;

    JPanel panel_wyniki;

    JPanel panel_przycisk_powrotu;

    Score() throws Exception {
        this.setLayout(new BorderLayout());
        this.setSize(750, 750);
        this.setTitle("Wyniki!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIconImage(MyWindow.logo.getImage());
        this.getContentPane().setBackground(Color.BLACK);


        wyniki();

        //this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void wyniki() throws Exception {
        //Panel
        panel_tekst = new JPanel();
        panel_wyniki = new JPanel();
        panel_przycisk_powrotu = new JPanel();

        //Layout
        panel_tekst.setLayout(new FlowLayout());
        panel_wyniki.setLayout(new FlowLayout());
        panel_przycisk_powrotu.setLayout(new FlowLayout());


        //Kolor
        panel_tekst.setBackground(Color.BLACK);
        panel_wyniki.setBackground(Color.BLACK);
        panel_przycisk_powrotu.setBackground(Color.BLACK);


        //Tekst
        JLabel tekst = new JLabel();
        tekst.setText("Ostatnie wyniki:");
        tekst.setForeground(Color.WHITE);
        tekst.setHorizontalAlignment(JLabel.CENTER);
        tekst.setVerticalAlignment(JLabel.TOP);
        tekst.setFont(new Font("Jokerman",Font.BOLD,70));

        //TextArea
        JTextArea textArea = new JTextArea(10,50);

        String data = Reader.plikJakoTekst("topscore.txt");
        textArea.setText(data);

        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Jokerman",Font.PLAIN,20));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700,350));

        //Najlepszy wynik
        JLabel bestScoreTitle = new JLabel();
        bestScoreTitle.setText("Najlepszy wynik:");
        bestScoreTitle.setForeground(Color.WHITE);
        bestScoreTitle.setHorizontalAlignment(JLabel.CENTER);
        bestScoreTitle.setVerticalAlignment(JLabel.TOP);
        bestScoreTitle.setFont(new Font("Jokerman",Font.BOLD,50));

        JLabel bestScore = new JLabel();
        TopScore.top();
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