public class task1 {
    public static void main(String[] args) {
        int x = 10;
        int[] array = new int[8];
        System.out.println(arrayLength(array, x));
    }

    public static int arrayLength(int[] array, int num){
        if (array.length < num){
           return -1;
        }
        return array.length;
    }


}