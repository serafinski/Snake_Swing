package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TopScore {
    static int topIndex = 0;
    static int topVaule=0;
    static String topName;

    public static void top() throws FileNotFoundException {
        File file = new File("topscore.txt");
        Scanner scanner = new Scanner(file);
        String[] strTab = new String[100];
        int[] intTab = new int[100];
        int index = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.split(": ");
            strTab[index] = tokens[0];
            intTab[index] = Integer.parseInt(tokens[1]);
            index++;
        }
        for(int i = 0; i< intTab.length; i++){
            if(topVaule<intTab[i]){
                topVaule = intTab[i];
                topIndex = i;
                topName = strTab[i];
            }
        }
    }
}
