package ua.epam.training.task3.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    private static final String SEARCH_MESSAGE = "Введите поисковый запрос:";

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(Columns.First.name);
        Transport transport = new Transport();
        transport.printRoutes(transport.getRoutes());
        String searchString;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(SEARCH_MESSAGE);
        while ((searchString = reader.readLine()) != null) {
            Transport.Route[] searchedRoutes = transport.searchRoutes(searchString);
            transport.printRoutes(searchedRoutes);
            System.out.println(SEARCH_MESSAGE);
        }
    }
}
