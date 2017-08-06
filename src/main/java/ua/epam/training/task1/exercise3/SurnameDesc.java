package ua.epam.training.task1.exercise3;

import java.util.Comparator;

class SurnameDesc implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student stud1 = (Student) o1;
        Student stud2 = (Student) o2;
        return stud2.getSurname().compareTo(stud1.getSurname());
    }
}
