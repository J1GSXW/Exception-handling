//Задание №4
//        Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
//        целочисленный одномерный массив.
//        Метод должен пройтись по каждому элементу и проверить что он не равен null.
//        А теперь реализуйте следующую логику:
//        1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
//        пользователя
//        2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их
//        “подсветить

public class task4 {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {2, 3, 5};
        checkNull(array);
    }

    public static void checkNull(Integer[] array){
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                errorMessage.append(i).append(" ");
            }
        }
        if (!errorMessage.isEmpty()){
            throw new RuntimeException("Error: " + errorMessage.toString());
        }
    }

}
