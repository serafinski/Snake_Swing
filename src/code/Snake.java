package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Snake extends JPanel implements ActionListener {
    //TEKSTURY JABLKO
    Image zielone_Jablko;
    Image czerwone_Jablko;


    //TEKSTURY WĄŻ
    Image czerwona_Glowa;
    Image czerwonyTuluw;

    Image zielonaGlowa;
    Image zielonyTuluw;

    Image niebieskaGlowa;
    Image niebieskiTuluw;

    //TEKSTURY SIATKA
    Image niebieska_Siatka;
    Image czerwona_Siatka;
    Image zielona_Siatka;
    Image biala_Siatka;

    //wymiary okna
    public static final int SZEROKOSC_OKNA = 750;
    public static final int WYSOKOSC_OKNA = 750;

    static final int POLE_POWIERZCHNI = SZEROKOSC_OKNA * WYSOKOSC_OKNA;

    //jeden kwadrat na ekranie
    static final int JEDNOSTKA = 30;

    //ile kwadratów na ekranie
    static final int WSZYSTKIE_JEDNOSTKI_GRY = POLE_POWIERZCHNI/JEDNOSTKA;

    //opóźnienie dla timer'a — manipulowanie prędkością gry
    static int OPOZNIENIE = 200;


    //wielkość tablicy ustawiamy na jednostki gry, bo wąż nie będzie nigdy większy niż sama gra

    //tablica zbierającą położenie koordynatów x ciała naszego węża (włącznie z głową)
    static final int[] koordynaty_x = new int[WSZYSTKIE_JEDNOSTKI_GRY];

    //tablica zbierającą położenie koordynatów y ciała naszego węża (włącznie z głową)
    static final int[] koordynaty_y = new int[WSZYSTKIE_JEDNOSTKI_GRY];

    //z iloma częściami ma startować nasz snake
    static int czesci_ciala = 3;

    static int punkty = 0;

    //losowane położenia x i y jabłka
    static int polozenieXjablka;
    static int polozenieYjablka;

    //D - do dołu -> będzie zaczynał gre od chodzenia w dół
    static char kierunek = 'D';

    //czy gra działa — początkowo nie
    static boolean czy_dziala = false;

    //zmienne do switch'y — kwestia panelu z opcjami
    public static char kolor_Siatki;

    public static char kolor_Jablka;

    public static char kolor_Glowy;

    public static char kolor_Ciala;

    //Timer, by ustawić prędkość
    Timer timer;

    //Random, by wylosować pozycje jabłka
    Random random;

    Snake(){

        //import tekstur

        //jablka
        zielone_Jablko = new ImageIcon("src/zasoby/green_jablko.png").getImage();
        czerwone_Jablko = new ImageIcon("src/zasoby/red_jablko.png").getImage();

        //waz
        czerwona_Glowa = new ImageIcon("src/zasoby/red_glowa.jpg").getImage();
        czerwonyTuluw = new ImageIcon("src/zasoby/red_cialo.jpg").getImage();

        niebieskaGlowa = new ImageIcon("src/zasoby/blue_glowa.jpg").getImage();
        niebieskiTuluw = new ImageIcon("src/zasoby/blue_cialo.jpg").getImage();

        zielonaGlowa = new ImageIcon("src/zasoby/green_glowa.jpg").getImage();
        zielonyTuluw = new ImageIcon("src/zasoby/green_cialo.jpg").getImage();

        //siatki
        niebieska_Siatka = new ImageIcon("src/zasoby/blue_grid.jpg").getImage();
        czerwona_Siatka = new ImageIcon("src/zasoby/red_grid.jpg").getImage();
        zielona_Siatka = new ImageIcon("src/zasoby/green_grid.jpg").getImage();
        biala_Siatka = new ImageIcon("src/zasoby/white_grid.jpg").getImage();

        //losowe pozycje dla jabłka
        random = new Random();


        //ponieważ w Game użyto pack -> to ustawi nam odpowiedni rozmiar
        this.setPreferredSize(new Dimension(SZEROKOSC_OKNA, WYSOKOSC_OKNA));
        this.setBackground(Color.BLACK);

        //bez tego trzeba kliknąć na okno by w ogóle można było zacząć sterować
        this.setFocusable(true);

        //klawisze służące do sterowania
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //ograniczamy możliwość zrobienia obrotu o 180 stopni
                switch (e.getKeyCode()){

                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if(kierunek != 'P'){
                            kierunek = 'L';
                        }
                        break;

                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if(kierunek != 'L'){
                            kierunek = 'P';
                        }
                        break;

                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        if (kierunek != 'D'){
                            kierunek = 'G';
                        }
                        break;

                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if(kierunek != 'G'){
                            kierunek = 'D';
                        }
                        break;
                    //debug option
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        startGry();
    }

    //inicjalizacja gry
    public void startGry(){
        //gra zaczyna się od dodania jabłka do gry
        dodajJablko();
        //zmiana czy działa na true
        czy_dziala = true;
        //dajemy this bo klasa implementuje action listener'a
        timer = new Timer(OPOZNIENIE,this);
        //uruchomienie timer'a
        timer.start();
    }

    public void paint (Graphics g){
        super.paint(g);


        if(czy_dziala){
            narysujSiatke(g);
            narysujJablko(g);
            waz(g);
        }
        else {
            try {
                koniecGry();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //rysowanie siatki
    public void narysujSiatke(Graphics g){
        //switch do wyboru koloru siatki
        switch(kolor_Siatki) {
            default:
                g.drawImage(niebieska_Siatka, 0, 0, null);
                break;
            case 'c':
                g.drawImage(czerwona_Siatka,0,0,null);
                break;
            case 'z':
                g.drawImage(zielona_Siatka,0,0,null);
                break;
            case 'b':
                g.drawImage(biala_Siatka,0,0,null);
                break;
            case '0':
                break;
            case 'n':
                g.drawImage(niebieska_Siatka, 0, 0, null);
                break;
        }
    }

    //rysowanie Jablka
    public void narysujJablko(Graphics g) {
        //switch do wyboru koloru jabłka
        switch (kolor_Jablka){
            default -> g.drawImage(zielone_Jablko,polozenieXjablka,polozenieYjablka,null);
            case 'c' -> g.drawImage(czerwone_Jablko,polozenieXjablka,polozenieYjablka,null);
            case 'g' -> g.drawImage(zielone_Jablko,polozenieXjablka,polozenieYjablka,null);
        }
    }

    //losowanie pozycji dla jabłka
    public void dodajJablko(){
        polozenieXjablka = random.nextInt(SZEROKOSC_OKNA /JEDNOSTKA)*JEDNOSTKA;
        polozenieYjablka = random.nextInt(WYSOKOSC_OKNA /JEDNOSTKA)*JEDNOSTKA;
    }

    //rysowanie snake'a
    public void waz (Graphics g){
        for (int i = 0; i<czesci_ciala; i++){
            if (i == 0){
                //switch do wyboru koloru głowy snake'a
                switch (kolor_Glowy){
                    default -> g.drawImage(czerwona_Glowa,koordynaty_x[i],koordynaty_y[i], null);
                    case 'n' -> g.drawImage(niebieskaGlowa,koordynaty_x[i],koordynaty_y[i],null);
                    case 'z' -> g.drawImage(zielonaGlowa,koordynaty_x[i],koordynaty_y[i],null);
                    case 'c' -> g.drawImage(czerwona_Glowa,koordynaty_x[i],koordynaty_y[i], null);

                }
            }
            else{
                //switch do wyboru koloru ciała snake'a
                switch (kolor_Ciala){
                    default -> g.drawImage(czerwonyTuluw,koordynaty_x[i],koordynaty_y[i],null);
                    case 'n' -> g.drawImage(niebieskiTuluw,koordynaty_x[i],koordynaty_y[i],null);
                    case 'z' -> g.drawImage(zielonyTuluw,koordynaty_x[i],koordynaty_y[i],null);
                    case 'c' -> g.drawImage(czerwonyTuluw,koordynaty_x[i],koordynaty_y[i],null);
                }
            }
        }
    }

    public void ruch(){
        //loop iterujący po ciele snake'a - aż przeiteruje po całym
        for(int i = czesci_ciala; i>0;i--){
            //przesunięcie koordynatów każdego z elementów ciała węża o 1
            koordynaty_x[i] = koordynaty_x[i-1];
            koordynaty_y[i] = koordynaty_y[i-1];
        }

        //switch odpowiedzialny za zmianę kierunków
        switch (kierunek) {
            //głowa przejdzie do następnej pozycji
            case 'G' -> koordynaty_y[0] = koordynaty_y[0] - JEDNOSTKA;
            case 'D' -> koordynaty_y[0] = koordynaty_y[0] + JEDNOSTKA;
            case 'L' -> koordynaty_x[0] = koordynaty_x[0] - JEDNOSTKA;
            case 'P' -> koordynaty_x[0] = koordynaty_x[0] + JEDNOSTKA;
        }
    }

    public void sprawdzJablko(){
        //sprawdzamy koordynaty głowy węża i jabłka

        //jeżeli się zgodzą
        if((koordynaty_x[0] == polozenieXjablka) && (koordynaty_y[0] == polozenieYjablka)){
            czesci_ciala++;
            punkty += 10;

            //za każdym stworzeniem jabłka aż opóźnienie będzie 10
            if(OPOZNIENIE>10){
                //zmniejszamy opóźnienie
                OPOZNIENIE=OPOZNIENIE-5;
                //restart timera
                timer.stop();
                timer = new Timer(OPOZNIENIE,this);
                timer.start();
            }

            //dodajemy nowe jabłko
            dodajJablko();
        }
    }

    public void kolizja(){
        //czy głowa weszła w kolizje z ciałem
        //loop iterujący po ciele snake'a — aż przeiteruje po całym
        for (int i = czesci_ciala;i>0;i--){
            //jeżeli głowa jest równa pozycji z indeksu i — oznacza to, że głowa weszła w ciało
            if ((koordynaty_x[0] == koordynaty_x[i]) && (koordynaty_y[0] == koordynaty_y[i])) {
                //koniec gry
                czy_dziala = false;
                break;
            }
        }

        //Kolizje z bokiem okienka

        //LEWY BOK
        if((koordynaty_x[0]<0)){
            czy_dziala = false;
            timer.stop();
        }
        //PRAWY BOK
        if((koordynaty_x[0]> SZEROKOSC_OKNA-JEDNOSTKA)){
            czy_dziala =false;
            timer.stop();
        }
        //GÓRNY BOK
        if((koordynaty_y[0]<0)){
            czy_dziala = false;
            timer.stop();
        }
        //DOLNY BOK
        if ((koordynaty_y[0]> WYSOKOSC_OKNA-JEDNOSTKA)){
            czy_dziala = false;
            timer.stop();
        }
    }

    //Koniec gry
    public void koniecGry() throws FileNotFoundException {
        this.setFocusable(false);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie: ");
        String imie = scanner.nextLine();

        try {
            //użyj funkcji zapis z klasy Zapis
            Zapis.zapis(imie,punkty);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Twoj wynik to: " + punkty + " pkt!");
        //aktywacja funkcji top — wydaje mi się, że nie potrzebne (pozostałość po ew. porównywaniu wyniku)
        TopScore.top();

        //zamyka program
        System.exit(0);

    }
    //repaint przy podanych przypadkach
    @Override
    public void actionPerformed(ActionEvent e) {
        if(czy_dziala){
            ruch();
            sprawdzJablko();
            kolizja();
        }
        repaint();
    }

}