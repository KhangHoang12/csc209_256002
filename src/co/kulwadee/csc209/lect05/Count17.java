package co.kulwadee.csc209.lect05;

public class Count17 {
    // count the number of times 17 appears in arr[index:..]
    public static int count17(int[] arr, int index) {
        if (index >= arr.length) return 0;

        if (arr[index] == 17) {
            return 1 + count17(arr, index+1);
        } else {
            return 0 + count17(arr, index+1);
        }
    }
    public static void main(String... args) {
        int[] arr1 = {17, 1, 2, 17};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4, 17, 0};
        System.out.println("[17, 1, 2, 17] : count17() = " + count17(arr1, 0));
        System.out.println("[1, 2, 3, 4] : count17() = " + count17(arr2, 0));
        System.out.println("[1, 2, 3, 4, 17, 0] : count17() = " + count17(arr3, 0));
    }
}
