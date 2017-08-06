package ua.epam.training.task1.exercise3.data;

import java.io.*;

public class FileRepository {
    public Object getObject() throws IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(getPath()));
        Object object = oos.readObject();
        oos.close();
        return object;
    }

    public void saveObject(Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getPath()));
        oos.writeObject(object);
        oos.close();
    }

    private String getPath() throws IOException {
        System.out.println("Введите полный путь к файлу:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        return path;
    }
}
