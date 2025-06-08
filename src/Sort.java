import java.util.Arrays;

public class Sort {
    public static void countSort(int[] arr,int exp){
        int max = maxFromArray(arr);
        int[] countArr = new int[10];
        for(int i: arr) countArr[(i/exp) % 10]++;
        for(int i = 1; i < countArr.length;i++)
            countArr[i] += countArr[i-1];

        int[] output = new int[arr.length];
        for(int i = arr.length - 1; i >= 0;i--){
            output[--countArr[(arr[i] / exp) % 10]] = arr[i];
        }

        for(int i = 0;i<arr.length;i++)
            arr[i] = output[i];
    }
    public static int maxFromArray(int[] arr){
        int max = arr[0];
        for(int i: arr) max = Math.max(max,i);
        return max;
    }
    public static void printArray(int[] arr){
        System.out.printf("{ ");
        for(int i: arr)
            System.out.printf("%d ",i);
        System.out.println("}");
    }
    public static void radixSort(int[] arr){
        int max = maxFromArray(arr);

        for(int exp = 1; max/exp > 0; exp *= 10)
            countSort(arr,exp);
    }
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,2,4,6,7,8,4,5,6,3,2,3,5,7,7,3,9,4,5,0};
        countSort(arr,1);
        printArray(arr);
        int[] temp = {12,432,234,34,12,675,213,75,78};
        radixSort(temp);
        printArray(temp);
    }
}
