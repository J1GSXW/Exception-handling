//Задание №2
//        Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//        Необходимо посчитать и вернуть сумму элементов этого массива.
//        При этом накладываем на метод 2 ограничения: метод может работать только с
//        квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
//        только значение 0 или 1.
//        Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
//        ошибке.

public class task3 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}};
        System.out.println(summary(matrix));
    }

    public static int summary(int[][] array){
        if (array.length != array[0].length) {
            throw new RuntimeException("Массив не квадратный");
        }
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                summ += array[i][j];
                if (array[i][j] != 0 && array[i][j] != 1){
                    throw new RuntimeException("Элемент не равен 0 или 1");
                }
            }
        }
        return summ;
    }
}
