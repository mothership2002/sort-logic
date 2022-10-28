package example.sortlogic;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortLogicApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortLogicApplication sa = new SortLogicApplication();
        int a = -1;

        while (a != 99) {
            sa.print();
            try {
                a = sc.nextInt();
                System.out.println("");
                sa.mainFrame(a);
                System.out.println("");
            } catch (InputMismatchException e) {
                System.err.println("예외");
                System.out.println();
                System.out.println();
                sc = new Scanner(System.in);
            }
        }
    }

    /**
     * 화면 출력
     */
    private void print() {
        System.out.println("정렬 번호 입력");
        System.out.println("");
        System.out.println(" O(N^2)");
        System.out.println("1. 선택정렬");
        System.out.println("2. 삽입정렬");
        System.out.println("3. 버블정렬");
        System.out.println("");
        System.out.println(" O(NlogN)");
        System.out.println("4. 퀵정렬");
        System.out.println("5. 병합정렬");
        System.out.println("6. 힙정렬");
        System.out.println("7. 트리정렬");

        System.out.println("99. 종료");
        System.out.println("");

        System.out.print("입력 : ");
    }

    /**
     * 메인 분기문
     *
     * @param a
     */
    public void mainFrame(int a) {

        switch (a) {
            case 1:
                selectSort();
                break;
            case 2:
                insertionSort();
                break;
            case 3:
                bubbleSort();
                break;
            case 4:
                quickChoice(a);
                break;
            case 5:
                mergeSort();
                break;
            case 6:
                heapSort();
                break;
            case 7:
                treeSort();
                break;
        }
    }

    public int selectSort() {
        System.out.println(" 선택 정렬");

        // 가장 적합한 값을 해당 위치로 찾아오는 정렬

        int[] array = randomNumber();

        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            swap(array, i, index);
            printArray(array);
        }
        endSort(array);
        return 0;
    }

    public int insertionSort() {

        System.out.println(" 삽입 정렬");
        // 순차적 접근으로 값을 변경?
        // 로직이 맞는지부터 판단이 잘 안됨.
        // 맞는거 같음

        int[] arr = randomNumber();

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                }
            }
            printArray(arr);
        }
        endSort(arr);
        return 0;
    }

    public int bubbleSort() {

        System.out.println(" 버블 정렬 ");

        int[] arr = randomNumber();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            printArray(arr);
        }
        endSort(arr);
        return 0;
    }

    public int quickChoice(int a) {
        try {
            Scanner sc = new Scanner(System.in);
            int b = 0;
            while (b != 4) {
                int[] arr = randomNumber();

                System.out.println(" 퀵 정렬 ");
                System.out.println(" 1. 첫번째 값을 피벗");
                System.out.println(" 2. 중간 값을 피벗");
                System.out.println(" 3. 마지막 값을 피벗");
                System.out.println(" 4. 이전으로");
                System.out.println();
                System.out.print("메뉴 선택 : ");
                b = sc.nextInt();

                switch (b) {
                    case 1:
                        b = firstPivot(arr);
                        break;
                    case 2:
                        b = centerPivot(arr);
                        break;
                    case 3:
                        b = lastPivot(arr);
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("예외 발생");
            System.out.println();
            quickChoice(a);
        }
        return 0;
    }

    private void quickExtracted(int[] arr) {
        System.out.println();
        System.out.println("정렬 후");
        printArray(arr);
        System.out.println("");
    }

    private int firstPivot(int[] arr) {

        int high = arr.length - 1;
        int low = 0;
        quickSortFirst(arr, high, low);
        quickExtracted(arr);
        return 0;
    }

    public void quickSortFirst(int[] array, int high, int low) {

        if (low >= high) return;

        int pivot = partitionFirst(array, high, low);

        quickSortFirst(array, pivot - 1, low);
        quickSortFirst(array, high, pivot + 1);
    }

    private int partitionFirst(int[] arr, int high, int low) {
        int right = high;
        int left = low;

        int pivot = arr[low];

        while (left < right) {

            while (arr[right] > pivot && left < right) {
                right--;
            }

            while (arr[left] <= pivot && left < right) {
                left++;
            }

            swap(arr, right, left);
        }

        swap(arr, low, left);

        return left;
    }

    private int centerPivot(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        quickSortCenter(arr, high, low);
        quickExtracted(arr);
        return 0;
    }

    private void quickSortCenter(int[] arr, int high, int low) {

    }

    private int lastPivot(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        quicksortLast(arr, high, low);
        quickExtracted(arr);
        return 0;
    }

    private void quicksortLast(int[] arr, int high, int low) {

        if (low >= high) return;

        int pivot = partitionLast(arr, high, low);

        quicksortLast(arr, pivot - 1, low);
        quicksortLast(arr, high, pivot + 1);

    }

    private int partitionLast(int[] arr, int high, int low) {

        int right = high;
        int left = low;

        int pivot = arr[high];

        while (left < right) {

            while (arr[right] >= pivot && left < right) {
                right--;
            }

            while (arr[left] < pivot && left < right) {
                left++;
            }

            swap(arr, right, left);
        }

        swap(arr, right, high);

        return right;
    }

    public int mergeSort() {
        return 0;
    }

    public int heapSort() {
        return 0;
    }

    public int treeSort() {

        return 0;
    }

    private int[] randomNumber() {
        int[] numberArray = new int[8];
        System.out.println("정렬 전");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = 1 + (int) Math.round(Math.random() * 100);
        }
        System.out.println(Arrays.toString(numberArray));
        System.out.println();
        return numberArray;
    }

    private void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private void endSort(int[] arr) {
        System.out.println();
        System.out.println("정렬 후");
        printArray(arr);
    }

    private void swap(int[] arr, int high, int low) {
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }

}
