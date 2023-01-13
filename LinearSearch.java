package phonebook;

import java.util.ArrayList;

public class LinearSearch {

    private long time;
    private int count;

    public void linearSearch(ArrayList<String> find, ArrayList<String> directory) {

        long start;
        long end;

        start = System.currentTimeMillis();

        for (String s : find) {
            for (String d : directory) {
                if (d.contains(s)) {
                    this.count++;
                    break;
                }
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
