package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Save {
    int top;

    public void save(int x){
        try {
            PrintWriter zapis = new PrintWriter("wyniki.txt");
            zapis.println(String.valueOf(x));
            zapis.close();
        } catch (FileNotFoundException e) {

        }
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void makeTop() throws FileNotFoundException {
        File file = new File("top.txt");
        Scanner in = new Scanner(file);
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {

        }

        top = parseInt(in.nextLine());
    }

    public int getTop() {
        return top;
    }
}
