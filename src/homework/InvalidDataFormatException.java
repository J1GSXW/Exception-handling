package homework;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException() {
        super("Неверный формат данных");
    }
}