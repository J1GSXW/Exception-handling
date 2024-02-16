package seminar3;

public class Task4 {

    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println(sumArray(arr));
    }

    public static int sumArray(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array.length != 4 || array[i].length !=4)
                throw new MyArraySizeExeption(array.length, array[i].length);
            for (int j = 0; j < array.length; j++) {
                try{
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

class MyArraySizeExeption extends RuntimeException{
    public MyArraySizeExeption(int row, int column) {
        super("Массив должен быть 4х4, размеры вашего массива -> " + row + "x" + column);
    }

    public MyArraySizeExeption(){
        super("Массив должен быть 4х4");
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(){
        super("В каком то элементе массива преобразование не удалось");
    }

    public MyArrayDataException(int i, int j){
        super("Преобразование не удалось, индексы -> " + i + ":" + j);
    }
}