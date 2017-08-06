package ua.epam.training.task1.exercise3.data;

import ua.epam.training.task1.exercise3.Student;

import java.util.Random;

public class StudentGenerator implements StudentData {
    static long studentID = 1;
    String maleSurnames[] = {"Бондаренко", "Гладкий", "Дворецкий", "Дударь", "Дяшкин", "Журавчак", "Иващенко", "Шевчук"};
    String maleNames[] = {"Олег", "Антон", "Владислав", "Дмитрий", "Артем", "Ярослав", "Алексей", "Денис", "Тарас"};
    String maleParentNames[] = {"Антонович", "Владиславович", "Дмитриевич", "Артёмович", "Ярославович", "Алексеевич"};
    String femaleSurnames[] = {"Бондаренко", "Гладкая", "Дворецкая", "Дударь", "Дяшкина", "Журавчак", "Иващенко", "Шевчук"};
    String femaleNames[] = {"Владислава", "Ольга", "Ярослава", "Александра", "Ирина", "Елена", "Валентина", "Наталья"};
    String femaleParentNames[] = {"Антоновна", "Владиславовна", "Дмитриевна", "Артёмовна", "Ярославовна", "Олеговна"};
    String countries[] = {"Украина", "Россия", "Молдова", "Австралия", "Норвегия", "США", "Германия", "Аргентина"};

    @Override
    public Student getStudent() {
        Student student = new Student();
        Random random = new Random();
        student.setSex(random.nextBoolean());
        if (student.getSex()) {
            student.setName(maleNames[(int) (random.nextDouble() * maleNames.length)]);
            student.setSurname(maleSurnames[(int) (random.nextDouble() * maleSurnames.length)]);
            student.setParentName(maleParentNames[(int) (random.nextDouble() * maleParentNames.length)]);
        } else {
            student.setName(femaleNames[(int) (random.nextDouble() * femaleNames.length)]);
            student.setSurname(femaleSurnames[(int) (random.nextDouble() * femaleSurnames.length)]);
            student.setParentName(femaleParentNames[(int) (random.nextDouble() * femaleParentNames.length)]);
        }
        student.setCountry(countries[(int) (random.nextDouble() * countries.length)]);
        student.setStudentID(studentID++);
        student.setCourse(random.nextInt(5) + 1);
        float performance;
        while (true) {
            performance = random.nextFloat() * 4 + 3f;
            if (Float.compare(performance, 5f) <= 0) break;
        }
        student.setPerformance(performance);
        return student;
    }
}
