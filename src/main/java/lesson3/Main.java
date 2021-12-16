package lesson3;

public class Main {

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer arr1[] = {1, 2, 3, 4, 5, 6,  7, 8, 9, 10, 12};

        Integer arr2[] = {1, 2, 3, 4, 5, 7, 8, 9, 10, 12};

        System.out.println(findMissedNum(arr1, 1));
    }

    public static final int findMissedNum(Integer [] arr, int elementStep) {

        int start = 0;
        int end = arr.length - 1;
        int current;

        while (start <= end) {
            current = (end + start) / 2;
            if (arr[0] != 1) {
                return 1;
            } else if (arr[current] - arr[current - 1] > elementStep) {
                return current + 1;
            } else if (current == arr[current - 1]) {
                start = current + 1;
            } else {
                end = current - 1;
            }
        }
        return -1;
    }
}
