package example.sortlogic;

import static example.sortlogic.CommonModule.*;

public class QuickSortClass {

    private CommonModule cm;

    public QuickSortClass(CommonModule cm) {
        this.cm = cm;
    }

    public void quickExtracted(int[] arr) {
        System.out.println();
        System.out.println("정렬 후");
        cm.printArray(arr);
        System.out.println("");
    }

    public int firstPivot(int[] arr) {

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

    public int partitionFirst(int[] arr, int high, int low) {
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

            cm.swap(arr, right, left);
        }

        cm.swap(arr, low, left);

        return left;
    }

    public int centerPivot(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        quickSortCenter(arr, high, low);
        quickExtracted(arr);
        return 0;
    }

    public void quickSortCenter(int[] arr, int high, int low) {

        if (high - low <= 0) return;

        int pivot = partitionCenter(arr, high, low);

        quickSortCenter(arr, pivot - 1, low);
        quickSortCenter(arr, high, pivot + 1);
    }

    public int partitionCenter(int[] arr, int high, int low) {
        int right = high;
        int left = low;
        int index = (high + low) / 2;
        int pivot = arr[index];

        while (true){
            while (arr[left] < pivot){
                left++;
            }
            while (arr[right] > pivot){
                right--;
            }
            cm.swap(arr, right, left);
            if(right == left){
                break;
            }
        }
        return right;

    }

    public int lastPivot(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        quicksortLast(arr, high, low);
        quickExtracted(arr);
        return 0;
    }

    public void quicksortLast(int[] arr, int high, int low) {

        if (low >= high) return;

        int pivot = partitionLast(arr, high, low);

        quicksortLast(arr, pivot - 1, low);
        quicksortLast(arr, high, pivot + 1);

    }

    //퀵 공통모듈로 정립가능 할 것 같은데
    public int partitionLast(int[] arr, int high, int low) {

        int right = high;
        int left = low;

        int pivot = arr[high];

        while (left < right) {

            while (arr[left] < pivot && left < right) {
                left++;
            }

            while (arr[right] >= pivot && left < right) {
                right--;
            }

            cm.swap(arr, right, left);
        }

        cm.swap(arr, high, right);

        return right;
    }

}
