package ua.epam.training.task3.exercise1;

public enum Columns {
    First("Название"), Second("Описание"), Third("Начало"), Fourth("Конец"), Fifth("Стоимость");

    String name;

    Columns(String name) {
        this.name = name;
    }
}
