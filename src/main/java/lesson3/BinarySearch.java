package lesson3;

public class BinarySearch {
    public static int search(Integer [] arr, int num) {
        int start = 0;
        int end = arr.length;
        int current;

        while (start <= end) {
            current = (end + start) / 2;
            if (arr[current] == num) {
                return current;
            }
            else if (arr[current] < num) {
                start = current + 1;
            } else {
                end = current - 1 ;
            }
        }
        return -1;
    }
}
