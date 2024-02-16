class Expr {
    public static String expr(char a) throws Exception {
// Введите свое решение ниже
        String result = "";
        if(a != ' ') {
            result = "Your input was - " + a;
        }
        else{
            throw new IllegalArgumentException("Empty string has been input.");
        }
        return result;
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Printer {
    public static void main(String[] args) {
        char a;

        if (args.length == 0) {
            a = 'j'; // Значение по умолчанию, если аргументы не были предоставлены
        } else {
            a = args[0].charAt(0); // Преобразуйте первый аргумент командной строки в символ
        }

        try {
            String result = Expr.expr(a);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}