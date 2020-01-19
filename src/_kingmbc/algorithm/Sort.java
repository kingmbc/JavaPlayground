package _kingmbc.algorithm;

public class Sort {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,1,5,2,34,100};
        Sort s = new Sort();
        s.insertionSort(numbers);
        s.printNums(numbers);
    }

    public void printNums(int[] nums){
        for(int i : nums){
            System.out.print(i + " | ");
        }
    }

    void insertionSort(int nums[])
    {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int j = i - 1;

            /* Move elements of nums[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }

    public void selectionSort(int[] nums){
        int minpos = 0;
        for(int i = 0; i < nums.length-1; i++){
            minpos = i;

            for(int j = i; j < nums.length; j++){
                if(nums[minpos] > nums[j]) {
                    minpos = j;
                }
            }
            swap(nums, i, minpos);
        }
    }

    public void bubbleSort(int[] nums){
        boolean swapped = false;
        for(int i = 0; i < nums.length-1; i++){
            swapped = false;
            for(int j = 0; j < nums.length-i-1; j++){
                if(nums[j] > nums[j+1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    public void swap(int[] n, int a, int b){
        int tmp = n[a];
        n[a] = n[b];
        n[b] = tmp;
    }
}
