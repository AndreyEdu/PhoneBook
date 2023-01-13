package phonebook;

import java.util.ArrayList;

public class JumpSearch {

    private long time;
    private int count;

    public void jumpSearch(ArrayList<String> find, ArrayList<String> directory) {

        long start;
        long end;

        start = System.currentTimeMillis();

        int last = directory.size();
        int step = (int) Math.floor(Math.sqrt(last));

        for (String s : find) {
            int currentPosition = 0;
            int previousPosition = 0;
            while (directory.get(currentPosition).compareTo(s) < 0) {
                if (currentPosition == last) {
                    System.out.println("not found");
                }
                previousPosition = currentPosition;
                currentPosition = Math.min(currentPosition + step, last);
            }
            while (directory.get(currentPosition).compareTo(s) > 0) {
                currentPosition--;
                if (currentPosition <= previousPosition) {
                    System.out.println("not found");
                }
            }
            if (directory.get(currentPosition).compareTo(s) == 0) {
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
