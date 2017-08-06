package ua.epam.training.task1.exercise3.data;

import ua.epam.training.task1.exercise3.Students;

import java.io.IOException;

public interface StudentsData {
    Students getStudents() throws IOException, ClassNotFoundException;
}
