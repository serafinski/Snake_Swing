package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Zapis {
    int top;
    public static void zapis(String imie ,int wynik) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("topscore.txt");
        zapis.println( imie + " - Wynik: " + String.valueOf(wynik));
        zapis.close();
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
