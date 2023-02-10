package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileReader {

    public String[] read(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            String input = sc.nextLine();
            return input.split(" ");
        } catch (FileNotFoundException e) {
            throw new InputParserException("Cannot read from file: '" + path + "'", e);
        }
    }
}
