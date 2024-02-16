package homework;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try {
            // Получение данных от пользователя через Scanner
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дд.мм.гггг НомерТелефона Пол (m/f)");
            String input = scanner.nextLine();
            scanner.close();

            // Проверка количества введенных данных
            String[] inputData = input.split(" ");
            if (inputData.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            // Проверка формата ФИО
            if (!inputData[0].matches("[А-ЯЁ][а-яё]*") ||
                    !inputData[1].matches("[А-ЯЁ][а-яё]*") ||
                    !inputData[2].matches("[А-ЯЁ][а-яё]*")) {
                throw new InvalidDataFormatException();
            }

            // Парсинг и проверка форматов введенных данных
            String lastName = inputData[0];
            String firstName = inputData[1];
            String middleName = inputData[2];
            LocalDate birthDate = parseDate(inputData[3]);
            long phoneNumber = parsePhoneNumber(inputData[4]);
            char gender = parseGender(inputData[5]);

            // Запись данных в файл
            writeToOutputFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static LocalDate parseDate(String dateStr) throws InvalidDataFormatException, FutureBirthDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate currentDate = LocalDate.now();
        if (date.isAfter(currentDate)) {
            throw new FutureBirthDateException();
        }
        return date;
    }

    private static long parsePhoneNumber(String phoneNumberStr) throws InvalidDataFormatException {
        if (!phoneNumberStr.matches("\\d{11}")) {
            throw new InvalidDataFormatException();
        }
        return Long.parseLong(phoneNumberStr);
    }

    private static char parseGender(String genderStr) throws InvalidDataFormatException {
        if (!genderStr.matches("[mf]")) {
            throw new InvalidDataFormatException();
        }
        return genderStr.charAt(0);
    }

    private static void writeToOutputFile(String lastName, String firstName, String middleName,
                                          LocalDate birthDate, long phoneNumber, char gender) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String data = lastName + " " + firstName + " " + middleName + " " +
                    birthDate.toString() + " " + phoneNumber + " " + gender + "\n";
            writer.write(data);
            System.out.println("Данные успешно записаны в файл: " + fileName);
        }
    }
}