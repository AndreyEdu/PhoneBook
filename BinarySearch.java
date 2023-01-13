package phonebook;

import java.util.ArrayList;

public class BinarySearch {

    private long time;
    private int count;

    public void binarySearch(ArrayList<String> find, ArrayList<String> directory) {

        long start;
        long end;

        start = System.currentTimeMillis();

        for (String s : find) {
            int left = 0;
            int right = directory.size() - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (directory.get(middle).compareTo(s) == 0) {
                    this.count++;
                    break;
                } else if (directory.get(middle).compareTo(s) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
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
