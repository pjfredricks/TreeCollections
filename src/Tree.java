import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/*
 * Overrides the compare method to retain insertion order
 */
class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return 1;
    }

}

public class Tree
{
    public Map<String, String> hmap = new HashMap<>();
    public Set<String> ts = new TreeSet<>(new MyComparator());
    public Map<Integer, String> rank = new HashMap<>();

    public static void main(String[] args) {
        Tree t = new Tree();

        t.getTree();
        t.setTree();
        t.displayTree();

    }

    /*
     * Reads the text file and stores the name,designations in a HashMap
     */
    public void getTree() {
        String filename = "e:/File_Tree_Input.txt";
        String line;

        try {
            FileReader filereader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(filereader);
            try {
                while ((line = buffer.readLine()) != null) {
                    String[] split = line.split(",");
                    String name = split[0];
                    String designation = split[1].trim();
                    hmap.put(name, designation);
                }
                buffer.close();
            } catch (Exception io) {
                System.out.println("Nothing to read");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    /*
     * Displays the contents of the Tree
     */
    public void displayTree() {
        System.out.println(ts);
    }

    /*
     * Compares the HashMap with a ranking HashMap and inserts into the TreeSet in ascending order of Ranking
     */
    public void setTree() {
        rank.put(1, "Chief Executive Officer");
        rank.put(2, "Vice President");
        rank.put(3, "Associate Vice President");
        rank.put(4, "Senior Manager - Projects");
        rank.put(5, "Manager - Projects");
        rank.put(6, "Architect");
        rank.put(7, "Associate");

        for (Map.Entry<Integer, String> m : rank.entrySet()) {
            for (Map.Entry<String, String> m2 : hmap.entrySet()) {
                if (m.getValue().equals(m2.getValue())) {
                    ts.add(m2.getKey());
                    //System.out.println(m2.getKey());
                } else
                    continue;
            }
        }
    }
}
