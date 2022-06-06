package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TopScore {
    static int topIndex = 0;
    static int topVaule = 0;
    static String topName;
    //funkcja zwracająca najlepszą wartość z pliku
    public static void top() throws FileNotFoundException {
        File file = new File("topscore.txt");
        Scanner scanner = new Scanner(file);
        //tablica na resztę informacji
        String[] strTab = new String[100];
        //tablica na punkty
        int[] intTab = new int[100];

        int index = 0;
        //do momentu aż jest następna linia
        while (scanner.hasNextLine()){
            //skanuj następną linię
            String line = scanner.nextLine();
            //podzieli po dwukropku
            String[] tokens = line.split(": ");
            //pierwsza część z podzielonych trafia do tablicy String'ów
            strTab[index] = tokens[0];
            //druga część z podzielonych trafia do tablicy int
            intTab[index] = Integer.parseInt(tokens[1]);
            index++;
        }
        for(int i = 0; i< intTab.length; i++){
            //jeżeli aktualna największa wartość jest mniejsza od aktualnie sprawdzanej wartości w tablicy int
            if(topVaule<intTab[i]){
                //zamień największą wartość na tą wartość
                topVaule = intTab[i];
                //ustaw, na którym jest to indeksie — tego chyba w końcu nie użyłem
                topIndex = i;
                //jako że obie tablice mają tyle samo pozycji do zapełnienia -> to indeksy będą się pokrywać
                topName = strTab[i];
            }
        }
    }
}
