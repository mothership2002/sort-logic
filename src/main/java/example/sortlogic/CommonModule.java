package example.sortlogic;

import java.util.Arrays;

public class CommonModule {

    private static CommonModule cm;

    public static CommonModule getInstance(){
        if(cm == null){
            cm = new CommonModule();
        }
        return cm;
    }

    public int[] randomNumber() {

        int[] numberArray = new int[9];
        System.out.println("정렬 전");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = 1 + (int) Math.round(Math.random() * 6);
        }
        System.out.println(Arrays.toString(numberArray));
        System.out.println();
        return numberArray;
    }

    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void endSort(int[] arr) {
        System.out.println();
        System.out.println("정렬 후");
        printArray(arr);
    }

    public void swap(int[] arr, int high, int low) {
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }

    public void time(long beforeTime){
        long afterTime = System.currentTimeMillis();
        System.out.println("소요시간 : " + (afterTime - beforeTime) + "ms" );
    }
}
