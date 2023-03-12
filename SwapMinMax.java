public class ArrayMinMaxProduct {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 6, 5, 1, 2};
        int[] b1 = {3, 4, 3, 2, 2, 5};
        int[] result = minmax(a1, b1);
        System.out.println("Minimum product: " + result[0]);
        System.out.println("Maximum product: " + result[1]);
        
        int[] a2 = {4, 4, 1, 3, 2};
        int[] b2 = {2, 8, 4, 2, 1}; 
        int[] result2 = minmax(a2, b2);
        System.out.println("Minimum product: " + result2[0]);
        System.out.println("Maximum product: " + result2[1]);
        
        int[] a3 = {8, 7, 9, 9, 5, 6, 6, 5, 6, 4, 6, 7, 8, 5, 4, 3, 2, 1, 4, 5, 6, 7, 8, 7, 8};
        int[] b3 = {2, 4, 5, 7, 8, 6, 7, 7, 9, 8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 5, 5, 5, 4, 5};
        int[] result3 = minmax(a3, b3);
        System.out.println("Minimum product: " + result3[0]);
        System.out.println("Maximum product: " + result3[1]);
        
        
    }

    public static int[] minmax(int[] a, int[] b) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int product = a[i] * b[i];
            if (product < result[0]) {
                result[0] = product;
            }
            if (product > result[1]) {
                result[1] = product;
            }
        }
        return result;
    }
}