package ua.epam.training.task1.exercise3;

import ua.epam.training.task1.exercise3.data.StudentGenerator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    Student[] students = new Student[8];

    {
        StudentGenerator studentDataSource = new StudentGenerator();
        for (int i = 0; i < students.length; i++) {
            students[i] = studentDataSource.getStudent();
        }
    }

    public void printSecondCourseAStudents() {
        boolean noData = true;
        for (Student student : students) {
            if ((Float.compare(student.getPerformance(), 5.0f) == 0) && (student.getCourse() == 2)) {
                noData = false;
                System.out.println(student);
            }
        }
        if (noData) System.out.println("Данных не найдено");
    }

    public void printForeignABStudents() {
        boolean noData = true;
        for (Student student : students) {
            if ((Float.compare(student.getPerformance(), 4.0f) >= 0) && (!"Украина".equals(student.getCountry()))) {
                noData = false;
                System.out.println(student);
            }
        }
        if (noData) System.out.println("Данных не найдено");
    }

    public void sortBySurnameDesc() {
        Arrays.sort(students, new SurnameDesc());
    }

    public void sortBySurnameAsc() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
    }

    public void sortByPerfomance() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Float.compare(o1.getPerformance(), o2.getPerformance());
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Student student :
                students) {
            stringBuilder.append(student).append("\r\n");
        }
        return stringBuilder.toString();
    }
}
