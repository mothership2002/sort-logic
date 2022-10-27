package example.sortlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class SortLogicApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortLogicApplication sa = new SortLogicApplication();
        int a = -1;

        while (a != 99){
            sa.print();
            try {
                a = sc.nextInt();
                System.out.println("");
                sa.mainFrame(a);
                System.out.println("");
            } catch (InputMismatchException e){
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
     * @param int nubmer
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
                    quickSort();
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
        
        // 가장 적합한 값을 해당 위치로 찾아오는 정렬
        
        int[] array = randomNumber();
        
        for(int i = 0 ; i < array.length ; i++){
            int index = i;
            for(int j = i + 1 ; j < array.length ; j++){
                if(array[index] > array[j]){
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        printArray(array);
        return 0;
    }

    public int insertionSort() {
        int[] arr = randomNumber();

        for(int i = 0 ; i < arr.length ; i++){

        }
        printArray(arr);
        return 0;
    }

    public int bubbleSort() {
        return 0;
    }

    public int quickSort() {
        return 0;
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

    private int[] randomNumber(){
        int[] numberArray = new int[8];
        System.out.println("정렬 전");
        for(int i = 0 ; i < numberArray.length ; i++ ) {
            numberArray[i] = 1 + (int)(Math.random() * 100);
            System.out.print(numberArray[i] + " ");
        }
        System.out.println("");
        return numberArray;
    }

    private void printArray(int[] arr){
        System.out.println();
        System.out.println("정렬 후");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
