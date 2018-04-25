import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FCT {
    /*
     * A method to read the text file line by line
     */
    public void getTree() {
        // The path to the text file from which we need to read inputs
        String filename = "e:/Projects/File_Tree_Input.txt";
        String line;
        try {
            FileReader filereader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(filereader);
            try {
                // Reads the file till the end of each line
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                }
                buffer.close();
            }
            // Exception if the file is empty
            catch (Exception io) {
                System.out.println("Nothing to read");
            }
        }
        // Exception if the file does not exist
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");

        }
    }
}


