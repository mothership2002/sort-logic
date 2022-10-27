package example.sortlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SortLogicApplication {

    public static void main(String[] args) {
        System.out.println("정렬 번호 입력");
        System.out.println(" O(N^2)");
        System.out.println("1. 선택정렬");
        System.out.println("2. 삽입정렬");
        System.out.println("3. 버블정렬");
        System.out.println(" O(NlogN)");
        System.out.println("4. 퀵정렬");
        System.out.println("5. 병합정렬");
        System.out.println("6. 퀵정렬");
        System.out.println("7. 트리정렬");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1: 
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
        }
    }

}
