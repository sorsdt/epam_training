package ua.epam.training.task1.exercise3.data;

import ua.epam.training.task1.exercise3.Student;
import ua.epam.training.task1.exercise3.Students;

import java.io.IOException;

public class StudentPersistence implements StudentData, StudentsData {
    @Override
    public Student getStudent() throws IOException, ClassNotFoundException {
        FileRepository fileRepository = new FileRepository();
        return (Student) fileRepository.getObject();
    }

    @Override
    public Students getStudents() throws IOException, ClassNotFoundException {
        FileRepository fileRepository = new FileRepository();
        return (Students) fileRepository.getObject();
    }

    public void saveStudents(Students students) throws IOException, ClassNotFoundException {
        FileRepository fileRepository = new FileRepository();
        fileRepository.saveObject(students);
    }
}
