package tk.solidays.algorithm.others;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {2 , 3 , 4 , 1, 10 , 9 , 6 , 5 , 8 , 7};
        //quickSort(arr,0,arr.length - 1);
        arr = mergeSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
//=================快速排序=================================
    static void quickSort(int[] arr,int left,int right){
        if(left < right){
            //partition
            int pivot = left;
            int index = pivot + 1;
            for(int i = index;i <= right;i++){
                if(arr[i] < arr[pivot]){
                    //swap
                    swap(arr,i,index);
                    index++;
                }
            }
            swap(arr,pivot,index - 1);

            quickSort(arr,left,index - 2);
            quickSort(arr,index,right);
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//=============================================================

// ==============归并排序====================================
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int dividePoint = arr.length/2;
        int[] left = Arrays.copyOf(arr,dividePoint);
        int[] right = Arrays.copyOfRange(arr,dividePoint,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    static int[] merge(int[] left, int[] right){
        int[] arr = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] < right[rightIndex]){
                arr[leftIndex + rightIndex] = left[leftIndex];
                leftIndex++;
            }
            else{
                arr[leftIndex + rightIndex] = right[rightIndex];
                rightIndex++;
            }
        }
        while (leftIndex < left.length){
            arr[leftIndex + rightIndex] = left[leftIndex];
            leftIndex++;
        }
        while(rightIndex < right.length){
            arr[leftIndex + rightIndex] = right[rightIndex];
            rightIndex++;
        }
        return arr;
    }
}
