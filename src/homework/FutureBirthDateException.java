package homework;

class FutureBirthDateException extends Exception {
    public FutureBirthDateException() {
        super("Вы ввели дату, которая позже сегодняшней.");
    }
}
