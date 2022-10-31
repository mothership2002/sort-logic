package example.sortlogic;

public class MergeSortClass {

    public int[] mergeDecomposition(int[] arr) {
        // 만약 정렬자리가 홀수 일때는 작동이 안될거라 예상됨 (인덱스아웃) / 해결 완
        // 더 좋은 방법이 있을 것 같음
        if (arr.length > 1) {
            int[] littleArr1;
            int[] littleArr2;

            if (arr.length % 2 == 0) {
                littleArr1 = new int[arr.length / 2];
                littleArr2 = new int[arr.length / 2];
            } else {
                littleArr1 = new int[arr.length / 2];
                littleArr2 = new int[arr.length / 2 + 1];
            }

            for (int i = 0; i < littleArr1.length; i++) {
                littleArr1[i] = arr[i];
            }
            for (int j = littleArr1.length; j < arr.length; j++) {
                littleArr2[j - littleArr1.length] = arr[j];
            }

            int[] temp = mergeDecomposition(littleArr1);
            int[] temp2 = mergeDecomposition(littleArr2);
            int[] mergeArray = new int[temp.length + temp2.length];

            mergeProcess(mergeArray, temp, temp2);

            return mergeArray;
        }
        return arr;
    }

    public void mergeProcess(int[] mergeArray, int[] temp, int[] temp2) {
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
                if (a >= b) {
                    mergeArray[c] = temp2[b];
                    b++;
                } else {
                    mergeArray[c] = temp[a];
                    a++;
                }
                c++;
            }
        }
    }
}
