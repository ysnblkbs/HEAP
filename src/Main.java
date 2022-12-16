import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numberStrs = line.split(",");
        int[] numbers = new int[numberStrs.length];
        for(int i = 0;i < numberStrs.length;i++)
        {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }

       // int[] numbers = {10, 45, 9, 4, 23, 12, 2, 1};
      //int[] numbers = {1, 4, 2, 9, 45, 23, 12, 10};


        MinHeap minHeap = new MinHeap(numbers.length);

        boolean result = minHeap.checkTreeMinHeap(numbers);

        if (!result) {
            for (int n : numbers) {
                minHeap.insert(n);
            }
        } else {
            minHeap.setHeap(numbers);
        }

        minHeap.print();

    }
}