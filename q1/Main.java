package q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static List<String> processFile(BufferReaderProcessor p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("call_of_the_wild.txt"));
        List<String> words = new ArrayList<>();
        String line;
        while((line = p.process(br)) != null) {
            String[] wordsList = line.trim().split(" ");
            for(String word : wordsList) {
                if (word.trim().length() != 0) {
                    words.add(word.trim());
                }
            }
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
        List<String> words = processFile(BufferedReader::readLine);
        words.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(words.get(0));
    }
}

@FunctionalInterface
interface BufferReaderProcessor {
    String process(BufferedReader b) throws IOException;
}