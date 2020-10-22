public class AddingBinaries {
    public static void main (String[] args) throws Exception {
        int[] binary1 = {1, 0, 1, 1};
        int[] binary2 = {1, 0, 1, 0};

        PrintIntegerArray(binary1);
        System.out.println(BinaryToInteger(binary1));
        PrintIntegerArray(binary2);
        System.out.println(BinaryToInteger(binary2));
        int[] sum = BinarySum(binary1, binary2);
        if(sum != null) PrintIntegerArray(sum);
        else System.out.println("Input was empty");
        System.out.println(BinaryToInteger(sum));
    }

    private static int[] BinarySum(int[] input1, int[] input2) throws Exception {
        int[] sum = new int[input1.length + 1];
        if(input1.length != input2.length) throw new Exception("Binary numbers must be of same length");
        if(input1.length == 0) return null;
        int carry = 0;
        for(int i = input1.length - 1; i >= 0; i--){
            int currentBitSum = input1[i] + input2[i] + carry;
            if(currentBitSum == 3){
                sum[i + 1] = 1;
                carry = 1;
            }
            else if(currentBitSum == 2){
                sum[i + 1] = 0;
                carry = 1;
            }
            else if(currentBitSum == 1){
                sum[i + 1] = 1;
                carry = 0;
            }
        }
        sum[0] = carry;
        return sum;
    }

    private static void PrintIntegerArray(int[] arr){
        for(int x : arr){
            System.out.print(x);
        }
        System.out.println();
    }

    private static int BinaryToInteger(int[] arr){
        int x = 0;
        int j = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == 1){
                x += Math.pow(2, j);
            }
            j++;
        }
        return x;
    }
}
