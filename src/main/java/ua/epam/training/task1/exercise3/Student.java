package ua.epam.training.task1.exercise3;

import ua.epam.training.task1.exercise3.data.Gender;

import java.io.Serializable;

public class Student implements Serializable {
    private String surname;
    private String name;
    private String parentName;
    private String country;
    private Gender sex;
    private long studentID;
    private int course;
    private float performance;

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override

    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + sex + '\'' +
                ", studentID=" + studentID +
                ", course=" + course +
                ", performance=" + performance +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public float getPerformance() {
        return performance;
    }

    public void setPerformance(float perfomance) {
        this.performance = perfomance;
    }
}
