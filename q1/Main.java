package q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static String processFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("call_of_the_wild.txt"));
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(processFile());
    }
}
