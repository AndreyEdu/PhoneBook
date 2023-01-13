package phonebook;

import java.util.ArrayList;

public class QuickSort {

    private long time;

    public ArrayList<String> bodyQuickSort(ArrayList<String> directory) {
        long start;
        long end;

        ArrayList<String> quickSort = new ArrayList<>();

        for (String s: directory) {
            quickSort.add(s.replaceAll("\\d", "").trim());
        }

        start = System.currentTimeMillis();

        int low = 0;
        int high = directory.size() - 1;

        quickSort(quickSort, low, high);

        end = System.currentTimeMillis();

        this.time = end - start;

        return quickSort;
    }

    public static ArrayList<String> quickSort(ArrayList<String> directory, int low, int high) {
        if (directory.size() == 0)
            return directory;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return directory;//завершить выполнение если уже нечего делить

        String pivot = directory.get(high);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (directory.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (directory.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                String temp = directory.get(i);
                directory.set(i, directory.get(j));
                directory.set(j, temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(directory, low, j);

        if (high > i)
            quickSort(directory, i, high);
        return directory;
    }

    public long getTime() {
        return time;
    }
}
