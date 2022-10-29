package example.sortlogic;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortLogicApplication {

    private static final CommonModule cm = CommonModule.getInstance();

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
                quickChoice(cm);
                break;
            case 5:
                int[] arr = cm.randomNumber();
                mergeSort(arr);
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

        int[] array = cm.randomNumber();

        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            cm.swap(array, i, index);
            cm.printArray(array);
        }
        cm.endSort(array);
        return 0;
    }

    public int insertionSort() {

        System.out.println(" 삽입 정렬");

        int[] arr = cm.randomNumber();

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    cm.swap(arr, i, j);
                }
            }
            cm.printArray(arr);
        }
        cm.endSort(arr);
        return 0;
    }

    public int bubbleSort() {

        System.out.println(" 버블 정렬 ");

        int[] arr = cm.randomNumber();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    cm.swap(arr, j, j + 1);
                }
            }
            cm.printArray(arr);
        }
        cm.endSort(arr);
        return 0;
    }

    public int quickChoice(CommonModule cm) {
        try {
            Scanner sc = new Scanner(System.in);
            QuickSortClass qs = new QuickSortClass(cm);
            int b = 0;
            while (b != 4) {

                System.out.println(" 퀵 정렬 ");
                System.out.println(" 1. 첫번째 값을 피벗");
                System.out.println(" 2. 중간 값을 피벗");
                System.out.println(" 3. 마지막 값을 피벗");
                System.out.println(" 4. 이전으로");
                System.out.println();
                int[] arr = cm.randomNumber();
                System.out.print("메뉴 선택 : ");
                b = sc.nextInt();

                switch (b) {
                    case 1:
                        b = qs.pivotChoice(arr, "first");
                        break;
                    case 2:
                        b = qs.pivotChoice(arr, "center");
                        break;
                    case 3:
                        b = qs.pivotChoice(arr, "last");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("예외 발생");
            System.out.println();
            quickChoice(cm);
        }
        return 0;
    }

    public int mergeSort(int[] arr) {

        System.out.println("정렬 전");
        cm.printArray(arr);
        System.out.println("정렬 후");
        cm.printArray(mergeProcess(arr));
        return 0;
    }

    public int[] mergeProcess(int[] arr) {
        if (arr.length > 1) {
            int[] littleArr1 = new int[arr.length / 2];
            int[] littleArr2 = new int[arr.length / 2];

            for (int i = 0; i < littleArr1.length; i++) {
                littleArr1[i] = arr[i];
            }
            for (int j = littleArr2.length; j < arr.length; j++) {
                littleArr2[j - littleArr2.length] = arr[j];
            }
            int[] temp = mergeProcess(littleArr1);
            int[] temp2 = mergeProcess(littleArr2);
            int[] mergeArray = new int[temp.length + temp2.length];

            int a = 0, b = 0, c = 0;
            while (c < mergeArray.length) {

                try {
                    if (temp[a] < temp2[b]) {
                        mergeArray[c] = temp[a];
                        a++;
                    } else {
                        mergeArray[c] = temp2[b];
                        b++;
                    }
                    c++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    if (a > b) {
                        mergeArray[c] = temp2[b];
                        b++;
                    } else {
                        mergeArray[c] = temp[a];
                        a++;
                    }
                    c++;
                }
            }

            return mergeArray;
        }
        return arr;
    }

    public int heapSort() {
        return 0;
    }

    public int treeSort() {

        return 0;
    }

}
