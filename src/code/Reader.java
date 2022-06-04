package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    public static String plikJakoTekst(String nazwaPliku) throws Exception {
        String dane = "";
        dane = new String(Files.readAllBytes(Paths.get(nazwaPliku)));
        return dane;
    }
}
