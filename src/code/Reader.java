package code;

import java.nio.file.Files;
import java.nio.file.Paths;

//klasa posiadająca metodę
public class Reader {
    //metoda pozwalająca czytać cały tekst z pliku i przerobić go na String
    public static String plikJakoTekst(String nazwaPliku) throws Exception {
        String dane = "";
        dane = new String(Files.readAllBytes(Paths.get(nazwaPliku)));
        return dane;
    }
}
