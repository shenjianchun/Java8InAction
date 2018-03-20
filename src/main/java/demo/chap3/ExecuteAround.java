package demo.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    public static void main(String[] args) throws IOException {

        String result = processFileLimited();
        System.out.println(result);

        System.out.println("-----");


        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader  br = new BufferedReader(new FileReader("src/main/resources/lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader  br = new BufferedReader(new FileReader("src/main/resources/lambdasinaction/chap3/data.txt"))) {
            return p.process(br);
        }
    }


    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }
}
