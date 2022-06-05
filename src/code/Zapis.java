package code;

import java.io.*;


public class Zapis {
    int top;
    public static void zapis(String imie ,int wynik) throws IOException {
        FileWriter zapis = new FileWriter("topscore.txt",true);
        PrintWriter pw = new PrintWriter(zapis);
        pw.println(imie + " - Wynik: " + String.valueOf(wynik));
        //zapis.write( imie + " - Wynik: " + String.valueOf(wynik));
        //zapis.write("\n");
        zapis.close();
        pw.close();
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
