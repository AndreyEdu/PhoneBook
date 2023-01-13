package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> directory = new ArrayList<>();
        ArrayList<String> find = new ArrayList<>();


        String pathDirectory = "C:\\directory.txt";
        String pathFind = "C:\\find.txt";

        File fileD = new File(pathDirectory);
        File fileF = new File(pathFind);

        try (Scanner scanner = new Scanner(fileD);
             Scanner scan = new Scanner(fileF)) {
            while (scanner.hasNext()) {
                directory.add(scanner.nextLine());
            }
            while (scan.hasNext()) {
                find.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found:");
        }

        LinearSearch linearSearch = new LinearSearch();
        BubbleSort bubbleSort = new BubbleSort();
        JumpSearch jumpSearch = new JumpSearch();
        QuickSort quickSort = new QuickSort();
        BinarySearch binarySearch = new BinarySearch();
        HashTable hashTable = new HashTable();
        SearchInHashTable searchInHashTable = new SearchInHashTable();

        System.out.println("Start searching (linear search)...");
        linearSearch.linearSearch(find, directory);
        System.out.printf("Found %d / 500 entries. Time taken: %d min. %d sec. %d ms.\n", linearSearch.getCount(),
                linearSearch.getTime() / 60000,
                linearSearch.getTime() / 1000,
                linearSearch.getTime() % 1000);

        System.out.println("\nStart searching (bubble sort + jump search)...");
        ArrayList<String> list = bubbleSort.bubbleSort(directory, linearSearch.getTime());

        if (bubbleSort.getStop()) {
            System.out.printf("Found %d / 500 entries. Time taken: %d min. %d sec. %d ms.\n", linearSearch.getCount(),
                    (bubbleSort.getTime() + linearSearch.getTime()) / 60000,
                    (bubbleSort.getTime() + linearSearch.getTime()) / 1000,
                    (bubbleSort.getTime() + linearSearch.getTime()) % 1000);
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n",
                    bubbleSort.getTime() / 60000,
                    bubbleSort.getTime() / 1000,
                    bubbleSort.getTime() % 1000);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n",
                    linearSearch.getTime() / 60000,
                    linearSearch.getTime() / 1000,
                    linearSearch.getTime() % 1000);
        } else {
            jumpSearch.jumpSearch(find, list);

            System.out.printf("Found %d / 500 entries. Time taken: %d min. %d sec. %d ms.\n", jumpSearch.getCount(),
                    (bubbleSort.getTime() + jumpSearch.getTime()) / 60000,
                    (bubbleSort.getTime() + jumpSearch.getTime()) / 1000,
                    (bubbleSort.getTime() + jumpSearch.getTime()) % 1000);
            System.out.printf("Sorting time: %d min. %d sec. %d ms.\n",
                    bubbleSort.getTime() / 60000,
                    bubbleSort.getTime() / 1000,
                    bubbleSort.getTime() % 1000);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n",
                    jumpSearch.getTime() / 60000,
                    jumpSearch.getTime() / 1000,
                    jumpSearch.getTime() % 1000);
        }

        System.out.println("\nStart searching (quick sort + binary search)...");

        ArrayList<String> sort = quickSort.bodyQuickSort(directory);

        binarySearch.binarySearch(find, sort);

        System.out.printf("Found %d / 500 entries. Time taken: %d min. %d sec. %d ms.\n", binarySearch.getCount(),
                (quickSort.getTime() + binarySearch.getTime()) / 60000,
                (quickSort.getTime() + binarySearch.getTime()) / 1000,
                (quickSort.getTime() + binarySearch.getTime()) % 1000);
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n",
                quickSort.getTime() / 60000,
                quickSort.getTime() / 1000,
                quickSort.getTime() % 1000);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n",
                binarySearch.getTime() / 60000,
                binarySearch.getTime() / 1000,
                binarySearch.getTime() % 1000);





        System.out.println("\nStart searching (hash table)...");

        Set<String> table = hashTable.createTable(directory);

        searchInHashTable.searchTable(find, table);

        System.out.printf("Found %d / 500 entries. Time taken: %d min. %d sec. %d ms.\n", searchInHashTable.getCount(),
                (hashTable.getTime() + searchInHashTable.getTime()) / 60000,
                (hashTable.getTime() + searchInHashTable.getTime()) / 1000,
                (hashTable.getTime() + searchInHashTable.getTime()) % 1000);
        System.out.printf("Creating time: %d min. %d sec. %d ms.\n",
                hashTable.getTime() / 60000,
                hashTable.getTime() / 1000,
                hashTable.getTime() % 1000);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n",
                searchInHashTable.getTime() / 60000,
                searchInHashTable.getTime() / 1000,
                searchInHashTable.getTime() % 1000);
    }
}
