package ua.epam.training.task1.exercise3.data;

import ua.epam.training.task1.exercise3.Student;

import java.io.IOException;

public interface StudentData {
    Student getStudent() throws IOException, ClassNotFoundException;
}
