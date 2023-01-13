package phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SearchInHashTable {

    private long time;
    private int count;

    public void searchTable(ArrayList<String> find, Set<String> table) {

        long start;
        long end;

        start = System.currentTimeMillis();

        for (String s : find) {
            if (table.contains(s)) {
                this.count++;
            }
        }

        end = System.currentTimeMillis();

        this.time = end - start;
    }

    public long getTime() {
        return this.time;
    }

    public int getCount() {
        return this.count;
    }
}
