import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FCT {
    public static void main(String[] args) {
        String filename = "e:/Projects/File_Tree_Input.txt";
        String line;
        try {
            FileReader filereader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(filereader);
            try {
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                }
                buffer.close();
            } catch (Exception io) {
                System.out.println("Nothing to read");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");

        }
    }
}


