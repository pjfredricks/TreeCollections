import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return 1;
    }

}

public class Tree
{
    public Map<String, String> hmap = new HashMap<String, String>();
    public Set<String> ts = new TreeSet<String>(new MyComparator());
    public Map<Integer, String> rank = new HashMap<Integer, String>();

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

    public void dispTree() {
        System.out.println(ts);
    }

    public void settree() {
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

    public static void main(String[] args) {
        Tree t = new Tree();

        t.getTree();
        t.settree();
        t.dispTree();

    }
}
