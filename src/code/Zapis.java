package code;

import java.io.*;


public class Zapis {
    //funkcja służąca do zapisu wyniku do pliku z wynikami
    public static void zapis(String imie ,int wynik) throws IOException {
        FileWriter zapis = new FileWriter("topscore.txt",true);
        //opakowujemy w printWriter'a bo ma metodę println
        PrintWriter pw = new PrintWriter(zapis);
        pw.println(imie + " - Wynik: " + String.valueOf(wynik));
        zapis.close();
        pw.close();
    }
}
