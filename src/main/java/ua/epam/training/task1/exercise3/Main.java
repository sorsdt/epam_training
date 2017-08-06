package ua.epam.training.task1.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Students students = new Students();
        System.out.println("1. Получить список всех студентов");
        System.out.println("2. Получить список студентов-отличников 2-го курса");
        System.out.println("3. Получить список студентов-иностранцев, обучающихся только на \"хорошо\" и \"отлично\"");
        System.out.println("4. Упорядочить студентов в порядке обратном алфавитному согласно фамилии");
        System.out.println("5. Упорядочить студентов в алфавитном порядке согласно фамилии");
        System.out.println("6. Упорядочить студентов по успеваемости");
        System.out.println("7. Пересоздать список студентов");
        exit:
        while (true) {
            System.out.print("Сделайте свой выбор или нажмите 0 для выхода:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (reader.readLine()) {
                case "0":
                    break exit;
                case "1":
                    System.out.print(students);
                    break;
                case "2":
                    students.printSecondCourseAStudents();
                    break;
                case "3":
                    students.printForeignABStudents();
                    break;
                case "4":
                    students.sortBySurnameDesc();
                    break;
                case "5":
                    students.sortBySurnameAsc();
                    break;
                case "6":
                    students.sortByPerfomance();
                    break;
                case "7":
                    students = new Students();
                    break;
                default:
                    System.out.println("Ошибочный ввод");
            }
        }
    }
}
