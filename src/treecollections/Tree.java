package treecollections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * <p>
 * This class reads inputs from a text file and stores them into a hashmap,
 * the stored values are then sorted based on a rank hashmap and inserted into
 * a treecollections.Tree object, to preserve the insertion order we override the compare method
 * to remain true for every input.
 * </p>
 * @author Jfredricks
 * @version 1.0
 */
public class Tree
{
    public Map<String, String> hmap = new HashMap<>();
    public Set<String> ts = new TreeSet<>(new MyComparator());
    public Map<Integer, String> rank = new HashMap<>();

    /**
     * Creates treecollections.Tree object and calls the methods
     *
     * @param args is unused
     */
    public static void main(String[] args) {
        Tree t = new Tree();

        t.getTree();
        t.setTree();
        t.displayTree();
    }

    /**
     * Reads the contents of a text file and stores them in a HashMap as Key,Value pairs
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

    /**
     * Displays the tree object
     */
    public void displayTree() {
        System.out.println(ts);
    }

    /**
     * Sorts the HashMap values based on a rank HashMap and stores them in a treecollections.Tree object
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
                } else
                    continue;
            }
        }
    }
}

/**
 * Class which overrides compare method
 */
class MyComparator implements Comparator<String> {
    /**
     * Instead of comparing two strings we just make it return true for all values
     *
     * @param a is some String value
     * @param b is some String value
     * @return true always
     */
    @Override
    public int compare(String a, String b) {
        return 1;
    }
}