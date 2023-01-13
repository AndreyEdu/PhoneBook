package phonebook;

import java.util.ArrayList;

public class BubbleSort {

    private long time;
    private boolean stop;

    public ArrayList<String> bubbleSort(ArrayList<String> directory, long time) {
        long start;
        long end;

        ArrayList<String> bubbleSort = new ArrayList<>();

        for (String s: directory) {
            bubbleSort.add(s.replaceAll("\\d", "").trim());
        }

        start = System.currentTimeMillis();

        int length = bubbleSort.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (bubbleSort.get(j).compareTo(bubbleSort.get(j + 1)) > 0) {
                    String change = bubbleSort.get(j);
                    bubbleSort.set(j, bubbleSort.get(j + 1));
                    bubbleSort.set(j + 1, change);
                }
            }
            end = System.currentTimeMillis();
            if (end - start > time * 10) {
                this.time = end - start;
                this.stop = true;
                break;
            }
        }

        end = System.currentTimeMillis();

        this.time = end - start;

        return bubbleSort;
    }

    public long getTime() {
        return time;
    }

    public boolean getStop() {
        return this.stop;
    }
}
