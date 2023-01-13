package phonebook;

import java.util.*;

public class HashTable {

    private long time;


    public Set<String> createTable(ArrayList<String> directory) {
        long start;
        long end;

        Set<String> table = new HashSet<>();
        Set<String> in = new HashSet<>();

        for (String s : directory) {
            String k = s.replaceAll("\\d", "").trim();
            in.add(k);
        }

        start = System.currentTimeMillis();

        for (String s : in) {
            table.add(s);
        }

        end = System.currentTimeMillis();

        this.time = end - start;

        return table;
    }

    public long getTime() {
        return time;
    }
}
