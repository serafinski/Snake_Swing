package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Snake extends JPanel implements ActionListener {
    Image zielone_Jablko;
    Image czerwona_Glowa;

    Image czerwonyTuluw;
    public static final int SZEROKOSC_OKNA = 750;
    public static final int WYSOKOSC_OKNA = 750;

    public static final int POLE_POWIERZCHNI = SZEROKOSC_OKNA * WYSOKOSC_OKNA;

    //jeden kwadrat na ekranie
    public static final int JEDNOSTKA = 30;

    //ile kwadratów na ekranie
    public static final int WSZYSTKIE_JEDNOSTKI_GRY = POLE_POWIERZCHNI/JEDNOSTKA;

    //opóźnienie dla timer'a — manipulowanie predkoscia gry
    public static int OPOZNIENIE = 200;

    //tablica zbierajaca polozenie koordynatów koordynaty_x ciala naszego węża (włącznie z głową)
    //wielkosc tablicy ustawiamy na jednostki gry, bo wąż nie będzie nigdy większy niż sama gra
    public static final int[] koordynaty_x = new int[WSZYSTKIE_JEDNOSTKI_GRY];

    //tablica zbierajaca polozenie koordynatów koordynaty_y ciala naszego węża
    public static final int[] koordynaty_y = new int[WSZYSTKIE_JEDNOSTKI_GRY];

    //z iloma czesciami ma startowac nasz snake
    public static int czesci_ciala = 3;

    public static int punkty = 0;

    public static int polozenieXjablka;
    public static int polozenieYjablka;

    //P - dla prawo -> będzie zaczynał gre od chodzenia w gore
    public static char kierunek = 'P';

    //czy gra dziala
    public static boolean czy_dziala = false;

    //Timer by ustawić prędkość
    Timer timer;

    //Random, by wylosować pozycje jabłka
    Random random;

    Snake(){

        //import tekstur
        zielone_Jablko = new ImageIcon("src/zasoby/jablko.png").getImage();
        czerwona_Glowa = new ImageIcon("src/zasoby/red_head.jpg").getImage();
        czerwonyTuluw = new ImageIcon("src/zasoby/red_square.jpg").getImage();

        //losowe pozycje dla jabłka
        random = new Random();


        //ponieważ użyto pack -> to ustawi nam odpowiedni rozmiar
        this.setPreferredSize(new Dimension(SZEROKOSC_OKNA, WYSOKOSC_OKNA));
        this.setBackground(Color.BLACK);

        //bez tego trzeba kliknąć na okno by w ogóle można było zacząć sterować
        this.setFocusable(true);

        //klawisze sluzace do sterowania
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
        //gra zaczna się od dodania jablka do gry
        dodajJablko();
        czy_dziala = true;
        //dajemy this bo klasa implementuje action listener'a
        timer = new Timer(OPOZNIENIE,this);
        //uruchomienie timer'a
        timer.start();
    }

    public void paint (Graphics g){
        super.paint(g);

        if(czy_dziala){
            siatka(g);
            narysujJablko(g);
            waz(g);
            wynik(g);
        }
        else {
            koniecGry(g);
        }
    }

    //rysowanie siatki
    public void siatka(Graphics g) {
        for (int i = 0; i < WYSOKOSC_OKNA / JEDNOSTKA; i++) {
            g.drawLine(i * JEDNOSTKA, 0, i * JEDNOSTKA, WYSOKOSC_OKNA);
            g.drawLine(0, i * JEDNOSTKA, SZEROKOSC_OKNA, i * JEDNOSTKA);
            g.setColor(Color.BLUE);
        }
    }

    //rysowanie Jablka
    public void narysujJablko(Graphics g) {
        g.drawImage(zielone_Jablko,polozenieXjablka,polozenieYjablka,null);
    }

    //losowanie pozycji dla jablka
    public void dodajJablko(){
        polozenieXjablka = random.nextInt(SZEROKOSC_OKNA /JEDNOSTKA)*JEDNOSTKA;
        polozenieYjablka = random.nextInt(WYSOKOSC_OKNA /JEDNOSTKA)*JEDNOSTKA;
    }

    //rysowanie snake'a
    public void waz (Graphics g){
        for (int i = 0; i<czesci_ciala; i++){
            if (i == 0){
                g.drawImage(czerwona_Glowa,koordynaty_x[i],koordynaty_y[i],null);
            }
            else{
                g.drawImage(czerwonyTuluw,koordynaty_x[i],koordynaty_y[i],null);
            }
        }
    }

    //też do zmiany
    public void wynik (Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Jokerman",Font.PLAIN,30));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Wynik: "+ punkty,(SZEROKOSC_OKNA - metrics.stringWidth("Wynik: " + punkty))/2,g.getFont().getSize());
    }


    public void ruch(){
        //loop iterujący po ciele snake'a
        for(int i = czesci_ciala; i>0;i--){
            //przesunięcie koordynatów o 1
            koordynaty_x[i] = koordynaty_x[i-1];
            koordynaty_y[i] = koordynaty_y[i-1];
        }

        //switch odpowiedzialny za zmiane kierunkow
        switch (kierunek) {
            //głowa przejdzie do nastepnej pozycji
            case 'G' -> koordynaty_y[0] = koordynaty_y[0] - JEDNOSTKA;
            case 'D' -> koordynaty_y[0] = koordynaty_y[0] + JEDNOSTKA;
            case 'L' -> koordynaty_x[0] = koordynaty_x[0] - JEDNOSTKA;
            case 'P' -> koordynaty_x[0] = koordynaty_x[0] + JEDNOSTKA;
        }
    }

    public void sprawdzJablko(){
        //sprawdzamy koordynaty głowy weza i jablka
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
        for (int i = czesci_ciala;i>0;i--){
            //jeżeli głowa jest równa pozycją z indeksu i
            if((koordynaty_x[0] == koordynaty_x[i]) && (koordynaty_y[0] == koordynaty_y[i])){
                //koniec gry
                czy_dziala = false;
            }
        }

        //kolizja z bokiem okienka

        //LEWY BOK
        if((koordynaty_x[0]<0)){
            czy_dziala = false;
            timer.stop();
        }
        //PRAWY BOK
        if((koordynaty_x[0]>= SZEROKOSC_OKNA-JEDNOSTKA)){
            czy_dziala =false;
            timer.stop();
        }
        //GÓRNY BOK
        if((koordynaty_y[0]<0)){
            czy_dziala = false;
            timer.stop();
        }
        //DOLNY BOK
        if ((koordynaty_y[0]>= WYSOKOSC_OKNA-JEDNOSTKA)){
            czy_dziala = false;
            timer.stop();
        }
    }

    //to trzeba będzie zmienić
    public void koniecGry(Graphics g){
        JLabel text = new JLabel();
    }

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